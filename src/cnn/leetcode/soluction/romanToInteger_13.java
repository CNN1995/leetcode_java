package cnn.leetcode.soluction;
public class romanToInteger_13 {
    /**
     * V 和 X 左边的小数字只能用Ⅰ。
     * L 和 C 左边的小数字只能用×。
     * D 和 M 左 边的小数字只能用 C 。
     */
    public static int romanToInt(String s) {
        int result = 0;
        int integerValue = 0;
        int integerValue2 = 0;
        if(s.length()==0){
            return 0;
        }
        for(int i = 0; i < s.length(); i++){
            integerValue = romanCharacherToInteger(s.charAt(i));
            if( i < (s.length() - 1) && integerValue < (integerValue2 = romanCharacherToInteger(s.charAt(i + 1)))) {

                result += integerValue2 - integerValue;
                i++;
            }
            else{
                result += integerValue;
            }
        }
        return result;
    }
    public static int romanCharacherToInteger(char ch){
        int result =0;
        switch (ch){
            case 'I': result = 1; break;
            case 'V': result = 5; break;
            case 'X': result = 10; break;
            case 'L': result = 50; break;
            case 'C': result = 100; break;
            case 'D': result = 500; break;
            case 'M': result = 1000; break;
        }
        return result;
    }
    public static void main(String[] args){

        System.out.println(romanToInt("IV"));
    }
}
