package DataTypes.BinaryTree;



public class BST_Exersices {

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
}
