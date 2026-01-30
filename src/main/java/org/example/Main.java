package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        int cnt = 0 ;

        while(true){
            System.out.print("명령)");
            String cmd = sc.nextLine();

            if(cmd.equals("등록")){
                System.out.print("명언:");
                sc.nextLine();
                System.out.print("작가:");
                sc.nextLine();
                cnt++;
                System.out.println(cnt+"번 명언이 등록되었습니다.");
            }
            else break;
        }
    }
}