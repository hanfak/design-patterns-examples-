package algorithms.validpalindrome;

public class Example02 {
    public boolean isPalindrome(String str) {
        short startInd = 0;
        short endInd = (short)(str.length()-1) ;
        char start ;
        char end;
        while(startInd<endInd){
            start = str.charAt(startInd);
            end = str.charAt(endInd);
            if(!Character.isLetterOrDigit(start)){
                startInd++;
            }
            if(!Character.isLetterOrDigit(end)){
                endInd--;
            }
            if (Character.toLowerCase(start) == Character.toLowerCase(end)){
                startInd++;
                endInd--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        new Example02().isPalindrome("A man, a plan, a canal: Panama");
    }
}
