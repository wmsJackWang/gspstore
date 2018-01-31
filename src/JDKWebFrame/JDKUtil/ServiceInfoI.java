package JDKWebFrame.JDKUtil;

import java.util.Map;

public interface ServiceInfoI {

	public  Map<String,String> getServerInfoByBussiness_type(String bussiness_type);
	
	public Map<String,String> getServerInfoByBussiness_type2List(String bussiness_type);
}
