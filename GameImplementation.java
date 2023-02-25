package FinalProject;

import java.util.*;

public class GameImplementation {
    final String[][] attackField;
    Set<Integer> savedShotsAxisX = new HashSet<>();
    Set<Integer> savedShotsAxisY = new HashSet<>();
    Set<Integer> destroyedShipsAxisX = new HashSet<>();
    Set<Integer> destroyedShipsAxisY = new HashSet<>();

    public GameImplementation() {
        attackField = new String[10][10];
        addEmptyPlace();
    }

    private void addEmptyPlace(){
        for (String[] strings : attackField) {
            Arrays.fill(strings, "⬜️");
        }
    }
}
