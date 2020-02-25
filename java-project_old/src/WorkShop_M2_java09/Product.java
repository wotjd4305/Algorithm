package WorkShop_M2_java09;

public class Product {
	private String number;
	private String name;
	private String price;
	private String stock;

	public Product(String number, String name, String price, String stock) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	@Override
	public String toString() {
		String buffer = String.format("%10s|%10s|%10s|%10s  \t|", number, name, price, stock);
		return buffer;
	}
	
	public String FileFomat() {
		String buffer = String.format("%s|%s|%s|%s", number, name, price, stock);
		return buffer;
	}
	
	

	public int RetPrice() {
		return Integer.parseInt(price);
	}
	public int RetStock() {
		return Integer.parseInt(stock);
	}
	

	public Product PassByNumber(String number) {
		if (number.equals(this.number)) {
			String number_d = this.number;
			String name = this.name;
			String price = this.price;
			String stock = this.stock;

			return new Product(number_d, name, price, stock);
		}
		return null;
	}

	public Product PassByName(String name) {
		if (name.equals(this.name)) {
			String number = this.number;
			String name_d = this.name;
			String price = this.price;
			String stock = this.stock;

			return new Product(number, name_d, price, stock);
		}
		return null;
	}

	public Product DeleteByNumber(String number) {
		if (number.equals(this.number)) {
			String number_d = this.number;
			String name = this.name;
			String price = this.price;
			String stock = this.stock;
			
			return new Product(number_d, name, price, stock);
		}
		return null;
	}
	
	
	
	
	
	
	
	

}
