package bst.tree;

import bst.shapes.CircleNode;


public class TreeNode {

    public CircleNode rootCircle;
    public TreeNode leftCircle;
    public TreeNode rightCircle;
    public boolean highlightFlag;

    public TreeNode(CircleNode rootCircle, TreeNode leftCircle, TreeNode rightCircle) {
        this.rootCircle = rootCircle;
        this.leftCircle = null;
        this.rightCircle = null;
    }
}
