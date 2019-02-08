package 贪心法;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
public class 模拟行走机器人_874 {
    /**
     * 返回最大欧式距离的平方,
     * 初始时在(0,0)位置
     * -2向左转
     * -1向右转
     * 1<=x<=9代表行走的步数
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Point> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(new Point(obstacle[0], obstacle[1]));
        }
        int[][] a = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int t = 0;//方向该变量控制,创建的类中只包含位置信息,怎么移动需要函数传入
        Point loc = new Point(0, 0);
        for (int command : commands) {
            if (command == -2) {
                t = t == 0 ? 3 : t - 1;
            } else if (command == -1) {
                t = t == 3 ? 0 : t + 1;
            } else {
                loc.move(a[t], command, set);
            }
        }
        return loc.getMaxDistance();
    }

    class Point {
        int x;
        int y;
        int maxDistance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x + y + x * y;
        }

        int distance() {
            return x * x + y * y;
        }

        public int getMaxDistance() {
            return maxDistance;
        }

        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return point.x == x && point.y == y;
        }

        public void move(int[] t, int d, Set<Point> stops) {
            while (d > 0) {
                int movex = x + t[0];
                int movey = y + t[1];
                Point point = new Point(movex, movey);
                if (stops.contains(point)) {
                    break;
                } else {
                    x = movex;
                    y = movey;
                    d--;
                }
                maxDistance = Math.max(maxDistance, distance());
            }
        }
    }
}
