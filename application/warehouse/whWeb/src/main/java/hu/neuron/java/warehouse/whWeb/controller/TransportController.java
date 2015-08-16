package hu.neuron.java.warehouse.whWeb.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "transportController")
public class TransportController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int db;

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}
	
	public void buttonAction(ActionEvent actionEvent) {
        addMessage("A szállítás hamarosan megkezdődik");
    }
     
    public void addMessage(String summary) {        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
