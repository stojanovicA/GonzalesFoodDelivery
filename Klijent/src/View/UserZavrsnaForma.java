package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.Racun;
import Domen.TransferObject;
import Domen.User;
import Domen.VremeDostave;
import FrontControler.FrontControler;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserZavrsnaForma extends JFrame {

	private JPanel contentPane;
	private Racun racun1;
	

	
	public UserZavrsnaForma(Racun racun) {
		this.racun1 = racun;
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
		ImageIcon uspesna = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\uspesnaporudzbina.jpg");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPorudzbina = new JLabel("");
		lblPorudzbina.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPorudzbina.setBounds(10, 25, 414, 82);
		contentPane.add(lblPorudzbina);
		
		JLabel lblVreme = new JLabel("");
		lblVreme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblVreme.setBounds(28, 118, 396, 40);
		contentPane.add(lblVreme);
		
		JLabel lblPotvrda = new JLabel(uspesna);
		lblPotvrda.setBounds(130, 154, 180, 175);
		contentPane.add(lblPotvrda);
		lblPotvrda.setVisible(false);
         
		if(racun1.getStatus_porudzbine() == 0) {
        	 lblPorudzbina.setText("       Vasa porudzbina se obradjuje....");
			
		}
		
		JButton proveriPorudzbinu = new JButton("Proveri porudzbinu");
		proveriPorudzbinu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferObject tr = TransferObject.create(racun1, KonstanteFK.RACUN, KonstanteBL.GET_RACUN);
				try {
					TransferObject response = FrontControler.getInstaca().execute(tr);
					racun1 = (Racun) response.getResponse()	; 
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if(racun1.getStatus_porudzbine() == 1) {
					TransferObject t = TransferObject.create(racun1, KonstanteFK.VREMEDOSTAVE, KonstanteBL.GET);
					String poruka = null;
					try {
						TransferObject response = FrontControler.getInstaca().execute(t);
						VremeDostave vremeDostave = (VremeDostave) response.getResponse();
						poruka = vremeDostave.getPoruka();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblPorudzbina.setText("      Vasa porudzbina je prihvacena ! ");
					lblVreme.setText("Ocekivano vreme vase isporuke je: "+poruka+" min");
					proveriPorudzbinu.setVisible(false);
					lblPotvrda.setVisible(true);
					
					
					
					
				}else if (racun1.getStatus_porudzbine()==2){
					lblPorudzbina.setText("      Vasa porudzbina je odbijena !");
					proveriPorudzbinu.setVisible(false);
				}
			}
		});
		proveriPorudzbinu.setBounds(106, 190, 206, 61);
		contentPane.add(proveriPorudzbinu);
		
		
		
		
		
		
	}

}
