package recursion;

import java.util.Scanner;

public class PermutationString {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter string: ");
		
		String s = sc.next();
		
		System.out.print("Permutations of given string: ");
		
		permute(s,0,s.length()-1);
		
		sc.close();
	}
	
	static void permute(String s,int x,int n) {
		if(x==n) {
			System.out.print(s+" ");
		}
		
		for(int i=x;i<=n;i++) {
			s = swap(s.toCharArray(),x,i);
			permute(s,x+1,n);
			s= swap(s.toCharArray(),x,i);
		}
	}
	
	static String swap(char ch[],int i,int j) {
		
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		
		return String.valueOf(ch);
	}

}
