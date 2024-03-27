package algorithms.validpalindrome;

public class Example01 {
    public boolean isPalindrome(String s) {
        int fp = 0;
        char[] chars = s.replaceAll("[^a-zA-Z0-9\\s]", " ").replaceAll("[\\s]", "").toLowerCase().toCharArray();
        int rp = chars.length - 1;
        System.out.println(chars);
        while (fp <= rp) {

            if (chars[fp] != chars[rp]) return false;
            fp++;
            rp--;
        }
        return true;

    }

    public static void main(String... args) {
        new Example01().isPalindrome("A man, a plan, a canal: Panama");
    }
}
