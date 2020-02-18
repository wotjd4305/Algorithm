package WorkShop_M2_java09;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * VO : Value Object
 * DTO : Data Transfer Object
 */
class OOTestVO implements Serializable {
	private String name;
	private String telNo;
	OOTestVO(String name, String tel){
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
			return name+" : "+telNo;
		}
}
public class IO7ObjectInOut {
	public static void main(String[] args) {
		//FileOutputStream fos = null;
		//
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			File outFile = new File((new File(".").getCanonicalPath())
														+"\\src\\objectout.dat");
			//fos = new FileOutputStream(outFile,true);
			//oos = new ObjectOutputStream(fos);
			fis = new FileInputStream(outFile);
			ois = new ObjectInputStream(fis);
			/*OOTestVO vo = new OOTestVO("유재석","030");
			oos.writeObject(vo);
			OOTestVO vo2 = new OOTestVO("강호동","011");
			oos.writeObject(vo2);
			oos.flush();*/
			//===================
			OOTestVO tmpVO = null;
			while((tmpVO=(OOTestVO)ois.readObject()) != null) {
				System.out.println(tmpVO);
			}
		} catch (EOFException e) {
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				//oos.close();
				//fos.close();
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
