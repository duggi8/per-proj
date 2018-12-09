package code.linkedlist;

/*Traverse linked list using two pointers. Move one pointer by one and other 
 * pointer by two. When the fast pointer reaches end slow pointer 
will reach middle of the linked list. One pass solution*/
public class MiddleElement {

	public static void main(String[] args) {
		Node<Integer> h = new Node<Integer>(2);
		LinkedList<Integer> list = new LinkedList<>(h);
		list.add(new Node<Integer>(4));
		list.add(new Node<Integer>(6));
		list.add(new Node<Integer>(8));
		list.add(new Node<Integer>(10));
		list.add(new Node<Integer>(12));
		list.add(new Node<Integer>(14));
		list.add(new Node<Integer>(16));
	//	list.add(new Node<Integer>(18));
		System.out.println(middleElement(list).getData());
		System.out.println(middleElementSol2(list).getData());
	}


	public static Node<Integer> middleElement(LinkedList<Integer> list) {
		Node<Integer> fast = list.getHead();
		Node<Integer> slow = list.getHead();
		int countFast = 0;
		int countSlow = 0;

		if (fast != null) {
			while (fast.getNextNode() != null) {
				fast = fast.getNextNode();
				countFast++;
				if (countFast / 2 != countSlow) {
					countSlow++;
					slow = slow.getNextNode();
				}
			}
		}

		return slow;
		}
	
	public static Node<Integer> middleElementSol2(LinkedList<Integer> list) {
		Node<Integer> fast = list.getHead();
		Node<Integer> slow = list.getHead();
		if(fast!=null) {
			while(fast!= null && fast.getNextNode()!=null) {
				fast = fast.getNextNode().getNextNode();
				slow = slow.getNextNode();
			}
		}
		return slow;
		}
}
