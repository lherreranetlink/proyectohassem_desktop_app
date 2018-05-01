package ArteApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class ObraNueva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField titulo;
	String ruta = null;
	//FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
	String nombreImagen = null;
	BufferedImage imagen;
	int n = 0;
	JProgressBar progressBar = new JProgressBar(0, 100);
	
	//Creacion de un hilo
	Thread hiloProgressBar = new Thread() {
		public void run() {
			while(n <= 100)
			{
				n++;
				progressBar.setValue(n);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(n >= 100)
			{
				JOptionPane.showMessageDialog(null,"La Imagen se a Subido Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
	};

	/**
	 * Create the frame.
	 */
	public ObraNueva(int Ax, int Bx) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		if(Ax < 489)
		{
			Ax = 489;
		}
		setBounds(100, 100, Bx, Ax);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		CustomPanel customPanel = new CustomPanel();
		customPanel.setOpaque(false);
		customPanel.setBackground(new Color(204, 255, 255));
		
		JLabel label_2 = new JLabel("ArteApp", SwingConstants.CENTER);
		label_2.setFont(new Font("SignPainter", Font.PLAIN, 40));
		
		JLabel label_3 = new JLabel("Herramientas", SwingConstants.CENTER);
		label_3.setForeground(Color.BLUE);
		
		JLabel label_4 = new JLabel("", SwingConstants.CENTER);
		label_4.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-modern_art.png")));
		
		JButton button_1 = new JButton("Inicio");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				PanelPrincipal pp = new PanelPrincipal(altura, anchura);
				pp.setVisible(true);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-home.png")));
		
		JButton btnMisObras = new JButton("Mis Obras");
		btnMisObras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Obras o = new Obras(altura, anchura);
				o.setVisible(true);
				dispose();
			}
		});
		btnMisObras.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-collage.png")));
		
		JButton button_9 = new JButton("Idolos    ");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Idolos i = new Idolos(altura, anchura);
				i.setVisible(true);
				dispose();
			}
		});
		button_9.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-leaving_queue.png")));
		
		JButton button_10 = new JButton("Mis Fans");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Fans f = new Fans(altura, anchura);
				f.setVisible(true);
				dispose();
			}
		});
		button_10.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-joining_queue.png")));
		
		JButton button_11 = new JButton("TOPs");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				TOP t = new TOP(altura, anchura);
				t.setVisible(true);
				dispose();
			}
		});
		button_11.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-leaderboard.png")));
		
		JButton button_12 = new JButton("Salir");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		button_12.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-export.png")));
		
		final JLabel label_5 = new JLabel("", SwingConstants.CENTER);
		label_5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//click;
			}
			public void mouseExited(MouseEvent e) {
				label_5.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-left_circular.png")));
			}
			public void mouseEntered(MouseEvent e) {
				label_5.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-left_round.png")));
			}
		});
		label_5.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-left_circular.png")));
		
		final JLabel label_6 = new JLabel("", SwingConstants.CENTER);
		label_6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label_6.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-right_round.png")));
			}
			public void mouseExited(MouseEvent e) {
				label_6.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-right_circular.png")));
			}
		});
		label_6.setIcon(new ImageIcon(ObraNueva.class.getResource("/botones/icons8-right_circular.png")));
		
		JLabel lblAadirNuevaObra_1 = new JLabel("Añadir Nueva Obra", SwingConstants.CENTER);
		lblAadirNuevaObra_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			
		titulo = new JTextField();
		TextPrompt placeholdert = new TextPrompt("Nombre de la Obra", titulo);
		placeholdert.changeAlpha(0.75f);
	    placeholdert.changeStyle(Font.ITALIC);
		titulo.setColumns(10);
		
		JButton btnSubir = new JButton("Subir");
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreImagen = titulo.getText();
				//System.out.println(ruta + " + " + nombreImagen);
				if((ruta != null) && (nombreImagen != null))
				{
						try {
							ImageIO.write(imagen, "jpg", new File("src/Imagenes/" + nombreImagen + ".jpg"));
							hiloProgressBar.start();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		
		JLabel lblArchivoCargado = new JLabel("Archivo Cargado: ");
		
		final JLabel lblNa = new JLabel("N/A");
		
		JFileChooser fileChooser = new JFileChooser();
		//fileChooser.setFileFilter(filtroImagen);
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser auxC = (JFileChooser)e.getSource();
				String OK = e.getActionCommand();
			    if(OK.equals(JFileChooser.APPROVE_SELECTION)) {
			    		ruta = auxC.getSelectedFile().getPath();
			    		String nombreArchivo = auxC.getSelectedFile().getName();
			    		lblNa.setText(nombreArchivo);
			    		File f = new File(ruta);
			    	    try {
							imagen = ImageIO.read(f);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    }
			    else
			    {
			    		int altura = getHeight();
					int anchura = getWidth();
					PanelPrincipal pp = new PanelPrincipal(altura, anchura);
					pp.setVisible(true);
					dispose();
			    }
			}
		});
		
	    
		GroupLayout gl_customPanel = new GroupLayout(customPanel);
		gl_customPanel.setHorizontalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_4))
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_customPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(84)
							.addComponent(lblAadirNuevaObra_1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
							.addGap(106))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(fileChooser, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_customPanel.createSequentialGroup()
									.addComponent(titulo, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSubir, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_customPanel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblArchivoCargado)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNa, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
								.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
							.addGap(45))))
		);
		gl_customPanel.setVerticalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(44)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(74)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblArchivoCargado)
								.addComponent(lblNa))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(3)
					.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblAadirNuevaObra_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubir))
					.addGap(40)
					.addComponent(fileChooser, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
					.addContainerGap())
		);
		customPanel.setLayout(gl_customPanel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(customPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(customPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
