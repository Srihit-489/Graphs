class Solution {
    public int[] findOrder(int n, int[][] arr) {
        HashMap<Integer,List<Integer>> myhash = new HashMap<>();
        for(int i=0;i<n;i++){
            myhash.put(i,new ArrayList<Integer>());
        }
        
        
        for(int i=0;i<arr.length;i++){
            myhash.get(arr[i][0]).add(arr[i][1]);
        }
        
        int[] visited = new int[n];
        
        for(int i=0;i<n;i++){
            if(!dfs(i,myhash,visited)){
                return new int[0];
            }
        }
        
        
        boolean[] reached = new boolean[n];
        Stack<Integer> mystack = new Stack<Integer>();
        for(int i=0;i<n;i++){
            if(!reached[i]){
                toposort(i,myhash,reached,mystack);
            }
            
        }
        Object[] finalarray = mystack.toArray();
        int[] retarray = new int[n];
        for(int i=0;i<n;i++){
            retarray[i] = (int)finalarray[i];
        }
        return retarray;
    }
    
    
    public void toposort(int hero,HashMap<Integer,List<Integer>> myhash,boolean[] reached,Stack<Integer> mystack){
        reached[hero] = true;
        for(int i:myhash.get(hero)){
            if(!reached[i]){
                toposort(i,myhash,reached,mystack);
            }
        }
        mystack.push(hero);
    }
    
    
    public boolean dfs(int hero,HashMap<Integer,List<Integer>> myhash,int[] visited){
        if(visited[hero] == -1){
            return false;
        }
        
        if(visited[hero] == 1){
            return true;
        }
        
        visited[hero] = -1;
        for(int i : myhash.get(hero)){
            if(!dfs(i,myhash,visited)){
                return false;
            }
        }
        
        visited[hero] = 1;
        return true;
        
        
        
    }
    
}
