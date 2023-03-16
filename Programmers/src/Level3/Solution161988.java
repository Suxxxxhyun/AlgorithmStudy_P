package Level3;

//https://velog.io/@ddongh1122/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%97%B0%EC%86%8D-%ED%8E%84%EC%8A%A4-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4%EC%9D%98-%ED%95%A9
//블로그 참조 (투포인터 풀이)
public class Solution161988 {
    public long solution(int[] sequence){
        long[] preSumPlus = new long[sequence.length + 1]; //+부터 시작
        long[] preSumMinus = new long[sequence.length + 1]; //-부터 시작

        long pm = 1;
        long plusSum = 0;
        long minusSum = 0;
        for(int i=0; i<sequence.length; i++){
            plusSum += sequence[i] * pm;
            preSumPlus[i + 1] = plusSum;
            pm *= -1;
            minusSum += sequence[i] * pm;
            preSumMinus[i + 1] = minusSum;
        }

        long result = Long.MIN_VALUE;
        result = getResult(sequence, preSumPlus, result);
        result = getResult(sequence, preSumMinus, result);
        return result;
    }

    public long getResult(int[] sequence, long[] preSum, long result){
        int lo = 0;
        int hi = 1;
        while(hi <= sequence.length){
            long sum = preSum[hi] - preSum[lo];
            if(sum >= 0) {
                result = Math.max(result, sum);
                hi++;
            } else {
                lo = hi;
                hi++;
            }
        }
        return result;
    }
}
