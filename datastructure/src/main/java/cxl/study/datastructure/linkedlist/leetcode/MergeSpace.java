package cxl.study.datastructure.linkedlist.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeSpace {

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * <p>
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * <p>
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        //进行排序
        sort(intervals);
        int j = 0;
        List<int[]> list = new ArrayList<>();
        int[] firstData = new int[2];
        if (intervals.length > 0) {
            firstData[0] = intervals[0][0];
            firstData[1] = intervals[0][1];
            list.add(firstData);
        }

        if (intervals.length == 1) {
            return intervals;
        }

        for (int i = 0; i < intervals.length; i++) {
            boolean needMerge = false;
            //判断当a的右值大小在 b的二值之间 需要合并
            if (list.get(j)[1] >= intervals[i][0] && list.get(j)[1] <= intervals[i][1]) {
                list.get(j)[1] = intervals[i][1];
                needMerge = true;
            }
            //当a的右值大于b的右值
            if (list.get(j)[1] > intervals[i][1]) {
                needMerge = true;
            }
            //当a的左右 二值 完全包括 b时
            if (list.get(j)[0] <= intervals[i][0] && list.get(j)[1] >= intervals[i][1]) {
                needMerge = true;
            }
            if (needMerge) {
                continue;
            }
            if (i != 0) {
                list.add(intervals[i]);
                j++;
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static void sort(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            if (i == data.length - 1) {
                break;
            }
            for (int j = i + 1; j < data.length; j++) {
                if (data[i][0] > data[j][0]) {
                    int[] temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] data = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] ints : MergeSpace.merge(data)) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

}
