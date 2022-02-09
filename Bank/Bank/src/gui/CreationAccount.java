package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * this class create a create account window
 * @author Buscarino Antonino
 *
 */
public class CreationAccount extends JFrame implements MouseListener{
	private JTextField text1, text3;
	private JPasswordField text2;
	private JButton button0;
	private String nickname, password;
	private int balance;
	
	/**
	 * constructor
	 */
	public CreationAccount() {
		super("Creation account");
		setSize(600, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		
		text1 = createTextField("insert nickname", 100, 50, 400, 100);
		text2 = createPasswordField("insert password", 100, 200, 400, 100);
		text3 = createTextField("insert balance", 100, 350, 400, 100);
		button0 = createButton("confirm", 250, 480, 100, 50);
		
		add(text1);
		add(text2);
		add(text3);
		add(button0);
		
		setVisible(true);
	}
	
	/**
	 * 
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
		
	}
	
	/**
	 * 
	 * @return balance
	 */
	public int getBalance() {
		return balance;
	}

	//create TextField object and returns
	private JTextField createTextField(String message, int x, int y, int width, int height) {
		JTextField text = new JTextField(message);
		text.setBounds(x, y, width, height);
		text.setName(message);
		return text;
	}
	
	//create JPasswordField object and returns
	private JPasswordField createPasswordField(String message, int x, int y, int width, int height) {
		JPasswordField text = new JPasswordField(message);
		text.setBounds(x, y, width, height);
		text.setName(message);
		return text;
	}
	
	//create JButton object and returns
	private JButton createButton(String name, int x, int y, int width, int height) {
		JButton button = new JButton("<html>" +
									"<body style=\" font-family: 'Times New Roman'\">" +
									name +
									"</body>" +
									"/html>");
		
		button.setBounds(x, y, width, height);
		button.setName(name);
		button.addMouseListener(this);
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setVisible(true);
		return button;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			nickname = text1.getText();
			password = text2.getText();
			balance = Integer.parseInt(text3.getText());
			dispose();
		}
		catch(Exception e1) {
			JOptionPane.showConfirmDialog(this, e1.getMessage(), "Exception", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
