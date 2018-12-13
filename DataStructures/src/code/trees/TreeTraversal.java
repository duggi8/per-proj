package code.trees;

import com.linkedListImp.NoLimitQueue;
import com.linkedListImp.QueueOverflowException;
import com.linkedListImp.QueueUnderflowException;

/*How do you solve traversals without using recursion?  Complexity is O(n) as we need to go to each node of tree in traversal.*/
public class TreeTraversal {

	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		
		Node<Integer> n6 = new Node<Integer>(10, null, null);
		Node<Integer> n5 = new Node<Integer>(9, n6, null);
		Node<Integer> n4 = new Node<Integer>(8, null, null);
		Node<Integer> n3 = new Node<Integer>(7, n4, n5);
		Node<Integer> n2 = new Node<Integer>(6, null, null);
		Node<Integer> n = new Node<Integer>(5,n2,n3);
		breadthFirstTraversal(n);
		System.out.println("****testing inorder traversal*****");
		inorderTravrsal(n);
		System.out.println("****testing preorder traversal*****");
		preOrderTraversal(n);
		System.out.println("****testing postorder traversal*****");
		postOrderTraversal(n);
	}

	/*Use queue -> Take tree root and enqueue and then dequeue and process the node and now enqueue both its children and then dequeue each child and process in the
	 *same way, do this until queue is empty.*/
	public static void breadthFirstTraversal(Node<Integer> n) throws QueueOverflowException, QueueUnderflowException {

		NoLimitQueue<Node<Integer>> qu = new NoLimitQueue<>();
		qu.enqueue(n);
		while(!qu.isEmpty()) {
			
			Node<Integer> out =  qu.dequeue();
			System.out.println(out.getData());
			if(out.getLeft()!=null)
			qu.enqueue(out.getLeft());
			if(out.getRight()!=null)
			qu.enqueue(out.getRight());
		}
		
	}
	
	/*process order-
		 *  1.left child
		 *  2.parent
		 *  3.right child */
	public static void inorderTravrsal(Node<Integer> n) {
		if(n==null)
			return;
		inorderTravrsal(n.getLeft());
		System.out.println(n.getData());
		inorderTravrsal(n.getRight());
	}
	
	public static void preOrderTraversal(Node<Integer> n) {
		if(n==null)
			return;
		System.out.println(n.getData());
		preOrderTraversal(n.getLeft());
		preOrderTraversal(n.getRight());
	}
	
	public static void postOrderTraversal(Node<Integer> n) {
		if(n==null)
			return;
		postOrderTraversal(n.getLeft());
		postOrderTraversal(n.getRight());
		System.out.println(n.getData());
	}

}
