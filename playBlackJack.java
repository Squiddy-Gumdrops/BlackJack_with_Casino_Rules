import java.util.Scanner;
import javax.swing.*;  
import com.sun.source.tree.IfTree;

class hand {
  String[] cards = new String[21];
  int handValue = 0;
  int numAces = 0;
}

  
class Button {  
  public static void main(String[] args) {  
      JFrame frame=new JFrame("Button Example");  
      JButton boop=new JButton("Click Here");  
      boop.setBounds(50,100,95,30);  
      frame.add(boop);  
      frame.setSize(400,400);  
      frame.setLayout(null);  
      frame.setVisible(true);   
  }  
}  

class playBlackJack {
  public static void clearScreen() {  
      System.out.print("\033[H\033[2J");  
      System.out.flush();  
  }
  
  

  

  static String newRound() {

    BlackJackLibrary poop = new BlackJackLibrary();


    int i = 0; // 'i' is for array location for user's cards
    int j = 0; // 'j' is for array location for cpu's cards
    int newCard;
    String input;
    hand userHand = new hand();
    hand cpuHand = new hand();
    Scanner scnr = new Scanner(System.in);


    boolean userBj = false; // boolean to determine if user got a blackjack
    boolean cpuBj = false;

    boolean[] deck = new boolean[52]; // establishing deck

    newCard = drawCard.draw(deck); // giving user 2 cards
    userHand.handValue += handValueCalc.CardValue(newCard, userHand);
    userHand.cards[i] = cardIdentification.cardName(newCard);
    ++i;

    newCard = drawCard.draw(deck); // giving user 2 cards
    userHand.handValue += handValueCalc.CardValue(newCard, userHand);
    userHand.cards[i] = cardIdentification.cardName(newCard);
    ++i;

    

    newCard = drawCard.draw(deck); //giving cpu 2 cards
    cpuHand.handValue += handValueCalc.CardValue(newCard, cpuHand);
    cpuHand.cards[j] = cardIdentification.cardName(newCard);
    ++j;

    newCard = drawCard.draw(deck); //giving cpu 2 cards
    cpuHand.handValue += handValueCalc.CardValue(newCard, cpuHand);
    cpuHand.cards[j] = cardIdentification.cardName(newCard);
    ++j;
    
    System.out.println("_______________________________");

    System.out.println("\nNEW GAME:");


    if (naturalBj.winningCombo(userHand.cards) == true && userHand.handValue == 21) {    //ALWAYS Check for BlackJack
      userBj = true;
    }

    if (naturalBj.winningCombo(cpuHand.cards) == true && cpuHand.handValue == 21) {    //ALWAYS Check for BlackJack
      cpuBj = true;
    }

    if (naturalBj.autoWin(userBj, cpuBj) == true) {
      return "push";
    }

    input = "yes";

    handDeclaration.sayHand(userHand.cards);



    System.out.println("Dealer is showing " + cpuHand.cards[1]);

    while (input.equals("no") == false && userHand.handValue <= 21) {// user draws cards until they say no
      System.out.println("\nYou have " + userHand.handValue + ", would you like another card? yes/no");
      input = scnr.next();
      if (input.equals("yes") == true) {
        newCard = drawCard.draw(deck);
        userHand.handValue += handValueCalc.CardValue(newCard, userHand);
        userHand.cards[i] = cardIdentification.cardName(newCard);
        clearScreen();
        System.out.println("\nYou drew " + userHand.cards[i]);
        ++i;
      }

      if (userHand.handValue > 21) { // immediate end if userScore is above 21
        if (handCheck.checkSoft(userHand) == true) {
          handCheck.reduceHand(userHand);
        }
        else {
          System.out.println("\nYou busted with "  + userHand.handValue +  ", you lose!\n");
          handDeclaration.sayHand(userHand.cards);
          return "lose";
        }
      }
    }

    System.out.println("\nDealer has " + cpuHand.handValue);
    
    while (cpuHand.handValue < 17) {// cpu gets cards while their score is < 17
      newCard = drawCard.draw(deck);
      cpuHand.handValue += handValueCalc.CardValue(newCard, cpuHand);
      cpuHand.cards[j] = cardIdentification.cardName(newCard);
      ++j;
      clearScreen();
      System.out.println("\nDealer hits " + cardIdentification.cardName(newCard));
      System.out.println("\nDealer has " + cpuHand.handValue);
      try {
        Thread.sleep(1000);
        }
        catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      
    }

    if (cpuHand.handValue > 21) { // immediate end if cpuScore is above 21
      System.out.println("\nDealer Busted, you win! \n");
      handDeclaration.sayHand(userHand.cards);
      System.out.println("");
      handDeclaration.sayHandCpu(cpuHand.cards);
      return true;
    }

    if (userHand.handValue == cpuHand.handValue) {// if you tie
        System.out.println("\nYou tied with the Dealer, looks like you push.\n");
        handDeclaration.sayHand(userHand.cards);
        System.out.println("");
        handDeclaration.sayHandCpu(cpuHand.cards);
        return "push";
    }
    

      else if (userHand.handValue > cpuHand.handValue) {// if you win
        System.out.print("\nDealer has " + cpuHand.handValue);
        System.out.println(" and you have " + userHand.handValue);
        System.out.println("You win! Congratulations! \n");
        handDeclaration.sayHand(userHand.cards);
        System.out.println("");
        handDeclaration.sayHandCpu(cpuHand.cards);
        return "win";
      }

      else if (userHand.handValue < cpuHand.handValue) {// if you lose

        System.out.print("\nDealer has " + cpuHand.handValue);
        System.out.println(" and you have " + userHand.handValue);
        System.out.println("You lose! Better luck next time! \n");
        handDeclaration.sayHand(userHand.cards);
        System.out.println("");
        handDeclaration.sayHandCpu(cpuHand.cards);
        return "lose";
      }
      else {
        System.out.println("error");
        System.out.print("\nDealer had a score of " + cpuHand.handValue);
        System.out.println(" and you had a score of " + userHand.handValue);
        handDeclaration.sayHand(userHand.cards);
        System.out.println("");
        handDeclaration.sayHandCpu(cpuHand.cards);
        return "push";
      }
    }

  }