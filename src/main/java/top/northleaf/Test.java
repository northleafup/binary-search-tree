package top.northleaf;

/**
 * Created by northleaf .
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        Integer[] integers = new Integer[]{50,30,30,20,31,60,55,65};
        //     50
        //   30   60
        //  30 31 55 65
        // 20
        for(int i=0;i<integers.length;i++){
            bst.add(integers[i]);
        }
        System.out.println("前序遍历");
        bst.preOrder();

        //System.out.println("中序遍历");
        //bst.inOrder();
        //System.out.println("后序遍历");
        //bst.postOrder();
        //System.out.println("层序遍历");
        //bst.levelOrder();
        //
        //System.out.println("====");
        //System.out.println(bst.getMin());
        //System.out.println(bst.getMax());
        //System.out.println(bst.removeMin());
        //System.out.println(bst.removeMin());
        //System.out.println("====");
        //bst.removeElement(20);
        //bst.preOrder();
        //bst.removeElement(60);
        //System.out.println("====");
        //bst.preOrder();
        //System.out.println("====");
        //bst.levelOrder();
        System.out.println("====");
        bst.removeElement(30);
        bst.preOrder();
        bst.levelOrder();

    }
}
