package Level1;

//내 코드
import java.util.*;
class Solution67256 {

    String answer = "";
    int[] left, right;

    public String solution(int[] numbers, String hand) {

        left = new int[2]; //x,y 좌표를 담아줌.
        right = new int[2]; //x,y 좌표를 담아줌.
        left[0] = 3;
        left[1] = 0;
        right[0] = 3;
        right[1] = 2;

        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            if(num == 1){
                left[0] = 0;
                left[1] = 0;
                answer += "L";
            } else if(num == 2){
                int left_dist = Math.abs(left[0] - 0) + Math.abs(left[1] - 1);
                int right_dist = Math.abs(right[0] - 0) + Math.abs(right[1] - 1);
                if(left_dist < right_dist){
                    answer += "L";
                    left[0] = 0;
                    left[1] = 1;
                } else if(left_dist > right_dist){
                    answer += "R";
                    right[0] = 0;
                    right[1] = 1;
                } else {
                    if(hand.equals("right")){
                        answer += "R";
                        right[0] = 0;
                        right[1] = 1;
                    } else {
                        answer += "L";
                        left[0] = 0;
                        left[1] = 1;
                    }
                }
            } else if(num == 3){
                right[0] = 0;
                right[1] = 2;
                answer += "R";
            } else if(num == 4){
                left[0] = 1;
                left[1] = 0;
                answer += "L";
            } else if(num == 5){
                int left_dist = Math.abs(left[0] - 1) + Math.abs(left[1] - 1);
                int right_dist = Math.abs(right[0] - 1) + Math.abs(right[1] - 1);
                if(left_dist < right_dist){
                    answer += "L";
                    left[0] = 1;
                    left[1] = 1;
                } else if(left_dist > right_dist){
                    answer += "R";
                    right[0] = 1;
                    right[1] = 1;
                } else {
                    if(hand.equals("right")){
                        answer += "R";
                        right[0] = 1;
                        right[1] = 1;
                    } else {
                        answer += "L";
                        left[0] = 1;
                        left[1] = 1;
                    }
                }
            } else if(num == 6){
                right[0] = 1;
                right[1] = 2;
                answer += "R";
            } else if(num == 7){
                left[0] = 2;
                left[1] = 0;
                answer += "L";
            } else if(num == 8){
                int left_dist = Math.abs(left[0] - 2) + Math.abs(left[1] - 1);
                int right_dist = Math.abs(right[0] - 2) + Math.abs(right[1] - 1);
                if(left_dist < right_dist){
                    answer += "L";
                    left[0] = 2;
                    left[1] = 1;
                } else if(left_dist > right_dist){
                    answer += "R";
                    right[0] = 2;
                    right[1] = 1;
                } else {
                    if(hand.equals("right")){
                        answer += "R";
                        right[0] = 2;
                        right[1] = 1;
                    } else {
                        answer += "L";
                        left[0] = 2;
                        left[1] = 1;
                    }
                }
            } else if(num == 9){
                right[0] = 2;
                right[1] = 2;
                answer += "R";
            } else {
                int left_dist = Math.abs(left[0] - 3) + Math.abs(left[1] - 1);
                int right_dist = Math.abs(right[0] - 3) + Math.abs(right[1] - 1);
                if(left_dist < right_dist){
                    answer += "L";
                    left[0] = 3;
                    left[1] = 1;
                } else if(left_dist > right_dist){
                    answer += "R";
                    right[0] = 3;
                    right[1] = 1;
                } else {
                    if(hand.equals("right")){
                        answer += "R";
                        right[0] = 3;
                        right[1] = 1;
                    } else {
                        answer += "L";
                        left[0] = 3;
                        left[1] = 1;
                    }
                }
            }
        }
        return answer;
    }
}
