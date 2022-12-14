package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.TransferObject;
import Domen.User;
import FrontControler.FrontControler;
import java.awt.Font;
import java.awt.Color;

public class UserPromeniInfo extends JFrame {

	private JPanel contentPane;
	private User user;
	private JTextField tfEmail;
	private JPasswordField pfPassword;
	private JPasswordField pfRePassword;
	private JLabel lblNewLabel_1;

	
	public UserPromeniInfo(User user) {
		
		this.user = user;
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 305, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(32, 73, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(32, 118, 73, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Re-password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(32, 162, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(122, 70, 145, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		tfEmail.setText(user.getEmail());
		
		JButton btnNewButton = new JButton("Promeni !");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		btnNewButton.setBounds(97, 216, 102, 23);
		contentPane.add(btnNewButton);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(122, 115, 145, 20);
		contentPane.add(pfPassword);
		
		pfRePassword = new JPasswordField();
		pfRePassword.setBounds(122, 159, 145, 20);
		contentPane.add(pfRePassword);
		
		lblNewLabel_1 = new JLabel("Izmena passworda i email-a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(46, 11, 221, 27);
		contentPane.add(lblNewLabel_1);
	}
}