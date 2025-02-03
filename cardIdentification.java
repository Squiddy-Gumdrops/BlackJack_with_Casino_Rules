class cardIdentification {
  
static String cardName(int card) { // determines suit of the card
  String cardName = "error";
  int num = (card - 1) / 13; // 1=spades, 2=clubs, 3=hearts, 4=diamonds

  if (num == 0) {
    cardName = "Spades";
  } else if (num == 1) {
    cardName = "Clubs";
  } else if (num == 2) {
    cardName = "Hearts";
  } else if (num == 3) {
    cardName = "Diamonds";
  }

  return cardType(card % 13) + " of " + cardName;

}

  static String cardType(int card) {
    // gives card a name if it is not one of the normal numbered cards

    if (card == 1) {
      return "Ace";
    } else if (card == 11) {
      return "Jack";
    } else if (card == 12) {
      return "Queen";
    } else if (card == 0) {
      return "King";
    } else {
      return Integer.toString(card);
    }
  }


}