package com.example;

public class Main {

    public static void main(String[] args) {

        int[] testArray = {10, 12, -4 , 5 , 20, 30};
        quickSort.Sort(testArray,0,testArray.length-1);
        Utility.PrintArray(testArray);

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder();



    }
}
