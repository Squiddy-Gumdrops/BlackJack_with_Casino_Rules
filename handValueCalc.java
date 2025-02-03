import java.util.Scanner;

class handValueCalc {

  static int CardValue(int card, hand CheckedHand) {
    // this function determines & returns card values for CPU
    if (card % 13 == 1) {
      ++CheckedHand.numAces;
      // if card is ace, change to 1 if score would be above 21, else change to 10
      if (CheckedHand.handValue + 10 > 21) {
        card = 1;
      } else {
        card = 11;
      }
    }

    else if (card % 13 == 0 || card % 13 >= 10) {
      // converts all face cards to a score of 10
      card = 10;
    } else {
      card = card % 13;
    }

    return card;
  }
  
}