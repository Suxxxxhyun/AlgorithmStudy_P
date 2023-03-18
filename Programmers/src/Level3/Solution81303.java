package Level3;
//실패코드
/*
1. LinkedList로 풀어야하나? 왜냐면 삭제되고 나서 복구가 될때, 원래의 자리로 복구가 되는데,
다음주소와 이전주소를 가지고 있는 이중연결리스트인 LinkedList는 이에 적합할 것같음.

2. 흠 근데, '콘'을 삭제하고 난뒤, 행의 번호가 0 1 2 3 4 5로 갱신된걸 보아하니,
ArrayList가 적합할 것같음.

3. ArrayList.add는 기본적으로 파라미터 하나라면, E e를 넣어주고,
파라미터가 두개라면 아래와 같이, index에 어떤 원소를 넣어준다. 는 것의 의미임.
ArrayList.add(int index, E e)

4. a는 원래의 배열, list는 cmd를 수행하고 난 뒤의 배열

5. 아, switch case문을 사용하고 싶은데 사용방법 잊어버림. 다른걸로 하자.

6. 자바 Stack클래스 객체 생성 방법 및 Queue인터페이스의 구현 클래스확인할것 ----------
Stack클래스의 원소 삽입, 삭제 메서드는 push, pop이다.
*/

import java.util.*;

class Solution81303 {

    List<Integer> a = new ArrayList<Integer>(); //최초의 인덱스를 담고 있는 공간
    List<Integer> list = new ArrayList<Integer>();
    Stack<Integer> erased = new Stack<Integer>();
    int pointer;
    String answer = "";

    public String solution(int n, int k, String[] cmd) {

        for(int i=0; i<n; i++){
            a.add(i);
            list.add(i);
        }
        pointer = k;

        for(int i=0; i<cmd.length; i++){
            if(cmd[i].charAt(0) == 'D'){
                String str = cmd[i].substring(2,cmd[i].length());
                pointer += Integer.parseInt(str);
                //System.out.println("pointer : " + pointer);
            } else if(cmd[i].charAt(0) == 'C'){
                //System.out.println("pointer : " + pointer);
                erased.push(list.get(pointer));
                list.remove(pointer);
                /*for(int j=0; j<list.size(); j++){
                    System.out.print(list.get(j) + " ");
                }
                System.out.println();
                for(int j=0; j<erased.size(); j++){
                    System.out.print(erased.get(j) + " ");
                }
                System.out.println();*/
                if(pointer == list.size()){
                    pointer -= 1;
                }
                //System.out.println("pointer : " + pointer);
            } else if(cmd[i].charAt(0) == 'U'){
                String str = cmd[i].substring(2,cmd[i].length());
                pointer -= Integer.parseInt(str);
                //System.out.println("pointer : " + pointer);
            } else {
                int x = erased.pop();
                //System.out.println("제거된 원소: " + x);
                //System.out.println("pointer : " + pointer);
                if(list.size() < a.indexOf(x)){
                    list.add(x);
                } else {
                    list.add(a.indexOf(x), x);
                    pointer++;
                    //이쪽 수정, 이쪽이 틀렸었음.
                }
                /*System.out.println("Z수행");
                for(int j=0; j<list.size(); j++){
                    System.out.print(list.get(j) + " ");
                }
                System.out.println();*/
            }
        }

        /*for(int i=0; i<a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();*/

        int j=0;
        for(int i=0; i<a.size(); i++){
            if(list.contains(i)){
                answer += "O";
            } else {
                answer += "X";
            }
        }
        return answer;
    }
}
