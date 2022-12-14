package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Domen.Jelo;
import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.TransferObject;
import Domen.User;
import Domen.VrsteJela;
import FrontControler.FrontControler;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class AdminDodajNovoJelo extends JFrame {

	private JPanel contentPane;
	private JTextField tfNazivJela;
	private JTextField tfCena;
	User user;
	JComboBox<String> cbVrsta ;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private Integer idJela;

	
	public AdminDodajNovoJelo(User user) {
		
		this.user = user;
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
		ImageIcon gonzales = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\Admindodajnovojelo.png");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNazivJela = new JTextField();
		tfNazivJela.setBounds(111, 56, 118, 20);
		contentPane.add(tfNazivJela);
		tfNazivJela.setColumns(10);
		
		tfCena = new JTextField();
		tfCena.setBounds(111, 96, 118, 20);
		contentPane.add(tfCena);
		tfCena.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Naziv jela");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 59, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCena = new JLabel("Cena");
		lblCena.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCena.setBounds(23, 99, 78, 14);
		contentPane.add(lblCena);
		
		JLabel lblVrstaJela = new JLabel("Vrsta jela");
		lblVrstaJela.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVrstaJela.setBounds(23, 137, 78, 14);
		contentPane.add(lblVrstaJela);
		
		cbVrsta = new JComboBox<String>();
		cbVrsta.setBounds(111, 133, 118, 22);
		contentPane.add(cbVrsta);
		postaviComboBox();
		cbVrsta.setSelectedIndex(-1);
		
		JButton btnNewButton = new JButton("Dodaj novo jelo");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv = tfNazivJela.getText();
				int cena = Integer.parseInt(tfCena.getText());
				String vrstaJela = (String) cbVrsta.getSelectedItem();
				int idRestorana = user.getStatus(); 
				Jelo jelo = new Jelo(idRestorana, naziv, cena, vrstaJela, idRestorana);
				
				TransferObject tr = TransferObject.create(jelo, KonstanteFK.JELO, KonstanteBL.POST);
			
				try {
					TransferObject tr1 =FrontControler.getInstaca().execute(tr);
					String message = tr1.getMessage();
					JOptionPane.showMessageDialog(null, message);
					postaviPodatke();
					tfNazivJela.setText("");
					tfCena.setText("");
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(10, 192, 135, 23);
		contentPane.add(btnNewButton);
		
		JButton btnIzmeniJelo = new JButton("Izmeni jelo");
		btnIzmeniJelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIzmeniJelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv = tfNazivJela.getText();
				int cena = Integer.parseInt(tfCena.getText());
				String vrstaJela = (String) cbVrsta.getSelectedItem();
				int idRestorana = user.getStatus(); 
				Jelo jelo = new Jelo(idJela, naziv, cena, vrstaJela, idRestorana);
				TransferObject tr = TransferObject.create(jelo, KonstanteFK.JELO, KonstanteBL.PUT);
				try {
					FrontControler.getInstaca().execute(tr);
					postaviPodatke();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnIzmeniJelo.setBounds(165, 192, 118, 23);
		contentPane.add(btnIzmeniJelo);
		
		JButton btnObrisiJelop = new JButton("Obrisi jelo");
		btnObrisiJelop.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnObrisiJelop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferObject tr = TransferObject.create(idJela, KonstanteFK.JELO, KonstanteBL.DELETE);
				try {
					FrontControler.getInstaca().execute(tr);
					postaviPodatke();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnObrisiJelop.setBounds(293, 192, 131, 23);
		contentPane.add(btnObrisiJelop);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 226, 414, 233);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				idJela = (Integer) table.getModel().getValueAt(red, 0);
				tfNazivJela.setText(table.getModel().getValueAt(red, 1).toString());
				tfCena.setText(table.getModel().getValueAt(red, 2).toString());
			
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblLogo = new JLabel(gonzales);
		lblLogo.setBounds(227, 11, 197, 170);
		contentPane.add(lblLogo);
		Object[]kolone = {"ID","Naziv","Cena","Vrsta"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(64);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		postaviPodatke();
		
		
		

	}
	
	private void postaviPodatke() {
		dtm.setRowCount(0);
		TransferObject request = TransferObject.create(user, KonstanteFK.JELO, KonstanteBL.GET);
		try {
			TransferObject response = FrontControler.getInstaca().execute(request);
			List<Jelo>jelo = (List<Jelo>) response.getResponse();
			for(Jelo j:jelo) {
				Object[]red = {j.getIdJelo(),j.getNaziv(),j.getCena(),j.getVrstaJela()};
				dtm.addRow(red);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
}
