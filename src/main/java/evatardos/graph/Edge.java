package evatardos.graph;

public class Edge {
    private Vertex src;
    private Vertex dst;

    public Edge(Vertex src, Vertex dst){
        this.src = src;
        this.dst = dst;
    }

    public Vertex getDst() {
        return dst;
    }

    public Vertex getSrc() {
        return src;
    }

    public void setDst(Vertex dst) {
        this.dst = dst;
    }

    public void setSrc(Vertex src) {
        this.src = src;
    }
}
