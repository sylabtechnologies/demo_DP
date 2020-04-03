import java.util.*;

//// ///  #D7 super cleanup datastrux interaction and idea

class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        
        Queue<Integer> qA = new LinkedList<>();
        Queue<Integer> qB = new LinkedList<>();
        
        boolean fromA = true;
        
        for (int i = 0; i < graph.length; i++) {          
            if (!visited.contains(i)) {  
                qA.offer(i);
                while (!qA.isEmpty() || !qB.isEmpty()) {
                    if (fromA) {
                        while (!qA.isEmpty()) {
                            int node = qA.poll();
                            visited.add(node);
                            A.add(node);
                            for (int j : graph[node]) {
                                if (A.contains(j)) {
                                    return false;
                                } else if (!visited.contains(j)) {
                                    qB.offer(j);
                                }
                            }
                        }
                        fromA = false;
                    } else {
                        while (!qB.isEmpty()) {
                            int node = qB.poll();
                            visited.add(node);
                            B.add(node);
                            for (int j : graph[node]) {
                                if (B.contains(j)) {
                                    return false;
                                } else if (!visited.contains(j)) {
                                    qA.offer(j);
                                }
                            }
                        }
                        fromA = true;
                    }
                }   
            }
        }   
        return true;
    }
}
