package kitpo;

import java.util.Comparator;

//import org.json.JSONObject;
public interface IUserType {
	
	public IUserType copy();
	
	public IUserType create();
	
	public String getClassName();
	
	public Comparator<?> getTypeComparator();

	

}
