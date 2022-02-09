package gui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import bank.BankAccountDatabase;
import exception.EqualsNickNameException;
import exception.NicknameNotFoundException;
import exception.PasswordException;
import exception.balanceException;
import fileManager.FileWrite;

/**
 * this class container main window
 * @author Buscarino Antonino
 *
 */
public class BankMenu extends JFrame implements MouseListener, Runnable {
	private JButton button0, button1, button2, button3, button4;
	private BankAccountDatabase bankAccount;
	private CreationAccount createAccount;
	private LoginAccount loginAccount;
	private boolean stateLabel;
	private JLabel label;
	
	public static void main(String[] args) {
		Thread thread = new Thread(new BankMenu());
		thread.start();
	}
	
	@Override
	public void run() {
		new BankMenu().setVisible(true);
	}
	
	public BankMenu() {
		super("bank menu");
		setSize(1000, 800);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		
		initButton();
		stateLabel = false;
	}
	
	private void initButton() {
		button0 = createButton("create account", 20, 100, 300, 100);
		button1 = createButton("login", 350, 100, 300, 100);
		button2 = createButton("deposit", 100, 400, 100, 100);
		button3 = createButton("withdrawal", 400, 400, 100, 100);
		button4 = createButton("get balance", 700, 400, 100, 100);
		
		add(button0);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		
		button0.setVisible(true);
		button1.setVisible(true);
	}
	
	private void createAccountGui() {	
		createAccount = new CreationAccount();
		FileWrite.mkdir();
		button0.setText("complete account");
		button0.setName("complete account");
	}
	
	private void createAccount() throws IOException, EqualsNickNameException {
		int balance = createAccount.getBalance();
		String password = createAccount.getPassword();
		String nickname = createAccount.getNickname();
		
		bankAccount = new BankAccountDatabase(nickname, password, balance);
	
		bankAccount.writeNickname();
		bankAccount.writePassword();
		bankAccount.writeBalance();
		
		button0.setText("create account");
		button0.setName("create account");
	}
	
	private void visibleButtonGui() {
		loginAccount = new LoginAccount();
		button1.setText("complete login");
		button1.setName("complete login");
	}
	
	private void visibleButton() throws IOException, NicknameNotFoundException, PasswordException {
		bankAccount = new BankAccountDatabase(loginAccount.getNickname(), loginAccount.getPassword());
		bankAccount.readNickname();		//verification nickname
		bankAccount.readPassword();		//check password
		bankAccount.readBalance();		//check balance
		
		button2.setVisible(true);
		button3.setVisible(true);
		button4.setVisible(true);
		
		
		button1.setText("login");
		button1.setName("login");
	}
	
	private void deposit() throws IOException, NumberFormatException, HeadlessException, balanceException {
		bankAccount.deposit(Integer.parseInt(JOptionPane.showInputDialog("insert ammout")));
		bankAccount.modifyWriteBalance();
	}
	
	private void withdrawal() throws NumberFormatException, HeadlessException, balanceException, IOException {
		bankAccount.withdrawal(Integer.parseInt(JOptionPane.showInputDialog("insert ammout")));
		bankAccount.modifyWriteBalance();
	}
	
	private void getBalance( ) {
		JOptionPane.showConfirmDialog(this, bankAccount.getBalance(), "view balance", JOptionPane.OK_CANCEL_OPTION);
	}
	
	private void createLabel() {
		if(stateLabel) {
			remove(label);
		}
		 label = new JLabel("<html>" +
									"<body style=\" font-family: 'Times New Roman'; color: red\">" +
									"sei nel profilo di: " +
									bankAccount.getNickname() +
									"</body>" +
									"/html>");
		
		label.setBounds(680, 100, 300, 100);
		add(label);
		stateLabel = true;
	}
	
	private JButton createButton(String name, int x, int y, int width, int height) {
		JButton button = new JButton("<html>" +
									"<body style=\" font-family: 'Times New Roman';\">" +
									name +
									"</body>" +
									"/html>");
		
		button.setBounds(x, y, width, height);
		button.setName(name);
		button.addMouseListener(this);
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setBackground(Color.MAGENTA);
		button.setVisible(false);
		return button;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			switch(e.getComponent().getName()) {
			case "create account":
				createAccountGui();
				break;
			case "complete account":
				createAccount();
				break;
			case "login":
				visibleButtonGui();
				break;
			case "complete login":
				visibleButton();
				createLabel();
				break;
			case "deposit":
				deposit();
				break;
			case "withdrawal":
				withdrawal();
				break;
			case "get balance":
				getBalance();
				break;
			}
		}
		catch(Exception e1) {
			JOptionPane.showConfirmDialog(this, e1.getMessage(), "Exception", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		update(getGraphics());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
