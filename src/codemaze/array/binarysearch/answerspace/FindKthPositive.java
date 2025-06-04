package codemaze.array.binarysearch.answerspace;
/*1539. Kth Missing Positive Number
Solved
        Easy
Topics
conpanies icon
Companies
        Hint
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.



        Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


Constraints:

        1 <= arr.length <= 1000
        1 <= arr[i] <= 1000
        1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length


Follow up:

Could you solve this problem in less than O(n) complexity?*/
class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            // Calculate how many positive integers are missing up to arr[mid]
            // The number of missing positive integers is arr[mid] - (mid + 1)
            // mid + 1 is used because the array is 0-indexed, so we need to adjust the count
            int missing = arr[mid]-(mid+1);
            if(missing<k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        //return high+1+k;
        return left+k;
    }
    public int findKthPositiveLinearTime(int[] arr, int k) {
        for(int a : arr){
            if(a<=k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }

}