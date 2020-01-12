package bst.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public final class TreeIterator implements Iterator<Integer> {

    private BinaryTree binaryTree;
    private TreeNode currentNode;
    private LinkedList<TreeNode> queue;

    public TreeIterator(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
        currentNode = null;
        queue = new LinkedList<>();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public Integer next() throws NoSuchElementException {
        try {
            currentNode = queue.remove();
            return currentNode.rootCircle.getSearchKey();
        } catch (QueueException e) {
            throw new NoSuchElementException();
        }
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }


    public void setPreorder() {
        queue.clear();
        preorder(binaryTree.root);
    }

    private void preorder(TreeNode treeNode) {
        if (treeNode != null) {
            queue.add(treeNode);
            preorder(treeNode.leftCircle);
            preorder(treeNode.rightCircle);
        }
    }

    public void setInorder() {
        queue.clear();
        inorder(binaryTree.root);
    }


    private void inorder(TreeNode treeNode) {
        if (treeNode != null) {
            inorder(treeNode.leftCircle);
            queue.add(treeNode);
            inorder(treeNode.rightCircle);
        }
    }

    public void setPostorder() {
        queue.clear();
        postorder(binaryTree.root);
    }


    private void postorder(TreeNode treeNode) {
        if (treeNode != null) {
            postorder(treeNode.leftCircle);
            postorder(treeNode.rightCircle);
            queue.add(treeNode);
        }
    }
}

