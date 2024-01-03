package JavaAlgo.src.main.java.datastructure.recursion;

/**
 * 递归二分查找
 */
public class BinarySearch {

    //对外只需要数组和目标值
    public static int search(int[] a, int target) {
        return fun(a,target,0,a.length -1);
    }




    /**
     * 递归函数
     * @param a 待查找的数组
     * @param target 待查找的目标朱
     * @param i 起始点
     * @param j 结束点
     * @return 返回值
     */
    private static int fun(int[] a, int target, int i, int j) {

        //递归结束条件
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if(target < a[m]) {
            return fun(a, target, i, m -1);
        } else if (a[m] < target) {
            return fun(a,target,m +1, j);
        } else {
            return m;
        }
    }
}
