package code.linkedlist;

import java.util.HashSet;

/*how to detect a cycle in a linkedlist?
https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/  */
public class CyclicOrNot {

	public static void main(String[] args) {
		
		Node<Integer> h = new Node<Integer>(2);
		LinkedList<Integer> list = new LinkedList<>(h);
		list.add(new Node<Integer>(4));
		list.add(new Node<Integer>(6));
		Node<Integer> cycleEnd = new Node<Integer>(8);
		list.add(cycleEnd);
		list.add(new Node<Integer>(10));
		list.add(new Node<Integer>(12));
		list.add(new Node<Integer>(14));
		list.add(new Node<Integer>(16));
		list.add(cycleEnd);
		
		System.out.println(cyclicOrNot(list));
		System.out.println(cyclicOrNotSol2(list));
	}
	
	/*have 2 pointers with different speeds. If there is a cycle then those 2 pointers (slow,fast)
	intersect at some point else if you encounter null then it is not cyclic.*/
	public static boolean cyclicOrNot(LinkedList<Integer> list) {
		
		Node<Integer> slow = list.getHead();
		Node<Integer> fast = list.getHead();
		if(list.getHead()!=null) {
			while(fast!=null && fast.getNextNode()!=null) {
				fast = fast.getNextNode().getNextNode();
				slow = slow.getNextNode();
				if(fast==slow) {
					return true;
				}
			}
		}
		return false;
		
	}
	/*using Java collections API- HashSet.If a node already exists in our Hashset then it is cyclic.*/
	public static boolean cyclicOrNotSol2(LinkedList<Integer> list) {
		HashSet<Node<Integer>> set = new HashSet<>();
		Node<Integer> pointer = list.getHead();
		if(list.getHead()!=null) {
			while(pointer!= null) {
				if(set.contains(pointer)) {
					return true;
				}
				else {
					set.add(pointer);
				}
				pointer = pointer.getNextNode();
				
			}
		}
		return false;
	}
}
