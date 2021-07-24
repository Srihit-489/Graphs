import java.util.List;
import java.util.Stack;

public class ShortestPath {
    public  void getshortestpath(List<Vertex> mygraph){
        TopoSort algo = new TopoSort();
        Stack<Vertex> mystack = algo.gettoposort(mygraph);
        while(!mystack.empty()){
            Vertex current = mystack.pop();
            for(Edge e : current.getNeghibors()){
                if(current.getMindistance()+e.getWeight() < e.getDestinaton().getMindistance()){
                    e.getDestinaton().setMindistance(current.getMindistance()+e.getWeight());
                    e.getDestinaton().setPreviousNode(current);
                }
            }
        }
    }
}
