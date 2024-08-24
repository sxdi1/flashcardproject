import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JLabel;

/**
 * DeckOfCards class creates a stack of flashcards
 * 
 * @author Sadiksha Dahal
 *
 */
public class DeckOfCards {

	static DeckOfCards tempDeck;

	private String title = null;
	private Node top = null;
	private int size = 0;

	// arraylist that holds all the cards for each deck
	private ArrayList<Flashcard> cards = new ArrayList<Flashcard>();

	// arraylist that holds all the deck of cards made
	public static ArrayList<DeckOfCards> allDecksOfCards = new ArrayList<DeckOfCards>();

	/**
	 * creates empty stack of cards
	 */
	public DeckOfCards() {
		top = null;
	}

	/**
	 * adds new flashcard to the top of the stack
	 * 
	 * @param card the card being added
	 */
	public void push(Flashcard card) {
		Node temp = new Node(card, top);
		top = temp;
		size++;
	}

	/**
	 * removes flashcard from the top of the stack
	 * 
	 * @return card at the top of stack
	 */
	public Flashcard pop() {
		if (top != null) {
			Flashcard card = top.getCard();
			top = top.getNext();
			size--;
			return card;
		} else {
			return null;
		}
	}

	/**
	 * checks if the stack is empty
	 * 
	 * @return true if stack is empty
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * returns the card at the top of the deck
	 * 
	 * @return the card at the top of the stack
	 */
	public Flashcard peek() {
		if (top == null) {
			return null;
		} else {
			Flashcard card = top.getCard();
			return card;
		}
	}

	/**
	 * empties a deck
	 */
	public void emptyDeck() {
		for (int i = 0; i <= size; i++) {
			this.pop();
		}
	}

	/**
	 * searches for a deck with the given title
	 * 
	 * @param title title of the deck being searched for
	 * @return the deck with that title
	 */
	public static DeckOfCards searchTitle(String title) {
		for (int i = 0; i < allDecksOfCards.size(); i++) {
			if (allDecksOfCards.get(i).getTitle().equals(title)) {
				return allDecksOfCards.get(i);
			}
		}

		return null;
	}

	/**
	 * removes unwanted deck 
	 * 
	 * @param deleteThis deck to be removed
	 */
	public static void deleteDeck(DeckOfCards deleteThis){
		int index = -1;
		for(int i = 0; i < getDeckTitles().length; i++){
			if(getDeckTitles()[i].equals(deleteThis.getTitle())){
				index = i;
			}
		}

		allDecksOfCards.remove(index);		
	}
	
	
	/**
	 * finds and returns the card at a given index in specific deck
	 * 
	 * @param deck  deck of cards being traversed through
	 * @param index index of card in the deck
	 * @return card at the given index
	 */
	public static Flashcard cardAt(DeckOfCards deck, int index) {
		DeckOfCards temp = deck;

			return temp.getCards().get(index-1);
	}
	
	/**
	 * displays the next card onto screen
	 * 
	 * @param card  card being displayed
	 * @param front JLabel that displays the front text
	 * @param back  JLabel that displays the back text
	 */
	public static void displayCard(Flashcard card, JLabel front, JLabel back) {

		front.setText("<html> <center> " + card.getFrontText() + "</center> </html>");
		back.setText("<html> <center> " + card.getBackText()+ "</center> </html>");

	}
	
	/**
	 * displays only front of card
	 * @param card
	 * @param front
	 */
	public static void displayCard(Flashcard card, JLabel front) {

		front.setText("<html> <center> " +card.getFrontText()+ "</center> </html>");

	}
	

	/**
	 * loads deck onto display
	 * 
	 * @param deck  deck of card being used
	 * @param front JLabel that displays front text
	 * @param back  JLabel that displays back text
	 */
	public static void loadDeck(DeckOfCards deck, JLabel front, JLabel back) {
		front.setText("<html> <center>  Deck: " + deck.getTitle()+ "</center> </html>");
		back.setText("<html> <center> Size: " + deck.getSize()+ "</center> </html>");
	}

	public int getSize() {
		return size;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	/**
	 * creates an array of all deck titles
	 * 
	 * @return array with titles of all decks
	 */
	public static String[] getDeckTitles() {
		String[] titles = new String[allDecksOfCards.size()];
		for (int i = 0; i < allDecksOfCards.size(); i++) {
			titles[i] = allDecksOfCards.get(i).getTitle();
		}
		return titles;
	}

	/**
	 * 
	 * @param newTitle the title user wants to set
	 * @return true if title already in use
	 */
	public static boolean titleExists(String newTitle){
		String check = newTitle.trim();
		String[] titles = getDeckTitles();
		for(int i = 0; i < titles.length; i++){
			if(titles[i].equals(check)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * shuffles existing deck of card
	 * @param deck deck of card that gets shuffled
	 * @return shuffled deck
	 */
	public static DeckOfCards shuffleDeck(DeckOfCards deck) {
		DeckOfCards temp = new DeckOfCards();
		ArrayList<Flashcard> copy = deck.getCards();
		ArrayList<Flashcard> shuffled = new ArrayList<Flashcard>();
		Random rand = new Random();
		while(copy.size()>0) {
			int index = rand.nextInt(copy.size());
			shuffled.add(copy.get(index));
			copy.remove(index);	
		}
		
		for(int i = 0; i < shuffled.size(); i++) {
			temp.push(shuffled.get(i));
		}
		
		temp.setCards(shuffled);
		
		return temp;
	}

	
	
	public ArrayList<Flashcard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Flashcard> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "DeckOfCards [title=" + title + ", top=" + top + ", size=" + size + ", cards=" + cards + "]";
	}

}
