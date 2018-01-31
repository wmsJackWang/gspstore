package business.service.impl.city;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.Scheduler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.dao.BaseDaoI;
import com.jeecg.pageModel.DataGrid;
import com.jeecg.service.impl.BaseServiceImpl;
import com.util.MyBeanUtils;

import JDKWebFrame.JDKUtil.impl.Server_Connect_Props;
import business.entity.city.CityEntity;
import business.page.city.CityPage;
import business.service.city.CityServiceI;

@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl implements CityServiceI{
	
	private static final String TABLE_NAME = "CityEntity";

	@Autowired
	private BaseDaoI<CityEntity> cityEntityDao; 
	
//	@Resource(name="serverinfo")
//	private Server_Connect_Props serverInfo;
	
//	@Resource(name = "quartzscheduler")
//	private Scheduler  scheduler;
	
	public BaseDaoI<CityEntity> getCityEntityDao() {
		return cityEntityDao;
	}

	public void setCityEntityDao(BaseDaoI<CityEntity> cityEntityDao) {
		this.cityEntityDao = cityEntityDao;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public DataGrid datagrid(CityPage cityPage) {
		// TODO Auto-generated method stub
		
		DataGrid dataGrid = new DataGrid();
		CityPage cityPage2 = new CityPage();
		CityEntity cityEntity = new CityEntity();
		dataGrid.setRows(getPagesFromEntitys(this.find(cityPage , this.TABLE_NAME ,cityEntity),cityPage2));
		dataGrid.setTotal(total(cityPage));
		test();
		return dataGrid;
	}

	private void test() {
		// TODO Auto-generated method stub

		cityEntityDao.printDBType();
//		Map<String , String> map = serverInfo.getServerInfoByBussiness_type2List("sftptest");
//		System.out.println(map.toString());
//		System.out.println(scheduler.hashCode());
		
		
	}

	@Override
	public void add(CityPage cityPage) {
		// TODO Auto-generated method stub
		CityEntity cityEntity = new CityEntity();
		BeanUtils.copyProperties(cityPage, cityEntity);
		System.out.println("cityEntity:"+cityEntity.toString());
		cityEntityDao.save(cityEntity);
	}

	public void update(CityPage cityPage) throws Exception {
		// TODO Auto-generated method stub
		CityEntity cityEntity = cityEntityDao.get(CityEntity.class, cityPage.getCityNo());
		if(cityEntity!=null)
			MyBeanUtils.copyBeanNotNull2Bean(cityPage ,cityEntity);
	}

	@Override
	public void delete(String ids) {
		// TODO Auto-generated method stub
			if(ids != null){
			CityEntity cityEntity = null;
			String [] idArray = ids.split(",");
			for(String id:idArray)
			{
				cityEntity = null;
				String hql = "FROM CityEntity WHERE cityNo = '" + id + "'";
				cityEntity = cityEntityDao.get(hql);
				if(cityEntity!=null)
				{
					cityEntityDao.delete(cityEntity);
				}
			}
		}
	}

	
	@Override
	public CityEntity get(CityPage cityPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityEntity get(String cityNo) {
		// TODO Auto-generated method stub
		CityEntity cityEntity = null;
		if(cityNo != null)
		{
			String hql = "FROM CityEntity WHERE cityNo = '"+cityNo+"'";
			cityEntity = cityEntityDao.get(hql);
		}
		if(cityEntity!=null)
			System.out.println(cityEntity.toString());
		else System.out.println("查询数据为空");
		return cityEntity;
	}

	@Override
	public List<CityEntity> listAll(CityPage cityPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityPage getOneCity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//
//	private List<Serializable> find(CityPage cityPage) {
//		String hql = "from CityEntity t where 1=1 ";
//
//		List<Object> values = new ArrayList<Object>();
//		CityEntity cityEntity = new CityEntity();
//		hql = addWhere(cityPage, hql, values ,cityEntity);
//
//		if (cityPage.getSort() != null && cityPage.getOrder() != null) {
//			hql += " order by " + cityPage.getSort() + " " + cityPage.getOrder();
//		}
//		List<Serializable>  list =  new ArrayList<Serializable>();
//		List <CityEntity> cityEntities  = cityEntityDao.find(hql, cityPage.getPage(), cityPage.getRows(), values);
//		for(CityEntity cityEntity2 : cityEntities)
//		{
//			Serializable serializable = cityEntity2;
//			list.add(serializable);
//		}
//		return  list;
//	}

//	
//
//	private String addWhere(CityPage cityPage, String hql, List<Object> values) {
//	    //循环查询条件Page的所有[Integer][String]类型的字段，如果字段不为空则动态加上查询条件
//		//-----------------------------------------------------
//		StringBuffer hqlbf = new StringBuffer(hql);
//		
//		CityEntity cityEntity = new CityEntity();
//		BeanUtils.copyProperties(cityPage, cityEntity);
//		SearchSqlGenerateUtil.createSearchParamsHql(hqlbf, values, cityEntity);
//		hql = hqlbf.toString();
//		return hql;
//	}
//	
//	private List<CityPage> getPagesFromEntitys(List<CityEntity> cityEntitys) {
//		List<CityPage> cityPages = new ArrayList<CityPage>();
//		if (cityEntitys != null && cityEntitys.size() > 0) {
//			for (CityEntity tb : cityEntitys) {
//				CityPage b = new CityPage();
//				BeanUtils.copyProperties(tb, b);
//				cityPages.add(b);
//			}
//		}
//		return cityPages;
//	}
	
	private Long total(CityPage cityPage) {
		String hql = "select count(*) from CityEntity t where 1=1 ";
		List<Object> values = new ArrayList<Object>();

		CityEntity cityEntity = new CityEntity();
		hql = addWhere(cityPage, hql, values,cityEntity);
		return cityEntityDao.count(hql, values);
	}

}
