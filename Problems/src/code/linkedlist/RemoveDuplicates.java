package code.linkedlist;

import java.util.HashSet;

/*we can do this in 3 different process. 
1.Brute force - check all elements in linkedlist for duplicate for each element O(n^2)
2. Sort using merge sort and then compare O(nlogn) + O(n)
3. Use HashTable to put elements and find element in hashtable if yes it is a duplicate so remove it and proceed. O(n) 
method 3 O(n) assuming hashtable access time is O(1) on average*/
public class RemoveDuplicates {

	public static void main(String[] args) {

		Node<Integer> n1 = new Node<Integer>(12);
		Node<Integer> n2 = new Node<Integer>(11);
		Node<Integer> n3 = new Node<Integer>(12);
		Node<Integer> n4 = new Node<Integer>(21);
		Node<Integer> n5 = new Node<Integer>(41);
		Node<Integer> n6 = new Node<Integer>(43);
		Node<Integer> n7 = new Node<Integer>(21);
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		n4.setNextNode(n5);
		n5.setNextNode(n6);
		n6.setNextNode(n7);
		System.out.println("test for bruteForce");
		Node<Integer> res = bruteForce(n1);
		while (res != null) {
			System.out.println(res.getData());
			res = res.getNextNode();
		}
		System.out.println("test for usingHashing");
		Node<Integer> res1 = usingHashing(n1);
		while (res1 != null) {
			System.out.println(res1.getData());
			res1 = res1.getNextNode();
		}
		
	}

	public static Node<Integer> bruteForce(Node<Integer> n) {
		int elementToCompare;
		Node<Integer> head = n;
		Node<Integer> temp;
		Node<Integer> cursor = n;
		while (n.getNextNode() != null) {
			elementToCompare = (Integer) n.getData();
			cursor = n;
			while (cursor != null && cursor.getNextNode() != null) {
				if (elementToCompare == (Integer) cursor.getNextNode().getData()) {
					temp = cursor.getNextNode().getNextNode();
					cursor.setNextNode(temp);
				}
				cursor = cursor.getNextNode();
			}
			n = n.getNextNode();

		}
		return head;
	}

	public static Node<Integer> usingHashing(Node<Integer> n) {
		HashSet<Node<Integer>> set = new HashSet<>();
		Node<Integer> head = n;
		Node<Integer> prev = null;
		while (n != null) {
			if (set.contains(n))
				prev.setNextNode(n.getNextNode());
			else
				set.add(n);
			prev = n;
			n = n.getNextNode();
		}
		return head;
	}

}
