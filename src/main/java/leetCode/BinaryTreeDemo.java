package leetCode;


import java.util.*;

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


//        TreeNode first = new TreeNode(3);
//        TreeNode second = new TreeNode(9);
//        TreeNode third = new TreeNode(20);
//        TreeNode fourth = new TreeNode(15);
//        TreeNode fifth = new TreeNode(7);
//
//        root = first;
//        first.left = second;
//        first.right = third;
//        third.left = fourth;
//        third.right = fifth;

//        TreeNode first = new TreeNode(3);
//        TreeNode second = new TreeNode(9);
//        TreeNode third = new TreeNode(20);
//        TreeNode fourth = null;
//        TreeNode fifth = null;
//        TreeNode six = new TreeNode(15);
//        TreeNode seven = new TreeNode(7);
//
//        root = first;
//        first.left = second;
//        first.right = third;
//        second.left = null;
//        second.right = null;
//        third.left = six;
//        third.right = seven;

//        TreeNode first = new TreeNode(1);
//        TreeNode second = new TreeNode(2);
//        TreeNode third = new TreeNode(3);
//        TreeNode fourth = new TreeNode(4);
//
//        TreeNode seven = new TreeNode(5);
//
//
//        root = first;
//        first.left = second;
//        first.right = third;
//        second.left = fourth;
//        third.right = seven;


        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        root = five;
        five.left = two;
        five.right = six;
        two.left = one;
        two.right = three;


    }
    public void preOrder(TreeNode root){
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

    public void levelOrder(){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null){
                queue.offer(temp.left);
            }

            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    public List<List<Integer>> levelOrderLeetCodeVersion(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null)
            return levelOrder;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> children = new ArrayList<>();
            int size = queue.size();

            //Pushing children in the queue
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                children.add(node.data);

                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            levelOrder.add(children);
        }
        return levelOrder;
    }

    public boolean isValid(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }

        if(root.data >= max || root.data <= min ){
            return false;
        }

        boolean left = isValid(root.left, min, root.data);
        if(left){
            boolean right = isValid(root.right, root.data,max);
            return right;
        }
        return false;
    }


    boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);

        while (!stack.isEmpty()){
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();

            if(n1==null && n2 == null) continue;
            if(n1==null || n2 == null
                        || n1.data!= n2.data) return false;

            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length == 0) return null;
        return constructTreeFromArray(nums,0,nums.length-1);
    }

    public TreeNode constructTreeFromArray(int[] nums, int left, int right){
        if(left>right) return null;
        int midpoint = left + (right-left)/2;
        TreeNode node = new TreeNode(nums[midpoint]);
        node.left = constructTreeFromArray(nums,left,midpoint-1);
        node.right = constructTreeFromArray(nums,midpoint+1,right);
        return node;
    }
    
    public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

    public int maxDepth(TreeNode root) {
    	if(root!=null)
    		System.out.println("Node value : " + root.data);
    	else
    		System.out.println("Node value : "+ "Null");
    	
        int left=0,right=0;
        // Base Condition
        if(root == null)
            return 0;
        // Hypothesis
        left = maxDepth(root.left);
        right = maxDepth(root.right);
        System.out.println("Left: "+ left + " ");
        System.out.println("right: "+ right);
        System.out.println("Processed data :"+ root.data);
        // Induction
        int result = Math.max(left, right) + 1;
        System.out.println("Result: "+result);
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeDemo bt = new BinaryTreeDemo();
        bt.createBinaryTree();
        // bt.preOrder(bt.root);
        //bt.preOrderWithIterative();
        //bt.inOrder(bt.root);
        // int result = bt.maxDepth(bt.root);
        // System.out.println(result);
       // bt.postOrder(bt.root);
        //bt.levelOrderLeetCodeVersion(bt.root);
        boolean result = bt.isValid(bt.root, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("Result: "+ result);
    }

}
