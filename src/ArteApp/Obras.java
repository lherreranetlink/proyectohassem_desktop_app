package ArteApp;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Obras extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Obras(int Ax, int Bx) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, Bx, Ax);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		CustomPanel customPanel = new CustomPanel();
		customPanel.setOpaque(false);
		customPanel.setBackground(new Color(204, 255, 255));
		contentPane.add(customPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("ArteApp", SwingConstants.CENTER);
		label.setFont(new Font("SignPainter", Font.PLAIN, 40));
		
		JLabel label_1 = new JLabel("Herramientas", SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		
		JLabel label_2 = new JLabel("", SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-modern_art.png")));
		
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
		
		JButton button_2 = new JButton("Idolos    ");
		button_2.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-leaving_queue.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Idolos i = new Idolos(altura, anchura);
				i.setVisible(true);
				dispose();
			}
		});
		
		JButton button_3 = new JButton("Mis Fans");
		button_3.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-joining_queue.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Fans f = new Fans(altura, anchura);
				f.setVisible(true);
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
		
		final JLabel label_3 = new JLabel("", SwingConstants.CENTER);
		label_3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label_3.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-left_round.png")));
			}
			public void mouseExited(MouseEvent e) {
				label_3.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-left_circular.png")));
			}
		});
		label_3.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-left_circular.png")));
		
		final JLabel label_4 = new JLabel("", SwingConstants.CENTER);
		label_4.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				label_4.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-right_circular.png")));
			}
			public void mouseEntered(MouseEvent e) {
				label_4.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-right_round.png")));
			}
		});
		label_4.setIcon(new ImageIcon(Obras.class.getResource("/botones/icons8-right_circular.png")));
		
		JLabel lblMisobras = new JLabel("Mis Obras", SwingConstants.CENTER);
		lblMisobras.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("Imagen 0", SwingConstants.CENTER);
		label_6.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_7 = new JLabel("Imagen 1", SwingConstants.CENTER);
		label_7.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_8 = new JLabel("Imagen 2", SwingConstants.CENTER);
		label_8.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_9 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_10 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_11 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_12 = new JLabel("Imagen 3", SwingConstants.CENTER);
		label_12.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_13 = new JLabel("Imagen 4", SwingConstants.CENTER);
		label_13.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_14 = new JLabel("Imagen 5", SwingConstants.CENTER);
		label_14.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_15 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_16 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_17 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_18 = new JLabel("Imagen 6", SwingConstants.CENTER);
		label_18.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_19 = new JLabel("Imagen 7", SwingConstants.CENTER);
		label_19.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_20 = new JLabel("Imagen 8", SwingConstants.CENTER);
		label_20.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label_21 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_22 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		
		JLabel label_23 = new JLabel("Nombre Imagen", SwingConstants.CENTER);
		GroupLayout gl_customPanel = new GroupLayout(customPanel);
		gl_customPanel.setHorizontalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 710, Short.MAX_VALUE)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_2))
						.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addGap(84)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMisobras, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(label_9, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(label_10, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_11, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(label_12, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(label_13, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(label_14, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(label_15, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_16, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_17, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(label_18, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_19, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(label_20, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addComponent(label_21, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_22, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(label_23, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(1)))
					.addGap(106))
		);
		gl_customPanel.setVerticalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 448, Short.MAX_VALUE)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(44)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(96)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(3)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblMisobras, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_9)
						.addComponent(label_10)
						.addComponent(label_11))
					.addGap(2)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_12, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(label_13, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(label_14, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_15)
						.addComponent(label_16)
						.addComponent(label_17))
					.addGap(2)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_18, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(label_19, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(label_20, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_21)
						.addComponent(label_22)
						.addComponent(label_23))
					.addGap(17))
		);
		customPanel.setLayout(gl_customPanel);
	}
}
