package cnn.leetcode.soluction;

public class integerToRoman_12 {
    public static String intToRoman(int num) {
        final String[][] str = {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},  // 个位数举例
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},  // 十位数举例
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},  // 百位数举例
                {"","M","MM","MMM"}  // 千位数举例
        };
        // 先将3999存到一个数组numResult中，得到{9,9,9,3},然后倒着遍历数组，从最高位依次输出 MMM--》MMMCM--》MMMCMXC--》MMMCMXCIX
        int i = -1;
        int[] numResult  = {-1,-1,-1,-1};
        String result = "";
        int restNum = num;
        while (restNum !=0 ) {
            int currNum = restNum % 10;
            restNum = restNum / 10;
            numResult[++i] = currNum;
        }
       // int length = numResult.length;
        while(i >= 0){
            result += str[i][numResult[i--]];
        }
        return result;

    }
    public static void main(String[] args){

        System.out.println(intToRoman(3999));
    }
}
