package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.Racun;
import Domen.TransferObject;
import Domen.User;
import FrontControler.FrontControler;

public class UserIstorijaPorudzbina extends JFrame {

	private JPanel contentPane;
	User user;
	private JTable table;
	DefaultTableModel dtm = new DefaultTableModel();

	
	public UserIstorijaPorudzbina(User user) {
		this.user = user;
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		Object[]kolone = {"Datum porudzbine","Broj racuna","Iznos porudzbine"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		postaviPodatke();
	}
	
	private void postaviPodatke() {
		dtm.setRowCount(0);
		TransferObject request = TransferObject.create(user, KonstanteFK.RACUN, KonstanteBL.GET_FOR_USER);
		try {
			TransferObject response = FrontControler.getInstaca().execute(request);
			List<Racun>racun = (List<Racun>) response.getResponse();
			
			for(Racun r: racun) {
				if(r.getStatus_porudzbine() == 1) {
				Object[]red = {r.getDatum(),r.getBroj_racuna(),r.getIznos()};
				dtm.addRow(red);
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}