import java.util.*;
class Homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            int cities = scanner.nextInt();
            int edges = scanner.nextInt();
            Graph graph = new Graph(cities);
            for(int j = 0; j < edges; j++){
                graph.addEdge(scanner.nextInt() - 1, scanner.nextInt() - 1, scanner.nextInt());
            }
            int max = graph.dijkstra(0, n);
            System.out.println(max);
        }
    }
}
class Graph {
    List<List<Edge>> adj;
    class Edge {
        int vertex;
        int weight;
        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public Graph(int v) {
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int s, int v, int weight) {
        adj.get(s).add(new Edge(v, weight));
        adj.get(v).add(new Edge(s, weight));
    }
    public List<Edge> getNeighbors(int vertex) {
        return adj.get(vertex);
    }
    public int dijkstra(int start, int end) {
        int v = adj.size();
        int[] maxs = new int[v];
        Arrays.fill(maxs, Integer.MAX_VALUE);
        maxs[start] = Integer.MAX_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        q.offer(new int[]{start, Integer.MAX_VALUE});
        while (!q.isEmpty()) {
            int[] edge = q.poll();
            int vertex = edge[0];
            int max = edge[1];
            if (vertex == end) {
                return max;
            }
            for (Edge neighbor : getNeighbors(vertex)) {
                int minSpeed = Math.min(max, neighbor.weight);
                if (minSpeed < maxs[neighbor.vertex]) {
                    maxs[neighbor.vertex] = minSpeed;
                    q.offer(new int[]{neighbor.vertex, minSpeed});
                }
            }
        }
        return -1;
    }
}


