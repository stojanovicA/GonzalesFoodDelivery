package proxy;

import java.awt.Frame;

import javax.swing.JOptionPane;

import Domen.User;
import View.AdminForma;
import View.UserMedjuForma;


public class LoginUser implements ProxyLogin {
	
	User user;

	@Override
	public void login(User user, Frame frame)  {
		
		try {if(user.getStatus()!= 0) {
			AdminForma af = new AdminForma(user);
					af.setVisible(true);
					frame.dispose();
				
					
		}else if(user.getStatus()== 0) {
			UserMedjuForma uf  = new UserMedjuForma(user);
			
			uf.setVisible(true);
			frame.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Korisnik ne postoji");
		}
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Pogresan username ili password");
		}
		
	}

}
