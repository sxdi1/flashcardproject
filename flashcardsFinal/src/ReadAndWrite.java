import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * methods regarding file input output
 * 
 * @author sadi
 *
 */
public class ReadAndWrite {


	/**
	 * writes out each flashcard front and back onto new line
	 * 
	 * @param deck deck of flashcards
	 */
	static void writeDeck(DeckOfCards deck) {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("flashcard-decks", true));
			out.write(deck.getTitle());
			out.newLine();
			out.write(String.valueOf(deck.getSize()));
			out.newLine();
			while (!deck.isEmpty()) {
				Flashcard temp = deck.peek();
				out.write(temp.getFrontText());
				out.newLine();
				out.write(temp.getBackText());
				out.newLine();
				deck.pop();
			}
			out.close();
		} catch (IOException e) {
			System.out.println("Error: Could not write to file.");
			e.printStackTrace();
		}
	}

	/**
	 * reads all lines in the text file contained deck of cards 
	 * @return string array containing each line as a separate element
	 */
	static String[] readInDecks() {
		String all = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader("flashcard-decks"));
			String line = in.readLine();

			while (line != null) {
				all += line + "_break_";
				line = in.readLine();

			}
			in.close();

		} catch (IOException e) {
			
			System.out.println("Error: Problem reading file!");
			e.printStackTrace();
		}
		return all.split("_break_");
	}

	/**
	 * uses array created when reading in text file to create individual decks and pushes their cards in
	 */
	static void createDecks() {
		DeckOfCards.allDecksOfCards.clear();
		String[] allDecks = readInDecks();

		String deckTitle = null;
		int cardNums = 0;
		int pointer = 0;
		int deckSize;
		DeckOfCards deck = null;

		while (pointer < allDecks.length) {
			deckTitle = allDecks[pointer];
			cardNums = Integer.parseInt(allDecks[pointer + 1]);
			deckSize = cardNums * 2;

			deck = new DeckOfCards();
			deck.setTitle(deckTitle);
			DeckOfCards.allDecksOfCards.add(deck);

			Flashcard card = null;

			for (int cardsI = pointer + 2 + deckSize; cardsI > pointer+2; cardsI -= 2) {
				String frontText = allDecks[cardsI-2];
				String backText = allDecks[cardsI-1];

				card = new Flashcard(frontText, backText);
				deck.push(card);
				deck.getCards().add(card);

			}

			pointer += (deckSize + 2);

		}

	}

}
