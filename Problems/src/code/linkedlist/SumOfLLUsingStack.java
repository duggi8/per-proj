package code.linkedlist;

import com.linkedListImp.Element;
import com.linkedListImp.Stack;
import com.linkedListImp.Stack.StackEmptyException;
import com.linkedListImp.Stack.StackFullException;

public class SumOfLLUsingStack {

	Node<Integer> result;

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		Node<Integer> n = null;
		Node<Integer> m = null;
		Node<Integer> n1 = new Node<Integer>(5);
		Node<Integer> n2 = new Node<Integer>(6);
		Node<Integer> n3 = new Node<Integer>(8);
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		Node<Integer> m1 = new Node<Integer>(8);
		Node<Integer> m2 = new Node<Integer>(4);
		Node<Integer> m3 = new Node<Integer>(2);
		Node<Integer> m4 = new Node<Integer>(4);
		m1.setNextNode(m2);
		m2.setNextNode(m3);
		m3.setNextNode(m4);
		Node<Integer> result = sumInputType2(n, m);
		print(result);
		result = sumUsingStack(n1, m1);
		print(result);
	}

	static void print(Node<Integer> p) {
		while (p != null) {
			System.out.println(p.getData());
			p = p.getNextNode();
		}
	}
	/*
	 * There is a recursive method too in geeksforgeeks.
	 * a = 3->5->7 357 b = 4->3->4 434 result = 7->9->1 791
	 *
	 * a = 3->5 35 b = 4->3->4->9 4349 result = 4->3->8->4 4384
	 */
	/*
	 * static Node<Integer> sumInputType1(Node<Integer> headA, Node<Integer> headB)
	 * {
	 * 
	 * }
	 */

	/*
	 * Input: First List: 5->6->3 // represents number 365 Second List: 8->4->2 //
	 * represents number 248 Output Resultant list: 3->1->6 // represents number 613
	 */
	static Node<Integer> sumInputType2(Node<Integer> headA, Node<Integer> headB) {

		int carry = 0, sum = 0;
		Node<Integer> n = null, head = null;
		while (headA != null || headB != null) {
			if (headA == null) {
				sum = headB.getData() + carry;
				headB = headB.getNextNode();
			} else if (headB == null) {
				sum = headA.getData() + carry;
				headA = headA.getNextNode();
			} else {
				sum = headA.getData() + headB.getData() + carry;
				headA = headA.getNextNode();
				headB = headB.getNextNode();
			}

			carry = sum / 10;
			if (n == null) {
				n = new Node<Integer>(sum % 10);
				head = n;
			} else {
				n.setNextNode(new Node<Integer>(sum % 10));
				n = n.getNextNode();
			}

		}
		if (carry == 1)
			n.setNextNode(new Node<Integer>(carry));
		return head;

	}

	 
	/* using Stack
	 * a = 3->5->7 357
	 * b = 4->3->4 434
	 * result = 7->9->1 791
	 *
	 * a = 3->5 35 
	 * b = 4->3->4->9 4349
	 * result = 4->3->8->4 4384
	 */
	static Node<Integer> sumUsingStack(Node<Integer> headA, Node<Integer> headB)
			throws StackFullException, StackEmptyException {
		int carry = 0, sum = 0;
		Node<Integer> head = null, n = null;
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();
		while (headA != null) {
			if (!s1.isFull()) {
				s1.push(headA.getData());
				headA = headA.getNextNode();
			}

		}
		while (headB != null) {
			if (!s2.isFull()) {
				s2.push(headB.getData());
				headB = headB.getNextNode();
			}
		}

		while (true) {
			if (!s1.isEmpty() && !s2.isEmpty()) {
				sum = s1.pop() + s2.pop() + carry;
				carry = sum / 10;
				s3.push(sum%10);
			} else if (!s1.isEmpty()) {
				sum = s1.pop() + carry;
				carry = sum / 10;
				s3.push(sum%10);
			} else if (!s2.isEmpty()) {
				sum = s2.pop() + carry;
				carry = sum / 10;
				s3.push(sum%10);
			} else {
				break;
			}
		}
		if (carry == 1)
			s3.push(carry);

		while (!s3.isEmpty()) {
			if (n == null) {
				n = new Node<Integer>(s3.pop());
				head = n;
			} else {
				n.setNextNode(new Node<Integer>(s3.pop()));
				n = n.getNextNode();
			}

		}
		return head;
	}

}
