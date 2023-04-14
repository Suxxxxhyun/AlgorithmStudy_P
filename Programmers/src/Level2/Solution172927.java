package Level2;

//4:23 ~ 4:53
//아 안돼..
//애초에 곡괭이를 꼭 서로다른 3개를 고르라는 법이 없었음. 그래서 내 코드로 해결안됨.
class Solution172927 {

    //어떤 곡괭이를 어떤 순서로 고를지, 이를 위한 배열
    //순서를 고려하며 중복을 허용하지 않는다.
    //0번은 다이아, 1번은 철, 2번은 돌
    int[] selected;
    int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {

        selected = new int[3];
        pro(picks, minerals, 0);
        return answer;
    }

    void pro(int[] picks, String[] minerals, int idx){
        if(idx == 3){
            System.out.println("고른 인덱스");
            for(int i=0; i<3; i++){
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            System.out.println("고르고 난 뒤 상황");
            for(int i=0; i<picks.length; i++){
                System.out.print(picks[i] + " ");
            }
            System.out.println();
            result(minerals,0,0,0);
            return;
        }

        for(int cand=0; cand<3; cand++){
            if(picks[cand] > 0){
                selected[idx] = cand;
                picks[cand]--;
                pro(picks,minerals,idx + 1);
                picks[cand]++;
            }
        }
    }

    void result(String[] minerals,int start,int sum,int idx){
        if(start == minerals.length){
            System.out.println(sum);
            answer = Math.min(sum, answer);
            return;
        }

        System.out.println(sum);

        if(selected[idx] == 0){
            if(start + 4 < minerals.length){
                sum += 5;
                result(minerals, start+4 , sum, idx+1);
            } else {
                int mod = minerals.length - start;
                result(minerals, start+mod , sum + mod, idx+1);
            }
        } else if(selected[idx] == 1){
            int s_idx = start;
            int e_idx = start+4;
            while(s_idx <= e_idx){
                if(s_idx == minerals.length){
                    break;
                }
                if(minerals[s_idx].equals("diamond")){
                    sum += 5;
                } else {
                    sum += 1;
                }
                s_idx++;
            }
            if(start + 4 < minerals.length){
                result(minerals, start+4 , sum, idx+1);
            } else {
                int mod = minerals.length - start;
                result(minerals, start+mod , sum, idx+1);
            }
        } else {
            int s_idx = start;
            int e_idx = start+4;
            while(s_idx <= e_idx){
                if(s_idx == minerals.length){
                    break;
                }
                if(minerals[s_idx].equals("diamond")){
                    sum += 25;
                } else if(minerals[s_idx].equals("iron")){
                    sum += 5;
                } else {
                    sum += 1;
                }
                s_idx++;
            }
            if(start + 4 < minerals.length){
                result(minerals, start+4 , sum, idx+1);
            } else {
                int mod = minerals.length - start;
                result(minerals, start+mod , sum, idx+1);
            }
        }
    }
}