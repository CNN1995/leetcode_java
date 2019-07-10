package cnn.leetcode.soluction;

public class AddBinary_67 {
    /**
     * Runtime: 5 ms, faster than 6.12% of Java online submissions for Add Binary.
     * Memory Usage: 35.5 MB, less than 58.98% of Java online submissions for Add Binary
     * @param a
     * @param b
     * @return
     */
        public static  String addBinary(String a, String b) {
            // 计算两个数相加
            int flag = 0;//进位
            String result = "";
            int i =0 ;
            for(; i < a.length()&&i<b.length(); i++){
                char A = a.charAt(a.length()-1-i);
                char B = b.charAt(b.length()-1-i);
                String item = "";
                if(A=='1'&&B=='1'){
                    if(flag == 0){
                        item = "0";
                    }else item = "1";
                    item = item + result;
                    result = item;
                    flag = 1;
                }else
                if(A=='0'&&B=='0'){
                    if(flag == 0){
                        item = "0";
                    }else item = "1";
                    item = item + result;
                    result = item;
                    flag = 0;
                }else
                if((A=='0'&&B=='1') ||(A=='1'&&B=='0') ){
                    if(flag == 0){
                        item = "1";
                        flag = 0;
                    }else
                    {item = "0";
                        flag = 1;}
                    item = item + result;
                    result = item;
                }

            }
            String newResult = "";
            if(flag == 0){
                if(b.length()>i){
                    newResult = b.substring(0,b.length()-i);
                }
                else{
                    newResult = a.substring(0,a.length()-i);
                }
            }else{
                while(b.length()>i){
                    // System.out.print("执行b");
                    String rest = b.substring(0,b.length()-i);
                    char item  = rest.charAt(rest.length()-1);
                    if(flag ==1){

                        if(item == '0'){
                            newResult = "1" + newResult;
                            rest =  rest.substring(0,rest.length()-1);
                            flag =0;
                        }
                        else{
                            System.out.print(" prenewResult:"+newResult);
                            newResult = "0" + newResult;
                            System.out.print(" postnewResult:"+newResult);
                            flag =1;
                        }
                    }
                    else{
                        newResult = item+newResult;
                    }
                    i++;
                }
                while(a.length()>i){
                    System.out.print("执行a");

                    String rest = a.substring(0,a.length()-i);
                    char item  = rest.charAt(rest.length()-1);
                    if(flag ==1){

                        if(item == '0'){
                            newResult = "1" + newResult;

                            flag =0;
                        }else{
                            newResult = "0" + newResult;

                            flag =1;
                        }
                    }else{
                        newResult = item+newResult;
                    }
                    i++;
                }

            }

            newResult = newResult + result;
            result= newResult;
            if(flag == 1){
                result = "1"+result;
            }
            return result;
        }

    /**
     * Runtime: 2 ms, faster than 53.10% of Java online submissions for Add Binary.
     * Memory Usage: 35.4 MB, less than 59.11% of Java online submissions for Add Binary.
     * 该思想客应用于T989
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a, String b) {
        String result="";
        int i = a.length()-1;
        int j = b.length()-1;
        int sum =0;
        while(i>=0 || j>=0 || sum == 1){
            sum += (i>=0)?a.charAt(i)-'0':0;
            sum += (j>=0)?b.charAt(j)-'0':0;

            result = (char)((char)(sum%2)+ '0')+result;

            // 或者  result = (char)((sum%2)+ '0')+result;
            // 因为 （char)1 = '\u00001' ASCII = 1
            // (char)(1+'0') = (char)49 = '1'; (char)((char)1+'0')=(char)(1+'0')=(char)49='1'
            // 记录进位的情况
            sum=sum/2;
            i--;
            j--;

        }
        return result;
    }
        public  static void main(String args[]){
            String result = addBinary2("101111","10");
            System.out.print(" result:"+result);
        }
    }

