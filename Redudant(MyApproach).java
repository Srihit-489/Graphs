class Solution {
    int[] edge = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer,List<Integer>> myhash = new HashMap<>();
        for(int[] edge : edges){
            int n1 = edge[0];
            int n2 = edge[1];
            List<Integer> l1 = myhash.getOrDefault(n1,new ArrayList<>());
            List<Integer> l2 = myhash.getOrDefault(n2,new ArrayList<>());
            l1.add(n2);
            l2.add(n1);
            myhash.put(n1,l1);
            myhash.put(n2,l2);
                
        }
        boolean[] visited = new boolean[myhash.size()+1];
        dfs(1,myhash,visited,0);
        return edge;
    }
    
    public void dfs(int start, HashMap<Integer,List<Integer>> myhash,boolean[] visited,int prev){
        visited[start] = true;
        for(int i : myhash.get(start)){
            if(!visited[i]){
                dfs(i,myhash,visited,start);
            }else{
                if(i != prev){
                    edge[0] = start;
                    edge[1] = i;
                    return;
                }
            }
        }
    }
