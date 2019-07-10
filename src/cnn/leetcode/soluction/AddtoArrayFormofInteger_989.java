package cnn.leetcode.soluction;

import java.util.ArrayList;
import java.util.List;

public class AddtoArrayFormofInteger_989 {

    /**
     * Runtime: 44 ms, faster than 20.36% of Java online submissions for Add to Array-Form of Integer.
     * Memory Usage: 39.7 MB, less than 98.28% of Java online submissions for Add to Array-Form of Integer.
     * 与T67相同的解题思想
     * @param A
     * @param K
     * @return
     */
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> result = new ArrayList<Integer>();
            int sum =0;
            int lengthA = A.length-1;
            while(K!=0 || lengthA>=0 || sum !=0){
                sum+= (lengthA>=0)?A[lengthA]:0;
                sum+= (K>=0)?K%10:0;
                result.add(0, sum%10);
                sum = sum/10;
                K=K/10;
                lengthA--;

            }
            return result;
        }
    }

