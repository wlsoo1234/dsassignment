import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {
    public static void main(String[] args) {
        String folderPath = "C:/Users/Mouawia/Downloads/WIA1002 DATA STRUCTURE/Lab/Pieces of Map/";

        // Load images and extract pixel maps
        int[][][] pixelMaps = new int[4][20][10];
        for (int i = 1; i <= 4; i++) {
            String imagePath = folderPath + "image" + i + ".png";
            BufferedImage image = readImage(imagePath);
            int[][] pixelMap = extractPixelMap(image);
            pixelMaps[i - 1] = pixelMap;
        }

        // Print pixel maps
        for (int i = 0; i < 4; i++) {
            System.out.println("Pixel Map for Image " + (i + 1));
            printPixelMap(pixelMaps[i]);
            System.out.println();
        }

        // Calculate the number of possible paths for each map piece passing through 3 stations
        int[] piecePaths = calculateMapPiecePaths(pixelMaps);

        // Print the number of possible paths for each map piece
        for (int i = 0; i < 4; i++) {
            System.out.println("Possible Paths for Map Piece " + (i + 1) + ": " + piecePaths[i]);
        }

        // Create a bigMap to represent the complete map
        int[][] bigMap = new int[40][20];

        // Form the complete map by inserting the map pieces into bigMap
        formCompleteMap(bigMap, pixelMaps);

        // Verify the final destination in the big map
        boolean isDestinationValid = verifyFinalDestination(bigMap);

        // Print the big map and verification result
        System.out.println("Big Map:");
        printBigMap(bigMap);
        System.out.println("Is Final Destination Valid? " + isDestinationValid);
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
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] pixelMap = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(col, row);
                int gray = (rgb >> 16) & 0xFF; // Extract red channel as grayscale value
                pixelMap[row][col] = gray / 64; // Convert grayscale value to range 0-3
            }
        }
        return pixelMap;
    }

    private static void printPixelMap(int[][] pixelMap) {
        for (int row = 0; row < pixelMap.length; row++) {
            for (int col = 0; col < pixelMap[row].length; col++) {
                System.out.print(pixelMap[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void formCompleteMap(int[][] bigMap, int[][][] pixelMaps) {
        // Implement your logic to form the complete map by inserting the map pieces into bigMap
        // You will need to iterate over the pixelMaps, identify the correct position in bigMap based on the numbers,
        // and copy the corresponding pixel values from the map piece to the bigMap
    }

    private static int[] calculateMapPiecePaths(int[][][] pixelMaps) {
        int[] piecePaths = new int[4];
        // Implement your logic to calculate the number of possible paths for each map piece
        // Update the piecePaths array accordingly
        for (int i = 0; i < pixelMaps.length; i++) {
            piecePaths[i] = countPaths(pixelMaps[i], 3);
        }
        return piecePaths;
    }

    private static int countPaths(int[][] pixelMap, int stations) {
        return countPathsRecursive(pixelMap, 0, 0, stations);
    }

    private static int countPathsRecursive(int[][] pixelMap, int row, int col, int stations) {
        // Base cases
        if (row < 0 || row >= pixelMap.length || col < 0 || col >= pixelMap[row].length) {
            return 0; // Out of bounds, no valid path
        }
        if (pixelMap[row][col] != 1) {
            return 0; // Invalid station, no valid path
        }
        if (stations == 0 && pixelMap[row][col] == 3) {
            return 1; // Reached the final destination, valid path
        }

        // Recursive cases
        int count = 0;
        if (pixelMap[row][col] == 1) {
            pixelMap[row][col] = -1; // Mark the station as visited

            // Explore all possible directions
            count += countPathsRecursive(pixelMap, row - 1, col, stations - 1); // Up
            count += countPathsRecursive(pixelMap, row + 1, col, stations - 1); // Down
            count += countPathsRecursive(pixelMap, row, col - 1, stations - 1); // Left
            count += countPathsRecursive(pixelMap, row, col + 1, stations - 1); // Right

            pixelMap[row][col] = 1; // Reset the station after backtracking
        }

        return count;
    }

    private static boolean verifyFinalDestination(int[][] bigMap) {
        boolean isDestinationValid = false;
        // Implement your logic to verify the final destination in the big map
        // Set isDestinationValid based on the verification result
        return isDestinationValid;
    }

    private static void printBigMap(int[][] bigMap) {
        for (int row = 0; row < bigMap.length; row++) {
            for (int col = 0; col < bigMap[row].length; col++) {
                System.out.print(bigMap[row][col] + " ");
            }
            System.out.println();
        }
    }
}
