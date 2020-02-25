package main.java.WorkShop_M2_java09;
public class Refrigerator extends Product {
	
	private String p_L;
	
	


	public Refrigerator(String p_num, String p_name, String p_price, String p_count, String p_L) {
		super(p_num, p_name, p_price,p_count);
		this.p_L = p_L;
	}



	@Override
	public String FileFomat() {
		// TODO Auto-generated method stub
		return super.FileFomat()+ "@"+ p_L;
	}


	@Override
	public String toString() {
		return super.toString() + p_L;
	}

	public String getP_L() {
		return p_L;
	}
	
}
