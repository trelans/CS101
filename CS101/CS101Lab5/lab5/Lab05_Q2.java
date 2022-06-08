import java.util.Random;
import java.util.Scanner;

/**
 * Black Jack
 * @author __Kutay Senyigit___
 * @version __2 NOV 2021__
 */
public class Lab05_Q2 {
    public static void main(String[] args) {
        // Variables
        String deck = "";
        String dealersCards = "";
        String playersCards = "";
        String showedDealersHand;
        int choice;
        int sumOfPlayersCards = 0;
        int sumOfDealerCards = 0;
        String randomPickedCard;
        int randomCardIndex;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean isGameOver = false;

        // Creating deck
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < 4; j++) {
                deck = deck + i;
            }
        }
        System.out.println("Starting the game with the following deck: \n" + deck);


        // Picking 2 card for Player
        for (int i = 0; i < 2 ; i++) {
            randomCardIndex = rand.nextInt(deck.length()-1);
            randomPickedCard = deck.charAt(randomCardIndex) + "";
            deck = deck.substring(0,randomCardIndex ) + deck.substring(randomCardIndex + 1, deck.length() );
            playersCards = playersCards + randomPickedCard;

        }

        // Picking 2 card for Dealer
        for (int i = 0; i < 2 ; i++) {
            randomCardIndex = rand.nextInt(deck.length()-1);
            randomPickedCard = deck.charAt(randomCardIndex) + "";
            deck = deck.substring(0,randomCardIndex ) + deck.substring(randomCardIndex + 1, deck.length() );
            dealersCards = dealersCards + randomPickedCard;
        }

        showedDealersHand = dealersCards.charAt(0) + "?";
        System.out.println("\nDealer is now dealing cards... \n"
                + "Player's hand:\n" + playersCards
        + "\nDealer's hand:\n" + showedDealersHand);



        do {
            System.out.println("\nPlease enter your choice:\n" +
                    "1) Hit\n" +
                    "2) Stand");
            choice = scanner.nextInt();
            if (choice == 1) {
                // Hit
                //Picks add a card to user and Removes that card from the deck
                randomCardIndex = rand.nextInt(deck.length()-1);
                randomPickedCard = deck.charAt(randomCardIndex) + "";
                deck = deck.substring(0,randomCardIndex ) + deck.substring(randomCardIndex + 1, deck.length() );
                playersCards = playersCards + randomPickedCard;
                // Finds sum of the players cards
                sumOfPlayersCards = 0;
                for (int i = 0; i < playersCards.length(); i++) {
                    String currentCard = playersCards.charAt(i)+ "";
                   sumOfPlayersCards = sumOfPlayersCards + Integer.parseInt(currentCard);
                }
                System.out.println("Hit! Dealer is giving the player a card...\n" +
                        "Player's hand:\n" +
                        playersCards);
                if (sumOfPlayersCards == 21) {
                    System.out.println("Player scored 21. Player wins!");
                    isGameOver = true;
                }
                else if (sumOfPlayersCards > 21) {
                    System.out.println("Player scored over 21. Player lost!");
                    isGameOver = true;
                }
            }
            else if (choice == 2){
                // Stand
                // Finds sum of the players cards
                sumOfPlayersCards = 0;
                for (int i = 0; i < playersCards.length(); i++) {
                    String currentCard = playersCards.charAt(i)+ "";
                    sumOfPlayersCards = sumOfPlayersCards + Integer.parseInt(currentCard);
                }
                System.out.println("Stand! Player's turn is now over. Player's hand sums to " + sumOfPlayersCards);
                System.out.println("Dealer is drawing cards...");

                do {
                    // Picks card to dealer
                    randomCardIndex = rand.nextInt(deck.length()-1);
                    randomPickedCard = deck.charAt(randomCardIndex) + "";
                    deck = deck.substring(0,randomCardIndex ) + deck.substring(randomCardIndex + 1, deck.length() );
                    dealersCards = dealersCards + randomPickedCard;
                    // Calculate dealer's sum
                    sumOfDealerCards = 0;
                    for (int i = 0; i < dealersCards.length(); i++) {
                        String currentCard = dealersCards.charAt(i)+ "";
                        sumOfDealerCards = sumOfDealerCards + Integer.parseInt(currentCard);
                    }
                    System.out.println("Dealer's hand: ");
                    System.out.println(dealersCards);
                    if (sumOfDealerCards == 21 ) {
                        System.out.println("Dealer scored 21. Dealer wins!");
                        isGameOver = true;
                    }
                    else if (sumOfDealerCards > sumOfPlayersCards && sumOfPlayersCards < 21) {
                        System.out.println("Dealer scored more than player. Dealer wins!");
                        isGameOver = true;
                    }
                    else if (sumOfDealerCards > 21){
                        isGameOver = true;
                        System.out.println("Dealer scored over 21. Dealer lost!");
                    }
                }while (!isGameOver);

            }

        }while (!isGameOver);

        scanner.close();
    }

}
