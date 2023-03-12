package Level2;

public class Solution12921 {
    public int solution(int n){
        int[] prime = new int[n+1];
        int answer = 0;

        prime[0] = prime[1] = 0;

        for(int i=2; i<=n; i++){
            prime[i] = i;
        }

        for(int i=2; i<n; i++){
            if(prime[i] == 0){
                continue;
            }

            //소수의 배수는 소수가 아니므로, 0으로 갱신한다.
            for(int j=2*i; j<=n; j+=i){
                prime[j] = 0;
            }
        }

        for(int i=0; i<prime.length; i++){
            if(prime[i] != 0){
                answer++;
            }
        }

        return answer;
    }
}
