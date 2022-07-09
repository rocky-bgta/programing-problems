package leetCode;


import java.util.Stack;

public class BinaryTreeDemo {

    private TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode (int data){
            this.data = data;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
      }
    }

    public void createBinaryTree(){
//        TreeNode first = new TreeNode(9);
//        TreeNode second = new TreeNode(2);
//        TreeNode third = new TreeNode(3);
//        TreeNode fourth = new TreeNode(4);
//
//        root = first;
//        first.left =second;
//        first.right = third;
//
//        second.left = fourth;


        TreeNode first = new TreeNode(3);
        TreeNode second = new TreeNode(9);
        TreeNode third = new TreeNode(20);
        TreeNode fourth = new TreeNode(15);
        TreeNode fifth = new TreeNode(7);

        root = first;
        first.left = second;
        first.right = third;
        third.left = fourth;
        third.right = fifth;


    }

    public void preOrder(TreeNode root){
        int count = 0;
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderWithIterative(){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void inOrderWithIterative(TreeNode root){
        if(root==null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public int maxDepth(TreeNode root) {
        // Base Condition
        if(root == null)
            return 0;
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeDemo bt = new BinaryTreeDemo();
        bt.createBinaryTree();
        //bt.preOrderWithIterative();
        //bt.inOrder(bt.root);
        bt.maxDepth(bt.root);
    }

}
