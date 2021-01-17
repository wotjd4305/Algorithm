package TextBook;

import java.util.Scanner;


public class Z05_Subset {

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		
		int[] a = {-7,-3,-2,5,8};
		
		for(int i =0; i<2; i++)
		{
			for(int j = 0; j<2; j++ ) {
				for(int k = 0; k<2; k++ ) {
					for(int l = 0; l<2; l++ ) {
						for(int m = 0; m<2; m++ ) {
							int sum =0;
							if(i==1) { System.out.print(a[0]+" ");sum+=a[0];}
							if(j==1) { System.out.print(a[1]+" ");sum+=a[1];}
							if(k==1) { System.out.print(a[2]+" ");sum+=a[2];}
							if(l==1) { System.out.print(a[3]+" ");sum+=a[3];}
							if(m==1) { System.out.print(a[4]+" ");sum+=a[4];}
							System.out.println("\t : 합" + sum);				
						}
					}
				}
			}			
		}		
	}// end of main
}// end of class
