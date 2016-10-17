package com.test.testdome.tests;
class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean isValidBST(Node root) {
    	
    	if (root == null) {
    		return false;
    	}
    	return validateEachNode(root);
    }
    
    private static boolean validateEachNode(Node current) {
    	Node left = current.left;
    	Node right = current.right;
    	boolean isLeftValid = false;
    	boolean isRightValid = false;
    	
    	System.out.println("Current: " + current.value);

    	if (left == null && right == null) {
    		 return true;
    	}
    	
    	if (left != null) {
    		System.out.println("left: " + left.value);
    		if (left.value < current.value) {
    			isLeftValid = validateEachNode(left);
    			System.out.println(" isLeftValid :" + isLeftValid);
    		} else {
    			return false;
    		}
    	} else {
    		isLeftValid = true;
    	}
    	
    	if (right != null && isLeftValid) {
    		System.out.println("right: " + right.value);
    		if (current.value < right.value) {
    			isRightValid = validateEachNode(right);
    			System.out.println(" isRightValid :" + isRightValid);
    		} else {
    			return false;
    		}
    	} else {
    		isRightValid = true;
    	}
    	return (isLeftValid && isRightValid);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println("Binary search Tree is valid: " + isValidBST(n2));
        
        Node a3 = new Node(3, null, null);
        Node a7 = new Node(7, null, null);
        Node a5 = new Node(5, a3, a7);
        Node a13 = new Node(13, null, null);
        Node a17 = new Node(17, null, null);
        Node a15 = new Node(15, a13, a17);
        Node a10 = new Node(10, a5, a15);

        System.out.println("Binary search Tree is valid: " + isValidBST(a10));    
        
        Node s1 = new Node(1, null, null);
        Node s2 = new Node(2, s1, null);
        Node s3 = new Node(3, s2, null);
        Node s5 = new Node(5, null, null);
        Node s6 = new Node(6, s5, null);
        Node s9 = new Node(9, null, null);
        Node s8 = new Node(81, null, s9);
        Node s7 = new Node(7, s6, s8);
        Node s4 = new Node(4, s3, s7);
        Node s11 = new Node(11, null, null);
        Node s13 = new Node(13, null, null);
        Node s12 = new Node(12, s11, s13);
        Node s14 = new Node(14, s12, null);
        Node s10 = new Node(10, s4, s14);
        
        System.out.println("Binary search Tree is valid: " + isValidBST(s10));
        
        /*Node s1 = new Node(1, null, null);
        Node s2 = new Node(2, s1, null);
        Node s3 = new Node(3, s2, null);
        Node s5 = new Node(5, null, null);
        Node s6 = new Node(6, s5, null);
        Node s9 = new Node(9, null, null);
        Node s8 = new Node(8, null, s9);
        Node s7 = new Node(7, s6, s8);
        Node s4 = new Node(4, s3, s7);
        Node s11 = new Node(11, null, null);
        Node s13 = new Node(13, null, null);
        Node s12 = new Node(12, s11, s13);
        Node s14 = new Node(14, s12, null);
        Node s10 = new Node(10, s4, s14);
        
        System.out.println("Binary search Tree is valid: " + isValidBST(s10));*/

    }
}