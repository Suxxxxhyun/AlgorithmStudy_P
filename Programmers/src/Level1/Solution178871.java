package Level1;

import java.util.*;

//시간초과코드
class Solution178871 {

    //String[] answer = {};
    ArrayList<String> player = new ArrayList<String>();

    public ArrayList<String> solution(String[] players, String[] callings) {

        //최대 5만
        for(int i=0; i<players.length; i++){
            player.add(players[i]);
        }

        //최대 백만
        for(int i=0; i<callings.length; i++){
            String name = callings[i];
            int idx = player.indexOf(name);
            player.remove(idx);
            player.add(idx-1,name);
        }
        return player;
    }
}
