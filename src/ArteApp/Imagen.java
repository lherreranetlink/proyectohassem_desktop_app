package ArteApp;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import JsonRead.JSONRead;
import connection.ConnectionManager;
import constants.Constants;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.swing.JTextPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Imagen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel label_1;
	private static JLabel lblImagen;
	static int retam = 0;
	private JLabel lblSeguri;
	int ac = 0;
	static List<String> titulos = new ArrayList<String>();
	static List<String> textos64 = new ArrayList<String>();
	static List<String> uID = new ArrayList<String>();

	/**
	 * Create the frame.
	 */
	public Imagen(int Ax, int Bx, final String titulos, final String textos64, final String userID) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				if(retam != 0)
				{
					imagenesC(titulos, textos64);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		CustomPanel customPanel = new CustomPanel();
		customPanel.setOpaque(false);
		customPanel.setBackground(new Color(204, 255, 255));
		contentPane.add(customPanel, BorderLayout.CENTER);
		
		JLabel lblComentarios = new JLabel("Comentarios", SwingConstants.CENTER);
		lblComentarios.setForeground(Color.BLUE);
		
		JLabel label_2 = new JLabel("", SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(Imagen.class.getResource("/botones/logop.png")));
		
		lblImagen = new JLabel("Imagen", SwingConstants.CENTER);
		lblImagen.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		label_1 = new JLabel("", SwingConstants.CENTER);
		label_1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-cancel.png")));
		
		final JLabel lblSol = new JLabel("", SwingConstants.CENTER);
		lblSol.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblSol.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-summer.png")));
			}
			public void mouseExited(MouseEvent e) {
				lblSol.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-sun.png")));
			}
		});
		lblSol.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-sun.png")));
		
		final JLabel lblNube = new JLabel("", SwingConstants.CENTER);
		lblNube.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblNube.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-moon.png")));
			}
			public void mouseExited(MouseEvent e) {
				lblNube.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-new_moon.png")));
			}
		});
		lblNube.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-new_moon.png")));
		
		final JLabel lblLuna = new JLabel("", SwingConstants.CENTER);
		lblLuna.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblLuna.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-cloud.png")));
			}
			public void mouseExited(MouseEvent e) {
				lblLuna.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-clouds.png")));
			}
		});
		lblLuna.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-clouds.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Escribe un Comentario Nuevo:");
		lblNewLabel.setForeground(Color.BLUE);
		
		JLabel SolContador = new JLabel("0", SwingConstants.CENTER);
		
		JLabel LunaContador = new JLabel("0", SwingConstants.CENTER);
		
		JLabel NubeContador = new JLabel("0", SwingConstants.CENTER);
		
		lblSeguri = new JLabel("", SwingConstants.CENTER);
		lblSeguri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblSeguri.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-leaving_queue.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSeguri.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-joining_queue.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ac == 0)
				{
					cargaDelJsonSeguir(userID);
				}
				else if(ac == 2)
				{
					cargaDelJsonNoSeguir(userID);
				}
			}
		});
		lblSeguri.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-leaving_queue.png")));
		
		JLabel lblSeguir = new JLabel("Seguir", SwingConstants.CENTER);
		GroupLayout gl_customPanel = new GroupLayout(customPanel);
		gl_customPanel.setHorizontalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCerrar, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
						.addComponent(lblComentarios, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_2))
						.addComponent(scrollPane_1))
					.addGap(39)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
						.addComponent(lblImagen, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSeguri, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLuna, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(lblNube, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(lblSol, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(SolContador, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(LunaContador, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(NubeContador, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(lblSeguir, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_customPanel.setVerticalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
							.addComponent(lblComentarios))
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCerrar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblImagen)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(lblSol, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(SolContador, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNube, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LunaContador, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
							.addGap(5)
							.addComponent(lblLuna, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(NubeContador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(5))
						.addComponent(label_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(4)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(lblSeguri, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSeguir)))
					.addContainerGap())
		);
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		customPanel.setLayout(gl_customPanel);
		
		setVisible(true);
		imagenesC(titulos, textos64);
		if(userID.equals(Constants.user_id_local))
		{
			lblSeguri.setEnabled(false);
			ac = 1;
		}
		
		cargaDelJsonUS();
		
		for(int i = 0; i < uID.size(); i++)
		{
			if(uID.get(i).equals(userID)) 
			{
				if(ac != 1)
				{
					lblSeguir.setText("Dejar de Seguir");
					ac = 2;
				}
			}
		}
	
	}
	
	public static void imagenesC(String titulos, String textos64)
	{
		retam = 1;
		byte[] decoder = Base64.getDecoder().decode(textos64);
		ByteArrayInputStream bis = new ByteArrayInputStream(decoder);
		BufferedImage image = null;
		try {
			image = ImageIO.read(bis);
			bis.close();
			ImageIcon fott = new ImageIcon(image);
			Icon iconot = new ImageIcon(fott.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_AREA_AVERAGING));
			label_1.setIcon(iconot);
			lblImagen.setText(titulos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void cargaDelJsonUS() {
		ConnectionManager.get_idolos();
		JSONRead JR = new JSONRead();
		JsonParser parser = new JsonParser();
        FileReader fr;
        try {
			fr = new FileReader("idolos.json");
			JsonElement datos = parser.parse(fr);
			titulos = JR.getNickNames(datos);
			textos64 = JR.getFotoPerfiles();
			uID = JR.getUsuarioIDs();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void cargaDelJsonSeguir(String userID) 
	{
		ConnectionManager.seguirPOST(userID);
	}
	
	public static void cargaDelJsonNoSeguir(String userID) 
	{
		ConnectionManager.quit_follow(userID);
	}
}
