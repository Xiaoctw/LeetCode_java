package 图;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 最小高度树_310 {
    /**
     * 最小高度数,找到所有构成最小高度的树并返回根节点
     *
     * @param n
     * @param edges
     * @return
     */
    private List<List<Integer>> graph = new ArrayList<>();
    private int maxHeight;
    private boolean[] visited;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[n];
        TreeMap<Integer, List<Integer>> heightList = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            Init();
            dfs(i, 0);
            if (!heightList.containsKey(maxHeight)) {
                heightList.put(maxHeight, new ArrayList<>());
                heightList.get(maxHeight).add(i);
            } else {
                heightList.get(maxHeight).add(i);
            }
        }
        return heightList.firstEntry().getValue();
    }

    private void Init() {
        maxHeight = -1;
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    private void dfs(int n, int height) {
        visited[n] = true;
        if (height > maxHeight) {
            maxHeight = height;
        }
        for (int x : graph.get(n)) {
            if (!visited[x]) {
                dfs(x, height + 1);
            }
        }
    }

    @Test
    public void test() {
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(findMinHeightTrees(4, edges));
    }
}
