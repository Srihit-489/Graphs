import java.lang.*;
import java.util.*;

class Counting{
	 public static int[]  r = new int[]{0,0,-1,1};
	 public static int[] c = new int[]{1,-1,0,0};
	  public static Scanner scanner = new Scanner(System.in);
	  public static void main(String[] args){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			scanner.nextLine();
			char[][] arr = new char[n][m];
			for(int i=0;i<n;i++){
						String input  = scanner.nextLine();
						for(int j=0;j<m;j++)
							arr[i][j] = input.charAt(j);
				  
			}
			int count = 0;
			for(int i=0;i<n;i++){
				  for(int j=0;j<m;j++){
						if(arr[i][j] == '.'){
							  count++;
							  getcount(arr,i,j);
						}
						  
				  }
			}
			System.out.println(count);
	  }

	  public static void getcount(char[][] arr,int x,int y){
		  if(!((0 <= x && x < arr.length) && (0 <= y && y < arr[0].length)))
			  return;
		  if(arr[x][y] == '#')
			  return;
			arr[x][y] = '#';
            for(int i=0;i<4;i++){
			         getcount(arr,x+r[i],y+c[i]);
			}
			return;
	  }









}
