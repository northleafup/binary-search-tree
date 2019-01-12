package top.northleaf;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by northleaf .
 * 二分搜索树
 */
public class BST<T extends Comparable> {


    private class Node<T>{
        /**
         * 元素
         */
        private T element;
        /**
         * 左子树
         */
        private Node left;
        /**
         * 右子树
         */
        private Node<T> right;


        public Node(T element){
            this.element = element;
            this.left= null;
            this.right=null;
        }

    }

    /**
     * 根节点
      */
    private Node root;

    /**
     * 元素个数
     */
    private int size;


    /**
     * 返回元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    public BST(){
        this.root = null;
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(T element){
        root= add(root,element);
    }

    /**
     * 向以node为根的二分搜索树中添加元素
     * @param node
     * @param element
     * @return 返回以node 为根的二分搜索树
     */
    private Node add(Node node, T element) {
        //1. 判断当前节点是否为空，为空，则直接创建一个节点并返回
        if (node == null) {
            size++;
            return new Node(element);
        }
        //2. 判断当前节点是否等于给定元素，如果等于，则添加到左子树并返回
        if(element.compareTo(node.element)==0){
            Node newNode = new Node(element);
            newNode.left = node.left;
            node.left = newNode;
            size++;
            return node;
        }
        //3. 比较当前节点与给定的元素，如果小于等于给定的元素，则放在左子树，否则放在右子树
        else if(element.compareTo(node.element)<1){
            node.left = add(node.left,element);
        }else{
            node.right = add(node.right,element);
        }

        return node;

    }

    /**
     * 判断元素是否存在
     * @param element
     * @return
     */
    public boolean contains(T element){
        return contains(root,element);
    }


    /**
     * 查询以node为根的二分搜索树中是否含有元素
     * @param node
     * @param ele
     * @return
     */
    private boolean contains(Node node,T ele){
        //1. 当前节点为null，返回空
        if (node == null) {
            return false;
        }
        //2. 判断当前节点与给定元素是否一致,一致返回true
        if(ele.compareTo(node.element)==0){
            return true;
        }
        //3.如果当前节点小于给定元素，则查询左子树，否则查询右子树
        if(ele.compareTo(node.element)<0){
            return contains(node.left,ele);
        }
        return contains(node.right,ele);
    }


    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树
     * @param node
     */
    private void preOrder(Node node){
        //1. 为空则终止
        if (node == null) {
            return;
        }
        //2. 遍历
        System.out.println(node.element);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树
     * @param node
     */
    private void inOrder(Node node){
        //1. 为空则终止
        if (node == null) {
            return;
        }
        //2. 遍历
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    public T getMin(){
        if(root==null){
            throw new NullPointerException("there is no element ");
        }
        return (T)getMin(root).element;
    }

    /**
     * 找到以node为根的最小节点
     * @param node
     * @return
     */
    private Node getMin(Node node){
        if(node.left==null){
            return node;
        }
        return getMin(node.left);
    }

    public T getMax(){
        if(root==null){
            throw new NullPointerException("there is no element ");
        }
        return (T)getMax(root).element;
    }

    /**
     * 找到以node为根的最大节点
     * @param node
     * @return
     */
    private Node getMax(Node node){
        if(node.right==null){
            return node;
        }
        return getMax(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树
     * @param node
     */
    private void postOrder(Node node){
        //1. 为空则终止
        if (node == null) {
            return;
        }
        //2. 遍历
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    /**
     * 层序遍历(用队列实现）
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //取出队头
            Node cur = queue.remove();
            System.out.println(cur.element);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    public void removeElement(T e){
        //判断是否存在
        while (contains(e)){
            root = removeElement(root,e);
        }
    }

    /**
     * 删除以node为根的二叉树中的元素e
     * @param node
     * @param e
     * @return
     */
    private Node removeElement(Node node, T e) {
        //1.判空
        if (node == null) {
            return null;
        }
        //2.判断它的值与当前值的比较
        if(e.compareTo(node.element)<0){
            node.left = removeElement(node.left,e);
            return node;
        }
        else if(e.compareTo(node.element)>0){
            node.right = removeElement(node.right,e);
            return node;
        }
        //等于当前值
        else{

            //左子树为空时
            //将当前节点的右节点分配给前当前节点的父节点
            if(node.left==null) {
                Node nodeRight = node.right;
                node.right = null;
                size--;
                return nodeRight;
            }

            //右子树为空时
            if(node.right==null){
                Node nodeLeft = node.left;
                node.left=null;
                size--;
                return nodeLeft;
            }
            //左右子树均不为空
            //找到右子树的最小节点
            Node min = getMin(node.right);
            Node noderight = node.right;
            min.left = node.left;
            node.left=node.right=null;
            return noderight;
        }
        //return null;
    }

}
