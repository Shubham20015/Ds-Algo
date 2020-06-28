package recursion;

import java.util.Scanner;

public class SubsequenceString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter string: ");
		
		String s = sc.next();
		
		System.out.print("Subsequences of given string: ");
		
		sequence(s,"");
		
		sc.close();
		}
	
	static void sequence(String s,String ans) {
		if(s.length() == 0) {
			System.out.println(ans);
			return;
		}
		sequence(s.substring(1),ans);
		sequence(s.substring(1),ans + s.charAt(0));
	}
}
