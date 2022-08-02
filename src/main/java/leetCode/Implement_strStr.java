package leetCode;

public class Implement_strStr {

    public int strStr(String haystack, String needle) {

        if(needle=="" || needle==null)
            return 0;

        return haystack.indexOf(needle);
    }
}
