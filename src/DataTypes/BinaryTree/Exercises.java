package DataTypes.BinaryTree;

public class Exercises {

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

    // TODO 104. Maximum Depth of Binary Tree (EASY)
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    // Runtime 0ms beats 100%
    // Memory 41.8mb beats 95%

    public int maxDepth(TreeNode root) {

        if(root==null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(right, left);

    }

    // TODO 101. Symmetric Tree (easy)
    // https://leetcode.com/problems/symmetric-tree/description/
    //Runtime 0ms beats 100%
    //Memory 40mb beats 98%

    public boolean isSymmetric(TreeNode root) {

        if(root == null) return false;
        return checkSymmetric(root.left, root.right);

    }

    //IN ORDER TRAVERSAL
    public boolean checkSymmetric(TreeNode left, TreeNode right){

        if(left == null && right == null) return true;
        if(left==null || right == null) return false;

        if(left.val != right.val) return false;

        boolean out = checkSymmetric(left.left, right.right);
        boolean in = checkSymmetric(left.right, right.left);

        return out && in;

    }


}
