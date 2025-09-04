package com.codex;

import java.util.*;

// ====================== Graph Class ======================
class Graph {
    private int V; // number of vertices
    private List<List<Integer>> adj; // adjacency list

    // Constructor
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // ---------- DFS ----------
    private void dfs(int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }

    // ---------- BFS ----------
    private void bfs(int start, boolean[] visited, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // ---------- Count Components using DFS ----------
    public int countComponentsDFS() {
        boolean[] visited = new boolean[V];
        int count = 0;

        System.out.println("\nConnected Components (DFS):");
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, visited, component);
                System.out.println("Component " + (++count) + ": " + component);
            }
        }
        return count;
    }

    // ---------- Count Components using BFS ----------
    public int countComponentsBFS() {
        boolean[] visited = new boolean[V];
        int count = 0;

        System.out.println("\nConnected Components (BFS):");
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                bfs(i, visited, component);
                System.out.println("Component " + (++count) + ": " + component);
            }
        }
        return count;
    }
}

// ====================== Main Driver Class ======================
public class Day_21 {
    public static void main(String[] args) {
        // Create a graph with 7 vertices (0 to 6)
        Graph g = new Graph(7);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(5, 6);

        // Count components using DFS
        int dfsCount = g.countComponentsDFS();
        System.out.println("Total Connected Components (DFS): " + dfsCount);

        // Count components using BFS
        int bfsCount = g.countComponentsBFS();
        System.out.println("Total Connected Components (BFS): " + bfsCount);
    }
}
