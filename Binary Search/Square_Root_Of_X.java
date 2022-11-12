package Problems;

public class Square_Root_Of_X {
	public int mySqrt(int x) {
		int start = 0;
		int end = x;
		long ans = -1;

		while(start<=end){
			long mid = (start+end)/2;
			long sqr = mid*mid;
			if(sqr == x)
				return (int)mid;
			if(sqr < x){
				ans = mid;
				start = (int)(mid+1);
			}
			else{
				end = (int)(mid-1); 
			}
		}
		return (int)ans;
	}
}
