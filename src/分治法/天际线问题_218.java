package 分治法;

import java.util.*;


@SuppressWarnings("ALL")
public class 天际线问题_218 {
    /**
     * 就是将起点连同高度与终点连同高度各作为一个pair都统一保存到一个数组中, 然后进行排序,
     * 为区分起点和终点将起点的高度设为负值, 将起点高度设为负值还有一个好处就是如果有另外一个终点和起点在同一个位置同一个高度,
     * 排序之后会起点会在前面, 也就是在同一个位置有一个起点和终点会先处理起点. 然后在处理这个包含起点和终点的数组, 如果是起点,
     * 就将其高度放到multiset中, 如果是终点就将在遍历起点入集合的高度值删除.
     * 然后再看添加和或者删除前后的multiset中最大值是否发生改变, 如果发生改变了说明这个点是边际点,
     * 另外删除multiset的时候不可以直接删除值, 因为这样会把所有等于这个值的点都删除,
     * 我们要先找到一个这个值的指针, 然后删除这个指针, 这样可以保证只删除一个.
     * 这个算法实在是太666了
     *
     * @param buildings
     * @return
     */
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<>();
        }
        int numBuildings = buildings.length;
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.loc != o2.loc) {
                    return o1.loc - o2.loc;
                } else {
                    return o1.height - o2.height;
                }
            }
        });
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        set.add(0);
        for (int i = 0; i < numBuildings; i++) {
            queue.offer(new Pair(buildings[i][0], -buildings[i][2]));
            queue.offer(new Pair(buildings[i][1], buildings[i][2]));
        }
        int maxVal = 0;
        List<int[]> list = new ArrayList<>();
        while (queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.height < 0) {
                set.add(-pair.height);
            } else {
                remove(set, pair.height);
            }
            if (set.first() != maxVal) {
                list.add(new int[]{pair.loc, set.first()});
            }
            maxVal = set.first();
        }
        return list;
    }

    private Iterator<Integer> remove(TreeSet<Integer> set, int val) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == val) {
                return iterator;
            }
        }
        return null;
    }


    class Pair {//代替结构体实现
        int loc;
        int height;

        public Pair(int loc, int height) {
            this.loc = loc;
            this.height = height;
        }
    }
}
