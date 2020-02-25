package main.java.WorkShop_M2_java09;
import java.util.Scanner;

public class ProductTest {

	static Scanner sc = new Scanner(System.in);
	static ProductMgrlmpl PM = new ProductMgrlmpl();
	
	public static void main(String args[]) {

		menu();

	}

	public static void menu() {
		

		while (true) {
			System.out.println("***********************메뉴선택***********************");
			System.out.println("0:종료, 1:상품 정보 저장, 2:상품 전체검색, 3:상품번호로 검색\n"
					+ "4:상품명으로 검색, 5: TV만 검색, 6: 냉장고만 검색, 7:상품번호로 제품삭제, 8:총제고가격으로 검색\n"
					+ "9:400L이상의 냉장고 검색, 10:50인치 이상의 TV검색, 11: 파일에서 읽어오기, 12:파일에 저장하기");
			int menuNum = sc.nextInt();
			int btn = 0;

			// 상품정보 저장, 상품정보 전체 검색, 상품번호 검색, 상품명으로 검색, tv정보만 검색,냉장고만 검색, 상품번호로 삭제
			switch (menuNum) {
			case 1:
				PM.requestProductSave();
				break;
			case 2:
				PM.requestProductPrint(PM.BAL);
				break;
			case 3:
				System.out.println("제품번호를 입력하주세요 : ");
				String isbn_input = sc.next();
				for (Product b : PM.requestProductByNumber(isbn_input, PM.BAL)) {
					System.out.println(b.toString());
				}
				break;
			case 4:
				System.out.println("제품명을 입력하주세요 : ");
				String title_input = sc.next();
				for (Product b : PM.requestProductByName(title_input, PM.BAL)) {
					System.out.println(b.toString());
				}
				break;
			case 5:
				PM.requestTvDes(PM.BAL);
				break;
			case 6:
				PM.requestReDes(PM.BAL);
				break;
			case 7:
				System.out.println("삭제할 제품번호를 입력하주세요 : ");
				String delete_number_input = sc.next();
				int result_code = PM.requestDeleteProductByNumber(delete_number_input, PM.BAL);
				if(result_code == -1)
					System.out.println("없는 제품입니다.");
				else
					PM.BAL.remove(result_code);
				break;
			case 8:
				System.out.printf("총 재고의 금액은 %d원입니다.", PM.requestRemainStockPrice(PM.BAL));
				break;
			case 9:
				PM.requestReOver400L(PM.BAL);
				break;
			case 10:
				PM.requestTVOver50inch(PM.BAL);
				break;
			case 11:
				PM.loadData();
				break;
			case 12:
				PM.saveData();
				break;
			default:
				btn = 1;
				break;
			}

			// 종료
			if (btn == 1)
				break;
		}
	}

}

