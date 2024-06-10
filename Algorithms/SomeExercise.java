import java.util.*;

public class SomeExercise{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Ochered o = new Ochered(n);
        for(int i = 0; i < m; i++){
            o.add(scan.nextInt(), scan.nextInt());
        }
        if(o.isCyclic()){
            System.out.println("IMPOSSIBLE");
        }
        else{
            DFS birdene = new DFS(o, 1);
            List<Integer> list = birdene.reversed();
            for(int a = list.size() - 1; a >= 0; a--) System.out.print(list.get(a) + "");
        }
    }
}
class Ochered{
    int v;
    boolean cycle = false;
    ArrayList<Integer>[] adj;
    Ochered(int v){
        this.v = v;
        adj = new ArrayList[v];
        for(int i = 1; i <= v; i++)
            adj[i - 1] = new ArrayList<>();
    }
    public void add(int a, int b){
        adj[a - 1].add(b);
    }
    public Iterable<Integer> adj(int v){
        return adj[v - 1];
    }
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack){
        if (recStack[i]) return true;
        if (visited[i]) return false;
        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj[i];
        for (Integer c : children)
            if (isCyclicUtil(c - 1, visited, recStack))
                return true;
        recStack[i] = false;
        return false;
    }
    public boolean isCyclic(){
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];
        for (int i = 0; i < v; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
        return false;
    }
}
class DFS{
    boolean[] marked;
    Stack<Integer> stack = new Stack<Integer>();
    DFS(Ochered o, int s){
        marked = new boolean[o.adj.length];
        dfs(o, s);
        for(int i = 1; i <= o.v; i ++){
            if(!marked[i - 1]) dfs(o, i);
        }
    }
    public void dfs(Ochered o, int v){
        marked[v - 1] = true;
        for(int w : o.adj[v - 1]){
            if(!marked[w - 1]) dfs(o, w);
        }
        stack.push(v);
    }
    public List<Integer> reversed(){
        return stack;
    }
}