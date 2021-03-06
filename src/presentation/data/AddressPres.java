package presentation.data;

import java.io.Serializable;

import business.externalinterfaces.Address;
import javafx.beans.property.SimpleStringProperty;

public class AddressPres implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6692530778375381236L;
	private Address address;
	public Address getAddress() {
		return address;
	}
	
	public String getStreet(){
		return address.getStreet();
	}
	
	public String getState(){
		return address.getState();
	}
	
	public String getCity(){
		return address.getCity();
	}
	
	public String getZip(){
		return address.getZip();
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public SimpleStringProperty streetProperty() {
		return new SimpleStringProperty(address.getStreet());
	}
	public SimpleStringProperty cityProperty() {
		return new SimpleStringProperty(address.getCity());
	}
	public SimpleStringProperty stateProperty() {
		return new SimpleStringProperty(address.getState());
	}
	public SimpleStringProperty zipProperty() {
		return new SimpleStringProperty(address.getZip());
	}
	public void setStreet(SimpleStringProperty aStreet) {
		address.setStreet(aStreet.get());
	}
	public void setCity(SimpleStringProperty aCity) {
		address.setCity(aCity.get());
	}
	public void setState(SimpleStringProperty aState) {
		address.setState(aState.get());
	}
	public void setZip(SimpleStringProperty aZip) {
		address.setZip(aZip.get());
	}
	public SimpleStringProperty shippingAddressProperty() {
		return new SimpleStringProperty((new Boolean(address.isShippingAddress()).toString()));
	}
	
	public SimpleStringProperty billingAddressProperty() {
		return new SimpleStringProperty((new Boolean(address.isBillingAddress()).toString()));
	}
	
}
