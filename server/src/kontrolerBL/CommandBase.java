package kontrolerBL;

import Domen.TransferObject;

public interface CommandBase {
	
	public void execute(TransferObject transferObject);

}
