package business.entity.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_xx_city" , schema = "")
@SuppressWarnings("serial")
public class CityEntity implements java.io.Serializable{

	/* 城市序列 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "CITYNO" , length = 20 , nullable = false)
	private String cityNo;
	
	/* 城市名字 */
	@Column(name = "CITYNAME" , nullable = false , length = 20)
	private String cityName ;
	
	/* 城市级别 */
	@Column(name = "CITYLEVEL" , nullable = true , length = 20)
	private String cityLevel ; 
	
	/* 城市所在国家 */
	@Column(name = "COUNTRY" , nullable = true , length = 20)
	private String country;
	
	/* 城市开始年限 */
	@Column(name = "AGE" , nullable = true , length = 4)
	private String age;

//	@Id
//	@GeneratedValue(generator = "paymentableGenerator")
//	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
//	@Column(name = "CITYNO" , length = 20 , nullable = false)
	public String getCityNo() {
		return cityNo;
	}

	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}

//	@Column(name = "CITYNAME" , nullable = false , length = 20)
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

//	@Column(name = "CITYLEVEL" , nullable = true , length = 20)
	public String getCityLevel() {
		return cityLevel;
	}

	public void setCityLevel(String cityLevel) {
		this.cityLevel = cityLevel;
	}

//	@Column(name = "COUNTRY" , nullable = true , length = 20)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

//	@Column(name = "AGE" , nullable = true , length = 4)
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	
}
