package cnn.leetcode.soluction;

import java.util.Vector;

import static java.lang.Math.pow;

public class ReverseInteger_7 {

    /**
     * 将数字分解，装到vector中，
     * 从vector中转换为数字，length<10可直接组装，length = 10；需要进行判断
     * @param x
     * @return
     */
    public  static  int reverse(int x) {
        boolean flag = false;
        if (x > 0){
            flag = true;
        }
        Vector<Integer> vector = integerToVec(x);
        int vecLen = vector.size();
        if(vecLen < 10){
            // 可以带着符号直接输出
            return  vectorToInteger(vector);
        }
        int[] intUtil ={2,1,4,7,4,8,3,6,4};
        if(vecLen == 10) {
            if (Math.abs(vector.get(0)) > 2) {
                return 0;
            } else if (Math.abs(vector.get(0)) < 2) {
                return vectorToInteger(vector);
            } else {
                if (Math.abs((vector.get(1))) > 1) {
                    return 0;
                } else if (Math.abs((vector.get(1))) < 1) {
                    return vectorToInteger(vector);
                } else {
                    if (Math.abs((vector.get(2))) > 4) {
                        return 0;
                    } else if (Math.abs((vector.get(2))) < 4) {
                        return vectorToInteger(vector);
                    } else {
                        if (Math.abs((vector.get(3))) > 7) {
                            return 0;
                        } else if (Math.abs((vector.get(3))) < 7) {
                            return vectorToInteger(vector);
                        } else {
                            if (Math.abs((vector.get(4))) > 4) {
                                return 0;
                            } else if (Math.abs((vector.get(4))) < 4) {
                                return vectorToInteger(vector);
                            } else {
                                if (Math.abs((vector.get(5))) > 8) {
                                    return 0;
                                } else if (Math.abs((vector.get(5))) < 8) {
                                    return vectorToInteger(vector);
                                } else {
                                    if (Math.abs((vector.get(6))) > 3) {
                                        return 0;
                                    } else if (Math.abs((vector.get(6))) < 3) {
                                        return vectorToInteger(vector);
                                    } else {
                                        if (Math.abs((vector.get(7))) > 6) {
                                            return 0;
                                        } else if (Math.abs((vector.get(7))) < 6) {
                                            return vectorToInteger(vector);
                                        } else {
                                            if (Math.abs((vector.get(8))) > 4) {
                                                return 0;
                                            } else if (Math.abs((vector.get(8))) < 4) {
                                                return vectorToInteger(vector);
                                            } else {
                                                if ((flag == true && vector.get(9) > 7) || (flag == false && vector.get(9) > 8)) {
                                                    return 0;
                                                } else if ((flag == true && vector.get(9) <= 7) || (flag == false && vector.get(9) <= 8)) {
                                                    return vectorToInteger(vector);
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        return 0;

    }

    public static Vector<Integer> integerToVec(int x){
        Vector<Integer> vector = new Vector<>();
        while(true) {
            vector.add(x % 10);
            x = x / 10;
            if(x == 0){
                break;
            }
        }
        return vector;
    }
    public static Integer vectorToInteger(Vector<Integer> vector){
        int vecLen = vector.size();
        Integer sum = 0;
        int i =0;
        while (vecLen != 0){
           sum += new Double(vector.get(i++) * pow(10, vecLen - 1)).intValue();
            --vecLen;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(reverse(1463847412));
    }
}
