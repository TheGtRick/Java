import java.util.*;

public class DFS{
    public static void main(String[] args){
        int n = 5;
        UGraph graph = new UGraph(n);
        graph.connect(4, 3);
        graph.connect(4, 0);
        graph.connect(3, 2);
        graph.connect(3, 0);
        graph.connect(2, 1);
        graph.dfs();
        for(int i = 0; i < graph.B.size(); i++){
            System.out.print(graph.B.get(i) + "");
        }
    }
}
class UGraph{
    ArrayList<Integer>[] adj;
    private boolean[] marked;
    ArrayList<Integer> A;
    ArrayList<Integer> B;
    int v;
    UGraph(int v){
        adj = new ArrayList[v];
        A = new ArrayList<Integer>();
        B = new ArrayList<Integer>();
        marked = new boolean[v];
        this.v = v;
        for(int i = 0; i < v; i++){
            adj[i] = new ArrayList<Integer>();
        }
    }
    public void connect(int a, int b){
        adj[a].add(b);
        adj[b].add(a);
    }
    public void dfs(){
        A.add(v - 1);
        dfs(v - 1);
        for(int i = 0; i < A.size(); i++){
            boolean found = false;
            for(int j = 0; j < B.size(); j++){
                if(A.get(i) == B.get(j)){
                    found = true;
                    break;
                }
            }
            if(!found){
                B.add(A.get(i));
            }
        }
    }
    public void dfs(int v){
        marked[v] = true;
        for(int w : adj[v]){
            A.add(w);
            if(!marked[w]){
                dfs(w);
            }
        }
    }
}