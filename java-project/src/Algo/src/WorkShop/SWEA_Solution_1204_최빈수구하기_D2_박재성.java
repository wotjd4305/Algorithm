package Algo.src.WorkShop;

import java.util.*;


	public class SWEA_Solution_1204_최빈수구하기_D2_박재성{
		public static void main(String [] args) {
		
			Scanner s = new Scanner(System.in);
			int[] NumTable = new int[1000];
			int[] tableStack = new int[101];
			int result = 0;
	
			int T= s.nextInt();
			for(int i = 0; i< T; i++)
			{
				Arrays.fill(tableStack, 0);//0���� �ʱ�ȭ, Ȥ�� �𸣱� ������
				Arrays.fill(NumTable, 0);//0���� �ʱ�ȭ, Ȥ�� �𸣱� ������
				
			
				int Tnum = s.nextInt();
				for(int j =0; j<1000; j++)
				{
					NumTable[j] = s.nextInt();
				}
				
				for(int k =0; k<1000; k++ )
				{
					tableStack[NumTable[k]] += 1;
				}
				
					result = Check(tableStack);
					
					System.out.println( "#"+ Tnum + " " +result);
				
			}	
		
	}
	public static int Check(int arr[])
	{
		int result = 0;
		int result_Array = 0;
		for(int l= 0; l<101; l++)
		{
			if(result <= arr[l])
			{
				result = arr[l];
				result_Array = l;
			}
		}
		return result_Array;
	}
	
	}
	
	




	

