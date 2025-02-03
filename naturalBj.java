class naturalBj {

static boolean winningCombo(String[] hand) {
  // checks to see if a player got an ace & 10 pt card for the auto win
  boolean hasAce = false;
  boolean didItHappen = false;
  int numCards = 0;
  int handValue = 0;
  int i = 0;

  while (hand[i] != null) {
    if (hand[i].indexOf("Ace") != -1) {
      hasAce = true;
    }
    ++i;
    ++numCards;
  }
  

  if (hasAce == true && numCards == 2) {
    // only counts if the player in question only has 2 cards AND an ace. (Function
    // is also only called if their score is 21)
    didItHappen = true;
  }

  return didItHappen;  
  }

  static boolean autoWin(boolean userBj, boolean cpuBj) {
    if (userBj == true && cpuBj == true) {
      System.out.println("You both have BlackJack, you Push!");
      return true;
    } 
    else if (userBj == true && cpuBj == false) {
      System.out.println("You have BlackJack, you Win!");
      return true;
    }
    else if (userBj == false && cpuBj == true) {
      System.out.println("The Dealer has BlackJack, you Lose!");
      return true;
    }
    else {
      return false;
    }
    
  }
}
;