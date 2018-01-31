package sun.page.jeecg;

import com.core.base.BasePage;
import java.math.BigDecimal;
/**
 *@类:JeecgOneDemoPage
 *@作者:zhangdaihao
 *@E-mail:zhangdaiscott@163.com
 *@日期:2013-1-23 
 */

@SuppressWarnings("serial")
public class JeecgOneDemoPage extends BasePage implements java.io.Serializable {

	/**主键*/
	private java.lang.String obid;

	/**用户名*/
	private java.lang.String name;

	/**年龄*/
	private java.lang.Integer age;

	/**工资*/
	private BigDecimal salary;

	/**生日*/
	private java.util.Date birthday;

	/**注册时间*/
	private java.util.Date registerDt;

	/**创建人ID*/
	private java.lang.String crtuser;

	/**创建人*/
	private java.lang.String crtuserName;

	/**创建时间*/
	private java.util.Date createDt;

	/**
	 *方法: 取得obid
	 *@return: java.lang.String  obid
	 */
	public java.lang.String getObid(){
		return this.obid;
	}

	/**
	 *方法: 设置obid
	 *@param: java.lang.String  obid
	 */
	public void setObid(java.lang.String obid){
		this.obid = obid;
	}

	/**
	 *方法: 取得name
	 *@return: java.lang.String  name
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置name
	 *@param: java.lang.String  name
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}

	/**
	 *方法: 取得age
	 *@return: java.lang.Integer  age
	 */
	public java.lang.Integer getAge(){
		return this.age;
	}

	/**
	 *方法: 设置age
	 *@param: java.lang.Integer  age
	 */
	public void setAge(java.lang.Integer age){
		this.age = age;
	}

	/**
	 *方法: 取得salary
	 *@return: BigDecimal  salary
	 */
	public BigDecimal getSalary(){
		return this.salary;
	}

	/**
	 *方法: 设置salary
	 *@param: BigDecimal  salary
	 */
	public void setSalary(BigDecimal salary){
		this.salary = salary;
	}

	/**
	 *方法: 取得birthday
	 *@return: java.util.Date  birthday
	 */
	public java.util.Date getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置birthday
	 *@param: java.util.Date  birthday
	 */
	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}

	/**
	 *方法: 取得registerDt
	 *@return: java.util.Date  registerDt
	 */
	public java.util.Date getRegisterDt(){
		return this.registerDt;
	}

	/**
	 *方法: 设置registerDt
	 *@param: java.util.Date  registerDt
	 */
	public void setRegisterDt(java.util.Date registerDt){
		this.registerDt = registerDt;
	}

	/**
	 *方法: 取得crtuser
	 *@return: java.lang.String  crtuser
	 */
	public java.lang.String getCrtuser(){
		return this.crtuser;
	}

	/**
	 *方法: 设置crtuser
	 *@param: java.lang.String  crtuser
	 */
	public void setCrtuser(java.lang.String crtuser){
		this.crtuser = crtuser;
	}

	/**
	 *方法: 取得crtuserName
	 *@return: java.lang.String  crtuserName
	 */
	public java.lang.String getCrtuserName(){
		return this.crtuserName;
	}

	/**
	 *方法: 设置crtuserName
	 *@param: java.lang.String  crtuserName
	 */
	public void setCrtuserName(java.lang.String crtuserName){
		this.crtuserName = crtuserName;
	}

	/**
	 *方法: 取得createDt
	 *@return: java.util.Date  createDt
	 */
	public java.util.Date getCreateDt(){
		return this.createDt;
	}

	/**
	 *方法: 设置createDt
	 *@param: java.util.Date  createDt
	 */
	public void setCreateDt(java.util.Date createDt){
		this.createDt = createDt;
	}

}