package GIS;

import java.util.Collection;
import java.util.HashSet;

public class layer extends  HashSet<element> {
	public HashSet<element> hashset;
	public String name="";
	public layer(String name) {
		this.hashset =new HashSet<element>();
		this.name+=name;
	}
	/*public boolean add(element element) {
		hashset.add(element);
		return true;
	}*/
	public String getName() {
		return name;
	}
	
	
}
