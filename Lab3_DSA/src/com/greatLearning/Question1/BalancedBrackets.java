package com.greatLearning.Question1;

import java.util.Stack;

public class BalancedBrackets {
     
	static boolean checkingForBalance(String bracket) {
		Stack<Character> stack = new Stack<Character>();
		
		for ( int i=0; i < bracket.length(); i++) {
			char characters = bracket.charAt(i);
			
			if (characters == '(' || characters == '['|| characters == '{' ) {
				stack.push(characters);
				continue;
			}
			
			if (stack.isEmpty())
				return false;
			char c;
			
			switch (characters) {
			
			case ')':
				c = stack.pop();
				if ( c == '{' || c =='[')
					return false;
				break;
			
			case '}':
				c = stack.pop();
				if (c == '(' || c =='[')
					return false;
				break;
				
			case ']':
				c = stack.pop();
				if (c == '(' || c == '{')
					return false;
				break;
			}
		}
		
		return (stack.isEmpty());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String bracket = "([[{}]])";
		
		Boolean result;
		
		result = checkingForBalance(bracket);
		
		if(result)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered String doesn't have Balanced Brackets");

	}

}
