
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        dfs(image, sr, sc, color, image[sr][sc]);

        return image;
    }

    public void dfs(int[][] image, int i, int j,
                    int newColor, int originalColor) {

        if (i < 0 || i >= image.length ||
            j < 0 || j >= image[0].length ||
            image[i][j] == newColor ||
            image[i][j] != originalColor) {

            return;
        }

        image[i][j] = newColor;

        dfs(image, i - 1, j, newColor, originalColor); // Up
        dfs(image, i, j + 1, newColor, originalColor); // Right
        dfs(image, i + 1, j, newColor, originalColor); // Down
        dfs(image, i, j - 1, newColor, originalColor); // Left
    }
}
