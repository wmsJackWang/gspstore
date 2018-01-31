package com.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MyMap2ListUtils {

	
	/**
	 * Object类型转化为String类型
	 * @param result
	 * @return
	 */
	public static  List<String> objectTransStringList(List<Object> lst){
		List<String> resultList = new ArrayList<String>();
		for(int i=0;i<lst.size();i++){
			resultList.add(lst.get(i).toString());
		}
		return resultList;
	}
	/**
	 * Object类型转化为BigDecimal类型
	 * @param result
	 * @return
	 */
	public static List<BigDecimal> objectTransBigDecimalList(List<Object> lst){
		List<BigDecimal> resultList = new ArrayList<BigDecimal>();
		for(int i=0;i<lst.size();i++){
			BigDecimal bd=new BigDecimal(lst.get(i).toString());
			resultList.add(bd);
		}
		return resultList;
	}
	/**
	 * Object类型转化为Double类型
	 * @param result
	 * @return
	 */
	public static List<Double> objectTransDoubleList(List<Object> lst){
		List<Double> resultList = new ArrayList<Double>();
		for(int i=0;i<lst.size();i++){
			Double bd=new Double(lst.get(i).toString());
			resultList.add(bd);
		}
		return resultList;
	}
	/**
	 * Object类型转化为Integer类型
	 * @param result
	 * @return
	 */
	public static List<Integer> objectTransIntegerList(List<Object> lst){
		List<Integer> resultList = new ArrayList<Integer>();
		for(int i=0;i<lst.size();i++){
			Integer bd=new Integer(lst.get(i).toString());
			resultList.add(bd);
		}
		return resultList;
	}
	/**
	 * Map<String,Object>转换成Map<String,String>格式
	 * @param result
	 * @return
	 */
	public static Map<String,String> mapTrans(Map<String,Object> result){
		Map<String,String> resultMap = new HashMap<String,String>();
		  Iterator<Entry<String, Object>> it = result.entrySet().iterator();
		  while (it.hasNext()) {
		   Map.Entry<String, Object> entry = it.next();
		   resultMap.put(entry.getKey(), entry.getValue().toString());
		  }
		return resultMap;
	}
	
	/**
	 * List<Map<String,Object>>转换成Map<String,String>格式
	 * @param result
	 * @return
	 */
	public static Map<String,String> mapTrans(List<Map<String,Object>> mapList){
		Map<String,String> resultMap = new HashMap<String,String>();
		//List lst01 = new ArrayList();
		List lst02 = new ArrayList();
		List lst03 = new ArrayList();
		for(int i=0;i<mapList.size();i++){
			Map<String, Object> obj = mapList.get(i);	
		    Iterator<Entry<String, Object>> it = obj.entrySet().iterator();
		    int count=0;
		    while (it.hasNext()) {
			count++;
		    Map.Entry<String, Object> entry = it.next();
			 if(count==1){
				lst02.add(entry.getValue());
			}else if(count==2){
				lst03.add(entry.getValue());
			 }
		   }
		}
		for(int k=0;k<lst02.size();k++){
			resultMap.put(lst02.get(k).toString(), lst03.get(k).toString());
		}
		return resultMap;
	}
}
