public class Edge {
    private Vertex destinaton;
    private int weight;

    public Edge(Vertex destinaton,int weight){
        this.destinaton = destinaton;
        this.weight = weight;
    }

    public Vertex getDestinaton() {
        return destinaton;
    }

    public void setDestinaton(Vertex destinaton) {
        this.destinaton = destinaton;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
