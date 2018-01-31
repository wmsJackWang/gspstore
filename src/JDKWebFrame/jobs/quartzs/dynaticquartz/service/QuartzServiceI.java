package JDKWebFrame.jobs.quartzs.dynaticquartz.service;

import java.util.List;

import com.jeecg.pageModel.DataGrid;

import JDKWebFrame.jobs.quartzs.dynaticquartz.entity.QuartzEntity;
import JDKWebFrame.jobs.quartzs.dynaticquartz.page.QuartzPage;

public interface QuartzServiceI {
	/**
	 * 获得数据表格
	 * 
	 * @param bug
	 * @return
	 */
	public DataGrid datagrid(QuartzPage quartzPage);

	/**
	 * 添加
	 * 
	 * @param QuartzPage
	 */
	public void add(QuartzPage quartzPage);

	/**
	 * 修改
	 * 
	 * @param QuartzPage
	 */
	public void update(QuartzPage quartzPage) throws Exception;

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	public void delete(String ids);

	/**
	 * 获得
	 * 
	 * @param Quartz
	 * @return
	 */
	public QuartzEntity get(QuartzPage quartzPage);
	
	
	/**
	 * 获得
	 * 
	 * @param Quartzno
	 * @return
	 */
	public QuartzEntity get(java.lang.String quartzNo);
	
	/**
	 * 获取所有数据
	 */
	public List<QuartzEntity> listAll(QuartzPage quartzPage);
	
	public QuartzPage getOneQuartz();
	
	public void runTask(QuartzEntity quartzEntity);
	

	public void stopTask(QuartzEntity quartzEntity);

}
