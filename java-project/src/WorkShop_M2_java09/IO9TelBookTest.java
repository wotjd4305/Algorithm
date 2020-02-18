package WorkShop_M2_java09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class TelNote implements Serializable {
	private String name;
	private String telNo;

	TelNote(String name, String tel) {
		this.name = name;
		this.telNo = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	@Override
	public String toString() {
		return name + " : " + telNo;
	}
}// class

public class IO9TelBookTest {
	File outFile = null;
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	Scanner scan = null;

	IO9TelBookTest() {
		try {
			outFile = new File((new File(".").getCanonicalPath()) + "\\src\\telbook.dat");
			scan = new Scanner(System.in);
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("전화번호부 생성에 실패 하였습니다.");
		}
	}// constructor

	public static void main(String[] args) {
		// 전화번호부 입력기를 만들자.
		// ObjectOutputStream을 사용하여, 파일에 전화번호부 입력, 출력.
		// 검색, 수정, 삭제 없음.
		IO9TelBookTest telBook = new IO9TelBookTest();
		System.out.println("========전화번호부========");
		int menuNo = 0;
		while (true) {
			System.out.print("0:종료, 1:입력, 2:출력, 선택 : ");
			menuNo = telBook.scan.nextInt();
			if (menuNo == 0) {
				telBook.scan.close();
				break;
			} else if (menuNo == 1) {
				telBook.insertData();
			} else if (menuNo == 2) {
				telBook.printData();
			}
		} // while
	}// main

	private void insertData() {
		System.out.print("이름 : ");
		String tmpName = scan.next();
		System.out.print("전화번호 : ");
		String tmpTel = scan.next();
		try {
			fos = new FileOutputStream(outFile, true);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new TelNote(tmpName, tmpTel));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				oos.flush();
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// insertData
	private void printData() {
		try {
				
			fis = new FileInputStream(outFile);
			ois = new ObjectInputStream(fis);
			TelNote tmpVO = null;
			while ((tmpVO = (TelNote) ois.readObject()) != null) {
				System.out.println(tmpVO);
			}
		} catch (ClassNotFoundException | IOException e) {
			//e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// printData

}// class
