//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。 
//
// 
// 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 
//-> ... 这样的车站路线行驶。 
// 
//
// 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。 
//
// 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
// 
//
// 示例 2： 
//
// 
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 105 
// routes[i] 中的所有值 互不相同 
// sum(routes[i].length) <= 105 
// 0 <= routes[i][j] < 106 
// 0 <= source, target < 106 （这里是10的6次方）
// 
// Related Topics 广度优先搜索 数组 哈希表 
// 👍 131 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：
     * 1.记录每个站点对应的公交车集合
     * 2.采用BFS遍历
     *  2.1根据每一轮的乘坐的车站查出对应的公交车
     *  2.2判断该公交是否乘坐过
     *  2.3有则跳过，没有则上车
     *  2.4找出该车经过的所有站点中在前几轮未乘坐过的站点，进行是否是终点的判断
     *  2.5如果是终点直接返回乘坐的公交数
     * 如下图：
     *                              乘坐的车站（A1） ---- 公交车C1,C2
     *                             /               \
     *   可换乘的车站（C1：B1，B2，B3）            可换乘的车站（C2：B4，B5，B6）
     *
     * 第一轮：根据A1查出经过A1的公交车C1,C2；C1经过站点B1，B2，B3，C2经过站点B4，B5，B6，
     * 第二轮：根据上一轮的B系列站点继续迭代
     *
     * @param routes
     * @param source
     * @param target
     * @return int
     * @author Hezeming
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        // 找出所有站点对应的车站映射
        // Map<站点, List<公交车下标集合>>
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int j = 0; j < route.length; j++) {
                List<Integer> list = map.computeIfAbsent(route[j], e -> new ArrayList<>());
                list.add(i);
            }
        }
        // 记录坐过的公交车
        int[] stationArr = new int[routes.length];
        // 记录尝试过的节点
        int[] nodeArr = new int[1000000];
        // 存储每一轮需要遍历的站点
        Deque<Integer> stack = new LinkedList<>();
        stack.offer(source);
        // 乘坐的公交车数量
        int count = 0;
        //
        while (!stack.isEmpty()) {
            // 每轮换乘一次公交
            count++;
            int size = stack.size();
            while (size-- > 0) {
                Integer cur = stack.pop();
                List<Integer> stationList = map.get(cur);
                for (Integer station : stationList) {
                    // 每辆车只坐一次
                    if (stationArr[station] == 1) {
                        continue;
                    }
                    // 上车标记
                    stationArr[station] = 1;
                    int[] route = routes[station];
                    // 构建下一轮的树遍历
                    for (int i : route) {
                        // 尝试过的站点直接跳过
                        if (nodeArr[i] == 1) {
                            continue;
                        }
                        // 到达终点
                        if (i == target) {
                            return count;
                        }
                        nodeArr[i] = 1;
                        stack.offer(i);
                    }
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
