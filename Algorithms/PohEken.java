import java.util.*;
public class PohEken{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int f = scan.nextInt();
        Graph g = new Graph(v);
        for(int i = 0; i < f; i++){
            g.connect(scan.nextInt(), scan.nextInt(), scan.nextInt());
        }
        Dijkstra d = new Dijkstra(g, 0);
        for(int i = 1; i < v; i++){
            System.out.println(i + ": " + d.distTo[i]);
        }
    }
}
class Dijkstra{
    IndexMinPQ pq;
    double[] distTo;
    Edge[] edgeTo; 
    Dijkstra(Graph g, int s){
        distTo = new double[g.v];
        edgeTo = new Edge[g.v];
        pq = new IndexMinPQ(g.v);
        for(int i = 0; i < g.v; i++)distTo[i] = Double.POSITIVE_INFINITY;
        distTo[0] = 0;
        pq.insert(s, 0.0);
        while(!pq.isEmpty()){
            int v = pq.delMin();
            for(Edge e : g.adj.get(v)) relax(e);
        }
    }
    public void relax(Edge e){
        int v = e.from(); int w = e.to();
        if(distTo[w] > distTo[v] + (double)e.weight()){
            distTo[w] = distTo[v] + (double)e.weight();
            edgeTo[w] = e;
            if(pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            }
            else pq.insert(w, distTo[w]);
        }
    }
}
class Graph{
    ArrayList<ArrayList<Edge>> adj;
    int v;
    Graph(int v){
        this.v = v;
        adj = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
    }
    public void connect(int a, int b, int weight){
        adj.get(a).add(new Edge(a, b, weight));
    }
}
class Edge{
    int from;
    int to;
    int weight;
    Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    public int from(){
        return from;
    }
    public int to(){
        return to;
    }
    public int weight(){
        return weight;
    }
}
class IndexMinPQ{
    KeyAndValue[] pq;
    class KeyAndValue{
        double key;
        int value;
        KeyAndValue(double key, int value){
            this.key = key;
            this.value = value;
        }
    }
    IndexMinPQ(int v){
        pq = new KeyAndValue[v];
        for(int i = 0; i < pq.length; i++){
            pq[i] = new KeyAndValue(Double.POSITIVE_INFINITY, -1);
        }
    }
    public void decreaseKey(int index, double key){
        for(int i = 0; i < pq.length; i++){
            if(pq[i].value == index){
                pq[i] = new KeyAndValue(key, index);
                break;
            }
        }
        for(int i = 0; i < pq.length; i++){
            for(int j = i; j < pq.length; j++){
                if(pq[j].key < pq[i].key){
                    KeyAndValue r = pq[j];
                    pq[j] = pq[i];
                    pq[i] = r;
                }
            }
        }
    }
    public void insert(int index, double key){
        pq[index] = new KeyAndValue(key, index);
        for(int i = 0; i < pq.length; i++){
            for(int j = i; j < pq.length; j++){
                if(pq[j].key < pq[i].key){
                    KeyAndValue r = pq[j];
                    pq[j] = pq[i];
                    pq[i] = r;
                }
            }
        }
    }
    public boolean contains(int index){
        for(int i = 0; i < pq.length; i++){
            if(pq[i] != null && pq[i].value == index) return true;
        }
        return false;
    }  
    public int delMin(){
        int a = pq[0].value;
        pq[0] = new KeyAndValue(Double.POSITIVE_INFINITY, a);
        return a;
    }
    public boolean isEmpty(){
        return pq[0].key == Double.POSITIVE_INFINITY;
    }
}