package com.jeecg.dao.impl;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jeecg.dao.BaseDaoI;
import com.jeecg.dao.jdbc.JdbcDao;

import com.util.MyBeanUtils;

import JDKWebFrame.jobs.quartzs.dynaticquartz.entity.QuartzEntity;

/**
 * 基础DAO
 * 
 * @author zhangdaihao
 * 
 */
@Repository
public class BaseDaoImpl<T> implements BaseDaoI<T> {

	/*
	 * spring的一种sql执行工具
	 */
    private JdbcTemplate jdbcTemplate;
    
    
    /*
     * 
     * 数据库类型测试，注解中不知名对象文件
     */
    @Value("${DBType}")
    private String DBType ;
    
    /*
     * 这些是测试从不同对象文件中获取配置属性的值
     */
    @Value("#{configProperties['p1']}")
    private String p1;

    @Value("#{configProperties['p2']}")
    private String p2;

    @Value("#{configProperties['p3']}")
    private String p3;
    
    @Value("#{configProperties['p4']}")
    private String p4;
    
    /*
     * hibernate框架中的session工厂对象
     */
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * 保存对像对象
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#save(java.lang.Object)
	 */
	public void save(T o) {
		this.getCurrentSession().save(o);
	}

	/*
	 * 跟新对象数据
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#update(java.lang.Object)
	 */
	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	/*
	 * 
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	public void merge(T o) {
		this.getCurrentSession().merge(o);
	}

	public void evict(T o) {
		getCurrentSession().evict(o);
	}
	
	
	
	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}

	/*
	 * 这个查询语句是不需要知道实体类型的，所有的查询信息都是由调用者传进来，basedaoImpl类中也可以使用反射机制，就不需要 指定好对象的sql语句
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#find(java.lang.String, java.util.List)
	 */
	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}
	/*
	 * 上面查询方法和下面方法只有参数是不一样的，前者传入的param是放在List中的集合参数，而后者支持传入单个或多个参数值。
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#find(java.lang.String, java.lang.Object[])
	 */
	public List<T> find(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	/*
	 * 分页查询，hibernate框架提供的query对象是支持分页查询的，且两个函数就能实现
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#find(java.lang.String, int, int, java.util.List)
	 */
	public List<T> find(String hql, int page, int rows, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	//add-end author:gaoxingang for:重写使用sql查询的find方法  date：20130315
	/*
	 * 传入参数为Object... 类型
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#find(java.lang.String, int, int, java.lang.Object[])
	 */
	public List<T> find(String hql, int page, int rows, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	//add-begin author:gaoxingang for:重写使用sql查询的find方法  date：20130315
	/*
	 * 这个方法当sql字符串为空时，只要传入了类的Class就行
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#find(java.lang.String, int, int, java.util.List, java.lang.Class)
	 */
	public List<T> find(String sql, int page, int rows, List<Object> param, Class clazz) {
		Query q = this.getCurrentSession().createSQLQuery(sql).addEntity(clazz);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/*
	 * 获取单个对象，根据查询
	 * (non-Javadoc)
	 * @see com.jeecg.dao.BaseDaoI#get(java.lang.Class, java.io.Serializable)
	 */
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql, Object... param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return (T) l.get(0);
		}
		return null;
	}

	public T get(String hql, List<Object> param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return (T) l.get(0);
		}
		return null;
	}

	public Long count(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	public Long count(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}
	
	public Long countBySql(String sql, List<Object> param) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return Long.valueOf(q.uniqueResult().toString());
	}

	public Integer executeHql(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	/**
	 * 使用指定的检索标准检索数据并分页返回数据
	 */
	public List<Map<String, Object>> findForJdbc(String sql, int page, int rows) {
		//封装分页SQL
		sql = JdbcDao.jeecgCreatePageSql(sql,page,rows);
		return this.jdbcTemplate.queryForList(sql);
	}
	
	
	/**
	 * 使用指定的检索标准检索数据并分页返回数据
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public List<T> findObjForJdbc(String sql, int page, int rows,Class<T> clazz) {
		List<T> rsList = new ArrayList<T>();
		//封装分页SQL
		sql = JdbcDao.jeecgCreatePageSql(sql,page,rows);
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
		
		T po = null;
		for(Map<String,Object> m:mapList){
			try {
				po = clazz.newInstance();
				MyBeanUtils.copyMap2Bean_Nobig(po, m);
				rsList.add(po);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rsList;
	}

	/**
	 * 使用指定的检索标准检索数据并分页返回数据-采用预处理方式
	 * 
	 * @param criteria
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws DataAccessException
	 */
	public  List<Map<String, Object>>  findForJdbcParam(String  sql,  int page, int rows,Object... objs){
		//封装分页SQL
		sql = JdbcDao.jeecgCreatePageSql(sql,page,rows);	
		return this.getJdbcTemplate().queryForList(sql,objs);
	}
	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC
	 */
	public Long getCountForJdbc(String  sql) {
		return  this.getJdbcTemplate().queryForLong(sql);
	}
	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC-采用预处理方式
	 * 
	 */
	public Long getCountForJdbcParam(String  sql,Object[] objs) {
		return  this.getJdbcTemplate().queryForLong(sql, objs);
	}

	public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
		return this.jdbcTemplate.queryForList(sql,objs);
	}

	public Integer executeSql(String sql,List<Object> param) {
		return this.jdbcTemplate.update(sql,param);
	}

	public Integer executeSql(String sql, Object... param) {
		return this.jdbcTemplate.update(sql,param);
	}

	public Integer countByJdbc(String sql, Object... param) {
		return this.jdbcTemplate.queryForInt(sql, param);
	}

	public Map<String, Object> findOneForJdbc(String sql, Object... objs) {
		try{ 
			return this.jdbcTemplate.queryForMap(sql, objs);
		}catch (EmptyResultDataAccessException e) {   
		    return null;   
		}  
	}

	/*
	 * 验证DBType是否被赋值给这个类对象中去
	 */
	public void printDBType(){
		System.out.println("DBType:"+this.DBType);
		System.out.println("p1:"+this.p1);
		System.out.println("p2:"+this.p2);
		System.out.println("p3:"+this.p3);
		System.out.println("p4:"+this.p4);
		
	}
	
	
	public void delete(String ids ,Class<T> classType) {
		// TODO Auto-generated method stub
		
		T t = this.get(classType , ids);
		this.delete(t);
		
	}

}
