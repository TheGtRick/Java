public class UF{
    public static void main(String[] args){
        int n = 10;
        QuickFind qf = new QuickFind(n);
        QuickUnion qu = new QuickUnion(n);
        qf.union(0, 9);
        qf.union(3, 4);
        qf.union(4, 0);
        System.out.println(qf.connected(3, 9));
        qu.union(0, 9);
        qu.union(3, 4);
        qu.union(4, 0);
        System.out.println(qu.connected(3, 9));
    }
}
class QuickUnion{
    int[] id;
    QuickUnion(int n){
        id = new int[n];
        for(int i = 0; i < n; i++) id[i] = i;
    }
    public int root(int i){
        while(id[i] != i){
            i = id[i];
        }
        return i;
    }
    public void union(int a, int b){
        int i = root(a);
        int j = root(b);
        id[i] = j;
    }
    public boolean connected(int a, int b){
        return root(a) == root(b);
    }
}
class QuickFind{
    int[] id;
    QuickFind(int n){
        id = new int[n];
        for(int i = 0; i < n; i++) id[i] = i;
    }
    public void union(int a, int b){
        int c = a;
        for(int i = 0; i < id.length; i++){
            if(id[i] == c) id[i] = id[b];
        }
    }
    public boolean connected(int a, int b){
        return id[a] == id[b];
    }
}