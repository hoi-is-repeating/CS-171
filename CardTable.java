import java.util.*;

/**
 * 
 * This class represents a table where a game is being played.
 * 
 * It implements the Table interface and is designed to work with Card and
 * CardPlayer objects.
 * 
 * <p>
 * Each table instance must keep track of the cards that players place on the
 * table
 * during the game. The number of places available has a fixed size
 * (<code>NUMBER_OF_PLACES</code>),
 * so we use a regular Java array to represent a CardTable's places field.
 * Each entry in this places array contains
 * the cards that were added to that place, which is a more dynamic structure
 * (we don't know
 * in advance how many cards will be added to this place!).
 * <p>
 * Therefore, each place
 * entry in this array will reference an ArrayList of Card objects.
 * <p>
 * Here is how to declare the array of ArrayLists field <code>places</code>:
 * 
 * <p>
 * <code>
 * 		private ArrayList&lt;Card&gt;[] places = new ArrayList[NUMBER_OF_PLACES];  
 * </code>
 * <p>
 * 
 * Note that the Field Summary section below will only show you public fields,
 * but you must declare the required field places described above, which is
 * private.
 * You are also free to create additional fields in your class implementation,
 * if deemed necessary.
 * 
 */

// TODO: Complete the implementation of class CardTable below according
// to the class documentation described here:
// https://www.cs.emory.edu/~nelsay2/cs171_s23/a2/doc/cs171a2/CardTable.html

public class CardTable implements Table { // TODO: Fix class declaration to implement Table interface
											// (see
											// documentation)

	// TODO: create all required instance variables (you can add more variables if
	// needed)
	private int turn = 0;
	private int iter = 0;
	private ArrayList<Card>[] places = new ArrayList[NUMBER_OF_PLACES];
	private ArrayList<Card> zero = new ArrayList<>();
	private ArrayList<Card> first = new ArrayList<>();
	private ArrayList<Card> second = new ArrayList<>();
	private ArrayList<Card> third = new ArrayList<>();

	// TODO: basic, no-argument constructor initializes all table
	// places to new ArrayLists of Card objects
	public CardTable() {
		places[0] = zero;
		places[1] = first;
		places[2] = second;
		places[3] = third;
	}

	// TODO: implement all required CardTable methods (you can add helper methods if
	// needed)
	public void addCardToPlace(Card card) {
		if (turn >= 4) {
			turn %= 4;
			iter++;
		}
		places[turn].add(card);
		turn++;
	}

	public int[] getPlaces() throws EmptyStackException {
		int[] id = new int[4];
		for (int i = 0; i < id.length; i++) {
			if (places[i].isEmpty())
				id[i] = -1;
			else {
				int ind = places[i].size() - 1;
				id[i] = places[i].get(ind).identifier;
			}
		}
		// if (zero.isEmpty())
		// id[0] = -1;
		// else
		// id[0] = zero.peek().identifier;
		// if (first.isEmpty())
		// id[1] = -1;
		// else
		// id[1] = first.peek().identifier;
		// if (second.isEmpty())
		// id[2] = -1;
		// else
		// id[2] = second.peek().identifier;
		// if (third.isEmpty())
		// id[3] = -1;
		// else
		// id[3] = third.peek().identifier;
		return id;
	}

	@Override
	public void checkPlaces(CardPlayer player) {
		/*
		 * 1. see player's last card
		 * 2. check table
		 * 3. find match
		 * 4. earn point
		 * 5. remove from person's hands and table, move to bank
		 * 6. end turn
		 */
		int lastPlace = 0;
		int myRank = 0;

		switch (turn) {
			case 0:
				lastPlace = 2;
				break;
			case 1:
				lastPlace = 3;
				break;
			case 2:
				lastPlace = 0;
				break;
			case 3:
				lastPlace = 1;
				break;
			default:
				break;
		}
		if (places[lastPlace].isEmpty())
			return;
		myRank = places[lastPlace].get(places[lastPlace].size() - 1).getRank();

		// switch (last) {
		// case 0:
		// myRank = zero.peek().getRank();
		// break;
		// case 1:
		// myRank = first.peek().getRank();
		// break;
		// case 2:
		// myRank = second.peek().getRank();
		// break;
		// case 3:
		// myRank = third.peek().getRank();
		// break;

		// default:
		// break;
		// }

		int cnt = 0;
		ArrayList<Integer> match = new ArrayList<>();

		for (int j = 0; j < places.length; j++) {
			if (places[j].isEmpty())
				break;
			Card lastCard = places[j].get(places[j].size() - 1);
			if (lastPlace != j) {
				if (lastCard.getRank() == myRank) {
					match.add(lastCard.identifier);
					player.bank.add(lastCard);
					places[j].remove(places[j].size() - 1);

					cnt++;
				}
			}
		}
		if (cnt > 0) {
			player.setPoints(player.getPoints() + 1);
			player.bank.add(places[lastPlace].get(places[lastPlace].size() - 1));
			match.add(places[lastPlace].get(places[lastPlace].size() - 1).identifier);
			places[lastPlace].remove(places[lastPlace].size() - 1);
			System.out.println("Matched ranks: " + match.toString());
		}
		// if (lastPlace != 0) {
		// if ((zero.peek()).getRank() == myRank) {
		// player.bank.add(zero.pop());
		// player.setPoints(player.getPoints() + 1);
		// }
		// }
		// if (lastPlace != 1)
		// if ((first.peek()).getRank() == myRank) {
		// player.bank.add((Card) places[i].pop());
		// player.setPoints(player.getPoints() + 1);
		// }
		// if ((second.peek()).getRank() == myRank) {
		// player.bank.add((Card) places[i].pop());
		// player.setPoints(player.getPoints() + 1);
		// }
		// if ((third.peek()).getRank() == myRank) {
		// player.bank.add((Card) places[i].pop());
		// player.setPoints(player.getPoints() + 1);
		// }
		player.turn = false;

	}

}
