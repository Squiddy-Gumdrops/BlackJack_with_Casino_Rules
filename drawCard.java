import java.util.Random;

class drawCard {
  static int draw(boolean[] deck) { // draws next card, used array of 52 booleans to prevent repeats. If a card is
                                  // drawn, value in array changes to 'true' so it can no longer be used

  Random rand = new Random();
  int card;

  card = rand.nextInt(52);
  while (deck[card] == true) {
    card = rand.nextInt(52);
  }
  deck[card] = true;

  card += 1; // add one to compensate for the fact that #'s start at zero

  return card;

}
}