package 数组;

import org.junit.Test;

@SuppressWarnings("ALL")
public class 搜索二维矩阵_240 {
    /**
     * 行和列都是递增的排序
     * 找到一个特定的元素
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j <= n - 1) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }


    @Test
    public void test() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] matrix1 = {{1, 2, 3, 4, 5, 7}};
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 20));
        System.out.println(searchMatrix(matrix1, 4));
    }
}
