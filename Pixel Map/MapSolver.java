import java.util.*;

public class MapSolver {

    private static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int ROWS, COLS;
    private static final int TARGET_STATIONS = 3;
    private static int target_stations;
    private static List<int[][]> images = new ArrayList<>();

    private static int[][] getImages(int a){
        return images.get(a);
    }

    private static int pathCount;
    public static void main(String[] args) {
        // Assuming you have loaded your 2D arrays into a list.

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
        int[] image_pathcounts = new int[5];

        for (int i = 0; i < images.size(); i++) {
            ROWS = images.get(i).length;
            COLS = images.get(i)[0].length;
            image_pathcounts[i] = findPaths(getImages(i), 3);
            System.out.println("Possible paths: " + image_pathcounts[i]);
        }

    }
    

    public static int findPaths(int[][] array, int targetStation) {
        //System.out.println("Method findPaths(array, " + targetStation + ")");
        pathCount = 0;
        boolean[][] visited = new boolean[array.length][array[0].length];
        target_stations = targetStation;
        dfs(array, 0, 0, 0,visited);
        return pathCount;
    }


    private static void dfs(int[][] image, int row, int col, int stationsCount, boolean[][] visited) {
        int rows = image.length;
        int columns = image[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= columns || visited[row][col] || image[row][col] == 1) {
            return;
        }

        if (image[row][col] == 3 && stationsCount == target_stations) {
            pathCount++;
            return;
        }

        if (image[row][col] == 2) {
            stationsCount++;
        }

        visited[row][col] = true;

        for (int[] direction : DIRECTIONS) {
            rows = row + direction[0];
            columns = col + direction[1];
            dfs(image, rows, columns, stationsCount,visited);
        }
        visited[row][col] = false;

    }
}
