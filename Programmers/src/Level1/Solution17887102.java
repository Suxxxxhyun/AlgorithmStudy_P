package Level1;

import java.util.HashMap;

public class Solution17887102 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<String, Integer> mapPlayer = new HashMap<>();
        HashMap<Integer, String> mapRank = new HashMap<>();

        for(int i=0; i<players.length; i++){
            mapPlayer.put(players[i], i);
            mapRank.put(i,players[i]);
        }

        for(int i=0; i<callings.length; i++){
            int currentRank = mapPlayer.get(callings[i]); //카이의 현재 등수 : 3등
            String player = mapRank.get(currentRank); //player = kai

            String frontplayer = mapRank.get(currentRank - 1); //frontplayer = poe
            mapPlayer.put(player, currentRank -1); //카이, 2등
            mapPlayer.put(frontplayer, currentRank); //poe, 3등

            mapRank.put(currentRank -1, player);
            mapRank.put(currentRank, frontplayer);
        }

        for(int i=0; i<players.length; i++){
            answer[i] = mapRank.get(i);
        }

        return answer;
    }
}
