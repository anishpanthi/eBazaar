package business.externalinterfaces;

import java.io.Serializable;

public interface CatalogTypes extends Serializable{
    public String getCatalogName(Integer id);
    public Integer getCatalogId(String name);
    public void addCatalog(Integer id, String name);
}
