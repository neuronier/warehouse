package hu.neuron.java.warehouse.whWeb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
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
	
	private Collection<String> warehouses;
	
	private Collection<String> wares;
	
	private int db;

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public Collection<String> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Collection<String> warehouses) {
		this.warehouses = warehouses;
	}
	
	public Collection<String> getWares() {
		return wares;
	}
	
	public void setWares(Collection<String> wares) {
		this.wares = wares;
	}
	
	@PostConstruct
    public void init() {
		
		warehouses = new ArrayList<String>();
		warehouses.add("warehouse1");
		warehouses.add("warehouse2");
		warehouses.add("warehouse3");
		
		wares = new ArrayList<String>();
		wares.add("ware1");
		wares.add("ware2");
		wares.add("ware3");
	}
	
	public void buttonAction(ActionEvent actionEvent) {
        addMessage("A szállítás hamarosan megkezdődik");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
