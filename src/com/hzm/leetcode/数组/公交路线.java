package com.hzm.leetcode.数组;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/bus-routes/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年06月25日
 */
public class 公交路线 {

    public static void main(String[] args) {
        int[][] arr = ArrayUtil.toArrayInt2("[[3,16,33,45,59,79,103,135],[3,35,39,54,56,78,96,101,120,132,146,148],[13,72,98],[37,70,107],[0,12,31,37,41,68,78,94,100,101,113,123],[11,32,52,85,135],[43,50,128],[0,13,49,51,53,55,60,65,66,80,82,87,92,99,112,118,120,125,128,131,137],[15,19,34,37,45,52,56,97,108,123,142],[7,9,20,28,29,33,34,38,43,46,47,48,53,59,65,72,74,80,88,92,110,111,113,119,135,140],[15,41,64,83],[7,13,26,31,57,85,101,108,110,115,119,124,149],[47,61,67,70,74,75,77,84,92,101,124,132,133,142,147],[0,2,5,6,12,18,34,37,47,58,77,98,99,109,112,131,135,149],[6,7,8,9,14,17,21,25,33,40,45,50,56,57,58,60,68,92,93,100,108,114,130,149],[7],[5,16,22,48,77,82,108,114,124],[34,71],[8,16,32,48,104,108,116,134,145],[3,10,16,19,35,45,64,74,89,101,116,149],[1,5,7,10,11,18,40,45,50,51,52,54,55,69,71,81,82,83,85,89,96,100,114,115,124,134,138,148],[0,2,3,5,6,9,15,52,64,103,108,114,146],[5,33,39,40,44,45,66,67,68,69,84,102,106,115,120,128,133],[17,26,49,50,55,58,60,65,88,90,102,121,126,130,137,139,144],[6,12,13,37,41,42,48,50,51,55,64,65,68,70,73,102,106,108,120,123,126,127,129,135,136,149],[6,7,12,33,37,41,47,53,54,80,107,121,126],[15,75,91,103,107,110,125,139,142,149],[18,24,30,52,61,64,75,79,85,95,100,103,105,111,128,129,142],[3,14,18,32,45,52,57,63,68,78,85,91,100,104,111,114,142],[4,7,11,20,21,31,32,33,48,61,62,65,66,73,80,92,93,97,99,108,112,116,136,139]]");
        System.out.println(arr.length);
        int[][] arr2 = ArrayUtil.toArrayInt2("[[11,17,19,21,23,28,46,47,59,67,72,73,74,75,79,86,87,89,101,102,105,111,126]" +
                ",[12,17,41,48,55,59,66,101,103]]");
        int i = new 公交路线().numBusesToDestination3(arr, 85, 112);
        System.out.println(i);
    }

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
    public int numBusesToDestination3(int[][] routes, int source, int target) {
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

    public int numBusesToDestination2(int[][] routes, int source, int target) {
        if (source == target) return 0;
        //<station,{bus}>-每个站都被哪些公交车经过
        HashMap<Integer, List<Integer>> s2b = new HashMap<>();
        for (int b = 0; b < routes.length; b++) {
            for (int s : routes[b]) {
                int t1 = b;
                if (!s2b.containsKey(s)) {
                    s2b.put(s, new ArrayList() {{
                        add(t1);
                    }});
                } else s2b.get(s).add(b);
            }
        }
        //记录已经坐了哪些公交车
        int[] memory2b = new int[routes.length];  //知道多长
        //bfs-收集当前station辐射到的station
        Queue<Integer> q = new LinkedList<>();
        q.offer(source); //先压入起始车站
        int count = 0; //坐过多少公交车

        //bfs
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            //每次q收集cur辐射到的所有station，都是cur可以不用换乘到达的车站
            //while(size--)结束，没有找到target说明需要换乘一次，count++
            while (size-- > 0) {
                int cur = q.poll();
                //经过cur的所有车
                for (int car : s2b.get(cur)) {
                    if (memory2b[car] == 1) continue;
                    memory2b[car] = 1;  //标记已经访问过的car

                    for (int s : routes[car]) {
                        if (s == target) return count;
                        if (s == cur) continue;
                        q.offer(s);
                    }
                }
            }
        }
        return -1;
    }
}
