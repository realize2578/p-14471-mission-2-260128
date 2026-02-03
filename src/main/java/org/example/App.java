package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);


    List<WiseSaying> sayings = new ArrayList<>();
    int cnt = 0 ;

    public void run(){
        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령)");
            String cmd = sc.nextLine();

            if(cmd.equals("등록")){
                actionWrite();
            }
            else if(cmd.equals("목록")){
                actionList();
            }
            else if(cmd.contains("삭제?id=")){
                actionDelete(cmd);
            }
            else break;
        }
    }

    private void actionWrite(){
        WiseSaying saying = new WiseSaying();
        System.out.print("명언:");
        saying.saying = sc.nextLine();
        System.out.print("작가:");
        saying.writer = sc.nextLine();
        saying.id = ++cnt;
        sayings.add(saying);
        System.out.println(cnt+"번 명언이 등록되었습니다.");
    }

    private void actionList(){
        Collections.reverse(sayings);
        for(WiseSaying saying : sayings){
            System.out.println(saying.id+"/"+saying.writer+"/"+saying.saying);
        }
    }

    private void actionDelete(String cmd){
        int toDel = Integer.parseInt(cmd); // 명령 문자열에서 id값 추출
        boolean isExist = sayings.removeIf(saying -> saying.id == toDel); //
        if (isExist)System.out.println(toDel+"번 명언이 삭제되었습니다.");
        else System.out.println(toDel+"번 명언은 존재하지 않습니다.");
    }
}
