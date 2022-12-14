package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.Racun;
import Domen.StavkeNaRacunu;
import Domen.TransferObject;
import Domen.User;
import Domen.VremeDostave;
import FrontControler.FrontControler;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class AdminAktuelnePorudzbine extends JFrame {

	private JPanel contentPane;
	private User user;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private JButton btnOdbij;
	private JButton btnPrihvati;
	private JButton btnOsvezi;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private Integer idRacun;

	private DefaultTableModel dtm2 = new DefaultTableModel();
	private JTextField tfVreme;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblslova;
	private JLabel lblikonica;
	
	public AdminAktuelnePorudzbine(User user) {
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
		ImageIcon gonzales = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\80x80.png");
		ImageIcon slova = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\107x30.png");
		ImageIcon prihvati = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\PRIHVATI.png");
		ImageIcon odbij = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\odbijmajmune.png");
		ImageIcon refresuj = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\refresuj.png");

	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		this.user = user;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 635, 239);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		
		Object[]kolone = {"Datum porudzbine","Broj racuna","Iznos","Narucilac","Status","Adresa za Isporuku"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		postaviPodatke();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				idRacun =  (Integer) table.getModel().getValueAt(red, 1);
				//SELECT * from jela INNER JOIN stavkajelo on jela.id_jela=stavkajelo.id_jela INNER JOIN racun ON stavkajelo.id_racun=racun.id_racun where racun.id_racun = 2
				postaviPodatke2();
			}

			
		});
		scrollPane.setViewportView(table);
		
		btnOdbij = new JButton(odbij);
		btnOdbij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferObject tr = TransferObject.create(idRacun, KonstanteFK.RACUN, KonstanteBL.PUT_REJECT);
				//UPDATE `racun` SET `status_porudzbine`= 1 WHERE id_racun = 2
				try {
					FrontControler.getInstaca().execute(tr);
					
					JOptionPane.showMessageDialog(null, "Uspesno ste odbili porudzbinu");
					postaviPodatke();
					dtm2.setRowCount(0);;
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Porudzbina je i dalje na cekanju, molimo Vas kontaktirajte tim ADMINA");
				}
				
			}
		});
		btnOdbij.setBounds(555, 536, 90, 90);
		contentPane.add(btnOdbij);
		
		btnPrihvati = new JButton(prihvati);
		btnPrihvati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferObject tr = TransferObject.create(idRacun, KonstanteFK.RACUN, KonstanteBL.PUT);
				//UPDATE `racun` SET `status_porudzbine`= 1 WHERE id_racun = 2
				String poruka = tfVreme.getText();
				VremeDostave vd = new VremeDostave(poruka, idRacun);
				
				try {
					FrontControler.getInstaca().execute(tr);
					TransferObject tr2 = TransferObject.create(vd, KonstanteFK.VREMEDOSTAVE, KonstanteBL.POST);
					FrontControler.getInstaca().execute(tr2);
					JOptionPane.showMessageDialog(null, "Uspesno ste prihvatili porudzbinu");
					postaviPodatke();
					dtm2.setRowCount(0);
					
					
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Porudzbina nije prihvacena, molimo Vas kontaktirajte ADMIN tim");
				}
				
			}
		});
		btnPrihvati.setBounds(555, 423, 90, 90);
		contentPane.add(btnPrihvati);
		
		btnOsvezi = new JButton(refresuj);
		btnOsvezi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviPodatke();
			}
		});
		btnOsvezi.setBounds(465, 275, 70, 70);
		contentPane.add(btnOsvezi);
		
		scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 275, 445, 351);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable(dtm2);
		scrollPane_1.setViewportView(table_1);
		
		tfVreme = new JTextField();
		tfVreme.setBounds(475, 458, 44, 20);
		contentPane.add(tfVreme);
		tfVreme.setColumns(10);
		
		lblNewLabel = new JLabel("Vreme dostave");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(465, 444, 102, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("min");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(521, 461, 28, 14);
		contentPane.add(lblNewLabel_1);
		
		lblslova = new JLabel(slova);
		lblslova.setBounds(538, 634, 107, 30);
		contentPane.add(lblslova);
		
		lblikonica = new JLabel(gonzales);
		lblikonica.setBounds(458, 603, 77, 72);
		contentPane.add(lblikonica);
		Object[]kolone2 = {"Naziv Jela","Prilozi","Cena"};
		dtm2.addColumn(kolone2[0]);
		dtm2.addColumn(kolone2[1]);
		dtm2.addColumn(kolone2[2]);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(20);
		
		
		
	}
	
	private void postaviPodatke() {
		dtm.setRowCount(0);
		TransferObject request = TransferObject.create(user, KonstanteFK.RACUN, KonstanteBL.GET);
		try {
			TransferObject response = FrontControler.getInstaca().execute(request);
			List<Racun>racun = (List<Racun>) response.getResponse();
			
			for(Racun r: racun) {
				if(r.getStatus_porudzbine() == 0) {
					String s = "Na cekanju";
				Object[]red = {r.getDatum(),r.getBroj_racuna(),r.getIznos(),r.getUsername(),s,r.getAdresaIsporuka()};
				dtm.addRow(red);
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void postaviPodatke2() {
		dtm2.setRowCount(0);
		TransferObject tr = TransferObject.create(idRacun, KonstanteFK.STAVKE_NA_RACUNU, KonstanteBL.GET);
		try {
			TransferObject response = FrontControler.getInstaca().execute(tr);
			List<StavkeNaRacunu> stavke = (List<StavkeNaRacunu>) response.getResponse();
			
			for(StavkeNaRacunu s : stavke) {
				Object[]red2 = {s.getNazivJela(),s.getPrilozi(),s.getCena()};
				dtm2.addRow(red2);
			}
			
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
