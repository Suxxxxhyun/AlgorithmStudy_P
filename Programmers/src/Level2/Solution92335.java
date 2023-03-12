package Level2;

/*
https://choichumji.tistory.com/171 진수변환
*/
class Solution92335 {

    String str = "";
    int answer = 0;

    public int solution(int n, int k) {

        str = Integer.toString(n,k);
        String[] temp = str.split("0");
        /*for(int i=0; i<temp.length; i++){
            System.out.print(temp[i] + " ");
        }*/
        for(int i=0; i<temp.length; i++){
            if(temp[i].equals("")){
                continue;
            }
            long num = Long.parseLong(temp[i]);
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }

    public boolean isPrime(long num){
        int cnt = 0;
        if(num < 2){
            return false;
        } else {
            for(int i=1; i<=Math.sqrt(num); i++){
                if(num % i == 0){
                    cnt++;
                }
            }
            if(cnt > 1){
                return false;
            } else {
                return true;
            }
        }
    }
}
