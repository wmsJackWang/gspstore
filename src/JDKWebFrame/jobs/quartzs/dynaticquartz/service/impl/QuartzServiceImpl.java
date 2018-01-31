package JDKWebFrame.jobs.quartzs.dynaticquartz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecg.dao.BaseDaoI;
import com.jeecg.pageModel.DataGrid;
import com.jeecg.service.impl.BaseServiceImpl;
import com.jeecg.util.SpringContextUtil;
import com.util.MyBeanUtils;
import com.util.dbcommon.SearchSqlGenerateUtil;

import JDKWebFrame.jobs.quartzs.dynaticquartz.entity.QuartzEntity;
import JDKWebFrame.jobs.quartzs.dynaticquartz.page.QuartzPage;
import JDKWebFrame.jobs.quartzs.dynaticquartz.service.QuartzServiceI;
import business.entity.city.CityEntity;
import context.SysConst;

@Service
public class QuartzServiceImpl extends BaseServiceImpl implements QuartzServiceI{

	static final String TABLE_NAME = "QuartzEntity";
	
	@Autowired
	SpringContextUtil bean;
	
	
	@Autowired
	BaseDaoI<QuartzEntity> quartzEntityDao;


	
	@Override
	public DataGrid datagrid(QuartzPage quartzPage) {
		// TODO Auto-generated method stub
//		DataGrid dataGrid = new DataGrid();
//		QuartzPage quartzPage2 = new QuartzPage();
//		QuartzEntity quartzEntity = new QuartzEntity();
//		dataGrid.setRows(this.getPagesFromEntitys(this.find(quartzPage, this.TABLE_NAME, quartzEntity), quartzPage2));
//		return dataGrid;
		DataGrid j = new DataGrid();
		j.setRows(getPagesFromEntitys(find(quartzPage)));
		j.setTotal(total(quartzPage));
		return j;
	}

	@Override
	public void add(QuartzPage quartzPage) {
		// TODO Auto-generated method stub
		QuartzEntity quartzEntity = new QuartzEntity();
		BeanUtils.copyProperties(quartzPage, quartzEntity);
		quartzEntityDao.save(quartzEntity);
		
	}

	@Override
	public void update(QuartzPage quartzPage){
		// TODO Auto-generated method stub
//		QuartzEntity quartzEntity = new QuartzEntity();
//		BeanUtils.copyProperties(quartzPage, quartzEntity);
//		quartzEntityDao.update(quartzEntity);
		System.out.println("quartzPage:"+quartzPage);
		QuartzEntity quartzEntity = quartzEntityDao.get(QuartzEntity.class, quartzPage.getQuartzNo());
		if(quartzEntity!=null)
			try {
				MyBeanUtils.copyBeanNotNull2Bean(quartzPage ,quartzEntity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void delete(String ids) {
		// TODO Auto-generated method stub
		quartzEntityDao.delete(ids,QuartzEntity.class);
	}

	@Override
	public QuartzEntity get(QuartzPage quartzPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuartzEntity get(String quartzNo) {
		// TODO Auto-generated method stub
		QuartzEntity quartzEntity = null;
		System.out.println("quartzNo:"+quartzNo);
		if(quartzNo != null)
		{
			String hql = "FROM QuartzEntity WHERE quartzNo = '"+quartzNo+"'";
			quartzEntity = quartzEntityDao.get(hql);
		}
		if(quartzEntity!=null)
			System.out.println(quartzEntity.toString());
		else System.out.println("查询数据为空");
		return quartzEntity;
	}

	@Override
	public List<QuartzEntity> listAll(QuartzPage quartzPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuartzPage getOneQuartz() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private List<QuartzPage> getPagesFromEntitys(List<QuartzEntity> quartzEntitys) {
		List<QuartzPage> quartzPages = new ArrayList<QuartzPage>();
		if (quartzEntitys != null && quartzEntitys.size() > 0) {
			for (QuartzEntity tb : quartzEntitys) {
				QuartzPage b = new QuartzPage();
				BeanUtils.copyProperties(tb, b);
				quartzPages.add(b);
			}
		}
		return quartzPages;
	}

	private List<QuartzEntity> find(QuartzPage quartzPage) {
		String hql = "from QuartzEntity t where 1=1 ";

		List<Object> values = new ArrayList<Object>();
		hql = addWhere(quartzPage, hql, values);

		if (quartzPage.getSort() != null && quartzPage.getOrder() != null) {
			hql += " order by " + quartzPage.getSort() + " " + quartzPage.getOrder();
		}
		return quartzEntityDao.find(hql, quartzPage.getPage(), quartzPage.getRows(), values);
	}

	private String addWhere(QuartzPage quartzPage, String hql, List<Object> values) {
	    //循环查询条件Page的所有[Integer][String]类型的字段，如果字段不为空则动态加上查询条件
		//-----------------------------------------------------
		StringBuffer hqlbf = new StringBuffer(hql);
		
		QuartzEntity quartzEntity = new QuartzEntity();
		BeanUtils.copyProperties(quartzPage, quartzEntity);
		SearchSqlGenerateUtil.createSearchParamsHql(hqlbf, values, quartzEntity);
		hql = hqlbf.toString();
		return hql;
	}
	private Long total(QuartzPage quartzPage) {
		String hql = "select count(*) from QuartzEntity t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		hql = addWhere(quartzPage, hql, values);
		return quartzEntityDao.count(hql, values);
	}

	@Override
	public void runTask(QuartzEntity quartzEntity) {
		// TODO Auto-generated method stub
		
		/*
		 * 启动定时任务
		 */
		Class jobClass = null;
		Scheduler scheduler = this.bean.getBean("quartzscheduler");//获取定时任务管理器
		
		JobKey jobKey = new JobKey(quartzEntity.getJobName(), quartzEntity.getJobGroupName());
		TriggerKey triggerkey = new TriggerKey(quartzEntity.getTriggerName(), quartzEntity.getTriggerGroupName());
		try {
			 jobClass = Class.forName(quartzEntity.getTaskClassName().trim());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JobDetail  jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).build(); 
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerkey).withSchedule(CronScheduleBuilder.cronSchedule(quartzEntity.getCronTime().trim())).build();
		
		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		 * 修改定时任务
		 */
		
		quartzEntity.setStatus(SysConst.TASK_STATUS_RUNNING);
		QuartzPage quartzPage = new QuartzPage();
		BeanUtils.copyProperties(quartzEntity, quartzPage);
		this.update(quartzPage);
		
		
	}

	@Override
	public void stopTask(QuartzEntity quartzEntity) {
		// TODO Auto-generated method stub
		Scheduler scheduler = this.bean.getBean("quartzscheduler");//获取定时任务管理器
		JobKey jobKey = new JobKey(quartzEntity.getJobName(), quartzEntity.getJobGroupName());
		try {
			scheduler.deleteJob(jobKey);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * 修改定时任务
		 */
		
		quartzEntity.setStatus(SysConst.TASK_STATUS_STOPPED);
		QuartzPage quartzPage = new QuartzPage();
		BeanUtils.copyProperties(quartzEntity, quartzPage);
		this.update(quartzPage);
		
	}
	
}
