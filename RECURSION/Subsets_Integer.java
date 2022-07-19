package DSA;
import java.util.*;
// T.C.- O(2^n)
public class Subsets_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        sub(nums,0,output,ans);
        System.out.println(ans);
	}
	
	public static void sub(int[] nums, int i, List<Integer> output, List<List<Integer>> ans){
        if(i >= nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }
       
        // include
        int element = nums[i];
        output.add(element);
        sub(nums,i+1,output,ans);
        
        //exclude
        output.remove(output.size()-1);
        sub(nums,i+1,output,ans);
    }
}
