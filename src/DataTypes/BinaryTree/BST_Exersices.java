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

    // TODO 235. Lowest Common Ancestor of a Binary Search Tree  MEDIUM
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/?envType=study-plan&id=level-1
    // Runtime 4ms beats 100%
    // Memory 43mb beats 44%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        if(root.val == p.val || root.val == q.val ) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) return null;

        if(left !=null && right!= null) return root;


        return left !=null ? left : right;

    }

    // TODO 100. Same Tree EASY
   // https://leetcode.com/problems/same-tree/description/
    // Runtime 0ms beats 1005
    // Memory 42mb
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null & q == null) return true;

        if(p == null || q == null ) return false;

        if(p.val != q.val ) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;

    }
}
