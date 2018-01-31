package business.entity.depot;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

/**   
 * @Title: Entity
 * @Description: 仓库信息
 * @author zhangdaihao
 * @date 2013-05-13 16:54:09
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_xx_depot", schema = "")
@SuppressWarnings("serial")
public class DepotEntity implements java.io.Serializable {
	/**仓库ID*/
	private java.lang.String depotid;
	/**仓库名称*/
	private java.lang.String depotname;
	/**仓管人*/
	private java.lang.String depotman;
	/**仓库地址*/
	private java.lang.String depotaddress;
	/**联系电话*/
	private java.lang.String phone;
	/**是否启用*/
	private java.lang.Integer isactive;
	/**修改日期*/
	private java.util.Date modifydate;
	/**创建日期*/
	private java.util.Date createdate;
	/**序号*/
	private java.lang.Integer ordernum;
	/**修改日期 开始时间 */
	private java.util.Date beginModifydate;
	/**修改日期 结束时间*/
	private java.util.Date endModifydate;
	/**创建日期 开始时间 */
	private java.util.Date beginCreatedate;
	/**创建日期 结束时间*/
	private java.util.Date endCreatedate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库ID
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	@Column(name ="DEPOTID",nullable=false,length=10)
	public java.lang.String getDepotid(){
		return this.depotid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库ID
	 */
	public void setDepotid(java.lang.String depotid){
		this.depotid = depotid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库名称
	 */
	@Column(name ="DEPOTNAME",nullable=false,length=100)
	public java.lang.String getDepotname(){
		return this.depotname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库名称
	 */
	public void setDepotname(java.lang.String depotname){
		this.depotname = depotname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓管人
	 */
	@Column(name ="DEPOTMAN",nullable=false,length=20)
	public java.lang.String getDepotman(){
		return this.depotman;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓管人
	 */
	public void setDepotman(java.lang.String depotman){
		this.depotman = depotman;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库地址
	 */
	@Column(name ="DEPOTADDRESS",nullable=false,length=80)
	public java.lang.String getDepotaddress(){
		return this.depotaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库地址
	 */
	public void setDepotaddress(java.lang.String depotaddress){
		this.depotaddress = depotaddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="PHONE",nullable=true,length=15)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否启用
	 */
	@Column(name ="ISACTIVE",nullable=false,precision=3,scale=0)
	public java.lang.Integer getIsactive(){
		return this.isactive;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否启用
	 */
	public void setIsactive(java.lang.Integer isactive){
		this.isactive = isactive;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改日期
	 */
	@Column(name ="MODIFYDATE",nullable=false)
	public java.util.Date getModifydate(){
		return this.modifydate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改日期
	 */
	public void setModifydate(java.util.Date modifydate){
		this.modifydate = modifydate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATEDATE",nullable=false)
	public java.util.Date getCreatedate(){
		return this.createdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreatedate(java.util.Date createdate){
		this.createdate = createdate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  序号
	 */
	@Column(name ="ORDERNUM",nullable=false,precision=5,scale=0)
	public java.lang.Integer getOrdernum(){
		return this.ordernum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  序号
	 */
	public void setOrdernum(java.lang.Integer ordernum){
		this.ordernum = ordernum;
	}
	
	@Transient
	public java.util.Date getBeginModifydate(){
		return this.beginModifydate;
	}
	
	/**
	 *方法: 设置java.util.Date 
	 *@param: java.util.Date  修改日期开始时间
	 */
	public void setBeginModifydate(java.util.Date beginModifydate){
		this.beginModifydate = beginModifydate;
	}
	
	@Transient
	public java.util.Date getEndModifydate(){
		return this.endModifydate;
	}
	
	/**
	 *方法: 设置java.util.Date 
	 *@param: java.util.Date  修改日期结束时间
	 */
	public void setEndModifydate(java.util.Date endModifydate){
		this.endModifydate = endModifydate;
	}
	@Transient
	public java.util.Date getBeginCreatedate(){
		return this.beginCreatedate;
	}
	
	/**
	 *方法: 设置java.util.Date 
	 *@param: java.util.Date  创建日期开始时间
	 */
	public void setBeginCreatedate(java.util.Date beginCreatedate){
		this.beginCreatedate = beginCreatedate;
	}
	
	@Transient
	public java.util.Date getEndCreatedate(){
		return this.endCreatedate;
	}
	
	/**
	 *方法: 设置java.util.Date 
	 *@param: java.util.Date  创建日期结束时间
	 */
	public void setEndCreatedate(java.util.Date endCreatedate){
		this.endCreatedate = endCreatedate;
	}
	
}
