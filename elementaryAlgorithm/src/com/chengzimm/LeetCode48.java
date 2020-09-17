package com.chengzimm;


/**
 * 旋转图像
 *
 * @author CM
 * @date 2020/9/4 10:44
 */
public class LeetCode48 {

    /**
     * 给定 matrix =
     * [    0  1  2       数组，x坐标先写第几个数组的index，y坐标写该数组的第几个数
     * 0  [1, 2, 3],
     * 1  [4, 5, 6],
     * 2  [7, 8, 9]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // n / 2 + n % 2即为旋转的次数
        for (int i = 0; i < n / 2 + n % 2; i++) {
            //
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                // 寻找周围顶点的数字存入数组
                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    // 旋转数组（将数组第四个放到第一个）
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    // n / 2 + n % 2 == (n + 1) / 2 （数字计算默认保存为int类型，舍去小数点后的数字）

    /**
     * 需要解决的问题：
     * 对应位置的 4 个元素，如何实现原地顺时针旋转 90° 的位置变化？
     * 如何通过一个“统一的格式”，表示这 4 个元素？
     * 例如，一个在矩阵左上角的数组元素 matrix[i][j] ，那么，其它对应 3 个元素如何表示？
     * 令 len = matrix.length            0  1  0 0
     * 那么，左下角对应元素为 matrix[len-j][i] 。右上角对应元素为 matrix[j][len-i] 。右下角对应元素为 matrix[len-i][len-j] 。
     * 如何实现顺时针旋转呢？          1    0    2 0                 1   2   0  2                      2       1  2 2
     *
     * 定义一个临时保值变量 temp ，具体程序如下：
     * temp = matrix[i][j];
     * matrix[i][j] = matrix[len-j][i];
     * matrix[len-j][i] = matrix[len-i][len-j];
     * matrix[len-i][len-j] = matrix[j][len-i];
     * matrix[j][len-i] = temp;
     *
     *
     * 先回顾一下三角函数 正余弦
     * sin(π/2+α)=cosα
     * cos(π/2+α)=-sinα
     * 假设转换前的点:origin=(i,j)
     * 可表示为
     * i=l*cosθ
     * j=l*sinθ
     *
     * 	y轴
     * 	^   (i,j)
     * 	|  /
     * 	| /
     * 	|/θ
     * 	|------------>x轴
     * 旋转90°->坐标变为:
     * i'=l*cos(θ+90°)= -l*sinθ = -j
     * j'=l*sin(θ+90°)= l*cosθ = i
     * i'可理解为矩阵的倒数第j个元素 可表示为 len-1-j
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int len = matrix.length - 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                //matrix[0][1] = 2
                int temp = matrix[i][j];
                // matrix[1][0] = matrix[len - j][i] = matrix[1][0] = 4
                matrix[i][j] = matrix[len - j][i];
                //  matrix[1][0] = matrix[len - i][len - j] = matrix[2][1] = 8
                matrix[len - j][i] = matrix[len - i][len - j];
                // matrix[2][1] = matrix[j][len - i] = matrix[1][2] = 6
                matrix[len - i][len - j] = matrix[j][len - i];
                // matrix[1][2] = 2
                matrix[j][len - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        LeetCode48 leetCode48 = new LeetCode48();
        for (int[] nums : matrix) {
            System.out.println();
            for (int num : nums) {
                System.out.print(num + " ");
            }
        }
        leetCode48.rotate1(matrix);
        System.out.println();
        for (int[] nums : matrix) {
            System.out.println();
            for (int num : nums) {
                System.out.print(num + " ");
            }
        }
        // 画一个正方形的框，（1,0）顶点等效于（0,2）顶点
        int n = 4, m = n / 2 + n % 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                System.out.println();
                System.out.println(i);
                System.out.println(j);
            }
        }
        if (n / 2 + n % 2 == (n + 1) / 2) {
            System.out.println(m);
            System.out.println();
        }
    }
}
