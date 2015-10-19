package pokerEnums;

public enum eHandStrength {

	NaturalRoyalFlush(120) {
		public String toString() {
			return "Natural Royal Flush";
		}
	},
	RoyalFlush(110) {
		public String toString() {
			return "Royal Flush";
		}
	},
	StraightFlush(100) {
		public String toString() {
			return "Straight Flush";
		}
	},
	FiveOfAKind(90) {
		public String toString() {
			return "Five of a Kind";
		}
	},
	FourOfAKind(80) {
		public String toString() {
			return "Four of a Kind";
		}
	},
	FullHouse(70) {
		public String toString() {
			return "Full House";
		}
	},
	Flush(60) {
		public String toString() {
			return "Flush";
		}
	},
	Straight(50) {
		public String toString() {
			return "Straight";
		}
	},
	ThreeOfAKind(40) {
		public String toString() {
			return "Three of a Kind";
		}
	},
	TwoPair(30) {
		public String toString() {
			return "Two Pairs";
		}
	},

	Pair(20) {
		public String toString() {
			return "One Pair";
		}
	},
	HighCard(10) {
		public String toString() {
			return "High Card";
		}
	};

	private eHandStrength(final int handstrength) {
		this.iHandStrength = handstrength;
	}

	private int iHandStrength;

	public int getHandStrength() {
		return iHandStrength;
	}

	public static String getEnumName(Integer strength) {
		String name = null;
		switch (strength) {
		case (10):
			name = eHandStrength.HighCard.toString();
			break;
		case (20):
			name = eHandStrength.Pair.toString();
			break;
		case (30):
			name = eHandStrength.TwoPair.toString();
			break;
		case (40):
			name = eHandStrength.ThreeOfAKind.toString();
			break;
		case (50):
			name = eHandStrength.Straight.toString();
			break;
		case (60):
			name = eHandStrength.Flush.toString();
			break;
		case (70):
			name = eHandStrength.FullHouse.toString();
			break;
		case (80):
			name = eHandStrength.FourOfAKind.toString();
			break;
		case (90):
			name = eHandStrength.FiveOfAKind.toString();
			break;
		case (100):
			name = eHandStrength.StraightFlush.toString();
			break;
		case (110):
			name = eHandStrength.RoyalFlush.toString();
			break;
		case (120):
			name = eHandStrength.NaturalRoyalFlush.toString();
			break;
		}
		return name;
	}
}
