package DSA;

import java.util.*;

public class Unique_Permutation_String {

	public static void main(String[] args) {
		String str = "aab";
		char[] ch = str.toCharArray();
		List<List<String>> ans = new ArrayList<>();
		permutation(ch,0,ans);
		System.out.println(ans);
	}

	private static void permutation(char[] ch, int pos, List<List<String>> ans) {
		if(pos >= ch.length) {
			ArrayList<String> list = new ArrayList<>();
			for(char c :ch) {
				list.add(Character.toString(c));
			}
			ans.add(list);
		}
		HashSet<Character> set = new HashSet<>();
		for(int i = pos; i<ch.length; i++) {
			if(!set.contains(ch[i])) {
				set.add(ch[i]);
				swap(ch,i,pos);
				permutation(ch, pos+1, ans);
				swap(ch,i,pos);
			}
			
		}
	}
	private static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

}
