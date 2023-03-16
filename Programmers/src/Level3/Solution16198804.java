package Level3;

//최종 내 풀이

//-1로 시작하는 것이나 1로 시작하는 것이나 누적합을 구한 배열에서, 최대 - 최소는 같다.
//따라서 단순히 1로 시작한 누적합 배열에서 최대-최소를 구한다.
//***** 여기서, sum[0] = 0을 만들어주는 이유는,
//배열이 5 1 -1 1 -1라고 했을때, 연속펄스는 [1,-1,1,-1,1]을 통해
//누적합 [5,4,3,2,1]이 되는데, 이때, 합이 최대가 되는 구간은 [0,0)인 구간이다. 
//즉, 인덱스가 0으로만 이루어진 구간 => [5]가 합이 최대가 되는 구간인데, 
//단순히 최대 - 최소를 하게 되면, 4가 나온다.
//따라서, 아무것도 포함하지 않는 구간에 대한 누적합을 넣어주어, 인덱스가 0부터 시작되는 구간도
//포함시킨다. 
class Solution16198804 {

    long[] sum;
    long max = Long.MIN_VALUE, min = Long.MAX_VALUE;

    public long solution(int[] sequence) {

        sum = new long[sequence.length+1];
        //+1로 시작
        for(int i=1; i<=sequence.length; i++){
            if(i % 2 == 1){
                sum[i] = sum[i-1] + (long)sequence[i-1];
            } else {
                sum[i] = sum[i-1] + (long)sequence[i-1] * -1;
            }
        }

        for(int i=0; i<=sequence.length; i++){
            //System.out.print(sum[i] + " ");
            max = Math.max(max, sum[i]);
            min = Math.min(min, sum[i]);
        }

        return max - min;
    }
}
