package recursion;

import java.util.Scanner;

public class Replace_pi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter string: ");
		
		String s = sc.next();
		
		System.out.println("New string: ");
		
		System.out.println(reppi(s));
		
		sc.close();
	}

	static String reppi(String input) {
		String output = "";
		for(int i=0;i<input.length()-1;i++) {
			if(input.charAt(i) == 'p' && input.charAt(i+1) == 'i') {
				output += 3.14;
				i++;
			}
			else
				output += input.charAt(i);
		}
		
		return output;
	}
}
