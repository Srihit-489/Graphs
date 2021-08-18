class Solution {
    HashMap<Integer,Integer> myhash = new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        
        for(int[] edge : edges){
            myhash.put(edge[0],edge[0]);
            myhash.put(edge[1],edge[1]);
        }
        
        for(int[] edge  : edges){
            int a = edge[0];
            int b = edge[1];
            if(find(a) == find(b)){
                return new int[]{a,b};
            }else{
                union(a,b);
            }
        }
        return new int[]{0,0};
    }
    
    public int find(int a){
        if(a == myhash.get(a))
            return a;
        return find(myhash.get(a));
    }
    
    public void union(int a,int b){
        myhash.put(find(a),find(b));
    }
}
