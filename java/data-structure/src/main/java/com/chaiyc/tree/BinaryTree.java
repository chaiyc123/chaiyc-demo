package com.chaiyc.tree;

import com.chaiyc.linear.Queue;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/19 14:49
 * @description: 二叉树代码
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {

    //根节点
    private Node root;

    //记录树中的元素
    private int N;

    //获取树种元素的个数
    public int size() {
        return N;
    }

    //向树中添加元素key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向指定的树x中添加key-value,并返回添加元素后新的树
    private Node put(Node x, Key key, Value value) {
        //若不存在树，则创建一个树
        if (x == null) {
            //个数+1
            N++;
            return new Node(key, value, null, null);
        }
        //compareTo:如果指定的数与参数相等返回0。如果指定的数小于参数返回 -1。如果指定的数大于参数返回 1。
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            //新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = put(x.left, key, value);
        } else {
            //新节点的key等于当前节点的key，把当前节点的value进行替换
            x.value = value;
        }
        return x;
    }

    //查询树中指定key对应的value
    private Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果要查询的key大于当前结点的key，则继续找当前结点的右子结点；
            return get(x.right, key);
        } else if (cmp < 0) {
            //如果要查询的key小于当前结点的key，则继续找当前结点的左子结点；
            return get(x.left, key);
        } else {
            //如果要查询的key等于当前结点的key，则树中返回当前结点的value。
            return x.value;
        }
    }

    //删除树中key对应的value
    public void delete(Key key) {
        root = delete(root, key);
    }

    //删除指定树x中的key对应的value，并返回删除后的新树
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            //新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else {
            //新结点的key等于当前结点的key,当前x就是要删除的结点

            //让元素个数-1
            N--;

            // 1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            if (x.right == null) {
                return x.left;
            }
            //2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (x.left == null) {
                return x.right;
            }
            //3.当前结点的左右子树都存在
            //3.1找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //3.2删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            //3.3让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小结点 minNode的右子树
            minNode.left = x.left;
            minNode.right = x.right;
            //3.4让被删除结点的父节点指向最小结点minNode
            x = minNode;
            //个数-1
            N--;
        }
        return x;
    }

    //查找整个树中最小的键
    public Key min(){
        return min(root).key;
    }

    //在指定树x中找出最小键所在的结点
    private Node min(Node x){

        //需要判断x还有没有左子结点，如果有，则继续向左找，如果没有，则x就是最小键所在的结点
        if (x.left!=null){
            return min(x.left);
        }else{
            return x;
        }
    }

    //在整个树中找到最大的键
    public Key max(){
        return max(root).key;
    }

    //在指定的树x中，找到最大的键所在的结点
    public Node max(Node x){
        //判断x还有没有右子结点，如果有，则继续向右查找，如果没有，则x就是最大键所在的结点
        if (x.right!=null){
            return max(x.right);
        }else{
            return x;
        }
    }

    //获取整个树中所有的键
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    //获取指定树x的所有键，并放到keys队列中
    private void preErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }

        //把x结点的key放入到keys中
        keys.enqueue(x.key);

        //递归遍历x结点的左子树
        if (x.left!=null){
            preErgodic(x.left,keys);
        }

        //递归遍历x结点的右子树
        if (x.right!=null){
            preErgodic(x.right,keys);
        }

    }

    //使用中序遍历获取树中所有的键
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    //使用中序遍历，获取指定树x中所有的键，并存放到key中
    private void midErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }
        //先递归，把左子树中的键放到keys中
        if (x.left!=null){
            midErgodic(x.left,keys);
        }
        //把当前结点x的键放到keys中
        keys.enqueue(x.key);
        //在递归，把右子树中的键放到keys中
        if(x.right!=null){
            midErgodic(x.right,keys);
        }

    }

    //使用后序遍历，把整个树中所有的键返回
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    //使用后序遍历，把指定树x中所有的键放入到keys中
    private void afterErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return ;
        }

        //通过递归把左子树中所有的键放入到keys中
        if (x.left!=null){
            afterErgodic(x.left,keys);
        }
        //通过递归把右子树中所有的键放入到keys中
        if (x.right!=null){
            afterErgodic(x.right,keys);
        }
        //把x结点的键放入到keys中
        keys.enqueue(x.key);
    }


    //使用层序遍历，获取整个树中所有的键
    public Queue<Key> layerErgodic(){
        //定义两个队列，分别存储树中的键和树中的结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //默认，往队列中放入根结点
        nodes.enqueue(root);

        while(!nodes.isEmpty()){
            //从队列中弹出一个结点，把key放入到keys中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            //判断当前结点还有没有左子结点，如果有，则放入到nodes中
            if (n.left!=null){
                nodes.enqueue(n.left);
            }
            //判断当前结点还有没有右子结点，如果有，则放入到nodes中
            if (n.right!=null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }


    //获取整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }


    //获取指定树x的最大深度
    private int maxDepth(Node x){
        if (x==null){
            return 0;
        }
        //x的最大深度
        int max=0;
        //左子树的最大深度
        int maxL=0;
        //右子树的最大深度
        int maxR=0;

        //计算x结点左子树的最大深度
        if (x.left!=null){
            maxL = maxDepth(x.left);
        }
        //计算x结点右子树的最大深度
        if (x.right!=null){
            maxR = maxDepth(x.right);
        }
        //比较左子树最大深度和右子树最大深度，取较大值+1即可

        max = maxL>maxR?maxL+1:maxR+1;

        return max;
    }

    //节点对象
    private class Node {
        //存储键
        public Key key;
        //存储值
        public Value value;
        //记录左子节点
        public Node left;
        //记录右子节点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) throws Exception {
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1, "老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
        bt.delete(1);
        System.out.println(bt.size());
    }
}

