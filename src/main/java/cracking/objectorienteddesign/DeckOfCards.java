package cracking.objectorienteddesign;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
  public enum Suit {
    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);
    private int value;

    private Suit(int v) {
      value = v;
    }

    public int getValue() {
      return value;
    }

    public static Suit getSuitFromValue(int value) {
      return null;
    }
  }

  public class Deck<T extends Card> {
    private List<T> cards; // all cards, dealt or not
    private int dealtlndex = 0; // marks first undealt card

    public void setDeckOfCards(List<T> deckOfCards) {}

    public void shuffle() {}

    public int remainingCards() {
      return cards.size() - dealtlndex;
    }

    public T[] dealHand(int number) {
      return null;
    }

    public T dealCard() {
      return null;
    }
  }

  public abstract class Card {
    private boolean available = true;

    /* number or face that's on card - a number 2 through 10, or 11 for Jack, 12 for
     * Queen, 13 for King, or 1 for Ace */
    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s) {
      faceValue = c;
      suit = s;
    }

    public abstract int value();

    public Suit suit() {
      return suit;
    }

    /* Checks if the card is available to be given out to someone */
    public boolean isAvailable() {
      return available;
    }

    public void markUnavailable() {
      available = false;
    }

    public void markAvailable() {
      available = true;
    }
  }

  public class Hand<T extends Card> {
    protected List<T> cards = new ArrayList<T>();

    public int score() {
      int score = 0;
      for (T card : cards) score += card.value();
      return score;
    }

    public void addCard(T card) {
      cards.add(card);
    }
  }

  public class BlackJackHand extends Hand<BlackJackCard> {
    /* There are multiple possible scores for a blackjack hand, since aces have
     * multiple values. Return the highest possible score that's under 21, or the
     * lowest score that's over. */
    public int score() {
      List<Integer> scores = possibleScores();
      int maxUnder = Integer.MIN_VALUE;
      int minOver = Integer.MAX_VALUE;
      for (int score : scores) {
        if (score > 21 && score < minOver) minOver = score;
        else if (score <= 21 && score > maxUnder) maxUnder = score;
      }
      return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    /* return a list of all possible scores this hand could have (evaluating each
     * ace as both 1 and 11 */
    private List<Integer> possibleScores() {
      return null;
    }

    public boolean busted() {
      return score() > 21;
    }

    public boolean is21() {
      return score() == 21;
    }

    public boolean isBlackJack() {
      return false;
    }
  }

  public class BlackJackCard extends Card {
    public BlackJackCard(int c, Suit s) {
      super(c, s);
    }

    public int value() {
      if (isAce()) return 1;
      else if (faceValue >= 11 && faceValue <= 13) return 10;
      else return faceValue;
    }

    public int minValue() {
      if (isAce()) return 1;
      else return value();
    }

    public int maxValue() {
      if (isAce()) return 11;
      else return value();
    }

    public boolean isAce() {
      return faceValue == 1;
    }

    public boolean isFaceCard() {
      return faceValue >= 11 && faceValue <= 13;
    }
  }
}
