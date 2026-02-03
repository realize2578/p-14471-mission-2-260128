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
            else if(cmd.contains("수정?id=")){
                actionModify(cmd);
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

        sayings.add(saying);

        saying.id = ++cnt;
        System.out.println(cnt+"번 명언이 등록되었습니다.");

    }

    private void actionList(){
        List<WiseSaying> foundedSayings = findList();
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------");
        for(WiseSaying saying : foundedSayings){
            System.out.println(saying.id+" / "+saying.writer+" / "+saying.saying);
        }
    }

    private List<WiseSaying> findList(){
        return sayings.reversed();
    }

    private void actionDelete(String cmd){

        int toDel = Integer.parseInt(cmd.split("=")[1]); // 명령 문자열에서 id값 추출

        boolean isExist = delete(toDel);

        if (isExist)System.out.println(toDel+"번 명언이 삭제되었습니다.");
        else System.out.println(toDel+"번 명언은 존재하지 않습니다.");
    }

    private boolean delete(int toDel){

        return sayings.removeIf(saying -> saying.id == toDel);

    }

    private void actionModify(String cmd){
        int toMod = Integer.parseInt(cmd.split("=")[1]); // 명령 문자열에서 id값 추출

        WiseSaying wiseSaying = findById(toMod);

        if (wiseSaying != null){

            System.out.println("명언(기존):"+wiseSaying.saying);
            String saying = sc.nextLine();

            System.out.println("작가(기존):"+wiseSaying.writer);
            String writer = sc.nextLine();

            modify(saying,writer,wiseSaying);

            System.out.println(toMod+"번 명언이 수정되었습니다.");
        }

        else System.out.println(toMod+"번 명언은 존재하지 않습니다.");

    }
    private WiseSaying findById(int id){

        for(WiseSaying saying : sayings){

            if(saying.id == id){
                return saying;
            }
        }
        return null;
    }
    private void modify(String saying, String wrtier, WiseSaying wiseSaying){
        wiseSaying.saying = saying;
        wiseSaying.writer = wrtier;
    }
}
