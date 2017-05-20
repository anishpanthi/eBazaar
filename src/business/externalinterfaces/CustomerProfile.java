
package business.externalinterfaces;

import java.io.Serializable;

public interface CustomerProfile extends Serializable{
    public String getFirstName();
    public String getLastName();
    public Integer getCustId();
    public boolean isAdmin();
    public void setFirstName(String fn);
    public void setLastName(String ln);
    public void setCustId(Integer id);
    
}
