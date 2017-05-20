
package business.externalinterfaces;

import java.io.Serializable;

public interface CreditCard extends Serializable{
    String getNameOnCard();
    String getExpirationDate();
    String getCardNum();
    String getCardType();

}
