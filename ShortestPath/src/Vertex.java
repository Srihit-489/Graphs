import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private Vertex previousNode;
    private boolean visited;
    private int mindistance;
    private List<Edge> neghibors;

    public Vertex(String name){
        this.name = name;
        mindistance = Integer.MAX_VALUE;
        neghibors = new ArrayList();
        this.visited = false;
    }



    public String getName() {
        return name;
    }

    public Vertex getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Vertex previousNode) {
        this.previousNode = previousNode;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMindistance() {
        return mindistance;
    }

    public void setMindistance(int mindistance) {
        this.mindistance = mindistance;
    }

    public List<Edge> getNeghibors() {
        return neghibors;
    }

    public void setNeghibor(Edge newedge) {
        this.neghibors.add(newedge);
    }
}
