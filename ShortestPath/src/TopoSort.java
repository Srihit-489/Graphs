import java.util.List;
import java.util.Stack;

public class TopoSort {
    public Stack<Vertex> mystack = new Stack<>();

    public TopoSort(){
        this.mystack = new Stack<>();
    }

    public Stack gettoposort(List<Vertex> mygraph){
        for(Vertex u : mygraph){
            if(!u.isVisited())
                dfs(u);
        }
        return mystack;
    }

    public void dfs(Vertex u){
        u.setVisited(true);
        for(Edge v : u.getNeghibors()){
            if(!v.getDestinaton().isVisited()){
                dfs(v.getDestinaton());
            }
        }

        mystack.push(u);
    }

}
