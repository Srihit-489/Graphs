class Solution {
    int[] distance = new int[1000];
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<edge>> myhash = new HashMap<Integer,List<edge>>();
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;
        for(int i=1;i<=n;i++)
            myhash.put(i,new ArrayList<edge>());
        for(int[] time : times){
            myhash.get(time[0]).add(new edge(time[0],time[1],time[2]));
        }
        
        PriorityQueue<edge> pq = new PriorityQueue<edge>(new Comp());
        for(edge e : myhash.get(k)){
            pq.add(e);
        }
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(k);
        while(pq.size() != 0){
            edge e = pq.remove();
            relax(e);
            if(!visited.contains(e.to)){
                for(edge child : myhash.get(e.to)){
                pq.add(child);
                }
                visited.add(e.to);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            System.out.print(distance[i]+" ");
            max = Math.max(max,distance[i]);
        }
        
        return max == Integer.MAX_VALUE?-1:max;
        

    }
    
    public void relax(edge e){
        if(distance[e.from] + e.dist < distance[e.to])
            distance[e.to]  = distance[e.from]+ e.dist;
        return;
    }
    
    public class Comp implements Comparator<edge>{
        public int compare(edge a,edge b){
            if(a.dist == b.dist)
                return a.dist;
            else
                return a.dist - b.dist;
        }
    }
    
    class edge{
        public int from;
        public int to;
        public int dist;
        
        public edge(int from,int to,int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
}




// 38/52
