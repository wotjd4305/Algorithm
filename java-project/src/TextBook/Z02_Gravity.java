package TextBook;

import java.util.Scanner;

/**��������*/
public class Z02_Gravity {

	static Scanner sc = new Scanner(System.in);
	static int map[][] = new int[8][9];
	static int box[] = {7,4,2,0,
			0,6,0,7,0};
	static int answer = 0;
	
	public static void main(String args[])
	{
		answer = 0;
		Make_Map(box);
		solution();
		System.out.println("�ִ� ���� - " + answer);
		//System.out.println(Arrays.toString(box));
	}// end of main
	
	public static void Make_Map(int box[])
	{
		int idx = 0;
		for(int i=0; i<box.length; i++)
		{
			for(int j=0; j<box[i]; j++)
			{
				map[j][idx] = 1;
			}
			idx++;
		}
	}
	
	public static void solution()
	{
		for(int i=0; i<9; i++)
		{
			int each_max = box[i];
			int count =0;
			
			for(int j=i; j<9; j++)
			{
				//�Ƚ׿������� ����.
				if(each_max== 0)
					break;		
				//�׿����ִ� ���� ���������� ����� ����(=����)�� ����.
				if(map[each_max-1][j] == 0) 
					count++;
			}
			answer = Math.max(answer, count);
		}
	}
}// end of class
