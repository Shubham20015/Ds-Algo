package recursion;

import java.util.Scanner;

public class StringToInteger {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter string: ");
		
		String s = sc.next();
		
		System.out.println("Integer Value: ");
		
		System.out.println(strToint(s,s.length()-1));
		
		sc.close();
	}

	static int strToint(String input,int i) {
		
		if(i == 0) {
				return input.charAt(i) - '0';
		}
			int x = input.charAt(i) - '0';
		
		return strToint(input,i-1)*10 + x;
	}

}

