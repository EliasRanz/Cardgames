package com.eliasranzschleifer.tree;

public class BinaryTreeNode<T> {
    private BinaryTreeNode<T> parentNode;
    private BinaryTreeNode<T> leftNode;
    private BinaryTreeNode<T> rightNode;
    private T data;

    public BinaryTreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(BinaryTreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public BinaryTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<T> leftNode) {
        leftNode.setParentNode(this);
        this.leftNode = leftNode;
    }

    public BinaryTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<T> rightNode) {
        rightNode.setParentNode(this);
        this.rightNode = rightNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "parentNode=" + (parentNode != null ? parentNode.getData().toString() : "null") +
                ", leftNode=" + (leftNode != null ? leftNode.getData().toString() : "null") +
                ", rightNode=" + (rightNode != null ? rightNode.getData().toString() : "null") +
                ", data=" + data +
                '}';
    }
}
