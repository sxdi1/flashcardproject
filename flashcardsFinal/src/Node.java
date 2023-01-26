
/**
 * Node class creates a node which can be used to link flashcards together
 * @author Sadiksha Dahal
 *
 */
public class Node {
	
	private Flashcard card;
	private Node next;
	
	public Node(Flashcard card, Node next) {
		this.card = card;
		this.next = next;
	}
	
	public Node() {
		this(null,null);
	}
	
	public Node(Flashcard card) {
		this.card = card;
		this.next = null;
	}

	public Flashcard getCard() {
		return card;
	}

	public void setCard(Flashcard card) {
		this.card = card;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	

}
