package WorkShop_M2_java09;
public class TV extends Product {
	
	private String p_inch;
	private String p_type;
	
	public TV(String p_num, String p_name, String p_price, String p_count, String p_inch, String p_type) {
		super(p_num, p_name, p_price, p_count);
		this.p_inch = p_inch;
		this.p_type = p_type;
	}


	@Override
	public String FileFomat() {
		return super.FileFomat()+ "@"+ p_inch + "@" + p_type;
	}


	@Override
	public String toString() {
		return super.toString() + p_inch + "\t | " + p_type;
	}


	public String getP_inch() {
		return p_inch;
	}

	
	
}
