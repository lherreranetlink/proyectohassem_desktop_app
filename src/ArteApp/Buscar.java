package ArteApp;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import JsonRead.JSONRead;
import connection.ConnectionManager;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Buscar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	static List<String> usuarioID = new ArrayList<String>();
	static List<String> nickName = new ArrayList<String>();
	static List<String> fotoPerfil = new ArrayList<String>();
	static List<String> tituloObra = new ArrayList<String>();
	static List<String> imagenObra64 = new ArrayList<String>();
	static List<String> ImagenID = new ArrayList<String>();
	static int retam = 0;
	static int found = 0;
	private static JLabel label_3;
	private static JLabel label_4;
	static String foto = "";
	static String tituloF = "";
	static String uID = "";
	static String imID = "";

	/**
	 * Create the frame.
	 */
	public Buscar(int Ax, int Bx) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				if(retam != 0)
				{
					cargarImagenes(foto);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 720, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(204, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		
		CustomPanel customPanel = new CustomPanel();
		customPanel.setOpaque(false);
		customPanel.setBackground(new Color(204, 255, 255));
		
		JLabel label = new JLabel("", SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Buscar.class.getResource("/botones/logop.png")));
		
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
		btnInicio.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-home.png")));
		
		final JLabel label_1 = new JLabel("", SwingConstants.CENTER);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-left_round.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-left_circular.png")));
			}
		});
		label_1.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-left_circular.png")));
		
		JButton button_1 = new JButton("Mis Fans");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Fans f = new Fans(altura, anchura);
				f.setVisible(true);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-joining_queue.png")));
		
		JButton button_2 = new JButton("Idolos    ");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Idolos i = new Idolos(altura, anchura);
				i.setVisible(true);
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-leaving_queue.png")));
		
		JButton button_3 = new JButton("Añadir Nueva");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				ObraNueva on = new ObraNueva(altura, anchura);
				on.setVisible(true);
				dispose();
			}
		});
		button_3.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-add_image.png")));
		
		JButton button_4 = new JButton("TOPs");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				TOP t = new TOP(altura, anchura);
				t.setVisible(true);
				dispose();
			}
		});
		button_4.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-leaderboard.png")));
		
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
		btnMisObras.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-collage.png")));
		
		JButton button_6 = new JButton("Salir");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		button_6.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-export.png")));
		
		JLabel label_2 = new JLabel("Herramientas", SwingConstants.CENTER);
		label_2.setForeground(Color.BLUE);
		
		JLabel lblBuscar = new JLabel("Buscar", SwingConstants.CENTER);
		lblBuscar.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		label_3 = new JLabel("", SwingConstants.CENTER);
		label_3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		label_4 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		final JLabel label_22 = new JLabel("", SwingConstants.CENTER);
		label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_22.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-right_round.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_22.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-right_circular.png")));
			}
		});
		label_22.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-right_circular.png")));
		
		JLabel lblBuscarUnaObra = new JLabel("Buscar una Obra: ");
		
		JLabel lblBuscarUnArtista = new JLabel("Buscar un Artista: ");
		
		textField = new JTextField();
		TextPrompt placeholderN = new TextPrompt("Nombre de la Obra", textField);
		placeholderN.changeAlpha(0.75f);
		placeholderN.changeStyle(Font.ITALIC);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		TextPrompt placeholderM = new TextPrompt("Nombre del Artista", textField_1);
		placeholderM.setText("Nick Name del Artista");
		placeholderM.changeAlpha(0.75f);
		placeholderM.changeStyle(Font.ITALIC);
		textField_1.setColumns(10);
		
		JButton btnBuscarObra = new JButton("Buscar Obra");
		btnBuscarObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaDelJson2();
				infoBuscaObra();
			}
		});
		btnBuscarObra.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-search.png")));
		
		JButton btnBuscarArtista = new JButton("Buscar Artista");
		btnBuscarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaDelJson();
				infoBuscar();
			}
		});
		btnBuscarArtista.setIcon(new ImageIcon(Buscar.class.getResource("/botones/icons8-search.png")));
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
									.addComponent(label))
								.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
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
							.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
								.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
							.addGap(106))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBuscarObra, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
								.addGroup(gl_customPanel.createSequentialGroup()
									.addComponent(lblBuscarUnaObra)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
								.addComponent(lblBuscar, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
								.addGroup(gl_customPanel.createSequentialGroup()
									.addComponent(lblBuscarUnArtista)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
								.addComponent(btnBuscarArtista, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(58))))
		);
		gl_customPanel.setVerticalGroup(
			gl_customPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_customPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblBuscarUnaObra)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_customPanel.createSequentialGroup()
									.addComponent(label_2)
									.addGap(8)
									.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE))
								.addGroup(gl_customPanel.createSequentialGroup()
									.addComponent(btnBuscarObra, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_customPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblBuscarUnArtista)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(0, 3, Short.MAX_VALUE)))
							.addGap(3)
							.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
							.addGap(1)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_customPanel.createSequentialGroup()
									.addComponent(lblBuscar, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(136)
									.addComponent(btnBuscarArtista, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_4)
									.addGap(12))
								.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
					.addGap(7))
		);
		customPanel.setLayout(gl_customPanel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 720, Short.MAX_VALUE)
				.addComponent(customPanel, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 498, Short.MAX_VALUE)
				.addComponent(customPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
	}
	
	public static void cargaDelJson() {
		ConnectionManager.busqueda();
		JSONRead JR = new JSONRead();
		JsonParser parser = new JsonParser();
        FileReader fr;
        try {
			fr = new FileReader("UsuariosRegion.json");
			JsonElement datos = parser.parse(fr);
			nickName = JR.getNickNames(datos);
			usuarioID = JR.getUsuarioIDs();
			fotoPerfil = JR.getFotoPerfiles();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void cargaDelJson2() {
		ConnectionManager.busquedaObra(textField.getText());
		JSONRead JR = new JSONRead();
		JsonParser parser = new JsonParser();
        FileReader fr;
        try {
			fr = new FileReader("ObraB.json");
			JsonElement datos = parser.parse(fr);
			tituloObra = JR.getTitulos(datos);
			imagenObra64 = JR.getTextos64();
			ImagenID = JR.getimagenID();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void infoBuscar() {
		
		if(!textField_1.getText().equals(null))
		{
			for(int i = 0; i < nickName.size(); i++)
			{
				if(nickName.get(i).equals(textField_1.getText()))
				{
					retam = 1;
					found = i;
				}
			}
			foto = fotoPerfil.get(found);
			tituloF = nickName.get(found);
			uID = usuarioID.get(found);
			cargarImagenes(foto);
		}
	}
	
public static void infoBuscaObra() {
		
		if(!textField.getText().equals(null))
		{
			for(int i = 0; i < tituloObra.size(); i++)
			{
				if(tituloObra.get(i).equals(textField.getText()))
				{
					retam = 1;
					found = i;
				}
			}
			foto = imagenObra64.get(found);
			tituloF = tituloObra.get(found);
			imID = ImagenID.get(found);
			cargarImagenes(foto);
		}
	}
	
	public static void cargarImagenes(String photo) {
		if(retam == 1)
		{
			//Decodificar la imagen y agregarla a una etiqueta/////////////////////
			byte[] decoder = Base64.getDecoder().decode(photo);
			ByteArrayInputStream bis = new ByteArrayInputStream(decoder);
			BufferedImage image = null;
				try {
					image = ImageIO.read(bis);
					bis.close();
					ImageIcon fott = new ImageIcon(image);
					Icon iconot = new ImageIcon(fott.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_DEFAULT));
					
					label_3.setIcon(iconot);
					label_4.setText(tituloF);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
