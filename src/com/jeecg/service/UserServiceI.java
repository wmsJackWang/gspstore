package com.jeecg.service;

import java.util.List;

import com.jeecg.pageModel.Auth;
import com.jeecg.pageModel.DataGrid;
import com.jeecg.pageModel.User;

/**
 * 用户Service
 * 
 * @author zhangdaihao
 * 
 */
public interface UserServiceI extends BaseServiceI {

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user);

	/**
	 * 用户datagrid
	 * 
	 * @param user
	 * @return
	 */
	public DataGrid datagrid(User user);

	/**
	 * 用户下拉列表
	 * 
	 * @param user
	 * @return
	 */
	public List<User> loginCombobox(User user);

	/**
	 * 用户注册
	 * 
	 * @param user
	 */
	public void reg(User user);

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(User user);

	/**
	 * 编辑用户
	 * 
	 * @param user
	 */
	public void update(User user);

	/**
	 * 删除用户
	 * 
	 * @param ids
	 */
	public void delete(String ids);

	/**
	 * 获得当前用户所有权限
	 * 
	 * @param user
	 * @return
	 */
	public List<Auth> getAuths(User user);

	/**
	 * 批量修改用户密码
	 * 
	 * @param user
	 */
	public void modifyPwd(User user);

	/**
	 * 批量修改用户角色
	 * 
	 * @param user
	 */
	public void modifyUserRole(User user);

	/**
	 * 修改自己的密码
	 * 
	 * @param user
	 */
	public boolean modifySelfPwd(User user);

    public List<User> listAll(User user);

}
