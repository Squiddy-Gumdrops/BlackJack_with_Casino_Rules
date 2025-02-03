class handCheck {
  public static boolean checkSoft(hand CheckedHand) {
      if (CheckedHand.numAces > 0) {
        return true;
      }
      else {
        return false;
      }
  }
  public static hand reduceHand(hand CheckedHand) {
    CheckedHand.handValue -= 10;
    CheckedHand.numAces -= 1;

    return CheckedHand;
  }
}