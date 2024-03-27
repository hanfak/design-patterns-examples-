package algorithms.hashtable.ransomnote;

public class _05Example {

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

        for (int i = 0; i < ransomNoteLength; i++) {
            char letter = ransomNote.charAt(i);
            int ind = magazine.indexOf(letter, chars[letter - 'a']);
            if (ind == -1) {
                return false;
            }
            chars[letter - 'a'] = ind + 1;
        }

        return true;

    }

    public static void main(String... args) {
        boolean b = canConstruct("aea", "aba");
        System.out.println("b = " + b);
    }

}
