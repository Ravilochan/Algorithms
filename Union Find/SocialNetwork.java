import java.util.Scanner;

public class SocialNetwork {
    private int[] parent;
    private int[] rank;
    private int count;
    private int n;

    public SocialNetwork(int n) {
        this.n = n;
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        if (rank[rootP] < rank[rootQ])
            parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ])
            parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SocialNetwork snc = new SocialNetwork(n);
        int m = sc.nextInt();
        int[] timestamps = new int[m];
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            timestamps[i] = sc.nextInt();
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            snc.union(a[i], b[i]);
            if (snc.count() == 1) {
                System.out.println("All members are connected at time " + timestamps[i]);
                break;
            }
        }
        sc.close();
    }
}
