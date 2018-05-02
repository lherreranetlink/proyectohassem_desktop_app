package ArteApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import connection.ConnectionManager;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NuUsuario;
	private JPasswordField password;
	JComboBox<String> comboBoxPaises;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(new Color(204, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		CustomPanel panel = new CustomPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(204, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblArteapp = new JLabel("ArteApp", SwingConstants.CENTER);
		lblArteapp.setFont(new Font("SignPainter", Font.PLAIN, 40));
		lblArteapp.setBounds(293, 71, 185, 67);
		panel.add(lblArteapp);
		
		JLabel lblInicio = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
		lblInicio.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblInicio.setBounds(293, 137, 125, 35);
		panel.add(lblInicio);
		
		NuUsuario = new JTextField();
		NuUsuario.setBounds(293, 184, 185, 43);
		panel.add(NuUsuario);
		NuUsuario.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(293, 239, 185, 43);
		panel.add(password);
		
		final JLabel aceptar = new JLabel("Aceptar", SwingConstants.CENTER);
		aceptar.setForeground(new Color(255, 255, 255));
		aceptar.setOpaque(true);
		aceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		aceptar.setBackground(new Color(0, 204, 0));
		aceptar.setBounds(237, 343, 241, 43);
		
		aceptar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				aceptar.setBackground(new Color(0, 102, 0));
				
			}
			public void mouseExited(MouseEvent e) {
				aceptar.setBackground(new Color(0, 204, 0));
			}
			public void mouseClicked(MouseEvent e) {
				String nickName = NuUsuario.getText().toString();
				String pass = String.valueOf(password.getPassword());
				String pais = comboBoxPaises.getSelectedItem().toString();
				
				if (ConnectionManager.Login(nickName, pass, pais)) {
					PanelPrincipal p = new PanelPrincipal(480, 720);
					p.setVisible(true);
					dispose();
				}
			}
		});
		
		panel.add(aceptar);
		
		JLabel lblIconousuario = new JLabel("");
		lblIconousuario.setIcon(new ImageIcon(Login.class.getResource("/botones/icons8-user.png")));
		lblIconousuario.setBounds(237, 171, 48, 53);
		panel.add(lblIconousuario);
		
		JLabel lblIconollave = new JLabel("");
		lblIconollave.setIcon(new ImageIcon(Login.class.getResource("/botones/icons8-key.png")));
		lblIconollave.setBounds(237, 226, 48, 56);
		panel.add(lblIconollave);
		
		final JLabel lblRegistrarse = new JLabel("Registrarse", SwingConstants.CENTER);
		lblRegistrarse.setForeground(new Color(255, 255, 255));
		lblRegistrarse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Registro reg = new Registro();
				reg.frame.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				lblRegistrarse.setBackground(new Color(0, 0, 153));
			}
			public void mouseExited(MouseEvent e) {
				lblRegistrarse.setBackground(new Color(0, 0, 255));
			}
		});
		lblRegistrarse.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblRegistrarse.setBounds(237, 398, 241, 43);
		lblRegistrarse.setOpaque(true);
		lblRegistrarse.setBackground(new Color(0, 0, 255));
		panel.add(lblRegistrarse);
		
		JLabel lblSalir = new JLabel("Salir", SwingConstants.CENTER);
		lblSalir.setBounds(49, 398, 61, 16);
		panel.add(lblSalir);
		
		final JLabel lblBotonsalir = new JLabel("", SwingConstants.CENTER);
		lblBotonsalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				lblBotonsalir.setIcon(new ImageIcon(Login.class.getResource("/botones/icons8-door_opened.png")));
			}
			public void mouseExited(MouseEvent e) {
				lblBotonsalir.setIcon(new ImageIcon(Login.class.getResource("/botones/icons8-door_closed.png")));
			}
		});
		lblBotonsalir.setIcon(new ImageIcon(Login.class.getResource("/botones/icons8-door_closed.png")));
		lblBotonsalir.setBounds(49, 336, 61, 79);
		panel.add(lblBotonsalir);
		
		JLabel lblAcerca = new JLabel("Acerca", SwingConstants.CENTER);
		lblAcerca.setBounds(606, 398, 61, 16);
		panel.add(lblAcerca);
		
		JLabel lblAcercaicono = new JLabel("", SwingConstants.CENTER);
		lblAcercaicono.setIcon(new ImageIcon(Login.class.getResource("/botones/icons8-info.png")));
		lblAcercaicono.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Acerca");
			}
		});
		lblAcercaicono.setBounds(606, 336, 61, 78);
		panel.add(lblAcercaicono);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Login.class.getResource("/botones/icons8-modern_art.png")));
		lblIcono.setBounds(303, 6, 96, 84);
		panel.add(lblIcono);
		
		comboBoxPaises = new JComboBox<String>();
		comboBoxPaises.setBounds(293, 294, 180, 35);
		panel.add(comboBoxPaises);
		
		llenarComboPaises();
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(247, 296, 38, 35);
		panel.add(lblPais);
		
	}
	
	private void llenarComboPaises() {
		comboBoxPaises.addItem("Mexico");
		comboBoxPaises.addItem("Egipto");
		comboBoxPaises.addItem("India");
	}
}
