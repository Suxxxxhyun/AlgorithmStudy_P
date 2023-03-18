package Level1;

import java.util.*;

class Solution1845 {

    public int solution(int[] nums) {

        int max = nums.length / 2;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            hashSet.add(nums[i]);
        }

        if(max <= hashSet.size()){
            return max;
        } else {
            return hashSet.size();
        }
    }
}
