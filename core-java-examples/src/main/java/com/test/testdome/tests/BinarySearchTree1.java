package com.test.testdome.tests;
/*class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}*/

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BinarySearchTree1 {
    public static boolean isValidBST(Node root) {
    	
    	if (root == null) {
    		return false;
    	}
    	return validateAllNodes(root);
    }
    
    private static boolean validateAllNodes(Node current) {
    	
    	while (true) {
    		Node left = current.left;
    		Node right = current.right;
    		if (left == null && right == null) {
    			return true;
    		}
    		if (left.value < current.value) {
    			current = left;
    		} else {
    			return false;
    		}
    		if (current.value < right.value) {
    			current = left;
    		} else {
    			return false;
    		}
    	}
    	
    	//return false;
    }
    
    private static boolean validateLeftRightNode(Node parent, Node left, Node right) {
    	if (left.value < parent.value && parent.value < right.value) {
    		validateLeftRightNode(left, left.left, left.right);
    		validateLeftRightNode(right, right.left, right.right);
    	}
    	
    	return false;
    }
    
    private static boolean validateEachNode(Node current) {
    	boolean isLeftValid = false;
    	boolean isRightValid = false;
    	Map<Node, Node> nodeList = new HashMap<>();
    	
    	while(current != null) {
    		Node left = current.left;
    		Node right = current.right;
    		if (left.value < current.value && current.value < right.value) {
    			nodeList.put(right, current);
    			current = left;
    		} else {
    			return false;
    		}
    	}
    	for (Entry<Node, Node> nodeEntry : nodeList.entrySet()) {
    		Node node = nodeEntry.getKey();
    		
    	}
    	return true;
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
        Node s8 = new Node(8, null, s9);
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