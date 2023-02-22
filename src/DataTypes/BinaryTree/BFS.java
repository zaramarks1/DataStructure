package DataTypes.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    //
    // https://leetcode.com/tag/breadth-first-search/

    // TODO 102. Binary Tree Level Order Traversal (MEDIUM)
    //https://leetcode.com/problems/binary-tree-level-order-traversal/description/


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return new ArrayList<>();

        int depth = maxDepth(root);
        //System.out.println(depth);

        for(int i = 0; i < depth; i ++){
            List<Integer> listLevel =searchList(root, new ArrayList<Integer>(), i);
            list.add(listLevel);

        }

        return list;

    }

    public List<Integer> searchList(TreeNode root, ArrayList<Integer> list, int level){

        if(root == null) return new ArrayList();

        if(level == 0) {
            list.add(root.val);
        }

        searchList(root.left, list, level-1);
        searchList(root.right, list, level-1);

        return list;
    }

    public int maxDepth(TreeNode root){

        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right)+1;
    }

    //Solution  2
    //Runtime 0ms bests 100%
    // Memory 42.2mb beats 93%
    public List<List<Integer>> levelOrder2(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> listLevel = new ArrayList<>();
            while(size!=0){
                TreeNode node =  queue.poll();
                listLevel.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                size--;
            }
            list.add(listLevel);
        }

        return list;

    }


    // TODO 116. Populating Next Right Pointers in Each Node MEDIUM
    // Runtime 0ms beats 100%
    // 42mb  Memory beats 78%
    //O(n) - O(1)
    public TreeNode.Node connect(TreeNode.Node root) {

        // Keep track of the left node (1st is head )
        TreeNode.Node leftRoot = root;

        while(leftRoot!=null){
            //We get our curr and put the next pointers on their childs (L and R)
            TreeNode.Node curr = leftRoot;

            while(curr!=null){
                //if curr.left is null is the end, if not, we can point it to the right
                if(curr.left!=null) curr.left.next = curr.right;

                // This is the tricky part :
                // The right node will connect to the left node but of another parent (curr.next)
                //So we check if curr.next exists. If exists, that means we can connect the right to the left
                // If not, then we are at the extreme right so the curr.right.next should keep pointing null
                if(curr.right!= null && curr.next!=null) curr.right.next = curr.next.left;
                curr = curr.next;
            }

            leftRoot = leftRoot.left;
        }

        return root;
    }
}
