package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.TransportDetailsServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "acceptController")
public class AcceptController {

	@EJB(beanName = "TransportDetailsService")
	private TransportDetailsServiceRemote serviceRemote;

	private TransportVO selectedTransport;

	public void updateTransport() {
		try {
			serviceRemote.updateTransportDetails(selectedTransport);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Update Success"));
			e.printStackTrace();
		}

	}

	public TransportDetailsServiceRemote getServiceRemote() {
		return serviceRemote;
	}

	public void setServiceRemote(TransportDetailsServiceRemote serviceRemote) {
		this.serviceRemote = serviceRemote;
	}

	public TransportVO getSelectedTransport() {
		return selectedTransport;
	}

	public void setSelectedTransport(TransportVO selectedTransport) {
		this.selectedTransport = selectedTransport;
	}

}
