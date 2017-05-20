package business.externalinterfaces;

import java.io.Serializable;

public interface CartItem extends Serializable{
	public boolean isAlreadySaved();
	public Integer getCartid();
	public Integer getLineitemid();
	public Integer getProductid();
	public String getProductName();
	public String getQuantity();
	public String getTotalprice();
	public void setCartId(int id);
}
