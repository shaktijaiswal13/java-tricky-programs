package com.test.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-binary-search-trees
 *
 */
class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinarySearchTreeHeight {

	public static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		int leftTreeHeight = 0;
		int rightTreeHeight = 0;

		if (root.left != null) {
			leftTreeHeight = 1;
		}
		if (root.right != null) {
			rightTreeHeight = 1;
		}
		leftTreeHeight += getHeight(root.left);
		rightTreeHeight += getHeight(root.right);

		return leftTreeHeight >= rightTreeHeight ? leftTreeHeight : rightTreeHeight;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		sc.close();
		int height = getHeight(root);
		System.out.println(height);
	}
}
