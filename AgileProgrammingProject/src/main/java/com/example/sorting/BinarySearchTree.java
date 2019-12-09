package com.example.sorting;

public class BinarySearchTree {
    /*Binary Search Tree, is a node-based binary tree data structure which has the following properties:
    The left subtree of a node contains only nodes with keys lesser than the node’s key.
    The right subtree of a node contains only nodes with keys greater than the node’s key.
    The left and right subtree each must also be a binary search tree.
    There must be no duplicate nodes.*/

//    Class containing left and right child of the current node and key value.
    class Node {
        int key;
        Node left, right;

        public Node(int item){
            key = item;
            left = right = null;
        }
    }

//    Root of Binary Search Tree
    Node root;

//    Constructor
    BinarySearchTree(){
        root = null;
    }

    // This method mainly calls deleteRec()
    void deleteKey(int key)
    {
        root = deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }


    void insert(int key){
        root = insertRec(root, key);
   }

   Node insertRec(Node root, int key){

       //Description: If the three is empty, return a new node
        if(root == null){
            root = new Node(key);
            return root;
        }

       //Description: If the tree is not empty recur down it
       if(key < root.key){
           root.left = insertRec(root.left, key);
       }
       else if(key > root.key){
           root.right = insertRec(root.right, key);
       }

       //Description: Return the unchanged node pointer
       return root;
   } //Description: A recursive function to insert a new key in BST


    void inorder(){
        inorderRec(root);
    } //Description: This method mainly calls InorderRec()


    void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }  //Description: A utility function to do inorder traversal of BST

}
