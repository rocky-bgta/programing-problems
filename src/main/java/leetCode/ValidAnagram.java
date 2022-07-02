package leetCode;

public class ValidAnagram {

    public static void main(String[] args) {
       String s = "anagram";
       String t = "nagaram";

       ValidAnagram.isAnagram(s,t);
    }

    public static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        int [] countArr = new int[26];

        for (int i=0; i<str1.length(); i++){
            countArr[str1.charAt(i) - 'a']++;

            countArr[str2.charAt(i) - 'a']--;
        }

        for(int j=0; j<countArr.length; j++){
            if (countArr[j] != 0){
                return false;
            }
        }
        return true;
    }
}
