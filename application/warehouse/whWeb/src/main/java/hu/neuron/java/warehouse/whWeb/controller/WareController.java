package hu.neuron.java.warehouse.whWeb.controller;






import hu.neuron.java.warehouse.whBusiness.service.WareServiceLocal;

import java.io.Serializable;



import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ViewScoped
@ManagedBean(name = "wareController")
public class WareController implements Serializable {


	private static final long serialVersionUID = 2618227417754884855L;

	private LazyWareModel lazyWareModel;
	
	
	
	
	@EJB(beanName = "WareService")
	WareServiceLocal wareService;
	
	

	@PostConstruct
	public void init() {
	
		setLazyWareModel(new LazyWareModel(getWareService()));
	}
	
	
	public WareServiceLocal getWareService() {
		return wareService;
	}
	public void setWareService(WareServiceLocal wareService) {
		this.wareService = wareService;
	}


	
	
	public LazyWareModel getLazyWareModel() {
		return lazyWareModel;
	}
	public void setLazyWareModel(LazyWareModel lazyWareModel) {
		this.lazyWareModel = lazyWareModel;
	}
}
