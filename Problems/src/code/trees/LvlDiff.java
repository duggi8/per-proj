package code.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LvlDiff {
	
	public static void main(String[] args) {
		LvlDiff.Node n = new LvlDiff().new Node(5);
		LvlDiff.Node n1 = new LvlDiff().new Node(4);
		LvlDiff.Node n2 = new LvlDiff().new Node(6);
		LvlDiff.Node n3 = new LvlDiff().new Node(1);
		LvlDiff.Node n4 = new LvlDiff().new Node(2);
		LvlDiff.Node n5 = new LvlDiff().new Node(8);
		LvlDiff.Node n6 = new LvlDiff().new Node(9);
		LvlDiff.Node n7 = new LvlDiff().new Node(10);
		LvlDiff.Node n8 = new LvlDiff().new Node(11);
	    n.left = n1;
	    n.right = n2;
	    n1.left = n3;
	    n1.right = n4;
	    n2.left = n5;
	    n2.right = n6;
	    n3.left = n7;
	    n3.right = n8;
	     //BFT(n);
	    // System.out.println(oddEvenDiff(n));
	     System.out.println(diffUsingBFT(n));
	     //System.out.println(heightOfTree(n));
	}
	
	static int oddEvenDiff(Node n) {
		return sumTree(n,1);
	}
	static int sumTree(Node n,int lvl) {
		if(n==null)
			return 0;
		if(lvl%2==0) {
			System.out.println(n.data);
			return  (sumTree(n.left, lvl+1)+sumTree(n.right, lvl+1)) - n.data;
		}
		else {
			System.out.println(n.data);
			return sumTree(n.left, lvl+1)+sumTree(n.right, lvl+1)+n.data;
		}
	}
	
  /*  static int sumTreeIterative(Node n) {
    	
    }*/
	static int heightOfTree(Node n) {
		if(n==null)
			return 0;
		System.out.println(n.data);
		return Math.max(heightOfTree(n.left),heightOfTree(n.right))+1;
	}


	static void BFT(Node n) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(n);
		while(queue.peek()!=null) {
			Node temp = queue.poll();
			System.out.println(temp.data);
			if(temp.left!=null) {
				queue.offer(temp.left);
			}
			if(temp.right!=null) {
				queue.offer(temp.right);
			}
		}
		
	}

	/*Queue can be used for breadth first traversal.
	 * 1.insert root in queue
	 * 2.remove it and process its children
	 * 3. repeat untill queue is empty.
	 * Here trick is to find size of queue and make those only many internal iterations
	 * to add the level sum.
	 * 1.Initially size = 1 , so we perform one iteration and come back to external loop.
	 * 2.Now check size again, this time it is 2. So we do 2 iterations in internal loop there by summing the level=2 data.
	 * 3.Now check size again, this time it is 4. So we do 4 iterations in internal loop there by summing the level=3 data.
	 * we exit when queue is empty.
	 * */
	static int diffUsingBFT(Node n) {
		Queue<Node> queue = new LinkedList<>();
		int oddSum=0,evenSum=0,level = 0,size = 0;
		
		queue.offer(n);
		
		while(queue.peek()!=null) {
			size = queue.size();
			level++;
			while(size>0) {
				Node temp = queue.poll();
				System.out.println(temp.data);
				if(level%2==0)
					evenSum = evenSum+temp.data;
				else
					oddSum = oddSum+temp.data;
				
				if(temp.left!=null) {
					queue.offer(temp.left);
				}
				if(temp.right!=null) {
					queue.offer(temp.right);
				}
				size--;
			}
			
		}
		return oddSum-evenSum;
		
	}

 class Node{
	int data;
	Node left,right;
	Node(int data){
		this.data = data;
		left=right=null;
	}
}
}
