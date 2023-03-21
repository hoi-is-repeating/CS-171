import java.util.*;

/**
 * A class that represents a card player.
 * 
 * For each card player instance, we should keep track of how many points
 * they earned in the game so far, as well as whether it is their turn or not.
 * Additionally, their hand and bank of cards should be stored in two
 * separate ArrayLists of Card objects.
 * 
 * @param <T>
 */
public class CardPlayer extends GeneralPlayer {
    /*
     * <p>
     * A player's points, turn, and hand of cards should all be declared
     * private fields, whereas the bank of cards should be public, as follows:
     */
    private int points;

    public boolean turn;

    private ArrayList<Card> hand = new ArrayList<Card>();

    public ArrayList<Card> bank = new ArrayList<Card>();

    /*
     * Note that the Field Summary section below will only show you public fields,
     * but you must declare all the fields described above in your implementation of
     * this class,
     * including the private fields. You are free to create additional fields if
     * deemed necessary.
     * 
     * @param <Card> the type of card used in the game
     */

    public CardPlayer() {
        super();
    }

    public CardPlayer(String name) {
        super.name = name;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public String bankToString() {
        String ret = "This player's bank has " + bank.size() + " cards : ";
        for (int i = 0; i < bank.size(); i++) {
            ret += bank.get(i).identifier + " ";
        }

        return ret;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public String handToString() {
        return hand.toString();
    }

    public boolean isTurn() {
        return turn;
    }

    public Card play() {
        Card top = hand.get(hand.size() - 1);
        hand.remove(hand.size() - 1);
        return top;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

}
