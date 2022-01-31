package com.greatLearning.Question2;

import java.util.ArrayList;

public class LongestPath {
	
	static class Node {
		Node leftNode;
		Node rightNode;
		int data;
	}
	
	static Node newNode(int data) {
		Node temp = new Node();
		
		temp.data = data;
		temp.leftNode = null;
		temp.rightNode = null;
		
		return temp;
		
	}
	
	public static ArrayList<Integer> longestPath(Node root){
		if ( root == null) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			return path;
		}
		
		ArrayList<Integer> rightNodeList = longestPath(root.rightNode);
		
		ArrayList<Integer> leftNodeList = longestPath(root.leftNode);
		
		if(rightNodeList.size() < leftNodeList.size())
			leftNodeList.add(root.data);
		else
			rightNodeList.add(root.data);
		
		
		return(leftNodeList.size() > rightNodeList.size() ? leftNodeList : rightNodeList);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root =newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.rightNode.rightNode = newNode(140);
		root.rightNode.leftNode = newNode(110);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.leftNode.leftNode.leftNode =newNode(5);
		
		ArrayList<Integer> path = longestPath(root);
		int size = path.size();
		
		System.out.print(path.get(size-1));
		for(int i= size-2;i>=0;i--) {
			System.out.print(" -> "+path.get(i));
		}
		

	}

}
