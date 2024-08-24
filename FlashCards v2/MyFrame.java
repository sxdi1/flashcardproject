
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class MyFrame extends JFrame {

	private JPanel contentPane;

	DeckOfCards deck = new DeckOfCards();

	DeckOfCards currentDeck;
	int cardCounter = 1;
	int hintCounter = 0;

	int corr = 0;
	int incorr = 0;
	int attempts = 0;

	ArrayList<String> deckTitles = new ArrayList<String>();

	ImageIcon image = new ImageIcon("./imgs/logo-flashcard.png");
	ImageIcon icon = new ImageIcon("./imgs/icon-flashcard.png");

	//private MyFrame frame;

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setTitle("Flashcards!");
		setResizable(false);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField userAnswer;
		JTextField deckTitle;
		JTextField frontText;
		JTextField backText;

		JPanel instrPanel = new JPanel();
		instrPanel.setBorder(null);
		instrPanel.setBackground(new Color(185,148,112));
		instrPanel.setBounds(0, 0, 1184, 761);
		contentPane.add(instrPanel);
		instrPanel.setLayout(null);

		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(new Color(115,144,114));
		gamePanel.setBounds(0, 0, 1184, 761);
		contentPane.add(gamePanel);
		gamePanel.setLayout(null);

		JPanel titlePage = new JPanel();
		titlePage.setBackground(new Color(176, 196, 222));
		titlePage.setBounds(0, 0, 1184, 761);
		contentPane.add(titlePage);
		titlePage.setLayout(null);
		titlePage.setVisible(false);

		JPanel titlePanel = new JPanel();
		titlePanel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titlePanel.setBackground(new Color(70, 130, 180));
		titlePanel.setBounds(0, 0, 1184, 761);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(185,148,112));
		menuPanel.setBounds(0, 0, 1184, 761);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);

		JPanel createPanel = new JPanel();
		createPanel.setBackground(new Color(58,77,57));
		createPanel.setBounds(0, 0, 1184, 761);
		contentPane.add(createPanel);
		createPanel.setLayout(null);

		JPanel addCardPanel = new JPanel();
		addCardPanel.setBorder(new LineBorder(new Color(79,111,82), 10, false));
		addCardPanel.setBackground(new Color(125,154,114));
		addCardPanel.setBounds(37, 280, 644, 369);
		createPanel.add(addCardPanel);
		addCardPanel.setLayout(null);
		addCardPanel.setVisible(false);

		JPanel previewPanel = new JPanel();
		previewPanel.setBorder(new LineBorder(new Color(79,111,82), 8, false));
		previewPanel.setBackground(new Color(125,154,114));
		previewPanel.setBounds(709, 280, 442, 369);
		createPanel.add(previewPanel);
		previewPanel.setLayout(null);
		previewPanel.setVisible(false);

		JPanel usePanel = new JPanel();
		usePanel.setBackground(new Color(133,163,137));
		usePanel.setBounds(0, 0, 1184, 761);
		contentPane.add(usePanel);
		usePanel.setLayout(null);

		JPanel cardPreviewPanel = new JPanel();
		cardPreviewPanel.setBorder(new MatteBorder(5, 3, 5, 3, (Color) new Color(255, 160, 122)));
		cardPreviewPanel.setBackground(new Color(255, 228, 181));
		cardPreviewPanel.setBounds(390, 230, 345, 322);
		usePanel.add(cardPreviewPanel);
		cardPreviewPanel.setLayout(new CardLayout(0, 0));

		JLabel instrTitle = new JLabel("Why use flashcards?");
		instrTitle.setBorder(new LineBorder(new Color(255, 222, 173), 3));
		instrTitle.setBackground(new Color(254,240,224));
		instrTitle.setOpaque(true);
		instrTitle.setHorizontalAlignment(SwingConstants.CENTER);
		instrTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
		instrTitle.setBounds(428, 23, 324, 68);
		instrPanel.add(instrTitle);

		JButton instrReturn = new JButton("return to main menu");
		instrReturn.setBackground(new Color(250, 240, 230));
		instrReturn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		instrReturn.setBorder(new EmptyBorder(0, 0, 0, 0));
		instrReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instrPanel.setVisible(false);
				menuPanel.setVisible(true);
			}
		});
		instrReturn.setBounds(58, 36, 155, 48);
		instrPanel.add(instrReturn);

		JLabel point1 = new JLabel(
				"<html> <center> Flashcards engage active recall!\r\nLooking at the front side of a flashcard and thinking of the causes you to remember a concept instead of rereading notes or a textbook! Flashcards facilitate repetition and help you memorize. \r\n\r\n<br>\r\n<br>\r\nFlashcards make you gather information from your memory<br>\n</br> and correlates two ideas together. </center> </html>");
		point1.setHorizontalAlignment(SwingConstants.CENTER);
		point1.setHorizontalTextPosition(SwingConstants.CENTER);
		point1.setAlignmentX(Component.CENTER_ALIGNMENT);
		point1.setBorder(new LineBorder(new Color(245, 222, 179), 5));
		point1.setOpaque(true);
		point1.setBackground(new Color(254,240,224));
		point1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		point1.setBounds(607, 187, 550, 199);
		instrPanel.add(point1);

		JLabel lblFlashcardsEngageActive = new JLabel(
				"<html> <center>\r\n Flashcards engage metacognition! Comparing your answers to the ones on the flashcards causes you to self reflect and asses your own answer. Metacognitive strategies ingrain memories deeper into your knowledge and allows you to focus on your weaknesses, plan your studies better, and more accurately judge how well you know the material! \r\n<br>\r\n\r\nFlashcards also allow for confidence based repetition as you are in control of how often and for how long you study.\r\n\r\n<br>\r\n<br>\r\nFlashcards make you gather information from your memory and correlates two ideas together. </center> </html>");
		lblFlashcardsEngageActive.setOpaque(true);
		lblFlashcardsEngageActive.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFlashcardsEngageActive.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlashcardsEngageActive.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFlashcardsEngageActive.setBorder(new LineBorder(new Color(245, 222, 179), 5));
		lblFlashcardsEngageActive.setBackground(new Color(254,240,224));
		lblFlashcardsEngageActive.setAlignmentX(0.5f);
		lblFlashcardsEngageActive.setBounds(30, 111, 567, 275);
		instrPanel.add(lblFlashcardsEngageActive);

		JLabel point2 = new JLabel("<html> <center> Using a digital version saves paper and ink!  </center> </html>");
		point2.setOpaque(true);
		point2.setHorizontalTextPosition(SwingConstants.CENTER);
		point2.setHorizontalAlignment(SwingConstants.CENTER);
		point2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		point2.setBorder(new LineBorder(new Color(245, 222, 179), 5));
		point2.setBackground(new Color(254,240,224));
		point2.setAlignmentX(0.5f);
		point2.setBounds(607, 112, 550, 64);
		instrPanel.add(point2);

		JLabel howTo1 = new JLabel(
				"<html> <center>\r\n\r\nstart by creating a new deck! <br>\r\nIn the main menu, select create deck and follow these steps: <br>\r\n1. enter the title of your deck in the textfield and hit submit (note: try to use a unique name for each of your flashcards) <br>\r\n2. After submitting the title you will be able to enter front and back text for your cards, <br>\r\ndo this for as many of your cards then hit completed deck! <br>\r\n**important: decks will not save if you close program here, you have to hit completed deck. <br>\r\n\r\n </center> </html>");
		howTo1.setOpaque(true);
		howTo1.setHorizontalTextPosition(SwingConstants.CENTER);
		howTo1.setHorizontalAlignment(SwingConstants.CENTER);
		howTo1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		howTo1.setBorder(new LineBorder(new Color(255, 228, 181), 5));
		howTo1.setBackground(new Color(254,240,224));
		howTo1.setAlignmentX(0.5f);
		howTo1.setBounds(30, 470, 545, 270);
		instrPanel.add(howTo1);

		JLabel howToUse = new JLabel("<html> <center> How to use this software? </center> </html>");
		howToUse.setOpaque(true);
		howToUse.setHorizontalTextPosition(SwingConstants.CENTER);
		howToUse.setHorizontalAlignment(SwingConstants.CENTER);
		howToUse.setFont(new Font("Segoe UI", Font.BOLD, 16));
		howToUse.setBorder(new LineBorder(new Color(245, 222, 179), 5));
		howToUse.setBackground(new Color(254,240,224));
		howToUse.setAlignmentX(0.5f);
		howToUse.setBounds(30, 400, 1129, 59);
		instrPanel.add(howToUse);

		JLabel HowTo2 = new JLabel(
				"<html> <center>\r\nhow to use the deck(s): <br>\r\nclick on the use option in the main menu  <br>\r\nselect the tutorial deck flashcard from the options <br>\r\nfollow the tutorial, or just play around with the program! <br>\r\n\r\nlearning game: <br>\r\nclicking learning game will take you to a screen that tests your knowledge on the current selected deck.  <br>\r\nyou'll be shown the front side of the flashcard and asked to enter the back <br>\r\nthere are hints if you get stuck!  <br>\r\nadditionally you can look at your score and see if you've improved from previous attempts!\r\n\r\n\r\n </center> </html>");
		HowTo2.setOpaque(true);
		HowTo2.setHorizontalTextPosition(SwingConstants.CENTER);
		HowTo2.setHorizontalAlignment(SwingConstants.CENTER);
		HowTo2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		HowTo2.setBorder(new LineBorder(new Color(255, 228, 181), 5));
		HowTo2.setBackground(new Color(254,240,224));
		HowTo2.setAlignmentX(0.5f);
		HowTo2.setBounds(597, 470, 562, 270);
		instrPanel.add(HowTo2);
		instrPanel.setVisible(false);

		JLabel deckPrompt = new JLabel("front side");
		deckPrompt.setBackground(new Color(255, 239, 213));
		deckPrompt.setOpaque(true);
		deckPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		deckPrompt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		deckPrompt.setBounds(183, 230, 503, 260);
		gamePanel.add(deckPrompt);

		userAnswer = new JTextField();
		userAnswer.setBackground(new Color(250, 235, 215));
		userAnswer.setBounds(183, 562, 866, 60);
		gamePanel.add(userAnswer);
		userAnswer.setColumns(10);
		userAnswer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userAnswer.setText("");
			}
		});

		JLabel numAttempts = new JLabel(" Number of total tries:");
		numAttempts.setBackground(new Color(250, 235, 215));
		numAttempts.setOpaque(true);
		numAttempts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		numAttempts.setBounds(831, 230, 218, 51);
		gamePanel.add(numAttempts);

		JLabel numCorr = new JLabel("  Total correct: ");
		numCorr.setForeground(new Color(0, 100, 0));
		numCorr.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		numCorr.setOpaque(true);
		numCorr.setBackground(new Color(250, 235, 215));
		numCorr.setBounds(831, 338, 218, 45);
		gamePanel.add(numCorr);

		JLabel numIncorr = new JLabel("  Total incorrect: ");
		numIncorr.setForeground(new Color(128, 0, 0));
		numIncorr.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		numIncorr.setBackground(new Color(250, 235, 215));
		numIncorr.setOpaque(true);
		numIncorr.setBounds(831, 439, 218, 45);
		gamePanel.add(numIncorr);
		gamePanel.setVisible(false);

		JLabel displayHint = new JLabel("hint");
		displayHint.setFont(new Font("Monospaced", Font.PLAIN, 14));
		displayHint.setVerticalAlignment(SwingConstants.TOP);
		displayHint.setBounds(183, 500, 866, 51);
		gamePanel.add(displayHint);

		JButton checkAnswer = new JButton("check answer");
		checkAnswer.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		checkAnswer.setBackground(new Color(250, 240, 230));
		checkAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String answer = userAnswer.getText();
				String correct = DeckOfCards.cardAt(currentDeck, cardCounter).getBackText();
				if (answer.equalsIgnoreCase(correct)) {
					corr++;
					attempts++;
					numCorr.setText("  Total Correct: " + String.valueOf(corr));
					numIncorr.setText("  Total Incorrect: " + String.valueOf(incorr));
					numAttempts.setText("  Total Attempted: " + String.valueOf(attempts));

					hintCounter = 0;
					displayHint.setText("");

					if (cardCounter < currentDeck.getSize())
					cardCounter++;
					else {
						int response = JOptionPane.showConfirmDialog(null, "Would you like to repeat deck?",
								"End of deck reached.", JOptionPane.YES_NO_OPTION);
						if (response == JOptionPane.YES_OPTION) {
							cardCounter = 1;
						} else {
							gamePanel.setVisible(false);
							usePanel.setVisible(true);
						}
				}

				DeckOfCards.displayCard(DeckOfCards.cardAt(currentDeck, cardCounter), deckPrompt);
					

				} else {
					incorr++;
					attempts++;
					numCorr.setText("  Total Correct: " + String.valueOf(corr));
					numIncorr.setText("  Total Incorrect: " + String.valueOf(incorr));
					numAttempts.setText("  Total Attempted: " + String.valueOf(attempts));
				}

				
			}
		});
		checkAnswer.setBounds(561, 646, 125, 53);
		gamePanel.add(checkAnswer);

		JLabel gameTitle = new JLabel("Learning Game!");
		gameTitle.setBackground(new Color(250, 235, 215));
		gameTitle.setOpaque(true);
		gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		gameTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
		gameTitle.setBounds(183, 50, 857, 65);
		gamePanel.add(gameTitle);

		JLabel miniDesc = new JLabel(
				"<html> You'll be shown the front side of a flashcard. Use your memory and knowledge to enter the text on the back. \r\n<br>\r\n<center> \r\nNOTE: spaces do matter, capitals do not.  </center>\r\n\r\n</html>");
		miniDesc.setHorizontalAlignment(SwingConstants.CENTER);
		miniDesc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		miniDesc.setForeground(new Color(250, 235, 215));
		miniDesc.setBounds(183, 126, 857, 45);
		gamePanel.add(miniDesc);

		

		JButton next = new JButton("next card");
		next.setBackground(new Color(250, 240, 230));
		next.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintCounter = 0;
				displayHint.setText("");

				if (cardCounter < currentDeck.getSize())
					cardCounter++;
				else {
					int response = JOptionPane.showConfirmDialog(null, "Would you like to repeat deck?",
							"End of deck reached.", JOptionPane.YES_NO_OPTION);
					if (response == JOptionPane.YES_OPTION) {
						cardCounter = 1;
					} else {
						gamePanel.setVisible(false);
						usePanel.setVisible(true);
					}
				}

				DeckOfCards.displayCard(DeckOfCards.cardAt(currentDeck, cardCounter), deckPrompt);
			}
		});
		next.setBounds(183, 647, 340, 51);
		gamePanel.add(next);

		JButton gameReturn = new JButton("return to deck options");
		gameReturn.setBackground(new Color(250, 240, 230));
		gameReturn.setBorder(new CompoundBorder());
		gameReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePanel.setVisible(false);
				hintCounter = 0;
				displayHint.setText("");
				usePanel.setVisible(true);
			}
		});
		gameReturn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		gameReturn.setBounds(949, 722, 179, 28);
		gamePanel.add(gameReturn);

		JButton reqHint = new JButton("display hint");
		reqHint.setBackground(new Color(250, 240, 230));
		reqHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hintCounter < DeckOfCards.cardAt(currentDeck, cardCounter).getBackText().length() - 1) {
					hintCounter++;
					displayHint.setText("<html> <center> "
							+ DeckOfCards.cardAt(currentDeck, cardCounter).getBackText().substring(0, hintCounter - 1)
							+ "</center> </html>");
				} else {
					if(DeckOfCards.cardAt(currentDeck, cardCounter).getBackText().length() - 1 < 1){
						displayHint.setText(("<html> <center> Hint is unavailable for this question. </center> </html>"));
					}
					displayHint.setText("<html> <center> Hints have been maxed out. </center> </html>");
				}
			}
		});
		reqHint.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		reqHint.setBounds(714, 646, 146, 53);
		gamePanel.add(reqHint);

		JLabel titleImage = new JLabel("");
		titleImage.setBounds(304, 90, 684, 462);
		titleImage.setHorizontalAlignment(SwingConstants.CENTER);
		titleImage.setIcon(image);
		titlePanel.add(titleImage);

		JLabel titleText = new JLabel("the ultimate study tool!");
		titleText.setBounds(480, 526, 316, 66);
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setFont(new Font("Calibri Light", Font.BOLD, 20));
		titlePanel.add(titleText);

		JButton exit = new JButton("exit program!");
		exit.setBackground(new Color(254,240,224));
		exit.setBorder(null);
		exit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {		

				System.exit(0);
				} else {

				}
			}
		});
		exit.setBounds(632, 395, 485, 327);
		menuPanel.add(exit);
		menuPanel.setVisible(false);

		JLabel deckTitlePrompt = new JLabel("  Please enter the title of your new flashcard deck:");
		deckTitlePrompt.setBorder(new LineBorder(new Color(79,111,82), 3));
		deckTitlePrompt.setBackground(new Color(125,154,114));
		deckTitlePrompt.setOpaque(true);
		deckTitlePrompt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		deckTitlePrompt.setBounds(37, 179, 403, 47);
		createPanel.add(deckTitlePrompt);

		JLabel createTitle = new JLabel("  Create A New FlashCard Deck!");
		createTitle.setBorder(new LineBorder(new Color(79,111,82), 5));
		createTitle.setBackground(new Color(125,154,114));
		createTitle.setOpaque(true);
		createTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
		createTitle.setBounds(420, 49, 401, 84);
		createPanel.add(createTitle);

		deckTitle = new JTextField();
		deckTitle.setBorder(new LineBorder(Color.GRAY));
		deckTitle.setBackground(new Color(250, 240, 230));
		deckTitle.setHorizontalAlignment(SwingConstants.CENTER);
		deckTitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		deckTitle.setForeground(new Color(102, 102, 102));
		deckTitle.setBounds(467, 181, 518, 47);
		createPanel.add(deckTitle);
		deckTitle.setColumns(10);
		deckTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deckTitle.setText("");
			}
		});

		JLabel frontTextPrompt = new JLabel("Enter front text: ");
		frontTextPrompt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		frontTextPrompt.setBounds(72, 34, 146, 38);
		addCardPanel.add(frontTextPrompt);

		JLabel backTextPrompt = new JLabel("Enter back text: ");
		backTextPrompt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		backTextPrompt.setBounds(72, 164, 146, 30);
		addCardPanel.add(backTextPrompt);

		frontText = new JTextField();
		frontText.setBounds(72, 72, 539, 73);
		addCardPanel.add(frontText);
		frontText.setColumns(10);

		backText = new JTextField();
		backText.setColumns(10);
		backText.setBounds(72, 199, 539, 90);
		addCardPanel.add(backText);

		JLabel frontPreview = new JLabel("<html> front text preview </html>");
		frontPreview.setForeground(new Color(0, 0, 0));
		frontPreview.setOpaque(true);
		frontPreview.setHorizontalAlignment(SwingConstants.CENTER);
		frontPreview.setFont(new Font("Ink Free", Font.BOLD, 17));
		frontPreview.setBackground(new Color(255, 255, 255));
		frontPreview.setBounds(22, 18, 401, 159);
		previewPanel.add(frontPreview);

		JLabel backPreview = new JLabel("back text preview");
		backPreview.setOpaque(true);
		backPreview.setHorizontalAlignment(SwingConstants.CENTER);
		backPreview.setForeground(Color.BLACK);
		backPreview.setFont(new Font("Ink Free", Font.BOLD, 17));
		backPreview.setBackground(Color.WHITE);
		backPreview.setBounds(25, 192, 401, 159);
		previewPanel.add(backPreview);

		JButton submitTitle = new JButton("Submit Title");
		submitTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		submitTitle.setBackground(new Color(250, 240, 230));
		submitTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deck.emptyDeck();
				String titleOfDeck = deckTitle.getText();
				deck.setTitle(titleOfDeck);
				if (titleOfDeck.equals("") || titleOfDeck == null) {
					JOptionPane.showMessageDialog(null, "title of deck cannot be empty", "Error: Empty Title",
							JOptionPane.INFORMATION_MESSAGE);
					addCardPanel.setVisible(false);
					previewPanel.setVisible(false);
				} else if(DeckOfCards.titleExists(titleOfDeck)){
					JOptionPane.showMessageDialog(null, "title of deck is already in use. select different name.", "Error: Existing Title",
							JOptionPane.INFORMATION_MESSAGE);
					addCardPanel.setVisible(false);
					previewPanel.setVisible(false);
				}
				
				else {
					deckTitles.add(titleOfDeck);
					addCardPanel.setVisible(true);
					submitTitle.setEnabled(false);
					previewPanel.setVisible(true);
				}

				deckTitle.setText("");
			}
		});
		submitTitle.setBounds(1024, 181, 127, 47);
		createPanel.add(submitTitle);

		JButton createReturn = new JButton("cancel / return to main menu");
		createReturn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		createReturn.setBackground(new Color(250, 240, 230));
		createReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createPanel.setVisible(false);
				menuPanel.setVisible(true);
				addCardPanel.setVisible(false);
				previewPanel.setVisible(false);

				if (createReturn.getText().equals("completed deck")) {
					ReadAndWrite.writeDeck(deck);
					addCardPanel.setVisible(false);
					previewPanel.setVisible(false);
					createReturn.setText("cancel / return to main menu");
				}
			}
		});
		createReturn.setBounds(436, 684, 363, 39);
		createPanel.add(createReturn);

		JButton addCard = new JButton("Add Card");
		addCard.setBackground(new Color(250, 240, 230));
		addCard.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		addCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardFront = frontText.getText();
				String cardBack = backText.getText();

				if (cardBack.equals("") || cardFront.equals("")) {
					JOptionPane.showMessageDialog(null, "front or back cant be empty", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					frontPreview.setText("<html> <center>  " + cardFront + "</center> </html>");
					backPreview.setText("<html> <center>  " + cardBack + "</center> </html>");
					frontText.setText("");
					backText.setText("");
					Flashcard card = new Flashcard(cardFront, cardBack);
					deck.push(card);
					createReturn.setText("completed deck");
				}

			}
		});
		addCard.setBounds(278, 301, 95, 38);
		addCardPanel.add(addCard);
		createPanel.setVisible(false);
		createPanel.setVisible(false);


		JButton startButton = new JButton("start!");
		startButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		startButton.setBackground(new Color(250, 240, 230));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titlePanel.setVisible(false);
				menuPanel.setVisible(true);
				createPanel.setVisible(false);
			}
		});
		startButton.setBounds(560, 601, 120, 40);
		titlePanel.add(startButton);

		JLabel useTitle = new JLabel("Use a deck!");
		useTitle.setHorizontalAlignment(SwingConstants.CENTER);
		useTitle.setFont(new Font("Calibri", Font.BOLD, 26));
		useTitle.setBounds(441, 52, 224, 65);
		usePanel.add(useTitle);

		JLabel names = new JLabel("");
		names.setVerticalAlignment(SwingConstants.TOP);
		names.setFont(new Font("Tahoma", Font.PLAIN, 14));
		names.setBounds(41, 128, 652, 65);
		usePanel.add(names);
		usePanel.setVisible(false);

		JComboBox<String> deckOptions = new JComboBox<String>();
		deckOptions.setBackground(Color.WHITE);

		JLabel frontOfCard = new JLabel("front");
		frontOfCard.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frontOfCard.setHorizontalAlignment(SwingConstants.CENTER);
		cardPreviewPanel.add(frontOfCard, "name_186966115190700");
	

		JLabel backOfCard = new JLabel("back");
		backOfCard.setFont(new Font("Segoe UI", Font.BOLD, 16));
		backOfCard.setHorizontalAlignment(SwingConstants.CENTER);
		cardPreviewPanel.add(backOfCard, "name_186997108968200");
		backOfCard.setVisible(false);

		JButton flipCard = new JButton("flip card");
		flipCard.setBackground(new Color(250, 240, 230));
		flipCard.setFont(new Font("Segoe UI", Font.BOLD, 12));
		flipCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frontOfCard.isVisible()) {
					frontOfCard.setVisible(false);
					backOfCard.setVisible(true);
				} else {
					frontOfCard.setVisible(true);
					backOfCard.setVisible(false);
				}
			}
		});
		flipCard.setBounds(511, 575, 101, 34);
		usePanel.add(flipCard);

		JButton useReturn = new JButton("return to main menu");
		useReturn.setBackground(new Color(250, 240, 230));
		useReturn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		useReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usePanel.setVisible(false);
				menuPanel.setVisible(true);
				ReadAndWrite.clearFile();
				ReadAndWrite.writeAllDecks();
				deckOptions.removeAllItems();

			}
		});
		useReturn.setBounds(20, 722, 179, 28);
		usePanel.add(useReturn);

		JButton nextCard = new JButton("next card");
		nextCard.setBackground(new Color(250, 240, 230));
		nextCard.setFont(new Font("Segoe UI", Font.BOLD, 12));
		nextCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontOfCard.setVisible(true);
				backOfCard.setVisible(false);

				if (cardCounter < currentDeck.getSize())
					cardCounter++;
				else
					cardCounter = 1;

				DeckOfCards.displayCard(DeckOfCards.cardAt(currentDeck, cardCounter), frontOfCard, backOfCard);
			}
		});
		nextCard.setBounds(634, 575, 101, 34);
		nextCard.setEnabled(false);
		usePanel.add(nextCard);

		JButton prevCard = new JButton("prev card");
		prevCard.setBackground(new Color(250, 240, 230));
		prevCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontOfCard.setVisible(true);
				backOfCard.setVisible(false);

				if (cardCounter > 1) {
					cardCounter--;
				} else {
					cardCounter = currentDeck.getSize();
				}

				DeckOfCards.displayCard(DeckOfCards.cardAt(currentDeck, cardCounter), frontOfCard, backOfCard);

			}
		});
		prevCard.setFont(new Font("Segoe UI", Font.BOLD, 12));
		prevCard.setEnabled(false);
		prevCard.setBounds(390, 575, 101, 34);
		usePanel.add(prevCard);

		JButton shuffleDeck = new JButton("shuffle deck");
		shuffleDeck.setBackground(new Color(250, 240, 230));
		shuffleDeck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDeck = DeckOfCards.shuffleDeck(currentDeck);
				DeckOfCards.displayCard(DeckOfCards.cardAt(currentDeck, cardCounter + 1), frontOfCard, backOfCard);
			}
		});
		shuffleDeck.setFont(new Font("Segoe UI", Font.BOLD, 12));
		shuffleDeck.setEnabled(false);
		shuffleDeck.setBounds(20, 230, 151, 34);
		usePanel.add(shuffleDeck);

		JButton matchingGame = new JButton("learning game");
		matchingGame.setBackground(new Color(250, 240, 230));
		matchingGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardCounter = 1;
				corr = 0;
				incorr = 0;
				attempts = 0;
				numCorr.setText("  Total Correct: " + String.valueOf(corr));
				numIncorr.setText("  Total Incorrect: " + String.valueOf(incorr));
				numAttempts.setText("  Total Attempted: " + String.valueOf(attempts));
				gamePanel.setVisible(true);
				usePanel.setVisible(false);
				DeckOfCards.displayCard(DeckOfCards.cardAt(currentDeck, cardCounter), deckPrompt);

			}
		});
		matchingGame.setFont(new Font("Segoe UI", Font.BOLD, 12));
		matchingGame.setEnabled(false);
		matchingGame.setBounds(20, 283, 151, 34);
		usePanel.add(matchingGame);
		usePanel.setVisible(false);

		JButton howTo = new JButton("why flashcards?");
		howTo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		howTo.setBackground(new Color(254,240,224));
		howTo.setBorder(null);
		howTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				instrPanel.setVisible(true);
			}
		});

		howTo.setBounds(59, 395, 485, 327);
		menuPanel.add(howTo);
		JButton create = new JButton("create new deck");
		create.setBorder(null);
		create.setBackground(new Color(254,240,224));
		create.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				createPanel.setVisible(true);
				submitTitle.setEnabled(true);
			}
		});
		create.setBounds(59, 39, 485, 327);
		menuPanel.add(create);


		JButton deleteDeck = new JButton("Delete selected deck");
		deleteDeck.setBackground(new Color(250, 240, 230));
		deleteDeck.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		deleteDeck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this deck?", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {		
					String currTitle = currentDeck.getTitle();
					if(currTitle.equals("Tutorial Deck")){
						JOptionPane.showMessageDialog(null,  currTitle + " is not allowed to be removed.", "Unsuccesful removal",
							JOptionPane.INFORMATION_MESSAGE);
					} else {
					DeckOfCards.deleteDeck(currentDeck);
					deckOptions.removeItem(currentDeck.getTitle());
					JOptionPane.showMessageDialog(null,  currTitle + " was removed.", "Succesfully removed",
							JOptionPane.INFORMATION_MESSAGE);}
				} else {
				}

			}
		});
		deleteDeck.setBounds(33, 65, 190, 34);
		usePanel.add(deleteDeck);
		deleteDeck.setEnabled(false);

		
		deckOptions.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		deckOptions.setBounds(913, 61, 190, 44);
		deckOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeckOfCards.tempDeck = null;
				deckOptions.setEnabled(false);
				deckOptions.setEnabled(true);

				String selected = (String) deckOptions.getSelectedItem();
				if (selected!=null && !selected.equals("Select here: ")) {
					nextCard.setEnabled(true);
					prevCard.setEnabled(true);
					shuffleDeck.setEnabled(true);
					matchingGame.setEnabled(true);
					deleteDeck.setEnabled(true);

					String selectedDeck = selected;
					currentDeck = DeckOfCards.searchTitle(selectedDeck);
					DeckOfCards.loadDeck(currentDeck, frontOfCard, backOfCard);
					cardCounter = 0;

				} else {
					nextCard.setEnabled(false);
					prevCard.setEnabled(false);
					shuffleDeck.setEnabled(false);
					matchingGame.setEnabled(false);
					deleteDeck.setEnabled(false);

					

				}

			}

		});

		usePanel.add(deckOptions);
		
		JButton use = new JButton("use a deck");
		use.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		use.setBackground(new Color(254,240,224));
		use.setBorder(null);
		use.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usePanel.setVisible(true);
				menuPanel.setVisible(false);
				ReadAndWrite.createDecks();
				names.setText("");
				String[] deckTitles = DeckOfCards.getDeckTitles();
				deckOptions.addItem("Select here: ");
				for (int i = 0; i < deckTitles.length; i++) {
					deckOptions.addItem(String.valueOf(deckTitles[i]));
				}
				
			}
		});
		use.setBounds(632, 39, 485, 327);
		menuPanel.add(use);

		menuPanel.setVisible(false);

		usePanel.setVisible(false);

	}
}
