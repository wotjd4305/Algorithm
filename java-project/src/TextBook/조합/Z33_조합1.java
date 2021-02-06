package TextBook.조합;

//반복문
public class Z33_조합1 {
	
	public static void main(String args[]) {
		int arr[] = {1,3,5,7,9};
		for(int i =0; i<arr.length-2; i++) {
			for(int j= i+1; j<arr.length-1; j++) {
				for (int k = j+1; k<arr.length; k++) {
					System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
				}
			}
		}
		
	}

}
