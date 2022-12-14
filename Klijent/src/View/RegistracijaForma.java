package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

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

import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import java.awt.Font;
import java.awt.SystemColor;

public class RegistracijaForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfPrezimeIme;
	private JTextField tfUsername;
	private JDateChooser dateChooser;
	private JPasswordField pfPassword;
	private JPasswordField pfPassword2;
	private JTextField tfEmail;
	private JLabel lblslova;
	private JLabel lblikonica;
	

	public RegistracijaForma() {
		setForeground(SystemColor.activeCaption);
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
		ImageIcon gonzales = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\80x80.png");
		ImageIcon slova = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\107x30.png");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prezime i ime");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(64, 52, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDatumRodjenja = new JLabel("Datum rodjenja");
		lblDatumRodjenja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatumRodjenja.setBounds(64, 96, 121, 14);
		contentPane.add(lblDatumRodjenja);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(64, 176, 98, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(64, 214, 79, 14);
		contentPane.add(lblPassword);
		
		tfPrezimeIme = new JTextField();
		tfPrezimeIme.setBounds(216, 49, 127, 20);
		contentPane.add(tfPrezimeIme);
		tfPrezimeIme.setColumns(10);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(216, 173, 127, 20);
		contentPane.add(tfUsername);
		
		JLabel lblPonovitePassowrd = new JLabel("Ponovite password");
		lblPonovitePassowrd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPonovitePassowrd.setBounds(64, 256, 121, 14);
		contentPane.add(lblPonovitePassowrd);
		
		JButton btnRegistracija = new JButton("Registracija");
		btnRegistracija.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistracija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prezimeIme = tfPrezimeIme.getText();
				int dan = dateChooser.getJCalendar().getDayChooser().getDay();
				int mesec = dateChooser.getJCalendar().getMonthChooser().getMonth()+1;
				int godina = dateChooser.getJCalendar().getYearChooser().getYear();
				LocalDate datumrodjenja = LocalDate.of(godina, mesec, dan);
				String email = tfEmail.getText();
				String username = tfUsername.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				String password2 = String.copyValueOf(pfPassword2.getPassword());
				int status = 0;
				int id_app = 1;
				if( password.equals(password2)) {
					User user = new User(prezimeIme, datumrodjenja, email, username, password, status, id_app);
					TransferObject tr = TransferObject.create(user, KonstanteFK.USER, KonstanteBL.POST);
					try {
						TransferObject tr1 = FrontControler.getInstaca().execute(tr);
						String message = tr1.getMessage();
						
						JOptionPane.showMessageDialog(null, message);
						dispose();
						
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Lozinka se ne poklapa, molimo Vas da ponovite !");
				}
				
			}
		});
		btnRegistracija.setBounds(162, 315, 132, 23);
		contentPane.add(btnRegistracija);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(216, 96, 127, 20);
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setDate(new Date());
		
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(216, 211, 127, 20);
		contentPane.add(pfPassword);
		
		pfPassword2 = new JPasswordField();
		pfPassword2.setBounds(216, 253, 127, 20);
		contentPane.add(pfPassword2);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(216, 140, 127, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(64, 143, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		lblslova = new JLabel(slova);
		lblslova.setBounds(327, 315, 107, 30);
		contentPane.add(lblslova);
		
		lblikonica = new JLabel(gonzales);
		lblikonica.setBounds(0, 281, 77, 72);
		contentPane.add(lblikonica);
	}
}
