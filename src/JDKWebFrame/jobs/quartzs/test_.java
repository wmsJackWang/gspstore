package JDKWebFrame.jobs.quartzs;

import org.springframework.beans.BeanUtils;

public class test_ {  

	public static void main(String[] args) {
		
		test te1 = new test1("1","2","3");
		test2 target = new test2();
		BeanUtils.copyProperties(te1, target);
		System.out.println(target.toString());
	}  
}
class test {
	String p1;
	String p2;
	public test() {
		// TODO Auto-generated constructor stub
	}
	public test(String p1 , String p2) {
		// TODO Auto-generated constructor stub
		this.p1 = p1;
		this.p2 = p2;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	
}
class test1 extends test{
	String p3;
	public test1() {
		// TODO Auto-generated constructor stub
	}
	public test1(String p1 , String p2, String p3) {
		// TODO Auto-generated constructor stub
		super(p1,p2);
		this.p3 = p3;
	}
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3 = p3;
	}
	
	
}

class test2{
	String p1;

	String p2;

	String p3;
	
	

	public String getP1() {
		return p1;
	}



	public void setP1(String p1) {
		this.p1 = p1;
	}



	public String getP2() {
		return p2;
	}



	public void setP2(String p2) {
		this.p2 = p2;
	}



	public String getP3() {
		return p3;
	}



	public void setP3(String p3) {
		this.p3 = p3;
	}



	@Override
	public String toString() {
		return "test2 [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
	}
	
	
}