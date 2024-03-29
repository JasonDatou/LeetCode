package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
  public static void main(String[] args) {
    MergeIntervalsSolution s = new MergeIntervalsSolution();
    int[][] intervals = new int[][]{{1, 4}, {1, 5},  {14, 55}};
    int[][] result = s.merge(intervals);
    System.out.println(Arrays.deepToString(result));
  }
}

class MergeIntervalsSolution {
  public int[][] merge(int[][] intervals) {
    List<int[]> res = new ArrayList<>();
    if (intervals.length == 0) return res.toArray(new int[0][]);
    // 对起点终点进行排序
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int i = 0;
    while (i < intervals.length) {
      int left = intervals[i][0];
      int right = intervals[i][1];
      // 如果有重叠，循环判断哪个起点满足条件
      while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
        i++;
        right = Math.max(right, intervals[i][1]);
      }
      // 将现在的区间放进res里面
      res.add(new int[]{left, right});
      // 接着判断下一个区间
      i++;
    }
    return res.toArray(new int[res.size()][]);
  }
}
