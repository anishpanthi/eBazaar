package business.externalinterfaces;

import java.io.Serializable;

public interface Catalog extends Serializable{
	int getId();
	String getName();
	void setId(int id);
	void setName(String name);
}
