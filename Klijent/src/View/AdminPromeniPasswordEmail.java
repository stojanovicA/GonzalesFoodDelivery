package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.TransferObject;
import Domen.User;
import FrontControler.FrontControler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AdminPromeniPasswordEmail extends JFrame {

	private JPanel contentPane;
	private User user;
	private JTextField tfEmail;
	private JPasswordField pfPassword;
	private JPasswordField pfRePassword;

	public AdminPromeniPasswordEmail(User user) {
		this.user = user;
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 305, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 73, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(22, 118, 73, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Re-password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(21, 161, 98, 14);
		contentPane.add(lblNewLabel_2);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(120, 70, 122, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Promeni !");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = tfEmail.getText();
				String password = null;
				
				
				if(String.copyValueOf(pfPassword.getPassword()).equals(String.copyValueOf(pfRePassword.getPassword()))) {
					password = String.copyValueOf(pfPassword.getPassword());
					User u = new User(user.getUsername(), password, email);
					TransferObject tr = TransferObject.create(u, KonstanteFK.USER, KonstanteBL.PUT);
					try {
						FrontControler.getInstaca().execute(tr);
						JOptionPane.showMessageDialog(null, "Uspesno ste promenili password");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Passwordi vam se ne poklapaju!");
				}
				
			}
		});
		btnNewButton.setBounds(97, 216, 115, 23);
		contentPane.add(btnNewButton);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(120, 115, 122, 20);
		contentPane.add(pfPassword);
		
		pfRePassword = new JPasswordField();
		pfRePassword.setBounds(120, 159, 122, 20);
		contentPane.add(pfRePassword);
	}
}
