package business.action.city;


import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeecg.action.BaseAction;
import com.jeecg.pageModel.Json;
import com.jeecg.util.ExceptionUtil;
import com.opensymphony.xwork2.ModelDriven;

import business.page.city.CityPage;
import business.service.city.CityServiceI;


@Action(value = "cityAction", results = {@Result (location = "/business/city/city.jsp" , name = "city")})
public class CityAction extends BaseAction implements ModelDriven<CityPage>{

	private CityPage model = new CityPage();
	
	@Autowired
	private CityServiceI cityService;
	
	private static final Logger logger = Logger.getLogger(CityAction.class);	
	
	@Override
	public CityPage getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	
	public void add(){
		
		Json json = new Json();
		try {
			cityService.add(model);
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
			cityService.update(model);
			json.setMsg("修改成功");
			json.setSuccess(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			json.setMsg("编辑失败");
		}
		writeJson(json);
	}

	public void  delete(){
		
		cityService.delete(model.getIds());
		System.out.println("ids:"+model.getIds());
		Json json = new Json();
		try {
				json.setMsg("删除成功");
				json.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			json.setMsg("删除失败");
			logger.error(ExceptionUtil.getExceptionMessage(e));
		}
		writeJson(json);
	}
	
	public void showDesc(){
		writeJson(cityService.get(model.getCityNo()));
	}
	
	public void datagrid(){
		System.out.println("here");
		writeJson(cityService.datagrid(model));
	}

	public String goCity(){
		return "city";
	}
}
