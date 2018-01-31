package business.service.city;

import java.util.List;

import com.jeecg.pageModel.DataGrid;
import com.jeecg.service.BaseServiceI;

import business.entity.city.CityEntity;
import business.page.city.CityPage;

public interface CityServiceI extends BaseServiceI{

	/**
	 * 获得数据表格
	 * 
	 * @param bug
	 * @return
	 */
	public DataGrid datagrid(CityPage CityPage);

	/**
	 * 添加
	 * 
	 * @param CityPage
	 */
	public void add(CityPage CityPage);

	/**
	 * 修改
	 * 
	 * @param CityPage
	 */
	public void update(CityPage CityPage) throws Exception;

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	public void delete(String ids);

	/**
	 * 获得
	 * 
	 * @param City
	 * @return
	 */
	public CityEntity get(CityPage CityPage);
	
	
	/**
	 * 获得
	 * 
	 * @param Cityno
	 * @return
	 */
	public CityEntity get(java.lang.String CityNo);
	
	/**
	 * 获取所有数据
	 */
	public List<CityEntity> listAll(CityPage CityPage);
	
	public CityPage getOneCity();

}
