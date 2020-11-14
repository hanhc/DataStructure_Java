package tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树相关操作
 */

public class BinaryTree {
    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     * @param inputList 输入的列表
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 树的高度
     */
    public static int maxDepth(TreeNode root) {
        if(root ==  null){
            return 0;
        }
        return Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild)) + 1;
    }

    /**
     * 二叉树前序遍历，递归
     */
    public static void preOrderTravel(TreeNode node) {
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTravel(node.leftChild);
        preOrderTravel(node.rightChild);
    }

    /**
     * 二叉树中序遍历，递归
     */
    public static void inOrderTravel(TreeNode node) {
        if(node == null){
            return;
        }
        inOrderTravel(node.leftChild);
        System.out.println(node.data);
        inOrderTravel(node.rightChild);
    }

    /**
     * 二叉树的后序遍历，递归
     */
    public static void postOrderTravel(TreeNode node) {
        if(node == null){
            return;
        }
        postOrderTravel(node.leftChild);
        postOrderTravel(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历: ");
        preOrderTravel(treeNode);
        System.out.println("中序遍历: ");
        inOrderTravel(treeNode);
        System.out.println("后序遍历: ");
        postOrderTravel(treeNode);
        System.out.println("高度：" + maxDepth(treeNode));

    }
}
