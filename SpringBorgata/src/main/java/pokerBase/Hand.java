package pokerBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;

public class Hand {
	private UUID playerID;
	@XmlElement
	private ArrayList<Card> CardsInHand;
	private ArrayList<Card> BestCardsInHand;

	@XmlElement
	private int HandStrength;
	@XmlElement
	private int HiHand;
	@XmlElement
	private int LoHand;
	@XmlElement
	private ArrayList<Card> Kickers = new ArrayList<Card>();

	private boolean bScored = false;

	private boolean Flush;
	private boolean Straight;
	private boolean Ace;
	private boolean FiveOfAKind;
	private static Deck dJoker = new Deck();
	private int NmbrOfJkr;

	public Hand() {

	}

	public void AddCardToHand(Card c) {
		if (this.CardsInHand == null) {
			CardsInHand = new ArrayList<Card>();
		}
		this.CardsInHand.add(c);
	}

	public Card GetCardFromHand(int location) {
		return CardsInHand.get(location);
	}

	public Hand(Deck d) {
		ArrayList<Card> Import = new ArrayList<Card>();
		for (int x = 0; x < 5; x++) {
			Import.add(d.drawFromDeck());
		}
		CardsInHand = Import;
	}

	public Hand(ArrayList<Card> setCards) {
		this.CardsInHand = setCards;
	}

	public ArrayList<Card> getCards() {
		return CardsInHand;
	}

	public ArrayList<Card> getBestHand() {
		return BestCardsInHand;
	}

	public void setPlayerID(UUID playerID) {
		this.playerID = playerID;
	}

	public UUID getPlayerID() {
		return playerID;
	}

	public void setBestHand(ArrayList<Card> BestHand) {
		this.BestCardsInHand = BestHand;
	}

	public int getHandStrength() {
		return HandStrength;
	}

	public ArrayList<Card> getKicker() {
		return Kickers;
	}

	public int getHighPairStrength() {
		return HiHand;
	}

	public int getLowPairStrength() {
		return LoHand;
	}

	public boolean getAce() {
		return Ace;
	}

	public int getNmbrOfJkr() {
		return NmbrOfJkr;
	}

	public static Hand EvalHand(ArrayList<Card> SeededHand) {

		Deck d = new Deck();
		Hand h = new Hand(d);
		h.CardsInHand = SeededHand;

		return h;
	}

	public void EvalHand() {
		// Evaluates if the hand is a flush and/or straight then figures out
		// the hand's strength attributes

		ArrayList<Card> remainingCards = new ArrayList<Card>();

		// Sort the cards!
		Collections.sort(CardsInHand, Card.CardRank);

		// Count number of jokers
		if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == eRank.JOKER) {
			NmbrOfJkr = 2;
			HiHand = CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank();
		} else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == eRank.JOKER) {
			NmbrOfJkr = 1;
			HiHand = CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank().getRank();
		} else {
			NmbrOfJkr = 0;
			HiHand = CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank().getRank();
		}

		// Ace Evaluation
		if (NmbrOfJkr == 0) {
			if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == eRank.ACE) {
				Ace = true;
			}
		} else if (NmbrOfJkr == 1) {
			if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == eRank.ACE) {
				Ace = true;
			}
		} else if (NmbrOfJkr == 2) {
			if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.ACE) {
				Ace = true;
			}
		}

		// Flush Evaluation
		if (NmbrOfJkr == 0) {
			if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getSuit() == CardsInHand
					.get(eCardNo.SecondCard.getCardNo()).getSuit()
					&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getSuit() == CardsInHand
							.get(eCardNo.ThirdCard.getCardNo()).getSuit()
					&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getSuit() == CardsInHand
							.get(eCardNo.FourthCard.getCardNo()).getSuit()
					&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getSuit() == CardsInHand
							.get(eCardNo.FifthCard.getCardNo()).getSuit()) {
				Flush = true;
			} else {
				Flush = false;
			}
		} else if (NmbrOfJkr == 1) {
			if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getSuit() == CardsInHand
					.get(eCardNo.SecondCard.getCardNo()).getSuit()
					&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getSuit() == CardsInHand
							.get(eCardNo.ThirdCard.getCardNo()).getSuit()
					&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getSuit() == CardsInHand
							.get(eCardNo.FourthCard.getCardNo()).getSuit()) {
				Flush = true;
			} else {
				Flush = false;
			}
		} else if (NmbrOfJkr == 2) {
			if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getSuit() == CardsInHand
					.get(eCardNo.ThirdCard.getCardNo()).getSuit()
					&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getSuit() == CardsInHand
							.get(eCardNo.FourthCard.getCardNo()).getSuit()) {
				Flush = true;
			} else {
				Flush = false;
			}
		}

		// Straight Evaluation
		if (Ace) {
			if (NmbrOfJkr == 0) {
				if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == eRank.KING
						&& CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.QUEEN
						&& CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.JACK
						&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.TEN) {
					Straight = true;
					// Looks for Ace, 2, 3, 4, 5
				} else if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.TWO
						&& CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.THREE
						&& CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.FOUR
						&& CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == eRank.FIVE) {
					Straight = true;
				} else {
					Straight = false;
				}
			} else if (NmbrOfJkr == 1) {
				if ((CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank()
						- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 3
						|| CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank()
								- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 2)
						&& (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.KING
								|| CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.QUEEN
								|| CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.FOUR
								|| CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.FIVE)) {
					Straight = true;
				} else {
					Straight = false;
				}
			} else if (NmbrOfJkr == 2) {
				if ((CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank().getRank()
						- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 2
						|| CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank().getRank()
								- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 1)
						&& (CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.KING
								|| CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.QUEEN
								|| CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.JACK
								|| CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.THREE
								|| CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.FOUR
								|| CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.FIVE)) {
					Straight = true;
				} else {
					Straight = false;
				}
			}
		} else {
			if (NmbrOfJkr == 0) {
				if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
						.getRank() == CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank().getRank() + 1
						&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
								.getRank() == CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank() + 2
						&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
								.getRank() == CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank().getRank() + 3
						&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
								.getRank() == CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() + 4) {
					Straight = true;
				} else {
					Straight = false;
				}
			} else if (NmbrOfJkr == 1) {
				if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank().getRank()
						- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 4
						|| CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank().getRank()
								- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 3) {
					Straight = true;
				} else {
					Straight = false;
				}
			} else if (NmbrOfJkr == 2) {
				if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank()
						- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 4
						|| CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank()
								- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 3
						|| CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank()
								- CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() == 2) {
					Straight = true;
				} else {
					Straight = false;
				}
			}
		}

		// Five of a Kind evaluation
		if (NmbrOfJkr == 0) {
			if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
					.get(eCardNo.FifthCard.getCardNo()).getRank()) {
				FiveOfAKind = true;
			} else {
				FiveOfAKind = false;
			}
		} else if (NmbrOfJkr == 1) {
			if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
					.get(eCardNo.FifthCard.getCardNo()).getRank()) {
				FiveOfAKind = true;
			} else {
				FiveOfAKind = false;
			}
		} else if (NmbrOfJkr == 2) {
			if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
					.get(eCardNo.FifthCard.getCardNo()).getRank()) {
				FiveOfAKind = true;
			} else {
				FiveOfAKind = false;
			}
		}

		// Evaluates the hand type

		// Natural Royal Flush (Without Joker)
		if (Straight == true && Flush == true && CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.TEN
				&& Ace && NmbrOfJkr == 0) {
			ScoreHand(eHandStrength.NaturalRoyalFlush, 0, 0, null);
		}

		// Royal Flush with Joker and Ace
		else if (Straight == true && Flush == true
				&& (CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.KING
						|| CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.QUEEN
						|| CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == eRank.JACK)
				&& Ace) {
			ScoreHand(eHandStrength.RoyalFlush, 0, 0, null);
		}
		// Royal Flush with Joker and without Ace
		else if (Straight == true && Flush == true
				&& (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.KING
						|| CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.QUEEN)
				&& (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.TEN
						|| CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.JACK)) {
			ScoreHand(eHandStrength.RoyalFlush, 0, 0, null);
		}

		// Straight Flush
		else if (Straight == true && Flush == true) {
			remainingCards = null;
			ScoreHand(eHandStrength.StraightFlush, getHighPairStrength(), 0, remainingCards);
		}

		// five of a Kind

		else if (FiveOfAKind) {
			remainingCards = null;
			ScoreHand(eHandStrength.FiveOfAKind, getHighPairStrength(), 0, remainingCards);
		}

		// Four of a Kind

		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank()) {
			
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));
			ScoreHand(eHandStrength.FourOfAKind, getHighPairStrength(), 0, remainingCards);
		}
		
		else if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank()) {
			HiHand = CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank();
			remainingCards.add(CardsInHand.get(eCardNo.FirstCard.getCardNo()));
			ScoreHand(eHandStrength.FourOfAKind, getHighPairStrength(), 0, remainingCards);
		} else if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank()
				&& NmbrOfJkr == 1) {
			HiHand = CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank().getRank();
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));
			ScoreHand(eHandStrength.FourOfAKind, getHighPairStrength(), 0, remainingCards);
		} else if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank()
				&& NmbrOfJkr == 1) {
			HiHand = CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank();
			remainingCards.add(CardsInHand.get(eCardNo.SecondCard.getCardNo()));
			ScoreHand(eHandStrength.FourOfAKind, getHighPairStrength(), 0, remainingCards);
		} else if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FourthCard.getCardNo()).getRank() && NmbrOfJkr == 2) {
			HiHand = CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank();
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));
			ScoreHand(eHandStrength.FourOfAKind, getHighPairStrength(), 0, remainingCards);
		} else if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank() && NmbrOfJkr == 2) {
			HiHand = CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank();
			remainingCards.add(CardsInHand.get(eCardNo.ThirdCard.getCardNo()));
			ScoreHand(eHandStrength.FourOfAKind, getHighPairStrength(), 0, remainingCards);
		}
		else if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FourthCard.getCardNo()).getRank() && NmbrOfJkr == 2) {
			HiHand = CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank().getRank();
			remainingCards.add(CardsInHand.get(eCardNo.ThirdCard.getCardNo()));
			ScoreHand(eHandStrength.FourOfAKind, getHighPairStrength(), 0, remainingCards);
		}
		// Full House
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getRank()) {
			remainingCards = null;
			ScoreHand(eHandStrength.FullHouse, CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank().getRank(),
					CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank().getRank(), remainingCards);
		}

		else if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FifthCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.SecondCard.getCardNo()).getRank()) {
			remainingCards = null;
			ScoreHand(eHandStrength.FullHouse, CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank(),
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank().getRank(), remainingCards);
		}

		// Flush
		else if (Flush) {
			remainingCards = null;
			ScoreHand(eHandStrength.Flush, getHighPairStrength(), 0, remainingCards);
		}

		// Straight
		else if (Straight) {
			remainingCards = null;
			ScoreHand(eHandStrength.Straight, getHighPairStrength(), 0, remainingCards);
		}

		// Three of a Kind
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()) {

			remainingCards.add(CardsInHand.get(eCardNo.FourthCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));
			ScoreHand(eHandStrength.ThreeOfAKind, getHighPairStrength(), 0, remainingCards);
		}

		else if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FourthCard.getCardNo()).getRank()) {
			remainingCards.add(CardsInHand.get(eCardNo.FirstCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));

			ScoreHand(eHandStrength.ThreeOfAKind, getHighPairStrength(), 0, remainingCards);
		} else if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FifthCard.getCardNo()).getRank()) {
			remainingCards.add(CardsInHand.get(eCardNo.FirstCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.SecondCard.getCardNo()));
			ScoreHand(eHandStrength.ThreeOfAKind, getHighPairStrength(), 0, remainingCards);
		}

		// Two Pair
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank())) {

			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));

			ScoreHand(eHandStrength.TwoPair, CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank().getRank(),
					CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank(), remainingCards);
		} else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& (CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getRank())) {

			remainingCards.add(CardsInHand.get(eCardNo.ThirdCard.getCardNo()));

			ScoreHand(eHandStrength.TwoPair, CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank().getRank(),
					CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank().getRank(), remainingCards);
		} else if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& (CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getRank())) {

			remainingCards.add(CardsInHand.get(eCardNo.FirstCard.getCardNo()));
			ScoreHand(eHandStrength.TwoPair, CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank().getRank(),
					CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank().getRank(), remainingCards);
		}

		// Pair
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()) {

			remainingCards.add(CardsInHand.get(eCardNo.ThirdCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FourthCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));
			ScoreHand(eHandStrength.Pair, CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank().getRank(), 0,
					remainingCards);
		} else if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()) {
			remainingCards.add(CardsInHand.get(eCardNo.FirstCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FourthCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));
			ScoreHand(eHandStrength.Pair, CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank().getRank(), 0,
					remainingCards);
		} else if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FourthCard.getCardNo()).getRank()) {

			remainingCards.add(CardsInHand.get(eCardNo.FirstCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.SecondCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));

			ScoreHand(eHandStrength.Pair, CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank(), 0,
					remainingCards);
		} else if (CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FifthCard.getCardNo()).getRank()) {

			remainingCards.add(CardsInHand.get(eCardNo.FirstCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.SecondCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.ThirdCard.getCardNo()));

			ScoreHand(eHandStrength.Pair, CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank().getRank(), 0,
					remainingCards);
		}

		else {
			remainingCards.add(CardsInHand.get(eCardNo.SecondCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.ThirdCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FourthCard.getCardNo()));
			remainingCards.add(CardsInHand.get(eCardNo.FifthCard.getCardNo()));

			ScoreHand(eHandStrength.HighCard, CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank().getRank(), 0,
					remainingCards);
		}
	}

	private void ScoreHand(eHandStrength hST, int HiHand, int LoHand, ArrayList<Card> kickers) {
		this.HandStrength = hST.getHandStrength();
		this.HiHand = HiHand;
		this.LoHand = LoHand;
		this.Kickers = kickers;
		this.bScored = true;

	}

	/**
	 * Custom sort to figure the best hand in an array of hands
	 */
	public static Comparator<Hand> HandRank = new Comparator<Hand>() {

		public int compare(Hand h1, Hand h2) {

			int result = 0;

			result = h2.getHandStrength() - h1.getHandStrength();

			if (result != 0) {
				return result;
			}

			result = h2.getHighPairStrength() - h1.getHighPairStrength();
			if (result != 0) {
				return result;
			}

			result = h2.getLowPairStrength() - h1.getLowPairStrength();
			if (result != 0) {
				return result;
			}

			if (h2.getKicker().get(eCardNo.FirstCard.getCardNo()) != null) {
				if (h1.getKicker().get(eCardNo.FirstCard.getCardNo()) != null) {
					result = h2.getKicker().get(eCardNo.FirstCard.getCardNo()).getRank().getRank()
							- h1.getKicker().get(eCardNo.FirstCard.getCardNo()).getRank().getRank();
				}
				if (result != 0) {
					return result;
				}
			}

			if (h2.getKicker().get(eCardNo.SecondCard.getCardNo()) != null) {
				if (h1.getKicker().get(eCardNo.SecondCard.getCardNo()) != null) {
					result = h2.getKicker().get(eCardNo.SecondCard.getCardNo()).getRank().getRank()
							- h1.getKicker().get(eCardNo.SecondCard.getCardNo()).getRank().getRank();
				}
				if (result != 0) {
					return result;
				}
			}
			if (h2.getKicker().get(eCardNo.ThirdCard.getCardNo()) != null) {
				if (h1.getKicker().get(eCardNo.ThirdCard.getCardNo()) != null) {
					result = h2.getKicker().get(eCardNo.ThirdCard.getCardNo()).getRank().getRank()
							- h1.getKicker().get(eCardNo.ThirdCard.getCardNo()).getRank().getRank();
				}
				if (result != 0) {
					return result;
				}
			}

			if (h2.getKicker().get(eCardNo.FourthCard.getCardNo()) != null) {
				if (h1.getKicker().get(eCardNo.FourthCard.getCardNo()) != null) {
					result = h2.getKicker().get(eCardNo.FourthCard.getCardNo()).getRank().getRank()
							- h1.getKicker().get(eCardNo.FourthCard.getCardNo()).getRank().getRank();
				}
				if (result != 0) {
					return result;
				}
			}
			return 0;
		}
	};

	public static Hand PickBestHand(ArrayList<Hand> Hands) throws exHand {

		Hand bestHand = null;

		ArrayList<Integer> HandRank = new ArrayList<Integer>();

		for (Hand eachHand : Hands) {
			HandRank.add(eachHand.getHandStrength());
		}

		Collections.sort(HandRank, Collections.reverseOrder());

		try {
			if (HandRank.get(0) > HandRank.get(1)) {
				for (Hand eachHand : Hands) {
					if (eachHand.getHandStrength() == HandRank.get(0)) {
						bestHand = eachHand;
						break;
					}
				}
			} else {
				throw new exHand("It is a Tie for " + eHandStrength.getEnumName(HandRank.get(0)));
			}
		} catch (exHand e) {
			System.out.println(e);
		}
		return bestHand;
	}
}
