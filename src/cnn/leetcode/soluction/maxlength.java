package cnn.leetcode.soluction;

public class maxlength {

  static  int  publicString(String A, String B){

       int max=0;
       int[][] samecount=new int[A.length()][B.length()];


       for(int i=0;i<A.length();i++){
           if(B.charAt(0) == A.charAt(i)){
               samecount[i][0]=1;
           }
       }

       for(int i=0;i<B.length();i++){
           if(B.charAt(i)==A.charAt(0)){
               samecount[0][i]=1;
           }
       }
       for(int row=1;row<A.length();row++){
           for(int col=1;col<B.length();col++){
               if(A.charAt(row)==B.charAt(col)){
                   samecount[row][col]=samecount[row-1][col-1]+1;
                   max=max>samecount[row][col]?max:samecount[row][col];
               }
           }
       }
       return max;
    }

    public static void  main(String args[]){
        int result  = publicString("1AB2345CD", "12345EF");
        System.out.print(result);
    }
}


