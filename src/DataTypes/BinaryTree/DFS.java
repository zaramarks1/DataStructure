package DataTypes.BinaryTree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

        //    In-Order
        //Pre-Order
        //Post-Order


    // TODO 236. Lowest Common Ancestor of a Binary Tree MEDIUM (Also works for 235)
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
    // Runtime 4 t0 7 ms depending on the exercise
    // Memory 43 to 90mb depending on the exercise
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        // if we find the value we return the root
        // The trick here is that if we find the value, we can check the next branch

        if(root.val == p.val || root.val == q.val ) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) return null; // if we didnt find the value anywhere we return null

        // We know that if we found a number in the left and in the right then the head must be the lowest  common ascenstor
        if(left !=null && right!= null) return root;

        // The thing is if one of the sides is null
        // then we know for sure that the next ascenstor will be under the same node we found the value and the head will be the node itself
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



    // TODO 112. Path Sum EASY
    //https://leetcode.com/problems/path-sum/description/
    // Runtime 0ms beats 100%
    // Mmeory 91mb beats 97%

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;
        return checkPath(root, 0, targetSum);
    }

    public boolean checkPath(TreeNode root, int value, int targetSum){

        if(root == null)  return false;

        value+=root.val;

        // if both right and left are null then we reached the end of the node
        if(root.left == null && root.right == null) return value==targetSum;

        // boolean left = checkPath(root.left, value, targetSum);
        // boolean right = checkPath(root.right, value, targetSum);

        return  checkPath(root.left, value, targetSum) || checkPath(root.right, value, targetSum);
    }


    // TODO 22. Generate Parentheses MEDIUM
    // https://leetcode.com/problems/generate-parentheses/description/
    // Runtime 1 ms Beats 92.5%
    // Memory 42.5 MB Beats 44.4%

    public List<String> generateParenthesis(int n) {

        if(n == 1 ) return Arrays.asList("()");

        List<String> res = new ArrayList<>();

        dfs(res, "", 0, 0, n);

        return res;

    }

    public void dfs(List<String> res, String temp, int left, int right, int n){

        if(temp.length() == n*2){
            res.add(temp);
            return;
        }

        if(left < n){
            dfs(res, temp + "(", left+1, right, n);
        }

        if(right < left){
            dfs(res, temp+")", left, right+1, n);
        }

    }


}
