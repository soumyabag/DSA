package DSA;
import java.util.*;

public class Unique_subsets {
	 public void sub(int[] nums, int i, List<Integer> output, List<List<Integer>> ans){
	        if(i >= nums.length){
	            ans.add(new ArrayList<>(output));
	            return;
	        }
	        // including
	        int element = nums[i];
	        output.add(element);
	        sub(nums,i+1,output,ans);
	        
	        // excluding
	        output.remove(output.size()-1);
	        
	        while(i+1 <nums.length && nums[i] == nums[i+1]){
	            i++;
	        }
	        sub(nums,i+1,output,ans);
	    }
	    public List<List<Integer>> subsetsWithDup(int[] nums) {
	        List<List<Integer>> ans = new ArrayList<>();
	        List<Integer> output = new ArrayList<>();
	        Arrays.sort(nums);
	        sub(nums,0,output,ans);
	        return ans;
	    }

}
