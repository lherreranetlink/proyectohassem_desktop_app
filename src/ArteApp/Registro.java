package ArteApp;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import connection.ConnectionManager;

public class Registro extends JFrame {
	JFrame frame;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Nusuario;
	private JPasswordField password;
	private JTextField Correo;
	private JRadioButton ATC;
	private JTextField Edad;
	String ruta = "";
	JComboBox<String> sexo;
	JComboBox<String> region;

	/**
	 * Create the frame.
	 */
	public Registro() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		CustomPanel panel = new CustomPanel();
		panel.setOpaque(false);
		
		JLabel Lregistro = new JLabel("Registro", SwingConstants.CENTER);
		Lregistro.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		Nombre = new JTextField();
		TextPrompt placeholderN = new TextPrompt("Nombre", Nombre);
		placeholderN.changeAlpha(0.75f);
	    placeholderN.changeStyle(Font.ITALIC);
		Nombre.setColumns(10);
		
		Nusuario = new JTextField();
		TextPrompt placeholderU = new TextPrompt("Nombre de Usuario", Nusuario);
		placeholderU.changeAlpha(0.75f);
	    placeholderU.changeStyle(Font.ITALIC);
		Nusuario.setColumns(10);
		
		password = new JPasswordField();
		TextPrompt placeholderP = new TextPrompt("Contraseña", password);
		placeholderP.changeAlpha(0.75f);
	    placeholderP.changeStyle(Font.ITALIC);
		
		Correo = new JTextField();
		TextPrompt placeholderC = new TextPrompt("Correo Electronico", Correo);
		placeholderC.setText("Correo Electrónico");
		placeholderC.changeAlpha(0.75f);
	    placeholderC.changeStyle(Font.ITALIC);
		Correo.setColumns(10);
		
		ATC = new JRadioButton("Acepta los Términos y Condiciones");
		
		Edad = new JTextField();
		TextPrompt placeholderE = new TextPrompt("Edad", Edad);
		placeholderE.changeAlpha(0.75f);
	    placeholderE.changeStyle(Font.ITALIC);
		Edad.setColumns(10);
		
		sexo = new JComboBox<String>();
		region = new JComboBox<String>();
		
		JLabel label_1 = new JLabel("", SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-help.png")));
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Terminos y Condiciones.");
			}
		});
		
		JLabel label_2 = new JLabel("", SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-modern_art.png")));
		
		JLabel lblNomicono = new JLabel("", SwingConstants.CENTER);
		lblNomicono.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-gender_neutral_user.png")));
		
		JLabel lblUsericono = new JLabel("", SwingConstants.CENTER);
		lblUsericono.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-dog_tag.png")));
		
		JLabel lblNewLabel = new JLabel("", SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-key_2.png")));
		
		JLabel label_3 = new JLabel("", SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-message.png")));
		
		JLabel label_4 = new JLabel("", SwingConstants.CENTER);
		label_4.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-resume.png")));
		
		JLabel label_5 = new JLabel("", SwingConstants.CENTER);
		label_5.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-gender_symbols.png")));
		
		JLabel label_6 = new JLabel("", SwingConstants.CENTER);
		label_6.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-globe.png")));
		
		JButton btnSleccionarImagen = new JButton("Seleccionar Imagen");
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-ok.png")));
		
		JButton cancelar = new JButton("");
		cancelar.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-cancel.png")));
		
		final JLabel imagen = new JLabel("Imagen de Perfil", SwingConstants.CENTER);
		imagen.setBackground(new Color(255, 255, 255));
		imagen.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblRegistroicono = new JLabel("", SwingConstants.CENTER);
		lblRegistroicono.setIcon(new ImageIcon(Registro.class.getResource("/botones/icons8-id_card.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
					.addGap(1))
		);
		
		JLabel label = new JLabel("ArteApp", SwingConstants.CENTER);
		label.setFont(new Font("SignPainter", Font.PLAIN, 40));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(label_2)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(72)
											.addComponent(Lregistro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(141))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNomicono, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(Nombre, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblUsericono, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(Nusuario, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(password, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(Correo, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(Edad, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(sexo, 0, 324, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(region, 0, 324, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ATC, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
							.addComponent(lblRegistroicono, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(11))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(27)
									.addComponent(aceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(12)
									.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(27)
										.addComponent(btnSleccionarImagen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(33)
										.addComponent(imagen, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(Lregistro)))
							.addGap(17)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomicono, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(7)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsericono, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(Nusuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(11)
									.addComponent(password, GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)))
							.addGap(7)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(Correo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(8)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(Edad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(sexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(region, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(6))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRegistroicono, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(imagen, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnSleccionarImagen, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(aceptar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(ATC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(3))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					String name = Nombre.getText().toString();
					String nickName = Nusuario.getText().toString();
					String pass = String.valueOf(password.getPassword());
					String mail = Correo.getText().toString();
					String edad = Edad.getText().toString();
					String sex = sexo.getSelectedItem().toString();
					String country = region.getSelectedItem().toString();
					if (ConnectionManager.Register(name, nickName, pass, mail, edad, sex, country)) {
						Login l = new Login();
						l.setVisible(true);
						frame.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
				}
			}
		});
		
		btnSleccionarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosser cho = new chosser();
				ruta = cho.ruta;
				if(ruta != "")
				{
					imagen.setText(null);
					ImageIcon fott = new ImageIcon(ruta);
					Icon iconot = new ImageIcon(fott.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
					imagen.setIcon(iconot);					
				}
			}
		});
		fillGenreComboBox();
		fillCountryComboBox();
	}
	
	private void fillGenreComboBox() {
		sexo.addItem("Femenino");
		sexo.addItem("Masculino");
	}
	
	private void fillCountryComboBox() {
		region.addItem("Mexico");
		region.addItem("Egipto");
		region.addItem("Indio");
	}
	
	public boolean validateForm(){
		return (!Nombre.getText().toString().equals("") && !Nusuario.getText().equals("")
							&& !String.valueOf(password.getPassword()).equals("") && 
							!Correo.getText().toString().equals("")
							&& !Edad.getText().toString().equals(""));
	}
	
}
