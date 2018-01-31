package JDKWebFrame.JDKUtil.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeecg.dao.BaseDaoI;
import com.util.MyMap2ListUtils;

import JDKWebFrame.JDKUtil.ServiceInfoI;

@Component("serverinfo")
public class Server_Connect_Props implements ServiceInfoI{

	@Autowired
	private BaseDaoI<T> basedao;
	
	/*
	 * sql查询结果获取一条记录
	 */
	public  Map<String,String> getServerInfoByBussiness_type(String bussiness_type){
		
		Map<String , String> serverInfo = new HashMap<String, String>();
		String sql = "select propname , propvalue from 	 where bussiness_type = ?	";
		Map<String ,Object> result = basedao.findOneForJdbc(sql, bussiness_type);
		
		serverInfo = MyMap2ListUtils.mapTrans(result);
		return serverInfo;
	}
	
	
	/*
	 * sql查询获取多条记录，并将多条记录数据合并成一条map
	 */
	public Map<String,String> getServerInfoByBussiness_type2List(String bussiness_type){
		
		Map<String , String> serverInfo = new HashMap<String, String>();
		String sql = "select propname , propvalue from server_connect_prop where bussiness_type = ?	";
		List<Map<String ,Object>> result = basedao.findForJdbc(sql, bussiness_type);
		
		serverInfo = MyMap2ListUtils.mapTrans(result);
		
		
		return serverInfo;
	}
	
}
