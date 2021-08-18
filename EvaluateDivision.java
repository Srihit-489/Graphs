class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<pair>>myhash = new HashMap<String,List<pair>>();
        HashSet<String> visited = new HashSet<String>();
        for(int i =0;i<equations.size();i++){
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            
            List<pair> l1 = myhash.getOrDefault(s1,new ArrayList<pair>());
            l1.add(new pair(s2,values[i]));
            myhash.put(s1,l1);
            List<pair> l2 = myhash.getOrDefault(s2,new ArrayList<pair>());
            l2.add(new pair(s1,1/values[i]));
            myhash.put(s2,l2);
        }
        
        double[] result = new double[queries.size()];
        int i=0;
        for(List<String> q : queries){
            if(myhash.containsKey(q.get(0)) && myhash.containsKey(q.get(1))){
                result[i] =  dfs(q.get(0),myhash,visited,q.get(1),1);
                 i++;
                visited.clear();
                continue;
               
            }
            
            
            
          //  System.out.println("I am here");
                result[i] = -1;
                i++;
                
        }
        return result;
        
    }
    
    public double dfs(String source,HashMap<String,List<pair>> myhash,HashSet<String> visited,String dest,double current){
        if(source.equals(dest))
            return current;
        
        visited.add(source);
        for(pair child : myhash.get(source)){
            if(!visited.contains(child.x)){
                if(child.x.equals(dest)){
                return current*child.dist;
                 }
                 double val = dfs(child.x,myhash,visited,dest,current*child.dist);
                 if(val != -1){
                    return val;
                 } 
            }
        }
        
        return -1;
    }
    
    class pair{
        public String x;
        public double dist;
        public pair(String x,double dist){
            this.x = x;
            this.dist = dist;
        }
    }
}
