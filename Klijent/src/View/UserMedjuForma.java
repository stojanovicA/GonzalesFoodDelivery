package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import Domen.Restoran;
import Domen.User;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMedjuForma extends JFrame {

	private JPanel contentPane;
	User user1;
	JPopupMenu menu;
	JMenuItem m1,m2;

	
	public UserMedjuForma(User user) {
		
		this.user1 = user;
		
		
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		
		Icon icon = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\mama buba.jpg");
		Icon icon2 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\inter.jpg");
		Icon icon3 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\walter.jpg");
		Icon icon4 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\kfc.jpg");
		Icon icon5 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\smokvica.jpg");
		Icon icon6 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\mek.jpg");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 838);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton btnBurgerHouse = new JButton(icon);
		btnBurgerHouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRestoran = 1;
				UserFormaGLAVNONarucivanje ufg = new UserFormaGLAVNONarucivanje(idRestoran,user1);
				ufg.setVisible(true);
			}
		});
		btnBurgerHouse.setBounds(24, 48, 268, 168);
		contentPane.add(btnBurgerHouse);
		
		JButton btnIntergalactic = new JButton(icon2);
		btnIntergalactic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRestoran = 2;
				UserFormaGLAVNONarucivanje ufg = new UserFormaGLAVNONarucivanje(idRestoran,user1);
				ufg.setVisible(true);
			}
		});
		btnIntergalactic.setBounds(312, 48,268, 168);
		contentPane.add(btnIntergalactic);
		
		JButton btnWalter = new JButton(icon3);
		btnWalter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRestoran = 3;
				UserFormaGLAVNONarucivanje ufg = new UserFormaGLAVNONarucivanje(idRestoran,user1);
				ufg.setVisible(true);
			}
		});
		btnWalter.setBounds(24, 283, 268, 168);
		contentPane.add(btnWalter);
		
		JButton btnKfc = new JButton(icon4);
		btnKfc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRestoran = 4;
				UserFormaGLAVNONarucivanje ufg = new UserFormaGLAVNONarucivanje(idRestoran,user1);
				ufg.setVisible(true);
			}
		});
		btnKfc.setBounds(312, 283,268, 168);
		contentPane.add(btnKfc);
		
		JButton btnSmokvica = new JButton(icon5);
		btnSmokvica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRestoran = 5;
				UserFormaGLAVNONarucivanje ufg = new UserFormaGLAVNONarucivanje(idRestoran,user1);
				ufg.setVisible(true);
			}
		});
		btnSmokvica.setBounds(24, 518, 268, 168);
		contentPane.add(btnSmokvica);
		
		JButton btnMcDonalds = new JButton(icon6);
		btnMcDonalds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRestoran = 6;
				UserFormaGLAVNONarucivanje ufg = new UserFormaGLAVNONarucivanje(idRestoran,user1);
				ufg.setVisible(true);
			}
			
		});
		btnMcDonalds.setBounds(312, 518, 268, 168);
		contentPane.add(btnMcDonalds);
		
		JLabel lblNewLabel = new JLabel("Burger House");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 218, 258, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Burgeri, Americka hrana, Rostilj");
		lblNewLabel_1.setBounds(24, 236, 268, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblIntergalacticDiner = new JLabel("Intergalactic Diner");
		lblIntergalacticDiner.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIntergalacticDiner.setBounds(312, 218, 258, 19);
		contentPane.add(lblIntergalacticDiner);
		
		JLabel lblWalter = new JLabel("Walter");
		lblWalter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWalter.setBounds(24, 454, 258, 19);
		contentPane.add(lblWalter);
		
		JLabel lblKfc = new JLabel("KFC");
		lblKfc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKfc.setBounds(312, 454, 258, 19);
		contentPane.add(lblKfc);
		
		JLabel lblNewLabel_1_1 = new JLabel("Burgeri, Americka hrana, Internacionalna hrana");
		lblNewLabel_1_1.setBounds(312, 236, 268, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Rostilj, Srpska hrana");
		lblNewLabel_1_2.setBounds(24, 471, 268, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Piletina, Burgeri, Americka hrana");
		lblNewLabel_1_2_1.setBounds(312, 471, 268, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblSmokvica = new JLabel("Smokvica");
		lblSmokvica.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSmokvica.setBounds(24, 689, 258, 19);
		contentPane.add(lblSmokvica);
	
		JLabel lblMcdonads = new JLabel("McDonald's");
		lblMcdonads.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMcdonads.setBounds(312, 689, 258, 19);
		contentPane.add(lblMcdonads);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Internacionalna hrana, Libanska hrana, Azijska hrana");
		lblNewLabel_1_2_2.setBounds(24, 707, 268, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Burgeri, Americka hrana, Poslastice");
		lblNewLabel_1_2_3.setBounds(312, 707, 268, 14);
		contentPane.add(lblNewLabel_1_2_3);
		Icon logo1 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\GONZALESMINI.png");
		JLabel lblLogovaniUser = new JLabel(logo1);
		lblLogovaniUser.setBounds(379, 0, 51, 37);
		contentPane.add(lblLogovaniUser);
		Icon logo = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\UGAO.png");
		
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(322, 732, 84, 77);
		contentPane.add(lblLogo);
		
		JLabel lblNewLabel_2 = new JLabel("Korisnik: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(440, 11, 43, 14);
		contentPane.add(lblNewLabel_2);
		Icon logo3 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\dostava logo.png");
		
		JLabel lblDostava = new JLabel(logo3);
		lblDostava.setBounds(404, 743, 221, 56);
		contentPane.add(lblDostava);
		Icon logo4 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\t.png");
		JButton btnSetings = new JButton(logo4);
		menu=new JPopupMenu();
		m1=new JMenuItem("Podesavanja naloga");
        m2=new JMenuItem("Moji racuni");
        menu.add(m1);
        menu.add(m2);
		btnSetings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showPopup(ae);
				
				
				
			}
		});
		m1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            	UserPromeniInfo ai = new UserPromeniInfo(user);
				ai.setVisible(true);
            } 
        }); 
  
        m2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            UserIstorijaPorudzbina appe = new UserIstorijaPorudzbina(user);
             appe.setVisible(true);
            } 
        }); 
		btnSetings.setBounds(565, 4, 25, 25);
		contentPane.add(btnSetings);
		
		JLabel lblUser = new JLabel("New label");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(493, 11, 84, 14);
		contentPane.add(lblUser);
		lblUser.setText(user.getUsername());
		
	/*	JButton btnNewButton_4 = new JButton("admin");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminForma af = new AdminForma();
				af.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(82, 11, 89, 23);
		contentPane.add(btnNewButton_4); */
		
		
		
		
		
		
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
