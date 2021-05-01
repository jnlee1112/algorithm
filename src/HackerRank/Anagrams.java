package HackerRank;

import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}
	
	public static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length() != b.length()) return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        for(char c = 'a'; c <= 'z'; c++){
            int countA = 0;
            int countB = 0;
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) == c){
                    countA++;
                }
                if(b.charAt(i) == c){
                    countB++;
                }
            }
            if(countA != countB) return false;            
        }
        return true;
    }

}
