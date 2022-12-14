package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Domen.Jelo;
import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.Prilog;
import Domen.Racun;
import Domen.StavkaJelo;
import Domen.TransferObject;
import Domen.User;
import Domen.VrsteJela;
import FrontControler.FrontControler;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class UserFormaGLAVNONarucivanje extends JFrame {

	private JPanel contentPane;
	private User user;
	private Racun racun;
	private JTable tableSvaJela;
	private JTable tableJelaKorpa;
	JComboBox<String> cbVrsta ;
	private int idRestoran;
	private DefaultTableModel dtmSvaJela = new DefaultTableModel();
	private DefaultTableModel dtmPorudzbina = new DefaultTableModel();
	private DefaultTableModel dtmPrilozi = new DefaultTableModel();
	
	private JTable tablePrilozi;
	private List<Jelo>jelo = new ArrayList<>();
	
	private int idJela;
	private String nazivJela;
	
	private List<StavkaJelo>stavke = new ArrayList<>();
	private int cena ;
	
	private JTextArea textArea;
	
	private int idRacun;
	private Racun rrr;
	
	private int porudzbinaIdJela;
	private String prilozi;
	private JLabel lblUkupno;
	private JTextField tfAdresa;
	private JLabel background;
	private String slikaString;
	public UserFormaGLAVNONarucivanje(int idRestoran, User user) {
		
		
		this.idRestoran = idRestoran;
		this.user = user;
		setLocationRelativeTo(null);
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		
		Icon plusButonIcon = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\PlusJava.png");
		Icon obrisibutIcon = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\ObrisiJavaKoristim.png");
		/*	Icon icon3 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\walter.jpg");
		Icon icon4 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\kfc.jpg");
		Icon icon5 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\smokvica.jpg");
		Icon icon6 = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\mek.jpg"); */
		Integer i = idRestoran;
		TransferObject  slikareq = TransferObject.create(i, KonstanteFK.RESTORAN, KonstanteBL.GET_SLIKA);
		try {
			TransferObject response = FrontControler.getInstaca().execute(slikareq);
			 slikaString = (String) response.getResponse();
		} catch (ClassNotFoundException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Icon logo = new ImageIcon(slikaString);
		
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 910, 607);
		contentPane = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		UserFormaGLAVNONarucivanje.class.getResource("/slike/gonzalespozadina.jpg"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };  
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogo.setBounds(711, 11, 173, 173);
		contentPane.add(lblLogo);
		
		JScrollPane sPSvaJela = new JScrollPane(tableSvaJela);
		sPSvaJela.setBounds(164, 91, 417, 216);
		contentPane.add(sPSvaJela);
		
		tableSvaJela = new JTable(dtmSvaJela);
		tableSvaJela.setRowHeight(30);
		tableSvaJela.setFont(new Font("Tahoma",Font.PLAIN , 12));
		//table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 20));
		
		tableSvaJela.getTableHeader().setFont(new Font("Tahoma",Font.BOLD, 15));
		
		
		tableSvaJela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = tableSvaJela.getSelectedRow();
				idJela =  (int) tableSvaJela.getModel().getValueAt(red, 0);
				nazivJela = (String) tableSvaJela.getModel().getValueAt(red, 1);
				cena = (int) tableSvaJela.getModel().getValueAt(red, 2);
				
				
			}
		});
		sPSvaJela.setViewportView(tableSvaJela);
		
		Object[]kolone = {"ID","Naziv","Cena","Vrsta"};
		dtmSvaJela.addColumn(kolone[0]);
		dtmSvaJela.addColumn(kolone[1]);
		dtmSvaJela.addColumn(kolone[2]);
		dtmSvaJela.addColumn(kolone[3]);
		
		tableSvaJela.getColumnModel().getColumn(0).setPreferredWidth(32);
		tableSvaJela.getColumnModel().getColumn(1).setPreferredWidth(245);
		tableSvaJela.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableSvaJela.getColumnModel().getColumn(3).setPreferredWidth(80);
		postaviSvaJela();
		
		JScrollPane spJelaKorpa = new JScrollPane(tableJelaKorpa);
		spJelaKorpa.setBounds(159, 355, 417, 138);
		contentPane.add(spJelaKorpa);
		
		tableJelaKorpa = new JTable(dtmPorudzbina);
		
		tableJelaKorpa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = tableJelaKorpa.getSelectedRow();
				porudzbinaIdJela = (int) tableJelaKorpa.getModel().getValueAt(red, 0);
				prilozi = (String) tableJelaKorpa.getModel().getValueAt(red, 2);
				
			}
		});
		spJelaKorpa.setViewportView(tableJelaKorpa);
		Object[]koloneKorpa = {"ID","Naziv","Prilozi","Cena"};
		dtmPorudzbina.addColumn(koloneKorpa[0]);
		dtmPorudzbina.addColumn(koloneKorpa[1]);
		dtmPorudzbina.addColumn(koloneKorpa[2]);
		dtmPorudzbina.addColumn(koloneKorpa[3]);
		tableJelaKorpa.getColumnModel().getColumn(0).setPreferredWidth(32);
		tableJelaKorpa.getColumnModel().getColumn(1).setPreferredWidth(185);
		tableJelaKorpa.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableJelaKorpa.getColumnModel().getColumn(3).setPreferredWidth(50);
		
		cbVrsta = new JComboBox();
		cbVrsta.setBounds(299, 64, 167, 22);
		contentPane.add(cbVrsta);
		
		JButton btnNewButton = new JButton("Prikazi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmSvaJela.setRowCount(0);
				String find = (String) cbVrsta.getSelectedItem();
				for (Jelo j : jelo) {
					if(find.equals(j.getVrstaJela())) {
						Object[]red = {j.getIdJelo(),j.getNaziv(),j.getCena(),j.getVrstaJela()};
						dtmSvaJela.addRow(red);
						
						
					}
			}
			}
		});
		btnNewButton.setBounds(476, 63, 82, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Vrsta jela");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(219, 65, 73, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Spisak jela");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(328, 23, 253, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Porudzbina");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(306, 332, 160, 22);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane spPrilozi = new JScrollPane(tablePrilozi);
		spPrilozi.setBounds(742, 215, 100, 116);
		contentPane.add(spPrilozi);
		
		tablePrilozi = new JTable(dtmPrilozi);
		spPrilozi.setViewportView(tablePrilozi);
		Object[]kolonePrilozi = {"Naziv priloga"};
		dtmPrilozi.addColumn(kolonePrilozi[0]);
		postaviPriloge();
		
		JLabel lblNewLabel_3 = new JLabel("Besplatni prilozi");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(742, 192, 115, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Upisi prilog");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(608, 111, 82, 30);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane spPrilozizaJelo = new JScrollPane();
		spPrilozizaJelo.setBounds(601, 138, 100, 48);
		contentPane.add(spPrilozizaJelo);
		textArea = new JTextArea();
		spPrilozizaJelo.setViewportView(textArea);
		
		JButton btnDodaj = new JButton(plusButonIcon);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String prilozi = textArea.getText()	;
				StavkaJelo stavka = new StavkaJelo(idJela, prilozi, 0, nazivJela,cena);
				stavke.add(stavka);
				postaviStavke();
				textArea.setText("");
				
				
			}
		});
		btnDodaj.setBounds(601, 230, 89, 77);
		contentPane.add(btnDodaj);
		
		
		
		
		JButton btnObrisi = new JButton(obrisibutIcon);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(StavkaJelo s :stavke) {
					if(porudzbinaIdJela == s.getIdJela() && prilozi.equals(s.getPrilozi())) {
						stavke.remove(s);
						postaviStavke();
						break;
					}
				}
			}
		});
		btnObrisi.setBounds(591, 396, 89, 77);
		contentPane.add(btnObrisi);
		
		JLabel lblNewLabel_5 = new JLabel("Ukupno:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(164, 521, 115, 30);
		contentPane.add(lblNewLabel_5);
		
		lblUkupno = new JLabel(" New label");
		lblUkupno.setForeground(Color.WHITE);
		lblUkupno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUkupno.setBounds(256, 525, 89, 26);
		contentPane.add(lblUkupno);
		lblUkupno.setText("0");
		
		JButton btnNewButton_3 = new JButton("Poruci !\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Da li ste sigurni ?");
				if(input == 0) {
					int iznos = Integer.parseInt(lblUkupno.getText());
					String username = user.getUsername();
					LocalDate datum = LocalDate.now()	;
					int restoran = idRestoran;
					int status = 0;
					String adresa = tfAdresa.getText();
					racun = new Racun(iznos, username, datum, restoran, status, adresa);
					TransferObject tr = TransferObject.create(racun, KonstanteFK.RACUN, KonstanteBL.POST);
					try {
						FrontControler.getInstaca().execute(tr);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					TransferObject t1 = TransferObject.create(user, KonstanteFK.RACUN, KonstanteBL.GET_LAST);
					try {
						TransferObject response = FrontControler.getInstaca().execute(t1);
						rrr = (Racun) response.getResponse();
						idRacun = rrr.getId_racun();
						
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for(StavkaJelo s : stavke) {
						s.setIdRacun(idRacun);
						TransferObject transfer = TransferObject.create(s, KonstanteFK.STAVKA_JELO, KonstanteBL.POST);
						try {
							FrontControler.getInstaca().execute(transfer);
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					UserZavrsnaForma uf = new UserZavrsnaForma(rrr);
					uf.setVisible(true);
					dispose();
				
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(742, 511, 152, 53);
		contentPane.add(btnNewButton_3);
		
		
		postaviComboBox();
		cbVrsta.setSelectedIndex(-1);
		
		JLabel lblNewLabel_6 = new JLabel("din");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(340, 531, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		tfAdresa = new JTextField();
		tfAdresa.setBounds(547, 531, 185, 20);
		contentPane.add(tfAdresa);
		tfAdresa.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Adresa za dostavu");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(579, 515, 153, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_4_1 = new JLabel("Dodaj porudzbinu");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(601, 210, 110, 22);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Obrisi porudzbinu");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1.setBounds(591, 372, 124, 30);
		contentPane.add(lblNewLabel_4_1_1);
	}
	public void postaviComboBox() {
		TransferObject tr = TransferObject.create(null, KonstanteFK.VRSTE_JELA, KonstanteBL.GET);
		try {
			TransferObject response = FrontControler.getInstaca().execute(tr);
			List<VrsteJela>vrsteJela = (List<VrsteJela>) response.getResponse();
			for( VrsteJela v : vrsteJela) {
				cbVrsta.addItem(v.getVrsta());
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void postaviSvaJela() {
		dtmSvaJela.setRowCount(0);
		User user2 = user;
		user2.setStatus(idRestoran);
		TransferObject request = TransferObject.create(user, KonstanteFK.JELO, KonstanteBL.GET);
		try {
			TransferObject response = FrontControler.getInstaca().execute(request);
			jelo = (List<Jelo>) response.getResponse();
			for(Jelo j:jelo) {
				Object[]red = {j.getIdJelo(),j.getNaziv(),j.getCena(),j.getVrstaJela()};
				dtmSvaJela.addRow(red);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	private void postaviPriloge() {
		dtmPrilozi.setRowCount(0);
		User user2 = user;
		user2.setStatus(idRestoran);
		TransferObject request = TransferObject.create(user, KonstanteFK.PRILOG, KonstanteBL.GET);
		try {
			TransferObject response = FrontControler.getInstaca().execute(request);
			List<Prilog>prilozi = (List<Prilog>) response.getResponse();
			for(Prilog p : prilozi) {
				Object[]red = {p.getIme()};
				dtmPrilozi.addRow(red);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}
	
	private void postaviStavke() {
		dtmPorudzbina.setRowCount(0);
		int ukupno = 0;
		for(StavkaJelo s : stavke) {
			Object[]red = {s.getIdJela(),s.getNaziv(),s.getPrilozi(),s.getCena()};
			dtmPorudzbina.addRow(red);
			ukupno = ukupno + s.getCena();
			lblUkupno.setText(String.valueOf(ukupno));
			
		
	}
}
}
