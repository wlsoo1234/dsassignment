import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ImageProcessor1 {

    private static final int MAP_ROWS = 80; // check the Big map (40x20)
    private static final int MAP_COLS = 10;

    public static void main(String[] args) {
        String folderPath = "C:/Users/Mouawia/Downloads/WIA1002 DATA STRUCTURE/Lab/Pieces of Map/";

        // Load images and extract pixel maps
        List<int[][]> pixelMaps = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            String imagePath = folderPath + "image" + i + ".png";
            BufferedImage image = readImage(imagePath);
            int[][] pixelMap = extractPixelMap(image);
            pixelMaps.add(pixelMap);
        }

        // Compute the paths
        int[] paths = computePaths(pixelMaps);

        // Order the maps
        pixelMaps = orderMaps(pixelMaps, paths);

        // Create a bigMap to represent the complete map
        int[][] bigMap = new int[MAP_ROWS][MAP_COLS];

        // Form the complete map by inserting the map pieces into bigMap
        formCompleteMap(bigMap, pixelMaps);

        // Modify the final destinations
        modifyFinalDestination(bigMap);

        // Verify the final destination in the big map
        boolean isDestinationValid = verifyFinalDestination(bigMap);

        // Print the big map and verification result
        System.out.println("Big Map:");
        printBigMap(bigMap);
        System.out.println("Is Final Destination Valid? " + isDestinationValid);

        // Search for possible paths with exactly 4 stations
        if (isDestinationValid) {
            int pathCount = searchPaths(bigMap);
            System.out.println("Number of possible paths: " + pathCount);

            List<List<int[]>> possiblePaths = searchForPaths(bigMap);
            System.out.println("Possible Paths:");
            for (List<int[]> path : possiblePaths) {
                printPath(path);
            }
        }
    }

    private static int[] computePaths(List<int[][]> pixelMaps) {
        int[] paths = new int[pixelMaps.size()];
        for (int i = 0; i < pixelMaps.size(); i++) {
            int pathCount = 0;
            for (int row = 0; row < pixelMaps.get(i).length; row++) {
                for (int col = 0; col < pixelMaps.get(i)[row].length; col++) {
                    if (pixelMaps.get(i)[row][col] == 1) {
                        pathCount++;
                    }
                }
            }
            paths[i] = pathCount;
        }
        return paths;
    }

    private static List<int[][]> orderMaps(List<int[][]> pixelMaps, int[] paths) {
        for (int i = 0; i < pixelMaps.size() - 1; i++) {
            for (int j = 0; j < pixelMaps.size() - i - 1; j++) {
                if (paths[j] < paths[j + 1]) {
                    // Swap paths
                    int tempPath = paths[j];
                    paths[j] = paths[j + 1];
                    paths[j + 1] = tempPath;

                    // Swap maps
                    int[][] tempMap = pixelMaps.get(j);
                    pixelMaps.set(j, pixelMaps.get(j + 1));
                    pixelMaps.set(j + 1, tempMap);
                }
            }
        }
        return pixelMaps;
    }

    private static void formCompleteMap(int[][] bigMap, List<int[][]> pixelMaps) {
        // Insert the pixel map into the big map at the correct position
        for (int mapIdx = 0; mapIdx < pixelMaps.size(); mapIdx++) {
            int[][] pixelMap = pixelMaps.get(mapIdx);
            int startRow = mapIdx * 20;
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 10; col++) {
                    bigMap[startRow + row][col] = pixelMap[row][col];
                }
            }
        }
    }

    private static void modifyFinalDestination(int[][] bigMap) {
        for (int row = 0; row < bigMap.length; row++) {
            for (int col = 0; col < bigMap[row].length; col++) {
                if (bigMap[row][col] == 3 && (row != bigMap.length - 1 || col != bigMap[row].length - 1)) {
                    bigMap[row][col] = 2; // change to obstacle
                }
            }
        }
    }

    private static void printBigMap(int[][] bigMap) {
        for (int row = 0; row < bigMap.length; row++) {
            for (int col = 0; col < bigMap[row].length; col++) {
                System.out.print(bigMap[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static BufferedImage readImage(String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private static int[][] extractPixelMap(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        int[][] pixelMap = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int pixel = image.getRGB(col, row);
                int gray = (pixel >> 16) & 0xff; // Extract red channel as grayscale value
                pixelMap[row][col] = gray / 64; // Convert grayscale value to range 0-3
            }
        }
        return pixelMap;
    }

    private static boolean verifyFinalDestination(int[][] bigMap) {
        int finalDestinationCount = 0;
        for (int row = 0; row < bigMap.length; row++) {
            for (int col = 0; col < bigMap[row].length; col++) {
                if (bigMap[row][col] == 3) {
                    finalDestinationCount++;
                    if (finalDestinationCount > 1) {
                        return false;
                    }
                }
            }
        }
        return finalDestinationCount == 1;
    }

    private static int searchPaths(int[][] bigMap) {
        // Create a data structure for visited nodes.
        boolean[][] visited = new boolean[MAP_ROWS][MAP_COLS];
        // Initialize a counter for the number of paths.
        int pathCount = 0;

        // Create a queue for BFS traversal.
        Queue<int[]> queue = new LinkedList<>();
        // Start BFS traversal from the top-left corner of the map.
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            // Get the next cell from the queue.
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Check if the cell is within the boundaries of the map and is not an obstacle.
            if (row >= 0 && row < MAP_ROWS && col >= 0 && col < MAP_COLS && bigMap[row][col] != 2) {
                // Check if the cell has not been visited yet.
                if (!visited[row][col]) {
                    visited[row][col] = true;

                    // Check if the cell is a destination.
                    if (bigMap[row][col] == 3) {
                        // Increment the path count.
                        pathCount++;
                    } else {
                        // Add the neighboring cells to the queue.
                        queue.add(new int[]{row - 1, col});
                        queue.add(new int[]{row + 1, col});
                        queue.add(new int[]{row, col - 1});
                        queue.add(new int[]{row, col + 1});
                    }
                }
            }
        }

        return pathCount;
    }

    private static List<List<int[]>> searchForPaths(int[][] bigMap) {
        List<List<int[]>> allPaths = new ArrayList<>();
        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[MAP_ROWS][MAP_COLS];
        // start from top left corner
        dfs(bigMap, 0, 0, visited, path, allPaths, 0);
        return allPaths;

    }
    private static void dfs(int[][] bigMap, int row, int col, boolean[][] visited, List<int[]> path, List<List<int[]>> allPaths, int stationCount) {
        // Check if the cell is within the boundaries of the map, is not an obstacle, and has not been visited yet.
        if (row < 0 || row >= MAP_ROWS || col < 0 || col >= MAP_COLS || bigMap[row][col] == 2 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        // Increase station count if current cell is a station
        if(bigMap[row][col] == 1) {
            stationCount++;
        }

        path.add(new int[]{row, col});

        // Check if the current cell is the destination and if the path has exactly 4 stations
        if (bigMap[row][col] == 3 && stationCount == 4) {
            allPaths.add(new ArrayList<>(path));  // add copy of the path
        } else {
            // Explore the neighboring cells.
            dfs(bigMap, row - 1, col, visited, path, allPaths, stationCount);
            dfs(bigMap, row + 1, col, visited, path, allPaths, stationCount);
            dfs(bigMap, row, col - 1, visited, path, allPaths, stationCount);
            dfs(bigMap, row, col + 1, visited, path, allPaths, stationCount);
        }

        // Backtrack: remove the cell from the current path and mark it as not visited.
        path.remove(path.size() - 1);
        visited[row][col] = false;
    }


    private static void printPath(List<int[]> path) {
        for (int[] coordinate : path) {
            System.out.println("(" + coordinate[0] + ", " + coordinate[1] + ")");
        }
        System.out.println();
    }

}
