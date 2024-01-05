/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String inputStr) {
        String noDupStr = "";
        for (int charIndex = 0; charIndex < inputStr.length(); charIndex++) {
            char letter = inputStr.charAt(charIndex);
            if (noDupStr.indexOf(letter) == -1 || letter == 32) {
                noDupStr += letter;
            }
        }
        return noDupStr;
    }
}