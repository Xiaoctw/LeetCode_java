package 图;

import org.junit.Test;

import java.util.*;

public class 最小高度数1_310 {
    /**
     * 采用删除叶节点的方法,直到图中节点数量小于等于2
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        for (int i = 0; i < n; i++) {
            //
            // graph.add(new HashSet<>());
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
                queue.offer(i);
            }
        }
        while (n > 2) {
            Queue<Integer> queue1 = new LinkedList<>();
            while (!queue.isEmpty()) {
                int x = queue.poll();
                n--;
                for (Integer i : graph.get(x)) {
                    graph.get(i).remove(x);
                    if (graph.get(i).size() == 1) {
                        queue1.offer(i);
                    }
                }
                //graph.remove(x);
                graph.remove(x);
            }
            queue.addAll(queue1);
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    @Test
    public void test() {
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(findMinHeightTrees(4, edges));
    }
}
