package code.linkedlist;
/*Create 2 pointers, second pointer starts its race after 3 loops behind the first pointer. So when first pointer reaches
 * the last node the second pointer will be 3 steps behind.Same concept used to find middle element of linkedlist in one pass.*/
public class FindThirdNodeFromEnd {

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
		System.out.println("thirdNodeFromEnd -" + thirdNodeFromEnd(n1).getData());
		
		
	}
	
	public static Node<Integer> thirdNodeFromEnd(Node<Integer> n){
		Node<Integer> p1 = n;
		Node<Integer> p2 = n;
		int count = 1;
		while(p1.getNextNode()!=null) {
			p1 = p1.getNextNode();
			count++;
			if(count>3) {
				p2 = p2.getNextNode();
			}
		}
		return p2;
		
	}

}
