import java.util.*;
public class SConnection{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int n = scan.nextInt();
        Graph g = new Graph(v);
        for(int i = 0; i < n; i++)  g.connect(scan.nextInt(), scan.nextInt());
        SCC scc = new SCC(g.reverse());
        System.out.println(scc.components());
    }
}
class Graph{
    ArrayList<Integer>[] adj;
    int v;
    public Graph(int v){
        this.v = v;
        adj = new ArrayList[v];
        for(int i = 0; i < v; i++)
            adj[i] = new ArrayList<Integer>();
    }
    public void connect(int a, int b){
        adj[a - 1].add(b);
    }
    private Graph(ArrayList<Integer>[] adj){
        this.adj = adj;
        this.v = adj.length;
    }
    public Graph reverse(){
        ArrayList<Integer>[] res = new ArrayList[v];
        for(int i = 0; i < v; i++) res[i] = new ArrayList<>();
        for(int i = 1; i <= v; i++){
            for(int w : adj[i - 1]){
                res[w - 1].add(i);
            }
        }
        Graph result = new Graph(res);
        return result;
    }
}
class SCC{
    boolean[] visited;
    int components;
    SCC(Graph g){
        components = 0;
        visited = new boolean[g.adj.length];
        DFS post = new DFS(g);
        for(int i : post.reversePost()){
            if(!visited[i - 1]){
                dfs(g, i);
                components++;
            }
        }
    }
    public void dfs(Graph g, int v){
        visited[v - 1] = true;
        for(int w : g.adj[v - 1]){
            if(!visited[w - 1]){
                dfs(g, w);
            }
        }
    }
    public int components(){
        return components;
    }
}
class DFS{
    boolean[] visited;
    Stack<Integer> stack;
    DFS(Graph g){
        stack = new Stack<>();
        visited = new boolean[g.adj.length];
        for(int i = 1; i <= g.adj.length; i++){
            if(!visited[i - 1]){
                dfs(g, i);
            }
        }
    }
    public void dfs(Graph g, int v){
        visited[v - 1] = true;
        for(int w : g.adj[v - 1]){
            if(!visited[w - 1]){
                dfs(g, w);
            }
        }
        stack.push(v);
    }
    public Stack<Integer> reversePost(){
        return stack;
    }
}