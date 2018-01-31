package sun.entity.jeecg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.math.BigDecimal;
/**
 *@类:JeecgOrderMainEntity
 *@作者:zhangdaihao
 *@E-mail:zhangdaiscott@163.com
 *@日期:2011-12-31 16:23:02
 */

@Entity
@Table(name ="jeecg_order_main")
@SuppressWarnings("serial")
public class JeecgOrderMainEntity implements java.io.Serializable {

	/**主键*/
	private java.lang.String obid;

	/**订单号*/
	private java.lang.String goOrderCode;

	/**订单类型 01:团单 02 单机票 03 单酒店 04 单签证 05 外拼 06 自由行*/
	private java.lang.String goderType;

	/**订单团购状态 01:占位 02:已订 03::取消*/
	private java.lang.String goStatus;

	/**旅行社ID*/
	private java.lang.String touristid;

	/**旅行社门店ID*/
	private java.lang.String agencyId;

	/**旅行社名称*/
	private java.lang.String agencyName;

	/**联系人ID*/
	private java.lang.String linkmenid;

	/**顾客类型 : 1直客 2同行*/
	private java.lang.String usertype;

	/**客户*/
	private java.lang.String goCusName;

	/**销售人*/
	private java.lang.String goSaleName;

	/**销售人ID*/
	private java.lang.String goSaleId;

	/**联系人*/
	private java.lang.String goContactName;

	/**区号*/
	private java.lang.String goZoneNo;

	/**电话*/
	private java.lang.String goPhone;

	/**手机*/
	private java.lang.String goTelphone;

	/**传真*/
	private java.lang.String goFacsimile;

	/**邮箱*/
	private java.lang.String goMail;

	/**订单人数*/
	private java.lang.Integer goOrderCount;

	/**总价(不含返款)*/
	private BigDecimal goAllPrice;

	/**返款*/
	private BigDecimal goReturnPrice;

	/**备注*/
	private java.lang.String goContent;

	/**审核状态 01:待审核 02:审核中 03:通过 04 驳回*/
	private java.lang.String auditorStatus;

	/**审核人ID*/
	private java.lang.String auditorObid;

	/**审核人*/
	private java.lang.String auditorName;

	/**创建人*/
	private java.lang.String crtuser;

	/**创建人名字*/
	private java.lang.String crtuserName;

	/**创建时间*/
	private java.util.Date createDt;

	/**修改人*/
	private java.lang.String modifier;

	/**修改人名字*/
	private java.lang.String modifierName;

	/**修改时间*/
	private java.util.Date modifyDt;

	/**删除标记*/
	private java.lang.Integer delflag;

	/**删除时间*/
	private java.util.Date delDt;
	
	//add-begin author:gaoxingang for:加关联查询属性  date：20130315
	private JeecgOrderCustomEntity jeecgOrderCustomEntity;
	
	private JeecgOrderProductEntity jeecgOrderProductEntity;
	//add-end author:gaoxingang for:加关联查询属性  date：20130315

	/**
	 *方法: 取得obid
	 *@return: java.lang.String  obid
	 */
	@Id
	@Column(name ="OBID", nullable = false, length = 36)
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
	 *方法: 取得goOrderCode
	 *@return: java.lang.String  goOrderCode
	 */
	@Column(name ="go_order_code")
	public java.lang.String getGoOrderCode(){
		return this.goOrderCode;
	}

	/**
	 *方法: 设置goOrderCode
	 *@param: java.lang.String  goOrderCode
	 */
	public void setGoOrderCode(java.lang.String goOrderCode){
		this.goOrderCode = goOrderCode;
	}

	/**
	 *方法: 取得goderType
	 *@return: java.lang.String  goderType
	 */
	@Column(name ="goder_type")
	public java.lang.String getGoderType(){
		return this.goderType;
	}

	/**
	 *方法: 设置goderType
	 *@param: java.lang.String  goderType
	 */
	public void setGoderType(java.lang.String goderType){
		this.goderType = goderType;
	}

	/**
	 *方法: 取得goStatus
	 *@return: java.lang.String  goStatus
	 */
	@Column(name ="go_status")
	public java.lang.String getGoStatus(){
		return this.goStatus;
	}

	/**
	 *方法: 设置goStatus
	 *@param: java.lang.String  goStatus
	 */
	public void setGoStatus(java.lang.String goStatus){
		this.goStatus = goStatus;
	}

	/**
	 *方法: 取得touristid
	 *@return: java.lang.String  touristid
	 */
	@Column(name ="touristid")
	public java.lang.String getTouristid(){
		return this.touristid;
	}

	/**
	 *方法: 设置touristid
	 *@param: java.lang.String  touristid
	 */
	public void setTouristid(java.lang.String touristid){
		this.touristid = touristid;
	}

	/**
	 *方法: 取得agencyId
	 *@return: java.lang.String  agencyId
	 */
	@Column(name ="agency_id")
	public java.lang.String getAgencyId(){
		return this.agencyId;
	}

	/**
	 *方法: 设置agencyId
	 *@param: java.lang.String  agencyId
	 */
	public void setAgencyId(java.lang.String agencyId){
		this.agencyId = agencyId;
	}

	/**
	 *方法: 取得agencyName
	 *@return: java.lang.String  agencyName
	 */
	@Column(name ="agency_name")
	public java.lang.String getAgencyName(){
		return this.agencyName;
	}

	/**
	 *方法: 设置agencyName
	 *@param: java.lang.String  agencyName
	 */
	public void setAgencyName(java.lang.String agencyName){
		this.agencyName = agencyName;
	}

	/**
	 *方法: 取得linkmenid
	 *@return: java.lang.String  linkmenid
	 */
	@Column(name ="linkmenid")
	public java.lang.String getLinkmenid(){
		return this.linkmenid;
	}

	/**
	 *方法: 设置linkmenid
	 *@param: java.lang.String  linkmenid
	 */
	public void setLinkmenid(java.lang.String linkmenid){
		this.linkmenid = linkmenid;
	}

	/**
	 *方法: 取得usertype
	 *@return: java.lang.String  usertype
	 */
	@Column(name ="usertype")
	public java.lang.String getUsertype(){
		return this.usertype;
	}

	/**
	 *方法: 设置usertype
	 *@param: java.lang.String  usertype
	 */
	public void setUsertype(java.lang.String usertype){
		this.usertype = usertype;
	}

	/**
	 *方法: 取得goCusName
	 *@return: java.lang.String  goCusName
	 */
	@Column(name ="go_cus_name")
	public java.lang.String getGoCusName(){
		return this.goCusName;
	}

	/**
	 *方法: 设置goCusName
	 *@param: java.lang.String  goCusName
	 */
	public void setGoCusName(java.lang.String goCusName){
		this.goCusName = goCusName;
	}

	/**
	 *方法: 取得goSaleName
	 *@return: java.lang.String  goSaleName
	 */
	@Column(name ="go_sale_name")
	public java.lang.String getGoSaleName(){
		return this.goSaleName;
	}

	/**
	 *方法: 设置goSaleName
	 *@param: java.lang.String  goSaleName
	 */
	public void setGoSaleName(java.lang.String goSaleName){
		this.goSaleName = goSaleName;
	}

	/**
	 *方法: 取得goSaleId
	 *@return: java.lang.String  goSaleId
	 */
	@Column(name ="go_sale_id")
	public java.lang.String getGoSaleId(){
		return this.goSaleId;
	}

	/**
	 *方法: 设置goSaleId
	 *@param: java.lang.String  goSaleId
	 */
	public void setGoSaleId(java.lang.String goSaleId){
		this.goSaleId = goSaleId;
	}

	/**
	 *方法: 取得goContactName
	 *@return: java.lang.String  goContactName
	 */
	@Column(name ="go_contact_name")
	public java.lang.String getGoContactName(){
		return this.goContactName;
	}

	/**
	 *方法: 设置goContactName
	 *@param: java.lang.String  goContactName
	 */
	public void setGoContactName(java.lang.String goContactName){
		this.goContactName = goContactName;
	}

	/**
	 *方法: 取得goZoneNo
	 *@return: java.lang.String  goZoneNo
	 */
	@Column(name ="go_zone_no")
	public java.lang.String getGoZoneNo(){
		return this.goZoneNo;
	}

	/**
	 *方法: 设置goZoneNo
	 *@param: java.lang.String  goZoneNo
	 */
	public void setGoZoneNo(java.lang.String goZoneNo){
		this.goZoneNo = goZoneNo;
	}

	/**
	 *方法: 取得goPhone
	 *@return: java.lang.String  goPhone
	 */
	@Column(name ="go_phone")
	public java.lang.String getGoPhone(){
		return this.goPhone;
	}

	/**
	 *方法: 设置goPhone
	 *@param: java.lang.String  goPhone
	 */
	public void setGoPhone(java.lang.String goPhone){
		this.goPhone = goPhone;
	}

	/**
	 *方法: 取得goTelphone
	 *@return: java.lang.String  goTelphone
	 */
	@Column(name ="go_telphone")
	public java.lang.String getGoTelphone(){
		return this.goTelphone;
	}

	/**
	 *方法: 设置goTelphone
	 *@param: java.lang.String  goTelphone
	 */
	public void setGoTelphone(java.lang.String goTelphone){
		this.goTelphone = goTelphone;
	}

	/**
	 *方法: 取得goFacsimile
	 *@return: java.lang.String  goFacsimile
	 */
	@Column(name ="go_facsimile")
	public java.lang.String getGoFacsimile(){
		return this.goFacsimile;
	}

	/**
	 *方法: 设置goFacsimile
	 *@param: java.lang.String  goFacsimile
	 */
	public void setGoFacsimile(java.lang.String goFacsimile){
		this.goFacsimile = goFacsimile;
	}

	/**
	 *方法: 取得goMail
	 *@return: java.lang.String  goMail
	 */
	@Column(name ="go_mail")
	public java.lang.String getGoMail(){
		return this.goMail;
	}

	/**
	 *方法: 设置goMail
	 *@param: java.lang.String  goMail
	 */
	public void setGoMail(java.lang.String goMail){
		this.goMail = goMail;
	}

	/**
	 *方法: 取得goOrderCount
	 *@return: java.lang.Integer  goOrderCount
	 */
	@Column(name ="go_order_count")
	public java.lang.Integer getGoOrderCount(){
		return this.goOrderCount;
	}

	/**
	 *方法: 设置goOrderCount
	 *@param: java.lang.Integer  goOrderCount
	 */
	public void setGoOrderCount(java.lang.Integer goOrderCount){
		this.goOrderCount = goOrderCount;
	}

	/**
	 *方法: 取得goAllPrice
	 *@return: BigDecimal  goAllPrice
	 */
	@Column(name ="go_all_price")
	public BigDecimal getGoAllPrice(){
		return this.goAllPrice;
	}

	/**
	 *方法: 设置goAllPrice
	 *@param: BigDecimal  goAllPrice
	 */
	public void setGoAllPrice(BigDecimal goAllPrice){
		this.goAllPrice = goAllPrice;
	}

	/**
	 *方法: 取得goReturnPrice
	 *@return: BigDecimal  goReturnPrice
	 */
	@Column(name ="go_return_price")
	public BigDecimal getGoReturnPrice(){
		return this.goReturnPrice;
	}

	/**
	 *方法: 设置goReturnPrice
	 *@param: BigDecimal  goReturnPrice
	 */
	public void setGoReturnPrice(BigDecimal goReturnPrice){
		this.goReturnPrice = goReturnPrice;
	}

	/**
	 *方法: 取得goContent
	 *@return: java.lang.String  goContent
	 */
	@Column(name ="go_content")
	public java.lang.String getGoContent(){
		return this.goContent;
	}

	/**
	 *方法: 设置goContent
	 *@param: java.lang.String  goContent
	 */
	public void setGoContent(java.lang.String goContent){
		this.goContent = goContent;
	}

	/**
	 *方法: 取得auditorStatus
	 *@return: java.lang.String  auditorStatus
	 */
	@Column(name ="auditor_status")
	public java.lang.String getAuditorStatus(){
		return this.auditorStatus;
	}

	/**
	 *方法: 设置auditorStatus
	 *@param: java.lang.String  auditorStatus
	 */
	public void setAuditorStatus(java.lang.String auditorStatus){
		this.auditorStatus = auditorStatus;
	}

	/**
	 *方法: 取得auditorObid
	 *@return: java.lang.String  auditorObid
	 */
	@Column(name ="auditor_obid")
	public java.lang.String getAuditorObid(){
		return this.auditorObid;
	}

	/**
	 *方法: 设置auditorObid
	 *@param: java.lang.String  auditorObid
	 */
	public void setAuditorObid(java.lang.String auditorObid){
		this.auditorObid = auditorObid;
	}

	/**
	 *方法: 取得auditorName
	 *@return: java.lang.String  auditorName
	 */
	@Column(name ="auditor_name")
	public java.lang.String getAuditorName(){
		return this.auditorName;
	}

	/**
	 *方法: 设置auditorName
	 *@param: java.lang.String  auditorName
	 */
	public void setAuditorName(java.lang.String auditorName){
		this.auditorName = auditorName;
	}

	/**
	 *方法: 取得crtuser
	 *@return: java.lang.String  crtuser
	 */
	@Column(name ="crtuser")
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
	@Column(name ="crtuser_name")
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
	@Column(name ="create_dt")
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

	/**
	 *方法: 取得modifier
	 *@return: java.lang.String  modifier
	 */
	@Column(name ="modifier")
	public java.lang.String getModifier(){
		return this.modifier;
	}

	/**
	 *方法: 设置modifier
	 *@param: java.lang.String  modifier
	 */
	public void setModifier(java.lang.String modifier){
		this.modifier = modifier;
	}

	/**
	 *方法: 取得modifierName
	 *@return: java.lang.String  modifierName
	 */
	@Column(name ="modifier_name")
	public java.lang.String getModifierName(){
		return this.modifierName;
	}

	/**
	 *方法: 设置modifierName
	 *@param: java.lang.String  modifierName
	 */
	public void setModifierName(java.lang.String modifierName){
		this.modifierName = modifierName;
	}

	/**
	 *方法: 取得modifyDt
	 *@return: java.util.Date  modifyDt
	 */
	@Column(name ="modify_dt")
	public java.util.Date getModifyDt(){
		return this.modifyDt;
	}

	/**
	 *方法: 设置modifyDt
	 *@param: java.util.Date  modifyDt
	 */
	public void setModifyDt(java.util.Date modifyDt){
		this.modifyDt = modifyDt;
	}

	/**
	 *方法: 取得delflag
	 *@return: java.lang.Integer  delflag
	 */
	@Column(name ="delflag")
	public java.lang.Integer getDelflag(){
		return this.delflag;
	}

	/**
	 *方法: 设置delflag
	 *@param: java.lang.Integer  delflag
	 */
	public void setDelflag(java.lang.Integer delflag){
		this.delflag = delflag;
	}

	/**
	 *方法: 取得delDt
	 *@return: java.util.Date  delDt
	 */
	@Column(name ="del_dt")
	public java.util.Date getDelDt(){
		return this.delDt;
	}

	/**
	 *方法: 设置delDt
	 *@param: java.util.Date  delDt
	 */
	public void setDelDt(java.util.Date delDt){
		this.delDt = delDt;
	}

	@Transient
	public JeecgOrderCustomEntity getJeecgOrderCustomEntity() {
		return jeecgOrderCustomEntity;
	}

	public void setJeecgOrderCustomEntity(
			JeecgOrderCustomEntity jeecgOrderCustomEntity) {
		this.jeecgOrderCustomEntity = jeecgOrderCustomEntity;
	}
	@Transient
	public JeecgOrderProductEntity getJeecgOrderProductEntity() {
		return jeecgOrderProductEntity;
	}

	public void setJeecgOrderProductEntity(
			JeecgOrderProductEntity jeecgOrderProductEntity) {
		this.jeecgOrderProductEntity = jeecgOrderProductEntity;
	}

}