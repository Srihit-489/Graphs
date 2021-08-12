import  java.util.*;
import java.lang.*;

class Bipartate{
	  public static Scanner scanner = new Scanner(System.in);
	  public static void main(String[] args){
			HashMap<Integer,List<Integer>> myhash = new HashMap<>();
			// Create A graph using hashmap and user input
			int[] visited = new int[myhash.size()];
			int[] col = new int[myhash.size()];
			for(int i=0;i<myhash.size();i++){
				  if(visited[i] == 0){
					    col[i] = 1;
						if(!dfs(i,myhash,1,visited,col))  // this means the given graph is not bipartite...
							return false;
				  }
			}
			return true;

	  }

	  public static void dfs(int pos,HashMap myhash,int col,int[] visited,int[] col){
		  visited[pos] = 1;
		  col[pos] = col;
		  for(int i : myhash.get(pos)){
				if(visited[i] == 0){
					  if(!dfs(i,myhash,-col,visited,col)
							  return false;		  
				}else{
					  if(col[pos] == col[i])
						  return false;
				}
		  }
			
	  }
}
