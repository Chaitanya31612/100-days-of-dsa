package day22_binarytreemisc;

public class FloodFill {
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if(originalColor == newColor)
            return image;

        floodFillUtil(image, sr, sc, originalColor, newColor);
        return image;
    }

    public void floodFillUtil(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;

        if(image[sr][sc] != originalColor)
            return;

        image[sr][sc] = newColor;
        for(int k = 0; k < 4; k++) {
            floodFillUtil(image, sr+dx[k], sc+dy[k], originalColor, newColor);
        }
    }
}
