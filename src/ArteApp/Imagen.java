package ArteApp;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class Imagen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Imagen(int Ax, int Bx) {
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
		
		JLabel label = new JLabel("ArteApp", SwingConstants.CENTER);
		label.setFont(new Font("SignPainter", Font.PLAIN, 40));
		
		JLabel lblComentarios = new JLabel("Comentarios", SwingConstants.CENTER);
		lblComentarios.setForeground(Color.BLUE);
		
		JLabel label_2 = new JLabel("", SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(Imagen.class.getResource("/botones/icons8-modern_art.png")));
		
		JLabel lblImagen = new JLabel("Imagen", SwingConstants.CENTER);
		lblImagen.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("Imagen 0", SwingConstants.CENTER);
		label_6.setBorder(BorderFactory.createLineBorder(Color.black));
		
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
		GroupLayout gl_customPanel = new GroupLayout(customPanel);
		gl_customPanel.setHorizontalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCerrar, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblComentarios, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(label_2))
						.addComponent(scrollPane_1))
					.addGap(39)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImagen, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
								.addComponent(lblNewLabel)
								.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblLuna, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNube, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_customPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblSol, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addComponent(SolContador, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addComponent(LunaContador, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(NubeContador, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_customPanel.setVerticalGroup(
			gl_customPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_customPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_customPanel.createSequentialGroup()
							.addGap(44)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(label_6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(4)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		customPanel.setLayout(gl_customPanel);
	}
}
