import java.util.Scanner;

class Main {
  public static void clearScreen() {  
      System.out.print("\033[H\033[2J");  
      System.out.flush();  
  }  

  

  public static void main(String[] args) {
    

    
    String input = "yes";
    String status = "null";
    Scanner scnr = new Scanner(System.in);
    playBlackJack poop = new playBlackJack();

    while (input.equals("yes") == true) {
      System.out.println("");
      status = playBlackJack.newRound();

      System.out.println("\n Would you like to play again? yes/no");
      input = scnr.next();

      if (input.equals("yes") == true) {
         clearScreen();
      }

      if (input.equals("no") == true) {
        System.out.println("\n Thanks for playing! \n");
      }
    }
    scnr.close();


  }
}
