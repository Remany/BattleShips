package FinalProject;

public class GameLaunch {

    public GameLaunch() {
        Player player1 = new Player("Леонид");
        Player player2 = new Player("Валерия");
        while (player1.start && player2.start){
            System.out.println("Первый атакует");
            player1.attack(player2);
            System.out.println("Второй атакует");
            player2.attack(player1);
        }
    }
}
