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


}
