/**
 * 
 */
package com.st.myprojects.main.object.oop.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.st.myprojects.main.object.oop.problems.OOPDeckOfCards.DeckOfCards.Card;

/*-
 * @author sundeeptonse
 * Design the DS for a generic deck of cards.
 * Explain how you would subclass the DS to implement BlackJack
 */
public class OOPDeckOfCards {

	public static class Player {
		int id;
		List<Card> cards;
		Table table;
		int cash;

		public void makeBet() {
		}
		public void addCardToPlayer(Card card) {
			cards.add(card);
		}
		public void clearCards() {
			cards = new ArrayList<>();
		}
	}

	public static class Dealer {
		int id;
		List<Card> cards;
		int cash;

		MultipleDeckOfCards deckOfCards = new MultipleDeckOfCards(4, null);
		Table table;

		Dealer() {
			table = new Table(this);
		}

		public void startNewGame() {
			if (!table.isEmpty()) {
				// Distribute First Card to All Players including Self
				for (Player player : table.players) {
					player.clearCards();
					player.addCardToPlayer(deckOfCards.pullCardFromDeck());
				}
			}
		}

		public void continueGame() {
			//For All Players where value is lesser than 21, check response
		}
		
		public void settleFinances(){
			
		}

	}

	public static class Table {

		int id;
		Set<Player> players = new HashSet<>();
		Dealer dealer;

		Table(Dealer dealer) {
			this.dealer = dealer;

		}

		// add Player
		// remove Player

		public void addPlayer(Player player) {
			players.add(player);
		}

		public void removePlayer(Player player) {
			players.remove(player);
		}

		public boolean isEmpty() {
			return players.size() == 0;
		}
	}

	public static class BlackJack {

	}

	public static class MultipleDeckOfCards {
		int numberOfDecks;
		List<DeckOfCards> cardDeck;

		public MultipleDeckOfCards(int numberOfDecks, Set<Card> skipCards) {
			this.numberOfDecks = numberOfDecks;
			cardDeck = new ArrayList<>(this.numberOfDecks);
			while (numberOfDecks-- > 0) {
				DeckOfCards deckOfCards = new DeckOfCards(skipCards);
				cardDeck.add(deckOfCards);
			}
		}

		public void shuffle() {

		}

		public boolean addCardToDeck() {
			return true;
		}

		public Card pullCardFromDeck() {
			return null;
		}
	}

	// Deck of 52 Cards
	// Each Deck Contains 4 Suits - hearts, clubs, spade, diamonds
	// With either 1 Number Value Associated to it or 2 (in case of A(1 or 11)).
	public static class DeckOfCards {
		List<Card> cardsList = new ArrayList<>();

		public enum Suit {
			Hearts, Clubs, Spade, Diamonds
		}

		public enum Rank {
			ACE(1, 11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(
					8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), JOKER(
					0);
			int value1;
			int value2;

			Rank(int value1) {
				this(value1, 0);
			}

			Rank(int value1, int value2) {
				this.value1 = value1;
				this.value2 = value2;
			}
		}

		// Deal a Random Card
		// Shuffle Deck
		public static class Card {
			private Suit suit;
			private Rank rank;

			private Card(Suit suit, Rank rank) {
				this.suit = suit;
				this.rank = rank;
			}

			public Suit getSuit() {
				return this.suit;
			}

			public Rank getRank() {
				return this.rank;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result
						+ ((rank == null) ? 0 : rank.hashCode());
				result = prime * result
						+ ((suit == null) ? 0 : suit.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Card other = (Card) obj;
				if (rank != other.rank)
					return false;
				if (suit != other.suit)
					return false;
				return true;
			}

		}

		public DeckOfCards(Set<Card> skipCards) {
			// Initialize Cards
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					Card card = new Card(suit, rank);
					if (skipCards == null || !skipCards.contains(card)) {
						this.cardsList.add(card);
					}
				}
			}
		}
	}

}
