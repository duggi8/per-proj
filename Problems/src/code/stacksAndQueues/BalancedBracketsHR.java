package code.stacksAndQueues;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;
//not complete - work on it.
public class BalancedBracketsHR {

	public static void main(String[] args) {
		String test = "{{[[(())]]}}";
		//Files.lines(Paths.get("BalancedBracketsTestInputtxt.txt"),StandardCharsets.UTF_8);
		try {
		Files.lines(Paths.get("sample.txt"),StandardCharsets.UTF_8).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(isBalanced(test));
		int a = '{';
		int b = '}';
		int l = '(';
		int m = ')';
		System.out.println(a +" "+ b + " "+ l +" "+m);
	}
	
    // Complete the isBalanced function below.
	//[({((}))]
    static String isBalanced(String s) {
    	Stack<Character> stack = new Stack<>();
    	if(s.length()/2!=0)
    		return "NO";
    	for(int i =0;i<s.length();i++) {
    		if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)== '(')
    			stack.push(s.charAt(i));
    		else 
    			if((s.charAt(i)==']' && stack.peek() == '[') ||
    					(s.charAt(i)=='}' && stack.peek() == '{') ||
    					     (s.charAt(i)==')' && stack.peek()=='('))
    			stack.pop();
    			else
    			return "NO";	
    	}

    	return stack.isEmpty()?"YES":"NO";
    }
}
