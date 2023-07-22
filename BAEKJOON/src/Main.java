import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

       String S = sc.next(); //baekjoon

       for(char c ='a';c<='z';c++) {
           System.out.print(S.indexOf(c)+" ");  // indexOf 메서드 사용
       }

       sc.close();
    }
}