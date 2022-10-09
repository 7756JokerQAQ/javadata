import java.util.Random;

public class Main {

    private static double textUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
//        UnionFind1 uf1=new UnionFind1(size);
//        System.out.println("UnionFind1: "+textUF(uf1,m));
//        UnionFind2 uf2=new UnionFind2(size);
//        System.out.println("UnionFind2: "+textUF(uf2,m));
        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3:" + textUF(uf3, m));
        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4:" + textUF(uf4, m));
        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5:" + textUF(uf5, m));
        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind5:" + textUF(uf6, m));

        //并查集的时间复杂度O(h),严格意义上 加入路径压缩O(log*n)
        // log*n=1+log*(logn)  if(n>1)  当n<=1时 log n= 0 几乎时O(1)复杂度

    }
}
