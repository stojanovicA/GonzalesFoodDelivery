package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.Restoran;
import Domen.TransferObject;
import Domen.User;
import FrontControler.FrontControler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminPromeniInfo extends JFrame {

	private JPanel contentPane;
	private User user;
	private JTextField tfIme;
	private JTextField tfAdresa;
	private JTextField tfTelefon;
	private Restoran restoran;
	

	
	public AdminPromeniInfo(User user) {
		this.user = user;
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		setujfildove();
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 65, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adresa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 115, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 167, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		tfIme = new JTextField();
		tfIme.setBounds(80, 62, 161, 20);
		contentPane.add(tfIme);
		tfIme.setColumns(10);
		
		tfAdresa = new JTextField();
		tfAdresa.setBounds(80, 112, 161, 20);
		contentPane.add(tfAdresa);
		tfAdresa.setColumns(10);
		
		tfTelefon = new JTextField();
		tfTelefon.setBounds(80, 164, 161, 20);
		contentPane.add(tfTelefon);
		tfTelefon.setColumns(10);
		
		tfIme.setText(restoran.getIme_restorana());
		tfAdresa.setText(restoran.getAdresa());
		tfTelefon.setText(restoran.getTelefon());
		
		/*TransferObject tr = TransferObject.create(user, KonstanteFK.RESTORAN, KonstanteBL.GET);
		Restoran restoran = (Restoran) tr.getResponse()	;
		tfIme.setText(restoran.getIme_restorana());
		tfAdresa.setText(restoran.getAdresa());
		tfTelefon.setText(restoran.getTelefon());*/
		
		JButton btnPromeni = new JButton("Promeni !");
		btnPromeni.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPromeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime = tfIme.getText();
				String adresa = tfAdresa.getText();
				String telefon = tfTelefon.getText();
				int idRestoran = user.getStatus();
				Restoran r = new Restoran(ime, adresa, telefon, idRestoran);
				TransferObject tr = TransferObject.create(r, KonstanteFK.RESTORAN, KonstanteBL.PUT);
				try {
					FrontControler.getInstaca().execute(tr);
					JOptionPane.showMessageDialog(null, "Uspesno ste promenili informacije o restoranu");
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPromeni.setBounds(80, 209, 100, 23);
		contentPane.add(btnPromeni);
		
		JLabel lblNewLabel_3 = new JLabel("Promena informacija");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(61, 11, 166, 28);
		contentPane.add(lblNewLabel_3);
	}


	private void setujfildove() {
		TransferObject tr = TransferObject.create(user, KonstanteFK.RESTORAN, KonstanteBL.GET);
		try {
			
			TransferObject response = FrontControler.getInstaca().execute(tr);
			
			
			restoran = (Restoran) response.getResponse();
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

}
