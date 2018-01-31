package com.jeecg.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.alibaba.fastjson.JSON;
import com.jeecg.pageModel.SessionInfo;
import com.jeecg.pageModel.User;
import com.jeecg.util.ExceptionUtil;
import com.jeecg.util.ResourceUtil;
import com.jeecg.util.SpringContextUtil;
import com.opensymphony.xwork2.ActionSupport;

import JDKWebFrame.jobs.quartzs.dynaticquartz.Interface.IUserSessionInfoDao;

/**
 * 基础ACTION,其他ACTION继承此ACTION来获得writeJson和ActionSupport的功能
 * 
 * @author zhangdaihao
 * 
 */
@ParentPackage("defaultPackage")
@Namespace("/")
@Scope("prototype")
public class BaseAction extends ActionSupport implements IUserSessionInfoDao{
	
	@Autowired
	public  SpringContextUtil context;	
	
	private User user;
	
	public BaseAction(){
		HttpSession httpSession = getSession();
		Object obj = httpSession.getAttribute("user");
		if(obj != null)
			this.setUserInfo((User)obj);
	}

	protected static final Logger logger = Logger.getLogger(BaseAction.class);
	
	
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	public SessionInfo getSessionInfo(){
		SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
		return sessionInfo;
	}

	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object) {
		try {
			// SerializeConfig serializeConfig = new SerializeConfig();
			// serializeConfig.setAsmEnable(false);
			// String json = JSON.toJSONString(object);
			// String json = JSON.toJSONString(object, serializeConfig, SerializerFeature.PrettyFormat);
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			// String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat);
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			System.out.println(json);
			ServletActionContext.getResponse().getWriter().flush();
		} catch (IOException e) {
			logger.debug(ExceptionUtil.getExceptionMessage(e));
		}
	}

	@Override
	public void setUserInfo(User user) {
		// TODO Auto-generated method stub
		this.user = user;
	}

	@Override
	public User getUserInfo() {
		// TODO Auto-generated method stub
		return this.user;
	}
}
