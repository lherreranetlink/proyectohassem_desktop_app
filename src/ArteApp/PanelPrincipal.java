package ArteApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import JsonRead.JSONRead;
import connection.ConnectionManager;
import javax.swing.JLabel;
import javax.swing.JButton;
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

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PanelPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JLabel lblImagen, label_1, lblImagen_1, lblImagen_2, lblImagen_3, lblImagen_4, lblImagen_5, lblImagen_6, lblImagen_7;
	static JLabel lblNombreImagen, label, label_2, label_3, label_4, label_5, label_6, label_7, label_8;
	static List<String> titulos = new ArrayList<String>();
	static List<String> textos64 = new ArrayList<String>();
	static List<String> uID = new ArrayList<String>();
	String profilePhotoString = null;
	static int retam = 0;
	private JButton buscar;

	/**
	 * Create the frame.
	 */
	public PanelPrincipal(int Ax, int Bx) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				if(retam != 0)
				{
					cargarImagenes();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 720, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		CustomPanel panel = new CustomPanel();
		panel.setOpaque(false);
		
		panel.setBackground(new Color(204, 255, 255));
		
		JLabel lblHerramientas = new JLabel("Herramientas", SwingConstants.CENTER);
		lblHerramientas.setForeground(new Color(0, 0, 255));
		
		JButton btnMisObras = new JButton("Mis Obras");
		btnMisObras.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-collage.png")));
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
		
		JButton btnAadirNuevaObra = new JButton("Añadir Nueva");
		btnAadirNuevaObra.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-add_image.png")));
		btnAadirNuevaObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				ObraNueva on = new ObraNueva(altura, anchura);
				on.setVisible(true);
				dispose();
			}
		});
		
		JButton btnIdolos = new JButton("Idolos    ");
		btnIdolos.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-leaving_queue.png")));
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
		
		JButton btnMisFans = new JButton("Mis Fans");
		btnMisFans.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-joining_queue.png")));
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
		
		JButton btnTops = new JButton("TOPs");
		btnTops.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-leaderboard.png")));
		btnTops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				TOP t = new TOP(altura, anchura);
				t.setVisible(true);
				dispose();
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-export.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame2.dispose();
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNuevas = new JLabel("Inicio", SwingConstants.CENTER);
		lblNuevas.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		lblImagen = new JLabel("", SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-help.png")));
		lblImagen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				int altura = getHeight();
				int anchura = getWidth();
				Imagen i = new Imagen(altura, anchura, titulos.get(0), textos64.get(0), uID.get(0));
				i.setVisible(true);
				
			}
		});
		lblImagen.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblImagen_2 = new JLabel("", SwingConstants.CENTER);
		lblImagen_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Imagen i = new Imagen(altura, anchura, titulos.get(3), textos64.get(3), uID.get(3));
				//i.setVisible(true);
			}
		});
		lblImagen_2.setBorder(BorderFactory.createLineBorder(Color.black));
		
	    label_1 = new JLabel("", SwingConstants.CENTER);
	    label_1.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Imagen i = new Imagen(altura, anchura, titulos.get(1), textos64.get(1), uID.get(1));
				//i.setVisible(true);
	    	}
	    });
		label_1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblImagen_1 = new JLabel("", SwingConstants.CENTER);
		lblImagen_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Imagen i = new Imagen(altura, anchura, titulos.get(2), textos64.get(2), uID.get(2));
				//i.setVisible(true);
			}
		});
		lblImagen_1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblImagen_3 = new JLabel("", SwingConstants.CENTER);
		lblImagen_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Imagen i = new Imagen(altura, anchura, titulos.get(4), textos64.get(4), uID.get(4));
				//i.setVisible(true);
			}
		});
		lblImagen_3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblImagen_4 = new JLabel("", SwingConstants.CENTER);
		lblImagen_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Imagen i = new Imagen(altura, anchura, titulos.get(5), textos64.get(5), uID.get(5));
				//i.setVisible(true);
			}
		});
		lblImagen_4.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblImagen_5 = new JLabel("", SwingConstants.CENTER);
		lblImagen_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Imagen i = new Imagen(altura, anchura, titulos.get(6), textos64.get(6), uID.get(6));
				//i.setVisible(true);
			}
		});
		lblImagen_5.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblImagen_6 = new JLabel("", SwingConstants.CENTER);
		lblImagen_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Imagen i = new Imagen(altura, anchura, titulos.get(7), textos64.get(7), uID.get(7));
				//i.setVisible(true);
			}
		});
		lblImagen_6.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblImagen_7 = new JLabel("", SwingConstants.CENTER);
		lblImagen_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Imagen i = new Imagen(altura, anchura, titulos.get(8), textos64.get(8), uID.get(8));
				//i.setVisible(true);
			}
		});
		lblImagen_7.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblNombreImagen = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		label = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		label_2 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		label_3 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		label_4 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		label_5 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		label_6 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		label_7 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		label_8 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_10 = new JLabel("", SwingConstants.CENTER);
		label_10.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/logop.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 461, Short.MAX_VALUE)
		);
		
		buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Buscar b = new Buscar(altura, anchura);
				b.setVisible(true);
				dispose();
			}
		});
		buscar.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(label_10))
								.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMisFans, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnIdolos, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAadirNuevaObra, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnTops, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(buscar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblHerramientas, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addGap(84)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNuevas, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblImagen, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(lblImagen_1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNombreImagen, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblImagen_2, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(lblImagen_3, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(lblImagen_4, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblImagen_5, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(lblImagen_6, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(lblImagen_7, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(1)))
					.addGap(106))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHerramientas)
							.addGap(8)
							.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addGap(3)
							.addComponent(buscar, GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
							.addGap(1)
							.addComponent(btnAadirNuevaObra, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIdolos, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMisFans, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTops, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNuevas, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImagen, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
								.addComponent(lblImagen_1, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNombreImagen)
								.addComponent(label)
								.addComponent(label_2))
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImagen_2, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(lblImagen_3, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(lblImagen_4, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_3)
								.addComponent(label_4)
								.addComponent(label_5))
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImagen_5, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(lblImagen_6, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(lblImagen_7, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_6)
								.addComponent(label_7)
								.addComponent(label_8))))
					.addGap(7))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		cargaDelJson();
		setVisible(true);
		cargarImagenes();
		//frame2.setVisible(true);
	}
	
	public static void cargaDelJson() {
		ConnectionManager.imagenesAzar();
		JSONRead JR = new JSONRead();
		JsonParser parser = new JsonParser();
        FileReader fr;
        try {
			fr = new FileReader("azar.json");
			JsonElement datos = parser.parse(fr);
			titulos = JR.getTitulos(datos);
			textos64 = JR.getTextos64();
			uID = JR.getUsuarioIDs();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void cargarImagenes() {
		//System.out.println(titulos.get(0));
		//System.out.println(textos64.get(0));
		retam = 1;
		
		//Decodificar la imagen y agregarla a una etiqueta/////////////////////
		byte[] decoder = Base64.getDecoder().decode(textos64.get(0));
		ByteArrayInputStream bis = new ByteArrayInputStream(decoder);
		BufferedImage image = null;
		try {
			image = ImageIO.read(bis);
			
			bis.close();
			ImageIcon fott = new ImageIcon(image);
			Icon iconot = new ImageIcon(fott.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
			
			lblImagen.setIcon(iconot);
			lblNombreImagen.setText(titulos.get(0));
			
			decoder = Base64.getDecoder().decode(textos64.get(1));
			bis = new ByteArrayInputStream(decoder);
			image = null;
			image = ImageIO.read(bis);
			bis.close();
			fott = new ImageIcon(image);
			iconot = new ImageIcon(fott.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT));
			
			label_1.setIcon(iconot);
			label.setText(titulos.get(1));
			
			decoder = Base64.getDecoder().decode(textos64.get(2));
			bis = new ByteArrayInputStream(decoder);
			image = null;
			image = ImageIO.read(bis);
			bis.close();
			fott = new ImageIcon(image);
			iconot = new ImageIcon(fott.getImage().getScaledInstance(lblImagen_1.getWidth(), lblImagen_1.getHeight(), Image.SCALE_DEFAULT));
			
			lblImagen_1.setIcon(iconot);
			label_2.setText(titulos.get(2));
			
			decoder = Base64.getDecoder().decode(textos64.get(3));
			bis = new ByteArrayInputStream(decoder);
			image = null;
			image = ImageIO.read(bis);
			bis.close();
			fott = new ImageIcon(image);
			iconot = new ImageIcon(fott.getImage().getScaledInstance(lblImagen_2.getWidth(), lblImagen_2.getHeight(), Image.SCALE_DEFAULT));
			
			lblImagen_2.setIcon(iconot);
			label_3.setText(titulos.get(3));
			
			decoder = Base64.getDecoder().decode(textos64.get(4));
			bis = new ByteArrayInputStream(decoder);
			image = null;
			image = ImageIO.read(bis);
			bis.close();
			fott = new ImageIcon(image);
			iconot = new ImageIcon(fott.getImage().getScaledInstance(lblImagen_3.getWidth(), lblImagen_3.getHeight(), Image.SCALE_DEFAULT));
			
			lblImagen_3.setIcon(iconot);
			label_4.setText(titulos.get(4));
			
			decoder = Base64.getDecoder().decode(textos64.get(5));
			bis = new ByteArrayInputStream(decoder);
			image = null;
			image = ImageIO.read(bis);
			bis.close();
			fott = new ImageIcon(image);
			iconot = new ImageIcon(fott.getImage().getScaledInstance(lblImagen_4.getWidth(), lblImagen_4.getHeight(), Image.SCALE_DEFAULT));
			
			lblImagen_4.setIcon(iconot);
			label_5.setText(titulos.get(5));
			
			decoder = Base64.getDecoder().decode(textos64.get(6));
			bis = new ByteArrayInputStream(decoder);
			image = null;
			image = ImageIO.read(bis);
			bis.close();
			fott = new ImageIcon(image);
			iconot = new ImageIcon(fott.getImage().getScaledInstance(lblImagen_5.getWidth(), lblImagen_5.getHeight(), Image.SCALE_DEFAULT));
			
			lblImagen_5.setIcon(iconot);
			label_6.setText(titulos.get(6));
			
			decoder = Base64.getDecoder().decode(textos64.get(7));
			bis = new ByteArrayInputStream(decoder);
			image = null;
			image = ImageIO.read(bis);
			bis.close();
			fott = new ImageIcon(image);
			iconot = new ImageIcon(fott.getImage().getScaledInstance(lblImagen_6.getWidth(), lblImagen_6.getHeight(), Image.SCALE_DEFAULT));
			
			lblImagen_6.setIcon(iconot);
			label_7.setText(titulos.get(7));
			
			decoder = Base64.getDecoder().decode(textos64.get(8));
			bis = new ByteArrayInputStream(decoder);
			image = null;
			image = ImageIO.read(bis);
			bis.close();
			fott = new ImageIcon(image);
			iconot = new ImageIcon(fott.getImage().getScaledInstance(lblImagen_7.getWidth(), lblImagen_7.getHeight(), Image.SCALE_DEFAULT));
			
			lblImagen_7.setIcon(iconot);
			label_8.setText(titulos.get(8));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////////////////////
	}
}
