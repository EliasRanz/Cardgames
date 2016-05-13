package com.eliasranzschleifer.tree;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BlackJackBinaryTree {
    private BinaryTreeNode<Integer> rootNode;

    public BlackJackBinaryTree(int baseScore) {
        this.rootNode = new BinaryTreeNode<>();
        rootNode.setData(baseScore);
    }

    public Collection<BinaryTreeNode<Integer>> getLeaves() {
        return getLeafHelper(rootNode);
    }

    private Collection<BinaryTreeNode<Integer>> getLeafHelper(BinaryTreeNode<Integer> current) {
        BinaryTreeNode<Integer> leftNode = current.getLeftNode();
        BinaryTreeNode<Integer> rightNode = current.getRightNode();
        Set<BinaryTreeNode<Integer>> leaves = new HashSet<>();
        // Base Case node current is a leaf?
        if(leftNode == null && rightNode == null) {
            leaves.add(current);
            return leaves;
        }

        if(leftNode != null){
            leaves.addAll(getLeafHelper(leftNode));
        }
        if(rightNode != null){
            leaves.addAll(getLeafHelper(rightNode));
        }

        return leaves;
    }
}
