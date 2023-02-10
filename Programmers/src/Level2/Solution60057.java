package Level2;

public class Solution60057 {
    public int solution(String s) {

        int answer = s.length();

        //입력되는 문자열의 길이가 7이라고 하면, 5단위..6단위..이런거 어차피 불가능하기 때문임!
        for(int i=1; i<=s.length()/2; i++){
            int pos = 0;
            int len = s.length();

            for( ; pos + i <= s.length();){
                String unit = s.substring(pos, pos + i);
                pos += i;

                int cnt = 0;
                for( ; pos + i <= s.length(); ){
                    if(unit.equals(s.substring(pos, pos + i))){
                        ++cnt;
                        pos += i;
                    } else {
                        break;
                    }
                }

                if(cnt > 0){
                    len -= i * cnt;

                    if(cnt < 9){
                        len += 1;
                    } else if(cnt < 99){
                        len += 2;
                    } else if(cnt < 999){
                        len += 3;
                    } else {
                        len += 4;
                    }
                }
            }

            answer = Math.min(answer, len);
        }
        return answer;
    }

    public int pro(String s, int i){

        int len = s.length(), ans = 0;

        if(i == 1){
            return len;
        } else {
            for(int j=0, L=0, R=1; j<len; j++){
                if(s.charAt(L) == s.charAt(L + i) && s.charAt(R) == s.charAt(R + i)){

                }
            }
        }
        return len;
    }
}
