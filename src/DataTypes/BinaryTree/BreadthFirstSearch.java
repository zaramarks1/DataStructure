package DataTypes.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

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
}
