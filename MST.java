import java.util.*;
import java.lang.*;

class MST{
	  public static Scanner scanner = new Scanner(System.in);
	  public static HashMap<Integer,Integer> myhash = new HashMap<>();
	  public static void main(String[] args){
		    int size = scanner.nextInt();
		    int n = scanner.nextInt();
			for(int i=1;i<=size;i++)
				myhash.put(i,i);
			PriorityQueue<edge> pq = new PriorityQueue<edge>((a,b)->a.w-b.w);
			for(int i=0;i<n;i++){
				 int a = scanner.nextInt();
				 int b = scanner.nextInt();
				 int w = scanner.nextInt();
				  pq.add(new edge(a,b,w));
				  myhash.put(b,b);

			}
			int sum = 0;
			while(pq.size() != 0){
				  edge e = pq.remove();
				  int a = e.a;
				  int b = e.b;
				  if(find(a) != find(b)){
						sum+= e.w;
						union(a,b);
				  }
						
			}

			System.out.println(sum);
	  }


	  public static int find(int a){
			if(a == myhash.get(a))
				return a;
			return find(myhash.get(a));
	  }

	  public static void union(int a,int b){
			myhash.put(find(a),find(b));
	  }



	  public static class edge{
			public int a;
			public int b;
			public int w;

			public edge(int a,int b,int w){
				  this.a = a;
				  this.b = b;
				  this.w = w;
			}
	  }
}
