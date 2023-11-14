package geeksforgeeks;

/*
    https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1

 */

public class StringsAreRotationsOfEachOtherOrNot {

    //Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2 )
    {
        // Your code here
        if(s1.length()!=s2.length()){
            return false;
        }else{
            if((s1+s1).contains(s2)){
                return true;
            }
        }
        return false;
    }
}
