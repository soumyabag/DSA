package Problems;

public class Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = getPivot(nums);
        if(target >= nums[pivot] && target <= nums[n-1]){
            return bSearch(nums, pivot, n-1, target);
        }else
            return bSearch(nums, 0, pivot, target);
    }

    public int getPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start < end){
            int mid = (start+end)/2;

            if(nums[mid] >= nums[0])
                start = mid+1;
            else
                end = mid;
        }
        return start;
    }

    public int bSearch(int[] nums, int s, int e, int target){
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid] == target)
                return mid;
            if(target > nums[mid])
                s = mid+1;
            else
                e = mid-1;
        }
        return -1;
    }

}
