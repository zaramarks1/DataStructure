package DataTypes.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Traversals {

    // Binary Tree Preorder Traversal
    // Runtime 0ms beats 100%
    // Memory 40mb beats 98%

    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root==null) return new ArrayList<>();

        list.add(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }

    //  Binary Tree InOrder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root==null) return new ArrayList<>();

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }

    // Binary Tree PostOrder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();

        postorderTraversal(root.left);
        postorderTraversal(root.right);

        list.add(root.val);

        return list;

    }
}
