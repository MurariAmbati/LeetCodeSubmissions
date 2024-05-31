// https://leetcode.com/problems/critical-connections-in-a-network

class Solution {
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    
    for (List<Integer> connection : connections) {
      int u = connection.get(0);
      int v = connection.get(1);
      graph.get(u).add(v);
      graph.get(v).add(u); // Add for undirected graph
    }
    
    int[] disc = new int[n];
    int[] low = new int[n];
    boolean[] visited = new boolean[n];
    List<List<Integer>> result = new ArrayList<>();
    int time = 0;
    
    dfs(graph, 0, -1, disc, low, visited, result, time);
    
    return result;
  }
  
  private void dfs(List<List<Integer>> graph, int node, int parent, int[] disc, int[] low, boolean[] visited, List<List<Integer>> result, int time) {
    disc[node] = low[node] = time++;
    visited[node] = true;
    
    for (int neighbor : graph.get(node)) {
      if (neighbor == parent) continue;
      
      if (!visited[neighbor]) {
        dfs(graph, neighbor, node, disc, low, visited, result, time);
        low[node] = Math.min(low[node], low[neighbor]);
        if (low[neighbor] > disc[node]) {
          result.add(Arrays.asList(node, neighbor));
        }
      } else {
        low[node] = Math.min(low[node], disc[neighbor]);
      }
    }
  }
}
