import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * @wbp.nonvisual location=-108,354
	 */
	private final JProgressBar progressBar = new JProgressBar();
	/**
	 * @wbp.nonvisual location=-149,344
	 */
	private final JTextPane textPane = new JTextPane();
	/**
	 * @wbp.nonvisual location=-405,314
	 */
	private final JToggleButton toggleButton = new JToggleButton("New toggle button");
	/**
	 * @wbp.nonvisual location=-221,274
	 */
	private final JRadioButton radioButton = new JRadioButton("New radio button");
	private JPasswordField password_ent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username_label = new JLabel("Username:");
		username_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username_label.setBounds(92, 63, 80, 16);
		contentPane.add(username_label);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password_label.setBounds(92, 96, 80, 16);
		contentPane.add(password_label);
		
		JTextField username_ent = new JTextField();
		username_ent.setBounds(184, 60, 116, 22);
		contentPane.add(username_ent);
		username_ent.setColumns(10);
		
		JLabel info = new JLabel("New label");
		info.setFont(new Font("Tahoma", Font.PLAIN, 15));
		info.setBounds(92, 211, 256, 16);
		contentPane.add(info);
		info.setText("");
		
		Main main = new Main(info);
		main.mysql_settings();
		
		JButton login_button = new JButton("Login");
		login_button.setForeground(new Color(0, 0, 0));
		login_button.setBackground(new Color(51, 204, 102));
		login_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = username_ent.getText();
				String password = password_ent.getText();
				main.login(username,password);
			}
		});
		login_button.setBounds(92, 136, 208, 25);
		contentPane.add(login_button);
		
		JLabel register_label = new JLabel("Don't you have an account? Click here.");
		register_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Register register = new Register(); // Invokes Register frame.
			}
		});
		register_label.setForeground(new Color(0, 0, 255));
		register_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		register_label.setBounds(92, 182, 256, 16);
		contentPane.add(register_label);
		
		password_ent = new JPasswordField();
		password_ent.setEchoChar('*');
		password_ent.setBounds(184, 94, 116, 22);
		contentPane.add(password_ent);
	
	}
}
