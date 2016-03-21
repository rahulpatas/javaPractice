package GeekCoder;

import java.util.*;

public class NNChess {

    static List<Map.Entry<int[][], Boolean>> completedChessList = new ArrayList<>();
    static final int[] xMove = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    static final int[] yMove = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void getNNChess(int N, int x, int y) {

        int[][] chess = new int[N][N];
        int curIndex = 1;

        findPath(chess, N, x, y, curIndex);
    }

    private static void findPath(int[][] chess, int N, int x, int y, int curIndex) {

        chess[x][y] = curIndex;

        if (curIndex == N * N) {
            completedChessList.add(new AbstractMap.SimpleEntry<>(chess, checkClosedLoop(chess, N, x, y)));
            System.out.println(completedChessList.size());
            printChess(chess, N);
            return;
        }

        for (int i = 0; i < xMove.length; i++) {

            int xNext = x + xMove[i];
            int yNext = y + yMove[i];

            if (xNext < N && xNext >= 0 && yNext >= 0 && yNext < N && chess[xNext][yNext] == 0) {
                findPath(chess, N, xNext, yNext, curIndex + 1);
                chess[xNext][yNext] = 0;
            }
        }
    }

    private static boolean checkClosedLoop(int[][] chess, int N, int x, int y) {

        for (int i = 0; i < xMove.length; i++) {

            int xNext = x + xMove[i];
            int yNext = y + yMove[i];

            if (xNext < N && xNext >= 0 && yNext >= 0 && yNext < N && chess[xNext][yNext] == 1) {
                return true;
            }
        }

        return false;
    }

    static void printChess(int chess[][], int N) {

        for (int x = 0; x < N; x++) {

            for (int y = 0; y < N; y++) {
                System.out.print((chess[x][y] > 9 ? chess[x][y] : "0" + chess[x][y]) + " ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        getNNChess(8, 0, 0);
    }
}
