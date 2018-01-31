package sun.service.order;

import sun.entity.order.GbuyOrderEntity;
import com.jeecg.pageModel.DataGrid;
import sun.page.order.GbuyOrderPage;
import com.jeecg.service.BaseServiceI;
import java.util.List;
import sun.page.order.GbuyOrderCustomPage;
import sun.entity.order.GbuyOrderCustomEntity;
import sun.page.order.GbuyOrderProductPage;
import sun.entity.order.GbuyOrderProductEntity;

/**   
 * @Title: Service
 * @Description: 订单抬头
 * @author zhangdaihao
 * @date 2011-12-19 13:09:34
 * @version V1.0   
 *
 */
public interface GbuyOrderServiceI extends BaseServiceI {

	/**
	 * 获得数据表格
	 * 
	 * @param bug
	 * @return
	 */
	public DataGrid datagrid(GbuyOrderPage gbuyOrderPage);

	/**
	 * 添加
	 * 
	 * @param gbuyOrderPage
	 */
	public void add(GbuyOrderPage gbuyOrderPage);

	
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(GbuyOrderPage gbuyOrderPage,List<GbuyOrderCustomPage> gbuyOrderCustomList,List<GbuyOrderProductPage> gbuyOrderProductList)  throws Exception ;
	
	/**
	 * 修改一对多
	 * 
	 */
	public void editMain(GbuyOrderPage gbuyOrderPage,List<GbuyOrderCustomPage> gbuyOrderCustomList,List<GbuyOrderProductPage> gbuyOrderProductList)  throws Exception ;
	
	
	/**
	 * 修改
	 * 
	 * @param gbuyOrderPage
	 */
	public void update(GbuyOrderPage gbuyOrderPage) throws Exception;

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	public void delete(String ids);

	/**
	 * 获得
	 * 
	 * @param GbuyOrder
	 * @return
	 */
	public GbuyOrderEntity get(GbuyOrderPage gbuyOrderPage);
	
	
	/**
	 * 获得
	 * 
	 * @param obid
	 * @return
	 */
	public GbuyOrderEntity get(String obid);
	
	/**
	 * 获取所有数据
	 */
	public List<GbuyOrderEntity> listAll(GbuyOrderPage gbuyOrderPage);
	
	/**根据主表Key,查询子表明细：订单客户明细*/
	public List<GbuyOrderCustomPage> getGbuyOrderCustomListByFkey(String obid,String goOrderCode);
	/**根据主表Key,查询子表明细：订单产品明细*/
	public List<GbuyOrderProductPage> getGbuyOrderProductListByFkey(String obid,String goOrderCode);

}
