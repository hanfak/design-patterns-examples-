package algorithms.hashtable.ransomnote;

public class _04Example {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int ransomNoteLength = ransomNote.length();
        int magazineLength = magazine.length();
        if (ransomNoteLength == 1 && magazineLength == 1) {
            return ransomNote.equals(magazine);
        }
        if (ransomNoteLength > magazineLength) {
            return false;
        }
        int[] chars = new int[26];

        for (int i = 0; i < magazineLength; i++) {
            char letter = magazine.charAt(i);
            chars[letter - 'a']++;
        }

        for (int i = 0; i < ransomNoteLength; i++) {
            char letter = ransomNote.charAt(i);
            chars[letter - 'a']--;
            if (chars[letter - 'a'] < 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String... args) {
        boolean b = canConstruct("aea", "aba");
        System.out.println("b = " + b);
    }

}
