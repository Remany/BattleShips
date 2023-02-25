package FinalProject;

import java.util.*;

public class PlayingField {
    private final String[][] field;
    public final Set<Integer> axisX = new HashSet<>();
    public final Set<Integer> axisY = new HashSet<>();
    public final Set<Integer> orealAxisX = new HashSet<>();
    public final Set<Integer> orealAxisY = new HashSet<>();

    public PlayingField() {
        field = new String[10][10];
    }

    private void addEmptyPlace(){
        for (String[] strings : field) {
                Arrays.fill(strings, "⬜️");
        }
    }

    private void addShip4(){

        try {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            StringTokenizer stringTokenizer = new StringTokenizer(line, ", ;");

            String stX1 = stringTokenizer.nextToken();
            String stY1 = stringTokenizer.nextToken();
            String stX2 = stringTokenizer.nextToken();
            String stY2 = stringTokenizer.nextToken();
            String stX3 = stringTokenizer.nextToken();
            String stY3 = stringTokenizer.nextToken();
            String stX4 = stringTokenizer.nextToken();
            String stY4 = stringTokenizer.nextToken();

            int x1 = Integer.parseInt(stX1);
            int x2 = Integer.parseInt(stX2);
            int x3 = Integer.parseInt(stX3);
            int x4 = Integer.parseInt(stX4);

            int y1 = Integer.parseInt(stY1);
            int y2 = Integer.parseInt(stY2);
            int y3 = Integer.parseInt(stY3);
            int y4 = Integer.parseInt(stY4);

            // проверки кода
            if (y2 != y1) {
                if (y2 > y1) {
                    y2 = y1 + 1;
                    y3 = y2 + 1;
                    y4 = y3 + 1;
                }
                if (y2 < y1) {
                    y2 = y1 + 1;
                    y3 = y2 + 1;
                    y4 = y3 + 1;
                }
            }

            if (x2 != x1){
                if (x2 > x1){
                    x2 = x1 + 1;
                    x3 = x2 + 1;
                    x4 = x3 + 1;
                }
                if (x2 < x1){
                    x2 = x1 + 1;
                    x3 = x2 + 1;
                    x4 = x3 + 1;
                }
            }

            // работа над ореолами
            axisX.add(x1);
            if (x1 < 9){
                orealAxisX.add(x1 + 1);
            }
            if (x1 > 0) {
                orealAxisX.add(x1 - 1);
            }
            axisX.add(x2);
            if (x2 < 9) {
                orealAxisX.add(x2 + 1);
            }
            if (x2 < 9) {
                orealAxisX.add(x2 - 1);
            }
            axisX.add(x3);
            if (x3 < 9) {
                orealAxisX.add(x3 + 1);
            }
            if (x3 > 0) {
                orealAxisX.add(x3 - 1);
            }
            axisX.add(x4);
            if (x4 < 9) {
                orealAxisX.add(x4 + 1);
            }
            if (x4 > 0) {
                orealAxisX.add(x4 - 1);
            }

            axisY.add(y1);
            if (y1 > 0) {
                orealAxisY.add(y1 - 1);
            }
            axisY.add(y2);
            axisY.add(y3);
            axisY.add(y4);
            if (y4 < 9){
                orealAxisY.add(y4 + 1);
            }

            field[y1][x1] = ("🛥");
            field[y2][x2] = ("🛥");
            field[y3][x3] = ("🛥");
            field[y4][x4] = ("🛥");

            for (String[] x: field){
                System.out.println(Arrays.toString(x));
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Капитан, не верно указаны координаты!");
            addShip4();
        }catch (NoSuchElementException e){
            System.out.println("Капитан вы забываете важную вещь - ваш корабль четырёхпалубный! " +
                    "введите 4 координаты!");
            addShip4();
        }
    }

    private void addShip3(){

        try {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            StringTokenizer stringTokenizer = new StringTokenizer(line, ", ;");

            String stX1 = stringTokenizer.nextToken();
            String stY1 = stringTokenizer.nextToken();
            String stX2 = stringTokenizer.nextToken();
            String stY2 = stringTokenizer.nextToken();
            String stX3 = stringTokenizer.nextToken();
            String stY3 = stringTokenizer.nextToken();

            int x1 = Integer.parseInt(stX1);
            int x2 = Integer.parseInt(stX2);
            int x3 = Integer.parseInt(stX3);

            int y1 = Integer.parseInt(stY1);
            int y2 = Integer.parseInt(stY2);
            int y3 = Integer.parseInt(stY3);

            // проверки кода
            if (y2 != y1) {
                if (y2 > y1) {
                    y2 = y1 + 1;
                    y3 = y2 + 1;
                }
                if (y2 < y1) {
                    y2 = y1 + 1;
                    y3 = y2 + 1;
                }
            }

            if (x2 != x1){
                if (x2 > x1){
                    x2 = x1 + 1;
                    x3 = x2 + 1;
                }
                if (x2 < x1){
                    x2 = x1 + 1;
                    x3 = x2 + 1;
                }
            }

            // работа над ореолами
            for (Integer integer: axisX){
                for (Integer integer1: axisY) {
                    if (integer.equals(x1) && integer1.equals(y1)) {
                        x1 += 10;
                    }
                    if (integer.equals(x2) && integer1.equals(y2)) {
                        x2 += 10;
                    }
                    if (integer.equals(x3) && integer1.equals(y3)) {
                        x3 += 10;
                    }
                }
            }

            for (Integer integer: orealAxisX){
                for (Integer integer1: orealAxisY){
                    if (integer.equals(x1) && integer1.equals(y1)) {
                        x1 += 10;
                    }
                    if (integer.equals(x2) && integer1.equals(y2)) {
                        x2 += 10;
                    }
                    if (integer.equals(x3) && integer1.equals(y3)) {
                        x3 += 10;
                    }
                }
            }

            field[y1][x1] = "🛥";
            field[y2][x2] = "🛥";
            field[y3][x3] = "🛥";

            axisX.add(x1);
            if (x1 < 9){
                orealAxisX.add(x1 + 1);
            }
            if (x1 > 0) {
                orealAxisX.add(x1 - 1);
            }
            axisX.add(x2);
            if (x2 < 9) {
                orealAxisX.add(x2 + 1);
            }
            if (x2 < 9) {
                orealAxisX.add(x2 - 1);
            }
            axisX.add(x3);
            if (x3 < 9) {
                orealAxisX.add(x3 + 1);
            }
            if (x3 > 0) {
                orealAxisX.add(x3 - 1);
            }

            axisY.add(y1);
            if (y1 > 0) {
                orealAxisY.add(y1 - 1);
            }
            axisY.add(y2);
            axisY.add(y3);
            if (y3 < 9){
                orealAxisY.add(y3 + 1);
            }

            for (String[] x: field){
                System.out.println(Arrays.toString(x));
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Капитан, не верно указаны координаты!");
            addShip3();
        }catch (NoSuchElementException e){
            System.out.println("Капитан вы забываете важную вещь - ваш корабль трёхпалубный! " +
                    "введите 3 координаты!");
            addShip3();
        }
    }

    private void addShip2(){

        try {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            StringTokenizer stringTokenizer = new StringTokenizer(line, ", ;");

            String stX1 = stringTokenizer.nextToken();
            String stY1 = stringTokenizer.nextToken();
            String stX2 = stringTokenizer.nextToken();
            String stY2 = stringTokenizer.nextToken();

            int x1 = Integer.parseInt(stX1);
            int x2 = Integer.parseInt(stX2);

            int y1 = Integer.parseInt(stY1);
            int y2 = Integer.parseInt(stY2);

            // проверки кода
            if (y2 != y1) {
                if (y2 > y1) {
                    y2 = y1 + 1;
                }
                if (y2 < y1){
                    y2  = y1 + 1;
                }
            }

            if (x2 != x1){
                if (x2 > x1){
                    x2 = x1 + 1;
                }
                if (x2 < x1){
                    x2 = x1 + 1;
                }
            }

            // работа над ореолами
            for (Integer integer: axisX){
                for (Integer integer1: axisY) {
                    if (integer.equals(x1) && integer1.equals(y1)) {
                        x1 += 10;
                    }
                    if (integer.equals(x2) && integer1.equals(y2)) {
                        x2 += 10;
                    }
                }
            }

            for (Integer integer: orealAxisX){
                for (Integer integer1: orealAxisY){
                    if (integer.equals(x1) && integer1.equals(y1)) {
                        x1 += 10;
                    }
                    if (integer.equals(x2) && integer1.equals(y2)) {
                        x2 += 10;
                    }
                }
            }

            axisX.add(x1);
            if (x1 < 9){
                orealAxisX.add(x1 + 1);
            }
            if (x1 > 0) {
                orealAxisX.add(x1 - 1);
            }
            axisX.add(x2);
            if (x2 < 9) {
                orealAxisX.add(x2 + 1);
            }
            if (x2 < 9) {
                orealAxisX.add(x2 - 1);
            }

            axisY.add(y1);
            if (y1 > 0) {
                orealAxisY.add(y1 - 1);
            }
            axisY.add(y2);
            if (y2 < 9){
                orealAxisY.add(y2 + 1);
            }

            field[y1][x1] = "🛥";
            field[y2][x2] = "🛥";

            for (String[] x: field){
                System.out.println(Arrays.toString(x));
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Капитан, не верно указаны координаты!");
            addShip2();
        }catch (NoSuchElementException e){
            System.out.println("Капитан вы забываете важную вещь - ваш корабль двухпалубный! " +
                    "введите 2 координаты!");
            addShip2();
        }
    }

    private void addShip1(){

        try {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            StringTokenizer stringTokenizer = new StringTokenizer(line, ", ;");

            String stX1 = stringTokenizer.nextToken();
            String stY1 = stringTokenizer.nextToken();

            int x1 = Integer.parseInt(stX1);

            int y1 = Integer.parseInt(stY1);

            // работа над ореолами
            for (Integer integer: axisX){
                for (Integer integer1: axisY) {
                    if (integer.equals(x1) && integer1.equals(y1)) {
                        x1 += 10;
                    }
                }
            }

            for (Integer integer: orealAxisX){
                for (Integer integer1: orealAxisY){
                    if (integer.equals(x1) && integer1.equals(y1)) {
                        x1 += 10;
                    }
                }
            }

            axisX.add(x1);
            if (x1 < 9){
                orealAxisX.add(x1 + 1);
            }
            if (x1 > 0) {
                orealAxisX.add(x1 - 1);
            }

            axisY.add(y1);
            if (y1 > 0) {
                orealAxisY.add(y1 - 1);
            }
            if (y1 < 9){
                orealAxisY.add(y1 + 1);
            }

            field[y1][x1] = "🛥";

            for (String[] x: field){
                System.out.println(Arrays.toString(x));
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Капитан, не верно указаны координаты!");
            addShip1();
        }catch (NoSuchElementException e){
            System.out.println("Капитан вы забываете важную вещь - этот корабль очень маленький! " +
                    "введите введите всего одну координату!");
            addShip1();
        }
    }

    public void addShipsToPLayer(){
        System.out.println("Введи координаты четырехпалубного корабля (формат: x,y; x,y; x,y; x,y)");
        addEmptyPlace();
        addShip4();
        /*System.out.println("Теперь перейдем к трехпалубному кораблю!");
        addShip3();
        System.out.println("Капитан, нужен второй!");
        addShip3();
        System.out.println("Переходим к двухпалубным! Капитан, нужно таких 3!");
        addShip2();
        addShip2();
        addShip2();
        System.out.println("Остались самые маленькие кэп! Их нужно 4!");
        addShip1();
        addShip1();
        addShip1();
        addShip1();*/
    }
}
