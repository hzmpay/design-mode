//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1436 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    class Node {
        int key;
        int value;
        /** 前驱节点 */
        Node prev;
        /** 后驱节点 */
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /** <key, Node> */
    private Map<Integer, Node> map;
    /** 容量 */
    private int capacity;
    /** 已使用容量 */
    private int size;
    /** 虚拟头部节点 */
    Node head;
    /** 虚拟尾部节点 */
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity * 4 / 3 + 1);
        this.capacity = capacity;
        this.size = 0;
        // 采用虚拟头尾节点，避免前后节点的空判断
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * get操作依赖用HashMap保持O(1)复杂度
     *
     * @param key
     * @return int
     * @author Hezeming
     */
    public int get(int key) {
        // 1.从map获取
        // 2.将该key对应的Node移到队列头部
        Node node = map.get(key);
        if (node == null) {
            // 不存在返回-1
            return -1;
        }
        moveHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 1.判断是否存在
        Node node = map.get(key);
        // 不存在
        if (node == null) {
            // 2.判断容量是否足够
            //  1.足够：放到队列头部，存入map
            //  2.不够：移除队列尾部元素，size++，放到队列头部，存入map
            node = new Node(key, value);
            if (size >= capacity) {
                // 删除尾部元素
                removeNode(tail.prev);
            } else {
                size++;
            }
            addHead(node);
        } else {
            // 存在则替换value，移到头部
            node.value = value;
            moveHead(node);
        }
    }

    /**
     * 添加新节点到head
     *
     * @param node
     * @return void
     * @author Hezeming
     */
    private void addHead(Node node) {
        // 处理node
        node.next = head.next;
        node.prev = head;
        // node插到head后面
        head.next.prev = node;
        head.next = node;
        map.put(node.key, node);
    }

    /**
     * 将已存在的节点移到头结点
     *
     * @param node
     * @return void
     * @author Hezeming
     */
    private void moveHead(Node node) {
        // 删除这个node，处理node前后节点
        removeNode(node);
        addHead(node);
    }

    /**
     * 删除元素
     *
     * @param node
     * @return void
     * @author Hezeming
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
