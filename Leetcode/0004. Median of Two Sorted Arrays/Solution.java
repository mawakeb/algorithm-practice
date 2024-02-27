class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;

        // wanted index
        int pos = totalLength / 2;

        // current index of 3 arrays
        int cur1 = 0;
        int cur2 = 0;
        int cur = 0;

        // two middle values
        int med1 = 0;
        int med2 = 0;

        while (cur<=pos){
            int curVal = 0;
            if ( //if next number in nums1 is smaller or equal
                (cur1<nums1.length && cur2<nums2.length 
                && nums1[cur1] <= nums2[cur2]) || 
                //if nums2 ran out of numbers
                (cur1<nums1.length && cur2>=nums2.length)){
                curVal = nums1[cur1];
                cur1++;
            }
            else {
                curVal = nums2[cur2];
                cur2++;
            }
            if (cur == pos-1) med1 = curVal;
            else if (cur == pos) med2 = curVal;
            cur++;
        }

        //if totalLength is even return average of two middle values
        if (totalLength%2 == 0){
            return (double) (med1 + med2) / 2;
        } else {
            return med2;
        }

    }

}