package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import Domen.User;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminForma extends JFrame {

	private JPanel contentPane;
	User user1;
	JPopupMenu menu;
	JMenuItem m1,m2;

	
	public AdminForma(User user) {
		
		this.user1 = user;
		
		ImageIcon settings = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\t.png");
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Icon logo3 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\dostava logo.png");
		
		JLabel lblDostava = new JLabel(logo3);
		lblDostava.setBounds(213, 205, 221, 56);
		contentPane.add(lblDostava);
		
		Icon logo = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\UGAO.png");
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(136, 184, 84, 77);
		contentPane.add(lblLogo);
		
		JButton btnNewButton = new JButton("Dodaj novo jelo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDodajNovoJelo adminDodajNovoJelo = new AdminDodajNovoJelo(user1);
				adminDodajNovoJelo.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(136, 118, 177, 23);
		contentPane.add(btnNewButton);
		
		JButton btnIzmeniInformacijeO = new JButton("Aktuelne porudzbine");
		btnIzmeniInformacijeO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAktuelnePorudzbine adminAktuelnePorudzbine = new AdminAktuelnePorudzbine(user1);
				adminAktuelnePorudzbine.setVisible(true);
			}
		});
		btnIzmeniInformacijeO.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIzmeniInformacijeO.setBounds(136, 11, 177, 63);
		contentPane.add(btnIzmeniInformacijeO);
		
		JButton btnSettings = new JButton(settings);
		menu=new JPopupMenu();
		m1=new JMenuItem("Promena opstih infomacija restorana");
        m2=new JMenuItem("Promeni password ili e-mail");
        menu.add(m1);
        menu.add(m2);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showPopup(ae);
				
				
				
			}
		});
		m1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            	AdminPromeniInfo ai = new AdminPromeniInfo(user1);
				ai.setVisible(true);
            } 
        }); 
  
        m2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
              AdminPromeniPasswordEmail appe = new AdminPromeniPasswordEmail(user1);
              appe.setVisible(true);
            } 
        }); 
		btnSettings.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSettings.setBounds(399, 11, 25, 25);
		contentPane.add(btnSettings);
		
		JButton btnIstorijaPorudzbina = new JButton("Istorija porudzbina");
		btnIstorijaPorudzbina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminIstorijaPorudzbina is = new AdminIstorijaPorudzbina(user1);
				is.setVisible(true);
			}
		});
		btnIstorijaPorudzbina.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIstorijaPorudzbina.setBounds(136, 85, 177, 23);
		contentPane.add(btnIstorijaPorudzbina);
		
		JButton btnDodajPriloge = new JButton("Dodaj priloge");
		btnDodajPriloge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDodajPriloge ad = new AdminDodajPriloge(user1);
				ad.setVisible(true);
			}
		});
		btnDodajPriloge.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDodajPriloge.setBounds(136, 152, 177, 23);
		contentPane.add(btnDodajPriloge);
	}
		
		  private void showPopup(ActionEvent ae)
		    {
		        // Get the event source
		        Component b=(Component)ae.getSource();
		        
		        // Get the location of the point 'on the screen'
		        Point p=b.getLocationOnScreen();
		        
		        
		        // Show the JPopupMenu via program
		        
		        // Parameter desc
		        // ----------------
		        // this - represents current frame
		        // 0,0 is the co ordinate where the popup
		        // is shown
		        menu.show(this,0,0);
		        
		        // Now set the location of the JPopupMenu
		        // This location is relative to the screen
		        menu.setLocation(p.x,p.y+b.getHeight());
	}
}
