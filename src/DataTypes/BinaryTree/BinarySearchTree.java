package DataTypes.BinaryTree;

import java.util.Stack;

public class BinarySearchTree {

    // TODO 700. Search in a Binary Search Tree (EASY)
    // https://leetcode.com/problems/search-in-a-binary-search-tree/description/
    // Runtime 0ms beats 100%
    // Memory 43mb beats 50%
    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null) return null;
        if(root.val == val) return root;

        TreeNode right = searchBST(root.right, val);

        if(right!=null) return right;

        TreeNode left = searchBST(root.left, val);

        return left;
    }

    // TODO 98. Validate Binary Search Tree (MEDIUM)
    //https://leetcode.com/problems/validate-binary-search-tree/description/
    // Runtime 0ms beats 100%
    //Memory 41mb beats 60%

    public boolean isValidBST(TreeNode root) {
        return  divideConquer(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean divideConquer(TreeNode root, long min, long max ){

        if(root == null) return true;

        if(root.val <= min || root.val >= max)return false;

        // If is left -> Then it should be smaller than root.val and bigger than min (smallest value)
        boolean left = divideConquer(root.left, min, root.val);
        // If is right -> Then it shoulf be bigger than the head so MIN value is root.val
        boolean right = divideConquer(root.right, root.val, max);

        return left && right;
    }

    // 173. Binary Search Tree Iterator (MEDIUM)
    // https://leetcode.com/problems/binary-search-tree-iterator/description/
    // Runtime 17ms beats 51%
    // MEMORY 52mb BEATS 6%
    class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            updateStack(root);

        }

        public int next() {

            TreeNode curr = stack.pop();
            updateStack(curr.right);

            return curr.val;

        }

        public boolean hasNext() {

            return !stack.empty();

        }

        public void updateStack(TreeNode node){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
        }
    }
}
