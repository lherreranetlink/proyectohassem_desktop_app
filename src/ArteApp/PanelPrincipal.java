package ArteApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelPrincipal extends JFrame {

	//JFrame frame2;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PanelPrincipal(int Ax, int Bx) {
		//frame2 = new JFrame();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 720, 480);
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
				Obras ob = new Obras(altura, anchura);
				ob.setVisible(true);
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
				Idolos i = new Idolos(altura, anchura);
				i.setVisible(true);
				dispose();
			}
		});
		
		JButton btnMisFans = new JButton("Mis Fans");
		btnMisFans.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-joining_queue.png")));
		btnMisFans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Fans f = new Fans(altura, anchura);
				f.setVisible(true);
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
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		
		JLabel lblNuevas = new JLabel("Inicio", SwingConstants.CENTER);
		lblNuevas.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel lblImagen = new JLabel("Imagen 0", SwingConstants.CENTER);
		lblImagen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Imagen i = new Imagen(altura, anchura);
				i.setVisible(true);
				//dispose();
			}
		});
		lblImagen.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblImagen_2 = new JLabel("Imagen 3", SwingConstants.CENTER);
		lblImagen_2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_1 = new JLabel("Imagen 1", SwingConstants.CENTER);
		label_1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblImagen_1 = new JLabel("Imagen 2", SwingConstants.CENTER);
		lblImagen_1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblImagen_3 = new JLabel("Imagen 4", SwingConstants.CENTER);
		lblImagen_3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblImagen_4 = new JLabel("Imagen 5", SwingConstants.CENTER);
		lblImagen_4.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblImagen_5 = new JLabel("Imagen 6", SwingConstants.CENTER);
		lblImagen_5.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblImagen_6 = new JLabel("Imagen 7", SwingConstants.CENTER);
		lblImagen_6.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblImagen_7 = new JLabel("Imagen 8", SwingConstants.CENTER);
		lblImagen_7.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblNombreImagen = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_2 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_3 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_4 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_5 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_6 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_7 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_8 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_9 = new JLabel("ArteApp", SwingConstants.CENTER);
		label_9.setFont(new Font("SignPainter", Font.PLAIN, 40));
		
		JLabel label_10 = new JLabel("", SwingConstants.CENTER);
		label_10.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-modern_art.png")));
		
		final JLabel label_11 = new JLabel("", SwingConstants.CENTER);
		label_11.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-left_circular.png")));
		label_11.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label_11.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-left_round.png")));
			}
			public void mouseExited(MouseEvent e) {
				label_11.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-left_circular.png")));
			}
		});
		
		final JLabel label_12 = new JLabel("", SwingConstants.CENTER);
		label_12.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-right_circular.png")));
		label_12.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label_12.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-right_round.png")));
			}
			public void mouseExited(MouseEvent e) {
				label_12.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/botones/icons8-right_circular.png")));
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHerramientas, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_10))
						.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAadirNuevaObra, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIdolos, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMisFans, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTops, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
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
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(96)
							.addComponent(lblHerramientas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addComponent(btnMisObras, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(btnAadirNuevaObra, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(btnIdolos, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(3)
					.addComponent(btnMisFans, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addComponent(btnTops, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNuevas, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImagen, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblImagen_1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNombreImagen)
						.addComponent(label)
						.addComponent(label_2))
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImagen_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblImagen_3, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblImagen_4, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5))
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImagen_5, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblImagen_6, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblImagen_7, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_6)
						.addComponent(label_7)
						.addComponent(label_8))
					.addGap(17))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		//setVisible(true);
		//frame2.setVisible(true);
	}
}
