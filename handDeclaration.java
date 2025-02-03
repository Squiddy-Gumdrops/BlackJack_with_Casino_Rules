

class handDeclaration {
  static void sayHand(String[] cards) {
    // function to say all the player's cards
    System.out.println("Your cards:");
    int i;
    i = 0;
    while (cards[i] != null) {
      System.out.println(cards[i]);
      ++i;
    }

  }

  static void sayHandCpu(String[] cards) {
    // function to say all the cpus cards
    System.out.println("Dealer's cards:");
    int i;
    i = 0;
    while (cards[i] != null) {
      System.out.println(cards[i]);
      ++i;
    }

  }
}