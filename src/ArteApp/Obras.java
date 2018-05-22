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
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class Obras extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static List<String> titulos = new ArrayList<String>();
	static List<String> textos64 = new ArrayList<String>();
	static int retam = 0;
	private JButton button;
	static JScrollPane scrollPane = new JScrollPane();
	static JPanel panel = new JPanel();
	static Dimension D = new Dimension();
	

	/**
	 * Create the frame.
	 */
	public Obras(int Ax, int Bx) {
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				if(retam != 0)
				{
					D.setSize(scrollPane.getWidth(), panel.getMaximumSize().getHeight());
					panel.setPreferredSize(D.getSize());
				}
				
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 720, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		CustomPanel customPanel = new CustomPanel();
		customPanel.setOpaque(false);
		customPanel.setBackground(new Color(204, 255, 255));
		contentPane.add(customPanel, BorderLayout.CENTER);
		
		JLabel label_1 = new JLabel("Herramientas", SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		
		JLabel label_2 = new JLabel("", SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(Obras.class.getResource("/botones/logop.png")));
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-home.png")));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				PanelPrincipal pp = new PanelPrincipal(altura, anchura);
				pp.setVisible(true);
				dispose();
			}
		});
		
		JButton button_1 = new JButton("Añadir Nueva");
		button_1.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-add_image.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				ObraNueva on = new ObraNueva(altura, anchura);
				on.setVisible(true);
				dispose();
			}
		});
		
		JButton button_2 = new JButton("Idolos");
		button_2.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-leaving_queue.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Idolos i = new Idolos(altura, anchura);
				//i.setVisible(true);
				dispose();
			}
		});
		
		JButton button_3 = new JButton("Mis Fans");
		button_3.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-joining_queue.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Fans f = new Fans(altura, anchura);
				//f.setVisible(true);
				dispose();
			}
		});
		
		JButton button_4 = new JButton("TOPs");
		button_4.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-leaderboard.png")));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				TOP t = new TOP(altura, anchura);
				t.setVisible(true);
				dispose();
			}
		});
		
		JButton button_5 = new JButton("Salir");
		button_5.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-export.png")));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblMisobras = new JLabel("Mis Obras", SwingConstants.CENTER);
		lblMisobras.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Buscar b = new Buscar(altura, anchura);
				b.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-search.png")));
		
	
		GroupLayout gl_customPanel = new GroupLayout(customPanel);
		gl_customPanel.setHorizontalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_customPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(label_2))
								.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(84)
							.addComponent(lblMisobras, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
							.addGap(106))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
							.addGap(24))))
		);
		gl_customPanel.setVerticalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblMisobras, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
							.addGap(31))))
		);
		customPanel.setLayout(gl_customPanel);
		cargaDelJson();
		setVisible(true);

		Dimension D = new Dimension();
		scrollPane.setViewportView(panel);
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//System.out.println(scrollPane.getWidth() + " " + scrollPane.getHeight());
		D.setSize(scrollPane.getWidth(),panel.getMaximumSize().getHeight());
		panel.setPreferredSize(D.getSize());
		panel.setOpaque(false);
		cargarImagenes();
		
	}
	
	public static void cargaDelJson() {
			ConnectionManager.get_all_photos();
			JSONRead JR = new JSONRead();
			JsonParser parser = new JsonParser();
	        FileReader fr;
	        try {
				fr = new FileReader("imagenes.json");
				JsonElement datos = parser.parse(fr);
				titulos = JR.getTitulos(datos);
				textos64 = JR.getTextos64();
				panel.removeAll();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void cargarImagenes() {
		//System.out.println(titulos.get(0));
		//System.out.println(textos64.get(0));
		retam = 1;
		
		//Decodificar la imagen y agregarla a una etiqueta y anexarla al JList///
		byte[] decoder;
		ByteArrayInputStream bis;
		BufferedImage image = null;
		for(int i = 0; i < textos64.size(); i++)
		{
			try {
				//System.out.println(textos64.get(i));
				decoder = Base64.getDecoder().decode(textos64.get(i));
				bis = new ByteArrayInputStream(decoder);
				image = null;
				image = ImageIO.read(bis);
				bis.close();
				ImageIcon fott = new ImageIcon(image);
				JLabel imagee = new JLabel("", SwingConstants.CENTER);
				imagee.setSize(113, 113);
				Icon iconot = new ImageIcon(fott.getImage().getScaledInstance(imagee.getWidth(), imagee.getHeight(), Image.SCALE_DEFAULT));
				//imagee.setOpaque(false);
				imagee.setIcon(iconot);
				
				final int in = i;
				imagee.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int altura = 520;
						int anchura = 720;
						//System.out.println("tamaño: " + userID.size());
						@SuppressWarnings("unused")
						Imagen im = new Imagen(altura, anchura, titulos.get(in), textos64.get(in), Constants.user_id_local);
						//i.setVisible(true);
					}
				});
				
				panel.add(imagee);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//////////////////////////////////////////////////////////////////////
	}
}
