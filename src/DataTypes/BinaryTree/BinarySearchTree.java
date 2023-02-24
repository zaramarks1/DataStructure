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

    // This solution takes under consideration that the Tree is a BST
    public TreeNode searchBST2(TreeNode root, int val) {

        if(root == null) return root;
        if(root.val == val){
            return root;
        }
        else{
            return val<root.val? searchBST(root.left,val):searchBST(root.right,val);
        }
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

    // TODO 173. Binary Search Tree Iterator (MEDIUM)
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

    // TODO 701. Insert into a Binary Search Tree (MEDIUM)
    // Runtime 0ms beats 100%
    // Memory 53mb beats 11%

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null) return new TreeNode(val);

        if(val < root.val ) root.left = insertIntoBST(root.left, val);

        else root.right = insertIntoBST(root.right, val);

        return root;

    }

    // TODO 450. Delete Node in a BST MEDIUM
    // https://leetcode.com/problems/delete-node-in-a-bst/description/
    // Runtimme 0ms 100%
    // Memory 42mb 59%

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return root;

        if(root.val == key){

            if(root.left == null) {
                return root.right;
            }

            if(root.right == null){
                return root.left;
            }

            TreeNode curr = root.right;
            while(curr.left !=null){
                curr = curr.left;
            }
            root.val = curr.val;
            root.right = deleteNode(root.right, curr.val);
        }

        if(key > root.val) root.right = deleteNode(root.right, key);
        else root.left = deleteNode(root.left, key);

        return root;
    }
}
