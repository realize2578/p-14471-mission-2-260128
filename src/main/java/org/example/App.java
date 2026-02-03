package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public void run(){
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        List<WiseSaying> sayings = new ArrayList<>();
        int cnt = 0 ;

        while(true){
            System.out.print("명령)");
            String cmd = sc.nextLine();

            if(cmd.equals("등록")){
                WiseSaying saying = new WiseSaying();
                System.out.print("명언:");
                saying.saying = sc.nextLine();
                System.out.print("작가:");
                saying.writer = sc.nextLine();
                saying.id = ++cnt;
                sayings.add(saying);
                System.out.println(cnt+"번 명언이 등록되었습니다.");
            }
            else if(cmd.equals("목록")){
                Collections.reverse(sayings);
                for(WiseSaying saying : sayings){
                    System.out.println(saying.id+"/"+saying.writer+"/"+saying.saying);
                }
            }
            else if(cmd.contains("삭제?id=")){
                int toDel = Integer.valueOf(cmd.split("=")[1]);
                sayings.removeIf(saying -> saying.id == toDel);
            }
            else break;
        }
    }
}
