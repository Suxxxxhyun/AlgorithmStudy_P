package Level3;

//~11:00
import java.util.*;
class Solution1768602 {

    //String[] answer = {};

    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>(){
            public int compare(String o1, String o2){

                String[] file1 = dispatch(o1);
                String[] file2 = dispatch(o2);

                int headValue = file1[0].compareTo(file2[0]);
                if(headValue == 0){
                    int val1 = Integer.parseInt(file1[1]);
                    int val2 = Integer.parseInt(file2[1]);
                    return Integer.compare(val1, val2);
                } else {
                    return headValue;
                }
            }
        });
        return files;
    }

    public String[] dispatch(String x){

        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        int idx = 0;
        for( ; idx < x.length(); idx++){
            if((x.charAt(idx) >= '0' && x.charAt(idx) <= '9')){
                break;
            }
            head.append(x.charAt(idx));
        }

        for( ; idx < x.length(); idx++){
            if(!(x.charAt(idx) >= '0' && x.charAt(idx) <= '9')){
                break;
            }
            number.append(x.charAt(idx));
        }

        for( ; idx < x.length(); idx++){
            tail.append(x.charAt(idx));
        }

        String[] files = {head.toString().toUpperCase(), number.toString(), tail.toString()};

        return files;
    }
}
