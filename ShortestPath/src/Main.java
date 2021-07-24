import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vertex> graph = new ArrayList<>();
        graph.add(new Vertex("S"));
        graph.get(0).setMindistance(0);
        graph.get(0).setPreviousNode(new Vertex("NULL"));
        graph.add(new Vertex("A"));
        graph.add(new Vertex("C"));
        graph.add(new Vertex("B"));
        graph.add(new Vertex("D"));
        graph.add(new Vertex("E"));
        graph.get(0).setNeghibor(new Edge(graph.get(1),1));
        graph.get(0).setNeghibor(new Edge(graph.get(2),2));
        graph.get(1).setNeghibor(new Edge(graph.get(3),6));
        graph.get(2).setNeghibor(new Edge(graph.get(1),4));
        graph.get(2).setNeghibor(new Edge(graph.get(4),3));
        graph.get(3).setNeghibor(new Edge(graph.get(4),1));
        graph.get(3).setNeghibor(new Edge(graph.get(5),2));
        graph.get(4).setNeghibor(new Edge(graph.get(5),1));
        ShortestPath sp = new ShortestPath();
        sp.getshortestpath(graph);
        for(Vertex v : graph){
            System.out.println(v.getName()+"-"+v.getMindistance()+" and prevNode is "+v.getPreviousNode().getName());
        }

    }
}
