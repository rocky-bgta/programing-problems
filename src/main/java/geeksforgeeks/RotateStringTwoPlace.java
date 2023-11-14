package geeksforgeeks;

/*
    https://www.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1

 */

public class RotateStringTwoPlace {

    public static void main(String[] args) {
//        String str1 = "amazon";
//        String str2 = "azonam";

        String str1 = "daxjheq";
        String str2 = "eqdaxjh";

        isRotated(str1, str2);
    }

    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2) {
        // check corner case
        if (str1.length() != str2.length()) {
            return false;
        }
        //String str1 = "amazon";
        //String str2 = "azonam";
        //left rotation
        //amazon    //azon
        //012345
        String first, second, third;
        first = str1.substring(2); //azon
        second = str1.substring(1, 2); //m
        third = str1.substring(0, 1); //a


        if ((str1.substring(2) + str1.substring(0, 1) + str1.substring(1, 2)).equals(str2)) {
            return true;
        }

        //right rotation

        //String str1 = "daxjheq";
        //String str2 = "eqdaxjh";
        //right rotation

        //012345

        first = str1.substring((str1.length() - 2), str1.length() - 1); //e
        second = str1.substring(str1.length() - 1, str1.length()); //q

        third = str1.substring(0, str1.length() - 2); //dazjh

        if ((str1.substring((str1.length() - 2), str1.length() - 1) + str1.substring(str1.length() - 1, str1.length()) + str1.substring(0, str1.length() - 2)).equals(str2)) {
            return true;
        }

        return false;
    }

}