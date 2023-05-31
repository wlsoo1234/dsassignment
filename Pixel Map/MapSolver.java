import java.util.*;

public class MapSolver {

    private static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int ROWS, COLS;

    public static void main(String[] args) {
        // Assuming you have loaded your 2D arrays into a list.
        List<int[][]> images = new ArrayList<>();

        int[][] map1 = { 
                { 0, 0, 2, 0, 0, 0, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 0, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 0, 2, 0, 1 },
                { 0, 1, 0, 1, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
                { 0, 0, 0, 1, 1, 1, 1, 0, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 0, 0, 2, 1, 1, 0, 1 },
                { 0, 1, 1, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 },
                { 2, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 3 } };
        int[][] map2 = { { 0, 0, 2, 0, 0, 0, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 0, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 0, 2, 0, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 2, 1, 0, 0, 1 },
                { 0, 0, 0, 1, 1, 0, 1, 0, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 0, 0, 0, 1, 2, 0, 1 },
                { 0, 1, 1, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 },
                { 2, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 0, 0, 1, 1, 0, 3 } };
        int[][] map3 = { { 0, 0, 2, 0, 0, 0, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 0, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 0, 2, 0, 1 },
                { 0, 1, 0, 1, 1, 2, 0, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
                { 0, 0, 0, 1, 1, 1, 1, 0, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 0, 0, 2, 1, 1, 0, 1 },
                { 0, 1, 1, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 },
                { 2, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 3 } };
        int[][] map4 = { { 0, 0, 2, 0, 0, 0, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 1, 2, 0, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 },
                { 0, 1, 0, 1, 1, 2, 0, 0, 0, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 0, 1, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 0, 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 1, 1 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 0, 0, 2, 1, 1, 0, 1 },
                { 0, 1, 1, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 },
                { 2, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 0, 0, 1, 1, 0, 3 } };

        images.add(map1);
        images.add(map2);
        images.add(map3);
        images.add(map4);

        for (int[][] image : images) {
            ROWS = image.length;
            COLS = image[0].length;
            int pathsCount = 0;
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (image[i][j] == 2) {
                        pathsCount += dfs(image, i, j, 0, new boolean[ROWS][COLS]);
                    }
                }
            }
            System.out.println("Possible paths: " + pathsCount);
        }
    }

    private static int dfs(int[][] image, int row, int col, int stationsCount, boolean[][] visited) {
        if (stationsCount > 3 || image[row][col] == 1 || visited[row][col]) {
            return 0;
        }

        if (image[row][col] == 3) {
            if (stationsCount == 3) {
                return 1;
            } else {
                return 0;
            }
        }

        visited[row][col] = true;
        int paths = 0;

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValid(newRow, newCol)) {
                paths += dfs(image, newRow, newCol, image[row][col] == 2 ? stationsCount + 1 : stationsCount, visited);
            }
        }

        visited[row][col] = false;

        return paths;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }
}
