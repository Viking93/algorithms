package evatardos.graph;

public class Vertex<T> {
    private T id;

    public Vertex(T id){
        this.id = id;

    }

    public boolean setId(T id){
        this.id = id;
        return true;
    }

    public T getId(){
        return  this.id;
    }
}
