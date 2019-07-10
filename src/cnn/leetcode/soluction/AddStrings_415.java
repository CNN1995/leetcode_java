package cnn.leetcode.soluction;

public class AddStrings_415 {
    /**
     * Runtime: 10 ms, faster than 42.36% of Java online submissions for Add Strings.
     * Memory Usage: 35.9 MB, less than 99.65% of Java online submissions for Add Strings.
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        String result="";
        int i = num1.length()-1;
        int j = num2.length()-1;
        int sum =0;
        while(i>=0 || j>=0 || sum!=0 ){
            sum += (i>=0)?num1.charAt(i)-'0':0;
            sum += (j>=0)?num2.charAt(j)-'0':0;
            result = (char)((char)(sum%10)+ '0')+result;
            // 记录进位的情况
            sum=sum/10;
            i--;
            j--;

        }
        return result;
    }
}
