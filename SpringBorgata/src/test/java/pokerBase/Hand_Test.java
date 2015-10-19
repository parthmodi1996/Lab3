package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Hand_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// Joker = 0
	@Test
	public void FiveOfAKind() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());

	}

	// Joker = 1
	@Test
	public void FiveOfAKind_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		// Add Number of Jokers
	}

	// Joker = 2
	@Test
	public void FiveOfAKind_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		// Add number of Jokers
	}

	// Joker = 0
	@Test
	public void NaturalRoyalFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.NaturalRoyalFlush.getHandStrength());
	}

	// Joker = 1 with Ace
	@Test
	public void RoyalFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
	}
	
	// Joker = 1 without Ace
	@Test
	public void RoyalFlush_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
	}
	
	// Joker = 2 with Ace
	@Test
	public void RoyalFlush_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
	}
	
	// Joker = 2 without Ace
	@Test
	public void RoyalFlush_3() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
	}
	
	// Joker == 0
	@Test
	public void StraightFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	// Joker = 1
	@Test
	public void StraightFlush_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.QUEEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);

		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
	}
	
	// Joker = 2
	@Test
	public void StraightFlush_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	//Joker = 0
	@Test
	public void Flush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.Flush.getHandStrength());
	}
	//Joker = 1
	@Test
	public void Flush_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.Flush.getHandStrength());
	}

	//Joker = 2
	@Test
	public void Flush_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.Flush.getHandStrength());
	}
	
	// Joker = 0
	@Test
	public void Straight() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	// Joker = 1
	@Test
	public void Straight_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		
		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	// Joker = 2
		@Test
		public void Straight_2() {
			Deck d = new Deck();
			Hand h = new Hand();
			h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
			h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
			h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
			h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
			h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
			h.EvalHand();

			assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
			assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
			assertTrue(h.getLowPairStrength() == 0);
			assertTrue(h.getKicker() == null);
		}

	// Joker = 0
	@Test
	public void FourOfAKind_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the kicker is a NINE
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());

	}
	
	// Joker = 0
	@Test
	public void FourOfAKind_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
	}
	
	// Joker = 1
	@Test
	public void FourOfAKind_3() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the kicker is a NINE
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());

	}
	
	// Joker = 1
	@Test
	public void FourOfAKind_4() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);

	}
	
	// Joker = 2
	@Test
	public void FourOfAKind_5() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);


		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the kicker is a NINE
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());

	}
	
	// Joker = 2
	@Test
	public void FourOfAKind_6() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the kicker is a NINE
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());

	}
	
	@Test
	public void ThreeOfAKind_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	}

	@Test
	public void ThreeOfAKind_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.EvalHand();

		assertTrue("Hand Eval", h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue("High Pair Strength", h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue("Low Pai Strength", h.getLowPairStrength() == 0);
		assertTrue("Kicker Size", h.getKicker().size() == 2);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());

		// Check to see if the first kicker is a KING
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());

		// Check to see if the second kicker is a NINE
		assertTrue(c2.getRank().getRank() == eRank.NINE.getRank());
	}

	@Test
	public void ThreeOfAKind_3() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());

		// Check to see if the first kicker is a THREE
		assertTrue(c1.getRank().getRank() == eRank.THREE.getRank());

		// Check to see if the second kicker is a TWO
		assertTrue(c2.getRank().getRank() == eRank.TWO.getRank());
	}

	@Test
	public void FullHouse_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void FullHouse_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void TwoPair() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the first kicker is a THREE
		assertTrue(c1.getRank().getRank() == eRank.ACE.getRank());
	}

	@Test
	public void Pair() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());

		// Check value of kicker
		assertTrue(c1.getRank().getRank() == eRank.ACE.getRank());

		// Check value of kicker
		assertTrue(c2.getRank().getRank() == eRank.THREE.getRank());

		// Check value of kicker
		assertTrue(c3.getRank().getRank() == eRank.TWO.getRank());

	}

	@Test
	public void HighCard() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.EvalHand();

		assertTrue(h.getHandStrength() == eHandStrength.HighCard.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 4);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		Card c4 = h.getKicker().get(eCardNo.FourthCard.getCardNo());

		// Check value of kicker
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());

		// Check value of kicker
		assertTrue(c2.getRank().getRank() == eRank.TEN.getRank());

		// Check value of kicker
		assertTrue(c3.getRank().getRank() == eRank.THREE.getRank());

		// Check value of kicker
		assertTrue(c4.getRank().getRank() == eRank.TWO.getRank());

	}

	@Test
	public void CompareTwoHands() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h1.EvalHand();

		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h2.EvalHand();

		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);

		Collections.sort(TwoHands, Hand.HandRank);

		Hand winningHand = new Hand();

		winningHand = TwoHands.get(0);

		assertTrue(winningHand.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.NINE.getRank());

	}
	
	// Test to Pick Best Hand
	
	// Joker = 0 without Exception
	@Test
	public void GetBestHand() throws exHand {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h1.EvalHand();

		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h2.EvalHand();
		
		Hand h3 = new Hand();
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h3.EvalHand();
		
		ArrayList<Hand> myHands = new ArrayList<Hand>();
		myHands.add(h1);
		myHands.add(h2);
		myHands.add(h3);
		
		Hand bestHand = Hand.PickBestHand(myHands);
		assertTrue(bestHand == h2);
		assertTrue(bestHand.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
	}
	
	// Joker = 0 with Exception
	@Test
	public void GetBestHand_1() throws exHand {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h1.EvalHand();

		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h2.EvalHand();
		
		Hand h3 = new Hand();
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h3.EvalHand();
		
		ArrayList<Hand> myHands = new ArrayList<Hand>();
		myHands.add(h1);
		myHands.add(h2);
		myHands.add(h3);
		
		// Raises an exception here
		Hand bestHand = Hand.PickBestHand(myHands);
	}
	
	// Joker = 1 without Exception
	@Test
	public void GetBestHand_2() throws exHand {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h1.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h1.EvalHand();

		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h2.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h2.EvalHand();
		
		Hand h3 = new Hand();
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h3.EvalHand();
		
		ArrayList<Hand> myHands = new ArrayList<Hand>();
		myHands.add(h1);
		myHands.add(h2);
		myHands.add(h3);

		Hand bestHand = Hand.PickBestHand(myHands);
		assertTrue(bestHand == h2);
		assertTrue(bestHand.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		
	}
	
	// Joker = 1 with Exception
	@Test
	public void GetBestHand_3() throws exHand {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.HEARTS, eRank.JOKER, 0));
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h1.EvalHand();

		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h2.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h2.EvalHand();
		
		Hand h3 = new Hand();
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h3.EvalHand();
		
		ArrayList<Hand> myHands = new ArrayList<Hand>();
		myHands.add(h1);
		myHands.add(h2);
		myHands.add(h3);
		
		//Raises an exception here
		Hand bestHand = Hand.PickBestHand(myHands);
	}
	
	// Joker = 2 without Exception
	@Test
	public void GetBestHand_4() throws exHand {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h1.AddCardToHand(new Card(eSuit.SPADES, eRank.JOKER, 0));
		h1.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h1.EvalHand();

		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h2.AddCardToHand(new Card(eSuit.SPADES, eRank.JOKER, 0));
		h2.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h2.EvalHand();
		
		Hand h3 = new Hand();
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h3.EvalHand();
		
		ArrayList<Hand> myHands = new ArrayList<Hand>();
		myHands.add(h1);
		myHands.add(h2);
		myHands.add(h3);
		
		Hand bestHand = Hand.PickBestHand(myHands);
		assertTrue(bestHand == h3);
		assertTrue(bestHand.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
	}
	
	// Joker = 2 with Exception
	@Test
	public void GetBestHand_5() throws exHand {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.HEARTS, eRank.JOKER, 0));
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h1.EvalHand();

		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, 0));
		h2.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h2.EvalHand();
		
		Hand h3 = new Hand();
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h3.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h3.EvalHand();
		
		ArrayList<Hand> myHands = new ArrayList<Hand>();
		myHands.add(h1);
		myHands.add(h2);
		myHands.add(h3);
		
		// Raises an exeption here
		Hand bestHand = Hand.PickBestHand(myHands);
	}
}
