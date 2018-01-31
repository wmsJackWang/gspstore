package com.jeecg.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.core.base.BasePage;
import com.jeecg.dao.BaseDaoI;
import com.jeecg.service.BaseServiceI;
import com.util.dbcommon.SearchSqlGenerateUtil;

import business.entity.city.CityEntity;
import business.page.city.CityPage;

/**
 * 基础Service,所有ServiceImpl需要extends此Service来获得默认事务的控制
 * 
 * @author zhangdaihao
 * 
 */
@Service("baseService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BaseServiceImpl implements BaseServiceI{

	
	/*
	 * 增加--王明胜-----begin
	 */
	@Autowired
	private  BaseDaoI<Serializable> baseDao;
	

	public  String addWhere(BasePage basePage, String hql, List<Object> values , Object entityObj) {
	    //循环查询条件Page的所有[Integer][String]类型的字段，如果字段不为空则动态加上查询条件
		//-----------------------------------------------------
		StringBuffer hqlbf = new StringBuffer(hql);
		
		//CityEntity cityEntity = new CityEntity();
		BeanUtils.copyProperties(basePage, entityObj);
		SearchSqlGenerateUtil.createSearchParamsHql(hqlbf, values, entityObj);
		hql = hqlbf.toString();
		return hql;
	}
	
	public  List<BasePage> getPagesFromEntitys(List<Serializable> entitySerializable , Object PageObj) {
		List<BasePage> cityPages = new ArrayList<BasePage>();
		if (entitySerializable != null && entitySerializable.size() > 0) {
			for (Serializable tb : entitySerializable) {
				BasePage b = null;
				try {
					b = (BasePage) PageObj.getClass().newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BeanUtils.copyProperties(tb, b);
				cityPages.add(b);
			}
		}
		return cityPages;
	}
	
	public  List<Serializable> find(BasePage basePage , String tableName ,Object entityObj) {
		String hql = "from " + tableName + " t where 1=1 ";

		List<Object> values = new ArrayList<Object>();
		hql = addWhere(basePage, hql, values ,entityObj);

		if (basePage.getSort() != null && basePage.getOrder() != null) {
			hql += " order by " + basePage.getSort() + " " + basePage.getOrder();
		}
//		List<Serializable>  list =  new ArrayList<Serializable>();
		List <Serializable> list  = baseDao.find(hql, basePage.getPage(), basePage.getRows(), values);
//		System.out.println("hello , you got here");
//		for(CityEntity cityEntity2 : list)
//		{
//			Serializable serializable = cityEntity2;
//			list.add(serializable);
//		}
		return  list;
	}

	/*
	 * 增加--王明胜-----end
	 */
}
