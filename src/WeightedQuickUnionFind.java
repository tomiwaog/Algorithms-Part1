public class WeightedQuickUnionFind {
    int[] member;
    int count;
    int weight[];

    public WeightedQuickUnionFind(int N) {
        member = new int[N];
        weight = new int[N];
        for (int i = 0; i < N; i++) {
            member[i] = i;
            weight[i] = 1;
        }
        count = N;
    }

    boolean isConnected(int member1, int member2) {
        return find(member1) == find(member2);
    }

    int find(int m) { // Path optimisation
        int input = m;
        while (input != member[input]) {
            member[input] = member[member[input]];
            input = member[input];
        }
        return input;
    }

    int count() {
        return count;
    }

    void union(int member1, int member2) {
        if (isConnected(member1, member2))
            return;

        int id1 = find(member1);
        int id2 = find(member2);

        if (weight[id1] <= weight[id2]) {
            member[id1] = member[id2];
            weight[id2] += weight[id1];
        } else {
            member[id2] = member[id1];
            weight[id1] = +weight[id1];
        }
        count--;
    }

    public static void main(String[] args) {
        WeightedQuickUnionFind uf = new WeightedQuickUnionFind(11);
        System.out.println("5, 2 connected? " + uf.isConnected(5, 2));
        System.out.println("1,3 connected? " + uf.isConnected(1, 3));
        uf.union(5, 2);
        uf.union(1, 3);
        uf.union(6, 8);
        uf.union(7, 1);
        uf.union(4, 1);
        uf.union(5, 3);
        uf.union(8, 7);
        uf.union(9, 10);
        uf.union(9, 0);
        uf.union(8, 10);
        uf.union(4, 7);
        System.out.println("2 3 connected? " + uf.isConnected(8, 7));

        System.out.println(uf.count());
    }
}
