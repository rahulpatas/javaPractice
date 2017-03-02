package Coursera;

public class QuickUnionUF {

    private static int[] id;
    private static int[] sz;

    public static void QuickUnionUF(int N) {

        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private static int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public static boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) {
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public static boolean isFrindsConnected(int p, int q) {
        if (connected(p, q)) {
            return true;
        } else {
            union(p, q);
            return false;
        }
    }

    public static void main (String[] args) {
        QuickUnionUF(10);
        union(9,0);
        union(3,4);
        union(8,5);
        union(7,2);
        union(2, 1);
        union(5, 7);
        union(0, 3);
        union(4, 2);

    }
}