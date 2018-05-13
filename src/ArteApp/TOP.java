package ArteApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TOP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TOP(int Ax, int Bx) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		label_2.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-modern_art.png")));
		
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
		button.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-home.png")));
		
		JButton button_1 = new JButton("Mis Obras");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Obras o = new Obras(altura, anchura);
				o.setVisible(true);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-collage.png")));
		
		JButton button_2 = new JButton("Añadir Nueva");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				ObraNueva on = new ObraNueva(altura, anchura);
				on.setVisible(true);
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-add_image.png")));
		
		JButton button_3 = new JButton("Idolos");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Idolos i = new Idolos(altura, anchura);
				i.setVisible(true);
				dispose();
			}
		});
		button_3.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-leaving_queue.png")));
		
		JButton btnMisFans = new JButton("Mis Fans");
		btnMisFans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int altura = getHeight();
				int anchura = getWidth();
				Fans f = new Fans(altura, anchura);
				f.setVisible(true);
				dispose();
			}
		});
		btnMisFans.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-joining_queue.png")));
		
		JButton button_5 = new JButton("Salir");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		button_5.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-export.png")));
		
		final JLabel label_3 = new JLabel("", SwingConstants.CENTER);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_3.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-left_round.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_3.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-left_circular.png")));
			}
		});
		label_3.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-left_circular.png")));
		
		final JLabel label_4 = new JLabel("", SwingConstants.CENTER);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-right_round.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_4.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-right_circular.png")));
			}
		});
		label_4.setIcon(new ImageIcon(TOP.class.getResource("/botones/icons8-right_circular.png")));
		
		JLabel lblTop = new JLabel("TOPs", SwingConstants.CENTER);
		lblTop.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
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
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMisFans, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addGap(84)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTop, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
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
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(3)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addComponent(btnMisFans, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTop, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
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
