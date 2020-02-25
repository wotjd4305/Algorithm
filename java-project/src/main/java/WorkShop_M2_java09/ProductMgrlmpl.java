package main.java.WorkShop_M2_java09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductMgrlmpl implements IProductMgr {

	// 파일용
	File outFile = null;
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	Scanner scan = null;

	static ArrayList<Product> BAL = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	ProductMgrlmpl() {
		try {
			outFile = new File((new File(".").getCanonicalPath()) + "\\src\\Product.dat");
			scan = new Scanner(System.in);
			//init();
			//saveData();
			//loadData();
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("제품 목록 생성에 실패 하였습니다.");
		}
	}// constructor
	
	
	@Override
	public void saveData() {
	
		PrintWriter pw = null;	
		try {
			pw = new PrintWriter((new FileWriter((outFile))));
			
			for(Product p : BAL) {
				pw.println(p.FileFomat());
			}
			pw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}	// insertData

	@Override
	public void loadData() {
		FileReader fr = null;
		BufferedReader br = null;		
		try {		
			fr = new FileReader(outFile);
			br = new BufferedReader(fr);
		
			String str = null;

			//냉장고는 5
			//tv 6
			while((str=br.readLine
					()) != null) {

				String buffer[] = str.split("@");
				if(buffer.length == 5)
					BAL.add(new Refrigerator(buffer[0], buffer[1],buffer[2],buffer[3],buffer[4]));
				if(buffer.length == 6)
					BAL.add(new TV(buffer[0], buffer[1],buffer[2],buffer[3],buffer[4], buffer[5]));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}// printData

	
	
	
	// 입력해주세요. : 제품번호, 제품이름, 제품가격, 제품수량, 인치, 모니터타입
	// 입력해주세요. : 제품번호, 제품이름, 제품가격, 제품수량, 용량
	public void init() {
		BAL.add(new Refrigerator("N-334", "삼성울트라냉장고-1", "110000", "3", "350"));
		BAL.add(new Refrigerator("N-3334", "삼성울트라냉장고-9", "170000", "2", "500"));
		BAL.add(new TV("N-3991", "삼성울트라TV-2", "2000", "5", "15", "led"));
		BAL.add(new TV("N-3221", "삼성울트라TV-3", "6000", "3", "60", "led"));

	}

	@Override
	public void requestProductSave() {
		System.out.println("제품을 선택해주세요. 1 : TV,  2 : 냉장고, 3  : 종료");
		int de_menuNum = sc.nextInt();
		if (de_menuNum == 1) {
			System.out.println("입력해주세요. : 제품번호, 제품명, 가격정보, 재고수량, 인치, 모니터타입");
			BAL.add(new TV(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
		} else if (de_menuNum == 2) {
			System.out.println("입력해주세요. : 제품번호, 제품명, 가격정보, 재고수량, 용량");
			BAL.add(new Refrigerator(sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
		} else {

		}
	}

	@Override
	public void requestProductPrint(ArrayList<Product> BAL) {
		System.out.println("***********************전체목록***********************");
		System.out.format("%10s|%10s|%10s|%10s\n", "제품번호", "제품명", "가격정보", "재고수량");
		System.out.println("====================================================");
		for (Product b : BAL) {
			System.out.println(b.toString());
		}
	}

	@Override
	public ArrayList<Product> requestProductByNumber(String input, ArrayList<Product> BAL) {
		System.out.println("***********************isbn으로 검색한 목록***********************");

		ArrayList<Product> AL_For_Return = new ArrayList<>();

		for (Product b : BAL) {
			if (b.PassByNumber(input) != null)
				AL_For_Return.add(b);
		}

		return AL_For_Return;
	}

	@Override
	public ArrayList<Product> requestProductByName(String input, ArrayList<Product> BAL) {
		System.out.println("***********************제목으로 검색한 목록***********************");

		ArrayList<Product> AL_For_Return = new ArrayList<>();

		for (Product b : BAL) {
			if (b.PassByName(input) != null)
				AL_For_Return.add(b);
		}

		return AL_For_Return;
	}

	@Override
	public void requestTvDes(ArrayList<Product> BAL) {
		System.out.println("***********************TV목록***********************");
		for (Product b : BAL) {
			if ((b instanceof TV))
				System.out.println(b.toString());
		}
	}

	@Override
	public void requestReDes(ArrayList<Product> BAL) {
		System.out.println("***********************냉장고목록***********************");
		for (Product b : BAL) {
			if (!(b instanceof TV)) {
				System.out.println(b.toString());
			}
		}
	}

	@Override
	public void requestReOver400L(ArrayList<Product> BAL) {
		System.out.println("***********************400L넘는 냉장고***********************");
		for (Product b : BAL) {
			if (!(b instanceof TV)) {
				if (Integer.parseInt(((Refrigerator) b).getP_L()) >= 400)
					System.out.println(b.toString());
			}
		}

	}

	@Override
	public void requestTVOver50inch(ArrayList<Product> BAL) {
		System.out.println("***********************50인치 이상 TV***********************");
		for (Product b : BAL) {
			if ((b instanceof TV))
				if (Integer.parseInt(((TV) b).getP_inch()) >= 50)
					System.out.println(b.toString());
		}
	}

	@Override
	public int requestDeleteProductByNumber(String input, ArrayList<Product> BAL) {
		int cnt = 0;
		for (Product b : BAL) {
			if (b.DeleteByNumber(input) != null)
				return cnt;
			cnt++;
		}
		return -1;
	}

	@Override
	public int requestRemainStockPrice(ArrayList<Product> BAL) {
		int result = 0;
		for (Product b : BAL) {
			result += b.RetPrice() * b.RetStock();
		}
		return result;

	}

}

interface IProductMgr {

	public void saveData();

	public void loadData();

	public void requestProductSave(); // 상품정보 저장

	public void requestProductPrint(ArrayList<Product> BAL);

	public ArrayList<Product> requestProductByNumber(String input, ArrayList<Product> BAL);

	public ArrayList<Product> requestProductByName(String input, ArrayList<Product> BAL);

	public void requestTvDes(ArrayList<Product> BAL);

	public void requestReDes(ArrayList<Product> BAL);

	public void requestReOver400L(ArrayList<Product> BAL);

	public void requestTVOver50inch(ArrayList<Product> BAL);

	public int requestDeleteProductByNumber(String input, ArrayList<Product> BAL);

	public int requestRemainStockPrice(ArrayList<Product> BAL);


}