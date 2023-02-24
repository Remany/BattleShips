package FinalProject;

import java.util.*;

public class GameImplementation {
    private final String[][] attackField;
    Set<Integer> savedShotsAxisX = new HashSet<>();
    Set<Integer> savedShotsAxisY = new HashSet<>();
    Set<Integer> destroyedShipsAxisX = new HashSet<>();
    Set<Integer> destroyedShipsAxisY = new HashSet<>();

    public GameImplementation() {
        attackField = new String[10][10];
        System.out.println("Начнем расставлять корабли на поле Player1. Другой игрок, не смотри!");
        Player player1 = new Player();
        System.out.println("Теперь расставляет корабли на поле Player2. Другой игрок, не смотри!");
        Player player2 = new Player();
        addEmptyPlace();
        attack(player1);
        addEmptyPlace();
        attack(player2);
        attack(player1);
        attack(player2);
    }

    private void addEmptyPlace(){
        for (String[] strings : attackField) {
            Arrays.fill(strings, "⬜️");
        }
    }

    public void attack(Player player){
        try {
            System.out.println("Капитан, давайте их уничтожим!");
            System.out.println("Введите координаты для нанесения удара: ");

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            StringTokenizer stringTokenizer = new StringTokenizer(line, ", ;");
            String stX1 = stringTokenizer.nextToken();
            String stY1 = stringTokenizer.nextToken();

            int x = Integer.parseInt(stX1);
            int y = Integer.parseInt(stY1);

            if (savedShotsAxisX.contains(x) && savedShotsAxisY.contains(y)){
                x += 10;
            }
            else if (destroyedShipsAxisX.contains(x) && destroyedShipsAxisY.contains(y)){
                x += 10;
            }

            if (!savedShotsAxisX.contains(x) || !savedShotsAxisY.contains(y)){
                if (player.axisX.contains(x) && player.axisY.contains(y)){
                    attackField[y][x] = "❌";

                    //destroyedShipsAxisX.add(x);
                    //destroyedShipsAxisY.add(y);
                }
                else if ((!player.axisX.contains(x) && !player.axisY.contains(y)) ||
                        (!player.axisX.contains(x) && player.axisY.contains(y)) ||
                        (player.axisX.contains(x) && !player.axisY.contains(y))){
                    attackField[y][x] = "0️⃣";

                    //savedShotsAxisX.add(x);
                    //savedShotsAxisY.add(y);
                }
            }

            for (String[] counter: attackField){
                System.out.println(Arrays.toString(counter));
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Капитан, вы туда уже атаковали");
            attack(player);
        }
    }
}
