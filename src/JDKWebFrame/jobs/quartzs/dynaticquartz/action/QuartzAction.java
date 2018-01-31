package JDKWebFrame.jobs.quartzs.dynaticquartz.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeecg.action.BaseAction;
import com.jeecg.pageModel.Json;
import com.jeecg.util.ExceptionUtil;
import com.opensymphony.xwork2.ModelDriven;

import JDKWebFrame.jobs.quartzs.dynaticquartz.entity.QuartzEntity;
import JDKWebFrame.jobs.quartzs.dynaticquartz.page.QuartzPage;
import JDKWebFrame.jobs.quartzs.dynaticquartz.service.QuartzServiceI;
import context.SysConst;


@Action(value = "quartzAction" , results = {@Result(name = "quartz" , location = "/JDKWebFrame/quartz/quartz.jsp")})
public class QuartzAction extends BaseAction implements ModelDriven<QuartzPage>{

	QuartzPage model = new QuartzPage();
	
	@Autowired
	private QuartzServiceI quartzService;
	
	@Override
	public QuartzPage getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	

	/**
	 * 获得角色datagrid
	 */
	public void datagrid() {
		writeJson(quartzService.datagrid(model));
//		writeJson(null);
	}
	
	/*
	 * 显示定时任务设置界面
	 */
	public String goQuartz(){
		return "quartz";
	}

	/*
	 * 添加一个定时任务类
	 */
	public void add(){
		
		Json json = new Json();
		try {
//			System.out.println(this.context.getUserInfo().toString());
			model.setCreatedUserId(this.getUserInfo().getCname());
			model.setLastModifyUserId(this.getUserInfo().getCname());
			model.setStatus(SysConst.TASK_STATUS_STOPPED);//创建任务时，任务状态默认为停止(stopped)
			quartzService.add(model);
			System.out.println(model.toString());
			json.setSuccess(true);
			json.setMsg("添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			json.setMsg("添加失败");
			logger.error(ExceptionUtil.getExceptionMessage(e));
		}
		writeJson(json);
	}
	
	public void edit(){
		
		Json json = new Json();
		try {
			quartzService.update(model);
			json.setMsg("修改成功");
			json.setSuccess(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			json.setMsg("编辑失败");
		}
		writeJson(json);
	}

	
	
	public void showDesc(){
		writeJson(quartzService.get(model.getQuartzNo()));
	}
	
	
	public void delete(){
		
		String ids = model.getIds().trim();
		String []idArr = ids.split(",");
		System.out.println("ids:*********"+ids);
		for(String id : idArr)
		{
			quartzService.delete(id.trim());
		}
	}
	
	public void runTask(){
		Json json = new Json();
		try{
			QuartzEntity entity = quartzService.get(model.getQuartzNo());
			System.out.println("test:");
			quartzService.runTask(entity);
			json.setMsg("修改成功");
			json.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			json.setMsg("编辑失败");
		}
		writeJson(json);
	}
	
	public void stopTask(){
		Json json = new Json();
		try{
			QuartzEntity entity = quartzService.get(model.getQuartzNo());
			System.out.println("test:");
			quartzService.stopTask(entity);
			json.setMsg("修改成功");
			json.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			json.setMsg("编辑失败");
		}
		writeJson(json);
	}
}
