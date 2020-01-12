package bst.tree;

import bst.shapes.CircleNode;

public abstract class BinaryTree {

    public TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(CircleNode rootCircle) {
        root = new TreeNode(rootCircle, null, null);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public TreeNode getRoot() throws TreeException {
        if (root == null) {
            throw new TreeException("tree.TreeException: Empty Tree");
        }

        return root;
    }

    public abstract void setRootItem(CircleNode newCircle);
}
