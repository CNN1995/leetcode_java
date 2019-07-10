package com.leetcode.test;

public class examAli {
    public static void main(String[] args){
        test(20,3);
    }
    public  static void test(int m,int k){
        String str = "";
        int result[] = new int[m+1];
        result[1]= 2;
        result[2] = 3;
        result[3]=4;
        int i =4;
        for(i =4; i<=m;i++){
            result[i] = result[i-2]+result[i-3];
        }
//        str = str+result[m];
//        int record[] = {1,1,0,0,0,0};
//        int y=1;
//        for( y=1; ;y++){
//            record[0]= record[2]+record[0];
//            for(int j = 1; j<3;j++){
//                record[j] = record[(j-1)];
//            }
//            int sum = sumPig(record);
//            if(sum>=m) break;;
//        }
//        str = str+","+(y+2018);
//        System.out.print(str);
        for(int year  =1; ;year++){
            if(ff(year)>=20) {
                System.out.print(year+2018);
                break;
            }
        }
    }
    public static int ff(int year){
        if(year==1) return 2;
        if(year==2) return 3;
        else return ff(year-1)+year-1;
    }
    static int  sumPig(int record[]){
        int sum =0;
        for(int  i=0;i<record.length;i++ ){
            sum+=record[i];
        }
        return sum;
    }
}
