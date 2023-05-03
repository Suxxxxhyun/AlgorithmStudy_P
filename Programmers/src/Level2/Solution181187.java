package Level2;

//12:44 ~ 1:15
//실패코드(시간초과)
class Solution181187 {

    //count는 y=x에 걸리는 것임.
    long answer = 0, cnt = 0, count = 0;

    public long solution(int r1, int r2) {

        answer += 8; //r1과 r2가 크기가 서로 다르기 때문에 무조건 각 원당 4개는 뽑을 수 있음.
        if(r2 - r1 > 1){
            answer += ((r2 - r1) - 1) * 4;
        }

        for(int x=1; x<=r2; x++){
            //1 + 2 + ... + 백만 -> 대략 5억이므로 시간초과 발생
            for(int y=1; y<=x; y++){
                int r = x*x + y*y;
                if(r >= r1*r1 && r <= r2*r2){
                    if(x == y){
                        count++;
                    } else {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(count);
        return answer + (cnt * 2 + count) * 4;
    }
}
