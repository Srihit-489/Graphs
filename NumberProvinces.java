class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,List<Integer>> myhash = new HashMap<>();
        for(int i=0;i<isConnected.length;i++){
            myhash.put(i,new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=i+1;j<isConnected.length;j++){
                if(isConnected[i][j] == 1){
                    myhash.get(i).add(j);
                    myhash.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                count++;
                dfs(i,myhash,visited);
            }
        }
        return count;
        
    }
    
    public void dfs(int hero,HashMap<Integer,List<Integer>> myhash,boolean[] visited){
        visited[hero] = true;
        for(int i : myhash.get(hero)){
            if(!visited[i])
                dfs(i,myhash,visited);
        }
        return;
    }
}
