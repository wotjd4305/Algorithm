package TextBook;

import java.util.Scanner;

public class Soultion_1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();//num of Testcases
		for (int testcase = 1; testcase <= TC; testcase++) {
			String str = sc.next();
			//System.out.println(str);
			int count = 0;
			int istrue = 1;
			int arr[] = new int[str.length()];
			for(int i =0; i < str.length();i++) {
				//변환
				//System.out.println("str:"+str.charAt(i));
				//System.out.println("arr:"+arr[i]);
				if(str.charAt(i)=='1' & arr[i]==0) { //1발견
					//System.out.println("변환");
					for(int x =i;x < str.length();x++) {
						arr[x] = 1;
					}
					count++;
				}
				else if (str.charAt(i)=='0' & arr[i]==1){
					for(int x =i;x < str.length();x++) {
						arr[x] = 0;
					}
					count++;
				}
				
				//판별
				istrue = 1;
				for(int z =0; z < str.length();z++) {
					if(str.charAt(z)!=arr[z]) {
						istrue = 0;
						break;
					}
				}
				if(istrue == 1)
					break;
			}
			System.out.println("#"+testcase+" "+count);
		}
	}


}
