package Domen;

import java.io.IOException;
import java.io.Serializable;



public class TransferObject implements Serializable {
	
	
	
	private Object request;
	private Object response;
	private KonstanteBL konstanteBl;
	private KonstanteFK konstanteFk;
	private String message;
	public Object getRequest() {
		return request;
	}
	public void setRequest(Object request) {
		this.request = request;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public KonstanteBL getKonstanteBl() {
		return konstanteBl;
	}
	public void setKonstanteBl(KonstanteBL konstanteBl) {
		this.konstanteBl = konstanteBl;
	}
	public KonstanteFK getKonstanteFk() {
		return konstanteFk;
	}
	public void setKonstanteFk(KonstanteFK konstanteFk) {
		this.konstanteFk = konstanteFk;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static TransferObject create(Object request, KonstanteFK konstanteFK, KonstanteBL konstanteBL) {
		TransferObject transferObject = new TransferObject();
		transferObject.setRequest(request);
		transferObject.setKonstanteFk(konstanteFK);
		transferObject.setKonstanteBl(konstanteBL);
		
		return transferObject;
		
		
	}
	
	
	
	
	
	

}
