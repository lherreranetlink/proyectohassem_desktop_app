package ArteApp;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;

public class chosser extends JFrame {
	JFrame frame2;
	String ruta;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public chosser() {
		frame2 = new JFrame();
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.setBounds(100, 100, 584, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame2.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(6, 6, 550, 400);
		int OK = fileChooser.showOpenDialog(this);
	    if(OK == JFileChooser.APPROVE_OPTION) {
	    		ruta = fileChooser.getSelectedFile().getPath();
	    		//System.out.println(ruta);
	    		frame2.dispose();
	    }
	    else
	    {
	    		frame2.dispose();
	    }
	    
		panel.add(fileChooser);
		
		
		//frame2.setVisible(true);
	}
}
