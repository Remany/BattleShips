package FinalProject;

public class GameLaunch {
    boolean start = true;
    Player player1 = new Player("Леонид");
    Player player2 = new Player("Валерия");
    public GameLaunch() {
        while(start) {
            if (player1.numberOfShipsDestroyed != 0 && player2.numberOfShipsDestroyed != 0) {
                System.out.println("Атакует первый");
                player1.attack(player2);
            } else if (player2.numberOfShipsDestroyed == 0){
                System.out.println("Game over! Player1 - " + player1.getName() + " выиграл!");
                start = false;
            }

            if (player1.numberOfShipsDestroyed != 0 && player2.numberOfShipsDestroyed != 0) {
                System.out.println("Атакует второй");
                player2.attack(player1);
            } else if (player1.numberOfShipsDestroyed == 0){
                System.out.println("Game over! Player2 - " + player2.getName() + " выиграл!");
                start = false;
            }
        }
    }
}
