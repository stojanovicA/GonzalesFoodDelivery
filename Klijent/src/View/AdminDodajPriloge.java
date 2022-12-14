package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Domen.Prilog;
import Domen.KonstanteBL;
import Domen.KonstanteFK;
import Domen.Prilog;
import Domen.TransferObject;
import Domen.User;
import FrontControler.FrontControler;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AdminDodajPriloge extends JFrame {

	private JPanel contentPane;
	private JTextField tfNaziv;
	User user;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	Integer idPrilog;

	
	public AdminDodajPriloge(User user) {
		this.user= user;
		ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
		ImageIcon gonzales = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\admindodajprilog.png");
		ImageIcon prilozi = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\prilozi.jpg");
	    this.setIconImage(ikonica.getImage());
		this.setTitle("Gonzales dostava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv");
		lblNewLabel.setBounds(7, 55, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		tfNaziv = new JTextField();
		tfNaziv.setBounds(38, 52, 114, 20);
		contentPane.add(tfNaziv);
		tfNaziv.setColumns(10);
		
		JButton btnNewButton = new JButton("Dodaj prilog");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv = tfNaziv.getText();
				int idRestoran = user.getStatus();
				Prilog prilog = new Prilog(naziv, idRestoran);
				TransferObject tr = TransferObject.create(prilog,KonstanteFK.PRILOG, KonstanteBL.POST);
				try {
					FrontControler.getInstaca().execute(tr);
					postaviPodatke();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(24, 146, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Obrisi prilog");
		btnNewButton_1.addActionListener(new ActionListener() {
		
				public void actionPerformed(ActionEvent e) {
					TransferObject tr = TransferObject.create(idPrilog, KonstanteFK.PRILOG, KonstanteBL.DELETE);
					try {
						FrontControler.getInstaca().execute(tr);
						postaviPodatke();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBounds(172, 146, 122, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 180, 270, 157);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				idPrilog = (Integer) table.getModel().getValueAt(red, 0);
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel(gonzales);
		lblNewLabel_1.setBounds(222, 334, 100, 100);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblprilozi = new JLabel(prilozi);
		lblprilozi.setBounds(156, 11, 166, 132);
		contentPane.add(lblprilozi);
		Object[]kolone = {"ID", "Naziv priloga"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		postaviPodatke();
	}


	private void postaviPodatke() {
		dtm.setRowCount(0);
		TransferObject request = TransferObject.create(user, KonstanteFK.PRILOG, KonstanteBL.GET);
		try {
			TransferObject response = FrontControler.getInstaca().execute(request);
			List<Prilog>prilozi = (List<Prilog>) response.getResponse();
			for(Prilog p : prilozi) {
				Object[]red = {p.getIdPrilog(),p.getIme()};
				dtm.addRow(red);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

