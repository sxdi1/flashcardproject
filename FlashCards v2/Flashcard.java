
/**
 * The Flashcard class creates a flashcard object The flashcards can be used to
 * learn from
 * 
 * @author Sadiksha Dahal
 *
 */
public class Flashcard {

	private String frontText, backText;

	/**
	 * Creates flash card object
	 * 
	 * @param frontText text on the front side of the card
	 * @param backText  text on the back side of the card
	 */
	public Flashcard(String frontText, String backText) {
		this.frontText = frontText;
		this.backText = backText;
	}

	public String getFrontText() {
		return frontText;
	}

	public void setFrontText(String frontText) {
		this.frontText = frontText;
	}

	public String getBackText() {
		return backText;
	}

	public void setBackText(String backText) {
		this.backText = backText;
	}

	public String toString() {
		return "front text: " + getFrontText() + " backText: " + getBackText();

	}

}
