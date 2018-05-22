package ArteApp;

import java.awt.BorderLayout;
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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Idolos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static List<String> titulos = new ArrayList<String>();
	static List<String> textos64 = new ArrayList<String>();
	static List<String> uID = new ArrayList<String>();
	String profilePhotoString = null;
	static int retam = 0;
	static JPanel panel = new JPanel();
	static JScrollPane scrollPane = new JScrollPane();
	static Dimension D = new Dimension();

	/**
	 * Create the frame.
	 */
	public Idolos(int Ax, int Bx) {
		
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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 255));
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
		label_2.setIcon(new ImageIcon(Idolos.class.getResource("/botones/logop.png")));
		
		JButton button = new JButton("Inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				PanelPrincipal pp = new PanelPrincipal(altura, anchura);
				pp.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Idolos.class.getResource("/botones/icons8-home.png")));
		
		JButton btnMisObras = new JButton("Mis Obras");
		btnMisObras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				@SuppressWarnings("unused")
				Obras o = new Obras(altura, anchura);
				//o.setVisible(true);
				dispose();
			}
		});
		btnMisObras.setIcon(new ImageIcon(Idolos.class.getResource("/botones/icons8-collage.png")));
		
		JButton btnAadirNueva = new JButton("Añadir Nueva");
		btnAadirNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				ObraNueva on = new ObraNueva(altura,anchura);
				on.setVisible(true);
				dispose();
			}
		});
		btnAadirNueva.setIcon(new ImageIcon(Idolos.class.getResource("/botones/icons8-add_image.png")));
		
		JButton button_3 = new JButton("Mis Fans");
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
		button_3.setIcon(new ImageIcon(Idolos.class.getResource("/botones/icons8-joining_queue.png")));
		
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
		button_4.setIcon(new ImageIcon(Idolos.class.getResource("/botones/icons8-leaderboard.png")));
		
		JButton button_5 = new JButton("Salir");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		button_5.setIcon(new ImageIcon(Idolos.class.getResource("/botones/icons8-export.png")));
		
		JLabel lblIdolos = new JLabel("Idolos", SwingConstants.CENTER);
		lblIdolos.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("Buscar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Buscar b = new Buscar(altura, anchura);
				b.setVisible(true);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(Idolos.class.getResource("/botones/icons8-search.png")));
		
		
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_customPanel = new GroupLayout(customPanel);
		gl_customPanel.setHorizontalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAadirNueva, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(102)
							.addComponent(lblIdolos, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
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
							.addContainerGap()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblIdolos, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(label_1)
							.addGap(2)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
							.addGap(3)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAadirNueva, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
							.addContainerGap(6, Short.MAX_VALUE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
							.addGap(31))))
		);
		
		
		scrollPane.setViewportView(panel);
		customPanel.setLayout(gl_customPanel);
		
		cargaDelJson();
		setVisible(true);
		
		Dimension D = new Dimension();
		scrollPane.setViewportView(panel);
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//System.out.println(scrollPane.getWidth() + " " + scrollPane.getHeight());
		D.setSize(scrollPane.getWidth(), panel.getMaximumSize().getHeight());
		panel.setPreferredSize(D.getSize());
		panel.setOpaque(false);
		cargarImagenes(this);
	}
	
	public static void cargaDelJson() {
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
			panel.removeAll();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void cargarImagenes(final Idolos idol) {
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
				imagee.setText(titulos.get(i));
				imagee.setIcon(iconot);
				final int in = i;
				imagee.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int altura = 520;
						int anchura = 720;
						@SuppressWarnings("unused")
						UsuarioS us = new UsuarioS(altura, anchura, titulos.get(in), textos64.get(in), uID.get(in));
						//i.setVisible(true);
						idol.dispose();
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
