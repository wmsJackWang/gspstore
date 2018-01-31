package sun.service.impl.jeecg;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sun.entity.jeecg.JeecgOneTestEntity;
import sun.page.jeecg.JeecgOneTestPage;
import sun.service.jeecg.JeecgOneTestServiceI;

import com.jeecg.dao.BaseDaoI;
import com.jeecg.dao.jdbc.JdbcDao;
import com.jeecg.model.Tuser;
import com.jeecg.pageModel.DataGrid;
import com.jeecg.service.impl.BaseServiceImpl;
import com.jeecg.util.excel.ExcelExportUtil;
import com.util.MyBeanUtils;
import com.util.dbcommon.SearchSqlGenerateUtil;

/**   
 * @Title: ServiceImpl
 * @Description: 单表模型Test
 * @author zhangdaihao
 * @date 2011-12-31 14:18:16
 * @version V1.0   
 *
 */
@Service("jeecgOneTestService")
public class JeecgOneTestServiceImpl extends BaseServiceImpl implements JeecgOneTestServiceI {

	@Autowired
	//SQL 使用JdbcDao
	private JdbcDao jdbcDao;
	private BaseDaoI<JeecgOneTestEntity> jeecgOneTestEntityDao;

	public BaseDaoI<JeecgOneTestEntity> getJeecgOneTestEntityDao() {
		return jeecgOneTestEntityDao;
	}
	@Autowired
	public void setJeecgOneTestEntityDao(BaseDaoI<JeecgOneTestEntity> jeecgOneTestEntityDao) {
		this.jeecgOneTestEntityDao = jeecgOneTestEntityDao;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public DataGrid datagrid(JeecgOneTestPage jeecgOneTestPage) {
		DataGrid j = new DataGrid();
		j.setRows(getPagesFromEntitys(find(jeecgOneTestPage)));
		j.setTotal(total(jeecgOneTestPage));
		return j;
	}

	private List<JeecgOneTestPage> getPagesFromEntitys(List<JeecgOneTestEntity> jeecgOneTestEntitys) {
		List<JeecgOneTestPage> jeecgOneTestPages = new ArrayList<JeecgOneTestPage>();
		if (jeecgOneTestEntitys != null && jeecgOneTestEntitys.size() > 0) {
			for (JeecgOneTestEntity tb : jeecgOneTestEntitys) {
				JeecgOneTestPage b = new JeecgOneTestPage();
				BeanUtils.copyProperties(tb, b);
				jeecgOneTestPages.add(b);
			}
		}
		return jeecgOneTestPages;
	}

	private List<JeecgOneTestEntity> find(JeecgOneTestPage jeecgOneTestPage) {
		String hql = "from JeecgOneTestEntity t where 1=1 ";

		List<Object> values = new ArrayList<Object>();
		hql = addWhere(jeecgOneTestPage, hql, values);

		if (jeecgOneTestPage.getSort() != null && jeecgOneTestPage.getOrder() != null) {
			hql += " order by " + jeecgOneTestPage.getSort() + " " + jeecgOneTestPage.getOrder();
		}
		return jeecgOneTestEntityDao.find(hql, jeecgOneTestPage.getPage(), jeecgOneTestPage.getRows(), values);
	}

	private Long total(JeecgOneTestPage jeecgOneTestPage) {
		String hql = "select count(*) from JeecgOneTestEntity t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		hql = addWhere(jeecgOneTestPage, hql, values);
		return jeecgOneTestEntityDao.count(hql, values);
	}

	private String addWhere(JeecgOneTestPage jeecgOneTestPage, String hql, List<Object> values) {
	    //循环查询条件Page的所有[Integer][String]类型的字段，如果字段不为空则动态加上查询条件
		//-----------------------------------------------------
		StringBuffer hqlbf = new StringBuffer(hql);
		
		JeecgOneTestEntity jeecgOneTestEntity = new JeecgOneTestEntity();
		BeanUtils.copyProperties(jeecgOneTestPage, jeecgOneTestEntity);
		SearchSqlGenerateUtil.createSearchParamsHql(hqlbf, values, jeecgOneTestEntity);
		hql = hqlbf.toString();
		//-----------------------------------------------------
		if (jeecgOneTestPage.getCcreatedatetimeStart() != null) {
			hql += " and createDt>=? ";
			values.add(jeecgOneTestPage.getCcreatedatetimeStart());
		}
		if (jeecgOneTestPage.getCcreatedatetimeEnd() != null) {
			hql += " and createDt<=? ";
			values.add(jeecgOneTestPage.getCcreatedatetimeEnd());
		}
		if (jeecgOneTestPage.getCmodifydatetimeStart() != null) {
			hql += " and modifyDt>=? ";
			values.add(jeecgOneTestPage.getCmodifydatetimeStart());
		}
		if (jeecgOneTestPage.getCmodifydatetimeEnd() != null) {
			hql += " and modifyDt<=? ";
			values.add(jeecgOneTestPage.getCmodifydatetimeEnd());
		}
		return hql;
	}

	public void add(JeecgOneTestPage jeecgOneTestPage) {
		if (jeecgOneTestPage.getObid() == null || jeecgOneTestPage.getObid().trim().equals("")) {
			jeecgOneTestPage.setObid(UUID.randomUUID().toString());
		}
		JeecgOneTestEntity t = new JeecgOneTestEntity();
		BeanUtils.copyProperties(jeecgOneTestPage, t);
		jeecgOneTestEntityDao.save(t);
	}

	public void update(JeecgOneTestPage jeecgOneTestPage) throws Exception {
		JeecgOneTestEntity t = jeecgOneTestEntityDao.get(JeecgOneTestEntity.class, jeecgOneTestPage.getObid());
	    if(t != null) {
			MyBeanUtils.copyBeanNotNull2Bean(jeecgOneTestPage, t);
		}
	}

	public void delete(String ids) {
		if (ids != null) {
			for (String id : ids.split(",")) {
				JeecgOneTestEntity t = jeecgOneTestEntityDao.get(JeecgOneTestEntity.class, id);
				if (t != null) {
					jeecgOneTestEntityDao.delete(t);
				}
			}
		}
	}
	
	//----------------------------------------------------------------
	//update-begin--Author:shiyanping  Date:20130315 for：增加excel导出
	//update-end--Author:shiyanping  Date:20130315 for：增加excel导出
	//----------------------------------------------------------------
	@Override
	public InputStream exportXls(JeecgOneTestPage jeecgOneTestPage)  throws  Exception{
		//获取数据
		List<JeecgOneTestEntity> listJeecgOneTest = listAll(jeecgOneTestPage);
		File file = new File(new Date(0).getTime()+".xls");
		OutputStream outputStream = new FileOutputStream(file);
		ExcelExportUtil.exportExcel("用户信息", JeecgOneTestEntity.class, listJeecgOneTest, outputStream);
		InputStream is = new BufferedInputStream(new FileInputStream(file.getPath()));
		file.delete();		
		return is;
	}	

	public JeecgOneTestEntity get(JeecgOneTestPage jeecgOneTestPage) {
		return jeecgOneTestEntityDao.get(JeecgOneTestEntity.class, jeecgOneTestPage.getObid());
	}

	public JeecgOneTestEntity get(String obid) {
		return jeecgOneTestEntityDao.get(JeecgOneTestEntity.class, obid);
	}
	public List<JeecgOneTestEntity> listAll(JeecgOneTestPage jeecgOneTestPage) {
		String hql = "from JeecgOneTestEntity where 1 = 1 ";
		List<Object> values = new ArrayList<Object>();
		hql = addWhere(jeecgOneTestPage, hql, values);
		List<JeecgOneTestEntity> list = jeecgOneTestEntityDao.find(hql,values);
		return list;
	}
}
