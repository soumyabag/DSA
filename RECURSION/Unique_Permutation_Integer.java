package DSA;
import java.util.*;

public class Unique_Permutation_Integer {
    public void perm(int[] nums, int pos, List<List<Integer>> ans){
        if(pos >= nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int n : nums){
                list.add(n);
            }
            ans.add(list);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=pos;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                swap(nums,i,pos);
                perm(nums,pos+1,ans);
                swap(nums,i,pos);
            }
            
        }
    }
    
    public int[] swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm(nums,0,ans);
        return ans;
    }
}


