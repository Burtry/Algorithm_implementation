package LeetCode.src.main.java.text.textAgain;

public class merge {
//    合并两个有序数组
    //合并nums2到nusm1中,nums1中的长度为n+m

    //nums1 [1,2,3,3,0,0,0] m = 4
           //p1
    //nums2 [1,2,5,6] n = 3
             //p2
    // [1,2,2,3,3,5,6]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m -1; //指向nums1中最后一个元素
        int p2 = n -1; //指向nums2中最后一个元素
        int len = m+n -1; //指向nums数组最后
        while (p1 >=0 && p2 >=0) {
            if(nums1[p1] >= nums2[p2]) {
                nums1[len] = nums1[p1];
                p1--;
                len--;
            }else {
                nums1[len] = nums2[p2];
                p2--;
                len--;
            }
        }
        while (p2 >0) nums1[len--] = nums2[p2--];
    }
}
