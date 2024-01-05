/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String inputString) {
        String newLowerStr = "";
        for (int charIndex = 0; charIndex < inputString.length(); charIndex++) {
            char letter = inputString.charAt(charIndex);
            if (letter >= 'A' && letter <='Z') {
                letter += 32;
            }
            newLowerStr += letter;
        }
        return newLowerStr;
    }
}