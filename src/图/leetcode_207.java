package 图;

import org.junit.Test;

import java.util.*;

public class leetcode_207 {
    /**
     * 这里采用第二种方法,
     */
    boolean[] marked;
    boolean[] onstack;
    List<List<Integer>> graph;
    boolean res = false;

    /**
     * 本题采用拓扑排序的方法,注意拓扑排序是通过队列来实现的
     * 给出两种方法.
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int[] pair : prerequisites) {
            graph.get(pair[0]).add(pair[1]);
            indegree[pair[1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;//记录安全的课程
        while (!queue.isEmpty()) {
            int v = queue.poll();
            count++;
            for (int x : graph.get(v)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    queue.offer(x);
                }
            }
        }
        return count == numCourses;
    }

    @Test
    public void test1() {
        int[][] pre = new int[2][2];
        pre[0][0] = 1;
        pre[0][1] = 0;
        pre[1][0] = 0;
        pre[1][1] = 1;
        System.out.println(canFinish(2, pre));
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) {
            return true;
        }
        marked = new boolean[numCourses];
        onstack = new boolean[numCourses];
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!marked[i]) {
                dfs(i);
            }
        }
        return !res;
    }

    private void dfs(int v) {
        onstack[v] = true;//表示节点在路径上,用来判断是否构成一个圈
        marked[v] = true;
        for (int x : graph.get(v)) {
            if (res) {
                return;
            } else if (!marked[x]) {
                dfs(x);
            } else if (onstack[x]) {
                res = true;
            }
        }
        onstack[v] = false;
    }
}
