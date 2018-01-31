package business.page.sale;

import java.math.BigDecimal;
import java.util.Date;

import business.page.article.ArticlePage;
import business.page.depot.DepotPage;

import com.core.base.BasePage;/**   
 * @Title: Page
 * @Description: 销售单明细
 * @author zhangdaihao
 * @date 2013-05-19 10:14:59
 * @version V1.0   
 *
 */
 
 @SuppressWarnings("serial")
public class SaleDetailPage  extends BasePage implements java.io.Serializable {
	/**销售明细主键*/
	private java.lang.String salebilldetailno;
	/**销售单号*/
	private java.lang.String salebillno;
	/**品种*/
	private java.lang.String articleid;
	private ArticlePage articlepage;
	/**批号*/
	private java.lang.String serial;
	/**数量*/
	private BigDecimal num;
	/**数量*/
	private BigDecimal backnum;
	/**销售价*/
	private BigDecimal saleprice;
	/**成本价*/
	private BigDecimal price;
	/**金额*/
	private BigDecimal amount;
	/**仓库*/
	private java.lang.String depotid;
	private DepotPage depotpage;
	/**防伪号*/
	private java.lang.String secretno;
	private java.lang.String stockkey;
	/**有效期*/
    private java.util.Date expiredate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售明细主键
	 */
	public java.lang.String getSalebilldetailno(){
		return this.salebilldetailno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售明细主键
	 */
	public void setSalebilldetailno(java.lang.String salebilldetailno){
		this.salebilldetailno = salebilldetailno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售单号
	 */
	public java.lang.String getSalebillno(){
		return this.salebillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售单号
	 */
	public void setSalebillno(java.lang.String salebillno){
		this.salebillno = salebillno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品种
	 */
	public java.lang.String getArticleid(){
		return this.articleid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品种
	 */
	public void setArticleid(java.lang.String articleid){
		this.articleid = articleid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批号
	 */
	public java.lang.String getSerial(){
		return this.serial;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批号
	 */
	public void setSerial(java.lang.String serial){
		this.serial = serial;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  数量
	 */
	public BigDecimal getNum(){
		return this.num;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  数量
	 */
	public void setNum(BigDecimal num){
		this.num = num;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  销售价
	 */
	public BigDecimal getSaleprice(){
		return this.saleprice;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  销售价
	 */
	public void setSaleprice(BigDecimal saleprice){
		this.saleprice = saleprice;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  成本价
	 */
	public BigDecimal getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  成本价
	 */
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  金额
	 */
	public BigDecimal getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  金额
	 */
	public void setAmount(BigDecimal amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库
	 */
	public java.lang.String getDepotid(){
		return this.depotid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库
	 */
	public void setDepotid(java.lang.String depotid){
		this.depotid = depotid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  防伪号
	 */
	public java.lang.String getSecretno(){
		return this.secretno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  防伪号
	 */
	public void setSecretno(java.lang.String secretno){
		this.secretno = secretno;
	}

    public ArticlePage getArticlepage()
    {
        return articlepage;
    }

    public void setArticlepage(ArticlePage articlepage)
    {
        this.articlepage = articlepage;
    }

    public DepotPage getDepotpage()
    {
        return depotpage;
    }

    public void setDepotpage(DepotPage depotpage)
    {
        this.depotpage = depotpage;
    }

    public java.lang.String getStockkey()
    {
        return stockkey;
    }

    public void setStockkey(java.lang.String stockkey)
    {
        this.stockkey = stockkey;
    }

    public java.util.Date getExpiredate()
    {
        return expiredate;
    }

    public void setExpiredate(java.util.Date expiredate)
    {
        this.expiredate = expiredate;
    }

    public BigDecimal getBacknum()
    {
        return backnum;
    }

    public void setBacknum(BigDecimal backnum)
    {
        this.backnum = backnum;
    }
	
}
