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

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel label_4;
	private static JLabel label_3;
	static int retam = 0;
	int ac = 0;
	static List<String> titulos = new ArrayList<String>();
	static List<String> textos64 = new ArrayList<String>();
	static List<String> uID = new ArrayList<String>();
	private JLabel label_5;

	/**
	 * Create the frame.
	 */
	public UsuarioS(int Ax, int Bx, final String titulos, final String textos64, final String userID) {
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				if(retam != 0)
				{
					imagenesC(titulos, textos64);
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 720, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		CustomPanel customPanel = new CustomPanel();
		customPanel.setOpaque(false);
		customPanel.setBackground(new Color(204, 255, 255));
		contentPane.add(customPanel, BorderLayout.CENTER);
		
		JLabel label_2 = new JLabel("", SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/logop.png")));
		
		label_3 = new JLabel("", SwingConstants.CENTER);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		label_4 = new JLabel("", SwingConstants.CENTER);
		label_4.setBorder(BorderFactory.createLineBorder(Color.black));
		
		final JLabel label_6 = new JLabel("", SwingConstants.CENTER);
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_6.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-joining_queue.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_6.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-leaving_queue.png")));
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
		label_6.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-joining_queue.png")));
		
		label_5 = new JLabel("Seguir", SwingConstants.CENTER);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				PanelPrincipal pp = new PanelPrincipal(altura, anchura);
				pp.setVisible(true);
				dispose();
			}
		});
		btnInicio.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-home.png")));
		
		JButton btnIdolos = new JButton("Idolos");
		btnIdolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Idolos i = new Idolos(altura, anchura);
				//i.setVisible(true);
				dispose();
			}
		});
		btnIdolos.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-joining_queue.png")));
		
		JButton btnAadirNueva = new JButton("Añadir Nueva");
		btnAadirNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				ObraNueva on = new ObraNueva(altura, anchura);
				on.setVisible(true);
				dispose();
			}
		});
		btnAadirNueva.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-add_image.png")));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Buscar b = new Buscar(altura, anchura);
				b.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-search.png")));
		
		JButton btnMisFans = new JButton("Mis Fans");
		btnMisFans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Fans f = new Fans(altura, anchura);
				//f.setVisible(true);
				dispose();
			}
		});
		btnMisFans.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-leaving_queue.png")));
		
		JButton btnMisObras = new JButton("Mis Obras");
		btnMisObras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				//System.out.println(anchura);
				@SuppressWarnings("unused")
				Obras ob = new Obras(altura, anchura);
				//ob.setVisible(true);
				dispose();
			}
		});
		btnMisObras.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-collage.png")));
		
		JButton button_6 = new JButton("Salir");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		button_6.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-export.png")));
		
		JLabel label = new JLabel("Herramientas", SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		
		JLabel lblVerObras = new JLabel("Ver Obras", SwingConstants.CENTER);
		
		final JLabel label_1 = new JLabel("", SwingConstants.CENTER);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-modern_art.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-collage.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				//System.out.println(anchura);
				@SuppressWarnings("unused")
				ObrasUS ob = new ObrasUS(altura, anchura, userID, titulos);
				//ob.setVisible(true);
				dispose();
			}
		});
		label_1.setIcon(new ImageIcon(UsuarioS.class.getResource("/botones/icons8-collage.png")));
		GroupLayout gl_customPanel = new GroupLayout(customPanel);
		gl_customPanel.setHorizontalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(29)
							.addComponent(label_2))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAadirNueva, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnIdolos, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMisFans, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(133)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVerObras, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
							.addGap(105)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(label_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
							.addGap(184))
						.addGroup(Alignment.TRAILING, gl_customPanel.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
								.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
							.addGap(76))))
		);
		gl_customPanel.setVerticalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(13)
							.addComponent(label_3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_customPanel.createSequentialGroup()
									.addComponent(label_1)
									.addGap(8))
								.addGroup(gl_customPanel.createSequentialGroup()
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVerObras)
								.addComponent(label_5)))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(label)
							.addGap(8)
							.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAadirNueva, GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIdolos, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMisFans, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)))
					.addGap(13))
		);
		customPanel.setLayout(gl_customPanel);
		setVisible(true);
		imagenesC(titulos, textos64);
		if(userID.equals(Constants.user_id_local))
		{
			label_6.setEnabled(false);
			ac = 1;
		}
		
		cargaDelJsonUS();
		
		for(int i = 0; i < uID.size(); i++)
		{
			if(uID.get(i).equals(userID)) 
			{
				if(ac != 1)
				{
					label_5.setText("Dejar de Seguir");
					ac = 2;
				}
			}
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
			Icon iconot = new ImageIcon(fott.getImage().getScaledInstance(label_4.getWidth(), label_4.getHeight(), Image.SCALE_AREA_AVERAGING));
			label_4.setIcon(iconot);
			label_3.setText(titulos);
		} catch (IOException e) {
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
