import java.util.ArrayList;
import java.util.List;

public class Traversal {
    public static void preOrder(TreeNode root, List<Integer> list){
        //终止条件
        if(root == null){
            return;
        }
        //执行函数
        System.out.println(root.getVal());
        list.add(root.getVal());
        //往左右节点递归
        preOrder(root.getLeft(), list);
        preOrder(root.getRight(), list);
    }
    public static List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }
}
class Test1{
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.setLeftAndRight(n2, n3);
        n2.setLeftAndRight(n4, n5);
        n3.setLeftAndRight(n6, n7);
        n4.setLeft(n8);
        TreeNode root = n1;
        List<Integer> list = new ArrayList<>();
        list = Traversal.preOrderTraversal(root);
        System.out.println(list);
    }
}
