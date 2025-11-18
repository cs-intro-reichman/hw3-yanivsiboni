/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		if (str1.length() != str2.length()){
			return false;
		}
		char[] charArray2 = str2.toCharArray();
		for (int i = 0; i < str1.length(); i++){
			char c1 = str1.charAt(i);
			boolean found = false;
			for (int j = 0; j < str2.length(); j++){
				if (charArray2[j] != '*' && c1 == charArray2[j]){
					charArray2[j] = '*';
					found = true;
					break;
				}
			}
			if (!found){
			return false;
			}
		 
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		int i = 0;
		while (i < str.length()){
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z'){
				newStr += c;
				i++;
			} else if (c >= 'A' && c <= 'Z'){
				c = (char) (c + 32);
				newStr += c;
				i++;
			} else {
				i++;
			}	
		}
		return newStr;
	}
		
		
	   


	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		char[] charArray = str.toCharArray();
		String newString = "";
		int N = charArray.length;
		for (int i = 0; i < str.length(); i++){
			int randomChar = (int) ((Math.random() * (N - i)) + i);
			char temp = charArray[i];
			charArray[i] = charArray[randomChar];
			charArray[randomChar] = temp;
			newString = newString + charArray[i];
			
		
		}
		
		return newString;

	}
}
