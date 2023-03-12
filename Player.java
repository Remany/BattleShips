package FinalProject;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Player extends PlayingField {
    private String name;
    int numberOfShipsDestroyed = 20;
    GameImplementation gameImplementation = new GameImplementation();
    public Player(String name) {
        this.name = name;
        System.out.println("Игрок " + name + " начинает расставлять свои корабли!");
        addShipsToPLayer();
    }

    public String getName() {
        return name;
    }

    public void attack(Player player) {
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

            if (gameImplementation.savedShotsAxisX.contains(x) &&
                    gameImplementation.savedShotsAxisY.contains(y)) {
                x += 10;
            } else if (gameImplementation.destroyedShipsAxisX.contains(x) &&
                    gameImplementation.destroyedShipsAxisY.contains(y)) {
                x += 10;
            }

            if (!gameImplementation.savedShotsAxisX.contains(x) ||
                    !gameImplementation.savedShotsAxisY.contains(y)) {
                if (player.axisX.contains(x) && player.axisY.contains(y)) {
                    gameImplementation.attackField[y][x] = "❌";

                    gameImplementation.destroyedShipsAxisX.add(x);
                    gameImplementation.destroyedShipsAxisY.add(y);

                    numberOfShipsDestroyed -= 1;

                    for (String[] counter : gameImplementation.attackField) {
                        System.out.println(Arrays.toString(counter));
                    }

                    if (numberOfShipsDestroyed != 0){
                        attack(player);
                    }
                }
                else if ((!player.axisX.contains(x) && !player.axisY.contains(y)) ||
                        (!player.axisX.contains(x) && player.axisY.contains(y)) ||
                        (player.axisX.contains(x) && !player.axisY.contains(y))) {
                    gameImplementation.attackField[y][x] = "0️⃣";

                    gameImplementation.savedShotsAxisX.add(x);
                    gameImplementation.savedShotsAxisY.add(y);

                    for (String[] counter : gameImplementation.attackField) {
                        System.out.println(Arrays.toString(counter));
                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Капитан, вы туда уже атаковали");
            attack(player);
        }
    }
}
