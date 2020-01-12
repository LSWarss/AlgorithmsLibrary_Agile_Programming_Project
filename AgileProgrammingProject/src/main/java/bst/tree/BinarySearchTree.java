package bst.tree;

import bst.shapes.CircleNode;

import java.util.Objects;

public final class BinarySearchTree extends BinaryTree {

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(CircleNode rootCircle) {
        super(rootCircle);
    }


    public void insertItem(CircleNode newCircle) {
        root = insertItem(root, newCircle);
    }

    protected TreeNode insertItem(TreeNode tNode, CircleNode newCircle) {
        TreeNode newSubtree;

        if (tNode == null) {
            tNode = new TreeNode(newCircle, null, null);
            return tNode;
        }

        CircleNode nodeItem = tNode.rootCircle;

        if (Objects.equals(newCircle.getSearchKey(), nodeItem.getSearchKey())) {
            return tNode;
        }

        if (newCircle.getSearchKey() < nodeItem.getSearchKey()) {
            newSubtree = insertItem(tNode.leftCircle, newCircle);
            tNode.leftCircle = newSubtree;
            return tNode;
        }

        newSubtree = insertItem(tNode.rightCircle, newCircle);
        tNode.rightCircle = newSubtree;
        return tNode;
    }

    public Integer retrieveItem(Integer searchKey) {
        return retrieveItem(root, searchKey);
    }


    protected Integer retrieveItem(TreeNode tNode, Integer searchKey) {
        Integer treeItem;
        if (tNode == null) {
            treeItem = null;

        } else {
            tNode.highlightFlag = true;
            CircleNode nodeItem = tNode.rootCircle;
            if (Objects.equals(searchKey, nodeItem.getSearchKey())) {
                tNode.highlightFlag = true;
                treeItem = tNode.rootCircle.getSearchKey();
            } else if (searchKey < nodeItem.getSearchKey()) {
                tNode.leftCircle.highlightFlag = true;
                treeItem = retrieveItem(tNode.leftCircle, searchKey);
            } else {
                tNode.rightCircle.highlightFlag = true;
                treeItem = retrieveItem(tNode.rightCircle, searchKey);
            }
        }

        return treeItem;
    }

    public void deleteItem(Integer searchKey) throws TreeException {
        root = deleteItem(root, searchKey);
    }

    protected TreeNode deleteItem(TreeNode tNode, Integer searchKey) {
        TreeNode newSubtree;

        if (tNode == null) {
            throw new TreeException("tree.TreeException: Item not found");
        }

        CircleNode nodeItem = tNode.rootCircle;
        if (Objects.equals(searchKey, nodeItem.getSearchKey())) {
            tNode = deleteNode(tNode);

        } else if (searchKey < nodeItem.getSearchKey()) {
            newSubtree = deleteItem(tNode.leftCircle, searchKey);
            tNode.leftCircle = newSubtree;
        } else {
            newSubtree = deleteItem(tNode.rightCircle, searchKey);
            tNode.rightCircle = newSubtree;
        }

        return tNode;
    }

    protected TreeNode deleteNode(TreeNode tNode) {

        CircleNode replacementItem;

        if ((tNode.leftCircle == null) && (tNode.rightCircle == null)) {
            return null;
        } else if (tNode.leftCircle == null) {
            return tNode.rightCircle;
        } else if (tNode.rightCircle == null) {
            return tNode.leftCircle;
        } else {

            replacementItem = findLeftmost(tNode.rightCircle);
            tNode.rootCircle = replacementItem;
            tNode.rightCircle = deleteLeftmost(tNode.rightCircle);
            return tNode;
        }
    }

    protected CircleNode findLeftmost(TreeNode tNode) {
        if (tNode.leftCircle == null) {
            return tNode.rootCircle;
        }
        return findLeftmost(tNode.leftCircle);
    }

    protected TreeNode deleteLeftmost(TreeNode tNode) {
        if (tNode.leftCircle == null) {
            return tNode.rightCircle;
        }
        tNode.leftCircle = deleteLeftmost(tNode.leftCircle);
        return tNode;
    }

    public void setResetColor(TreeNode tNode) {
        resetColor(tNode);
    }

    protected void resetColor(TreeNode tNode) {
        if (tNode != null) {
            tNode.highlightFlag = false;

            if (tNode.leftCircle != null) {
                tNode.leftCircle.highlightFlag = false;
            }

            if (tNode.rightCircle != null) {
                tNode.rightCircle.highlightFlag = false;
            }
            resetColor(tNode.leftCircle);
            resetColor(tNode.rightCircle);
        }
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.leftCircle), getHeight(root.rightCircle)) + 1;
    }


    public int getSize(TreeNode root) {
        if (root == null)
            return 0;
        return (getSize(root.leftCircle) + getSize(root.rightCircle)) + 1;
    }

    @Override
    public void setRootItem(CircleNode newItem) {
        root = new TreeNode(newItem, null, null);
    }
}
