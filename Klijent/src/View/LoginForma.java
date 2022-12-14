package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.TransferObject;
import Domen.User;
import FrontControler.FrontControler;
import proxy.LoginUser;
import proxy.ProxyLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class LoginForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private static LoginForma frame;

	/**
	 * Launch the application.
	 * 
	 * 
	 * stao si na ispravci dodavanja jela da ne vrati sve nego za odredjeni restoran
	 * isto to uraditi za priloge, pa onda i za  racun
	 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginForma();
					frame.setVisible(true);
					ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
				    frame.setIconImage(ikonica.getImage());
					frame.setTitle("Gonzales dostava");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForma() {
		setForeground(SystemColor.activeCaption);
		ImageIcon gonzales = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\80x80.png");
		ImageIcon slova = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\107x30.png");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 269);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(46, 50, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(46, 85, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(117, 47, 139, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(117, 82, 139, 20);
		contentPane.add(pfPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = String.valueOf(pfPassword.getPassword());
				User user = new User(username,password);
				TransferObject tr =TransferObject.create(user, KonstanteFK.USER, KonstanteBL.GET_USER);
				try {
					TransferObject respone = FrontControler.getInstaca().execute(tr);
					User u = (User) respone.getResponse();
					ProxyLogin proxyLogin = new LoginUser();
					proxyLogin.login(u,frame);
					
					
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Pogresan password za ukucan username");
					e1.printStackTrace();
				}
				
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(140, 126, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Niste korisnik? Sta cekate ? ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(218, 185, 138, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Registruj se!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistracijaForma rf = new RegistracijaForma();
				rf.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(218, 200, 128, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblikonica = new JLabel(gonzales);
		lblikonica.setBounds(266, 36, 77, 72);
		contentPane.add(lblikonica);
		
		JLabel lblslova = new JLabel(slova);
		lblslova.setBounds(10, 193, 107, 30);
		contentPane.add(lblslova);
	}
}
