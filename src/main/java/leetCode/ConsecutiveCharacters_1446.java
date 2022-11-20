package leetCode;
//https://leetcode.com/problems/consecutive-characters/description/
public class ConsecutiveCharacters_1446 {

            int maxPower(String s){
                int ans =1;
                int x =1;

                for(int i=1; i<s.length(); i++){
                    if(s.charAt(i-1)==s.charAt(i)){
                        x++;
                    }else {
                        ans = Math.max(ans,x);
                        x=1;
                    }
                }
                ans = Math.max(ans,x);
                return ans;
            }


}
