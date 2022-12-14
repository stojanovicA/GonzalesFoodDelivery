package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import niti.DateThread;
import niti.ServerTread;
import niti.TimeThread;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Server extends JFrame {

	private JPanel contentPane;
	private DateThread dateThread;
	private TimeThread timeThread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					ImageIcon ikonica = new ImageIcon("C:\\Users\\stoja\\Desktop\\Projekat\\poslednjapromena.jpg");
				    frame.setIconImage(ikonica.getImage());
					frame.setTitle("Gonzales server");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		Server.class.getResource("/slike/gonzalespozadina.jpg"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Pokreni Server");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServerTread serverTread = new ServerTread();
				serverTread.start();
				timeThread.start();
				dateThread.start();
				
				
			}
		});
		btnNewButton.setBounds(113, 109, 224, 61);
		contentPane.add(btnNewButton);
		
		JLabel lblVreme = new JLabel("");
		lblVreme.setForeground(Color.WHITE);
		lblVreme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVreme.setBounds(159, 214, 224, 23);
		contentPane.add(lblVreme);
		timeThread = new TimeThread(lblVreme);
		
		JLabel lblDatum = new JLabel("");
		lblDatum.setForeground(Color.WHITE);
		lblDatum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatum.setBounds(113, 238, 224, 23);
		contentPane.add(lblDatum);
		dateThread = new DateThread(lblDatum);
	}

}
