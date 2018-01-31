package business.page.city;

import com.core.base.BasePage;

public class CityPage extends BasePage implements java.io.Serializable{

	/* 城市序列 */
	private String cityNo;
	
	/* 城市名字 */
	private String cityName ;
	
	/* 城市级别 */
	private String cityLevel ; 
	
	/* 城市所在国家 */
	private String country;
	
	/* 城市开始年限 */
	private String age;
	
	/*
	 *  方法: 获取String
	 *  @return: String 城市序列
	 *   */
	public String getCityNo() {
		return cityNo;
	}

	/* 
	 * 方法: 设置string
	 * @param : String 城市序列
	 *  */
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}

	/*
	 *  方法: 获取String
	 *  @return: String 城市名
	 *   */
	public String getCityName() {
		return cityName;
	}

	/* 
	 * 方法: 设置string
	 * @param : String 城市名
	 *  */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/* 
	 * 方法 : 获取string
	 * @return : String 城市级别
	 *  */
	public String getCityLevel() {
		return cityLevel;
	}

	/* 
	 * 方法 : 设置string 城市级别
	 * @param: string  
	 * */
	public void setCityLevel(String cityLevel) {
		this.cityLevel = cityLevel;
	}

	/* 
	 * 方法: 获取string 城市所在国家
	 * @return : string 
	 *  */
	public String getCountry() {
		return country;
	}

	/* 
	 * 方法: 设置String 城市所在国家 
	 * @param : string */
	public void setCountry(String country) {
		this.country = country;
	}

	/* 
	 * 方法: 设置string 城市成立时长
	 * @return String  */
	public String getAge() {
		return age;
	}

	/* 
	 * 方法: 获取string城市成立时长
	 * @param: string */
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
