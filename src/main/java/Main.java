import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int day = 1;
        int end = 0; // 성공(1) 혹은 실패(2) 시 while문 탈출
        int number1, number2; // 동물 번호
        int[] gone_animal = new int[] {0, 0, 0}; // 입양간 동물
        int[] check_done = new int[] {0, 0, 0}; // 검진을 마친 동물

        Scanner scanner = new Scanner(System.in);
        Spider spider = new Spider("거밍", 3, 4);
        Octopus octopus = new Octopus("문엉", 23, 2);
        Bee bee = new Bee("꿀버리", 1, 1);

        while (check_done[0]*check_done[1]*check_done[2] == 0){
            System.out.printf("\n춘식이 동물 보호소의 %d일차 아침이 밝았습니다!\n", day);
            System.out.printf("~~~ 오늘의 동물 리스트입니다. ~~~\n");
            if (gone_animal[0] == 0) {
                System.out.printf("번호: 1 | 이름: %s | 나이: %d살\n", spider.get_name(), spider.get_age());
            }
            if (gone_animal[1] == 0) {
                System.out.printf("번호: 2 | 이름: %s | 나이: %d살\n", octopus.get_name(), octopus.get_age());
            }
            if (gone_animal[2] == 0) {
                System.out.printf("번호: 3 | 이름: %s | 나이: %d살\n\n", bee.get_name(), bee.get_age());
            }

            while (check_done[0]*check_done[1]*check_done[2] == 0) { // 모든 동물의 검진이 끝날 때까지 반복
                System.out.printf("검진할 동물의 번호를 입력하세요 : ");
                number1 = scanner.nextInt();
                System.out.printf("\n");

                if (number1 == 1) {
                    spider.checkup();
                    System.out.printf("%s의 건강 수치 : %d\n\n", spider.get_name(), spider.get_health_level());
                    check_done[0] = 1;
                }
                else if (number1 == 2) {
                    octopus.checkup();
                    System.out.printf("%s의 건강 수치 : %d\n\n", octopus.get_name(), octopus.get_health_level());
                    check_done[1] = 1;
                }
                else if (number1 == 3) {
                    bee.checkup();
                    System.out.printf("%s의 건강 수치 : %d\n\n", bee.get_name(), bee.get_health_level());
                    check_done[2] = 1;
                }
            }
            // 모두 검진을 마친 후 병원에 보낼 수 있음
            System.out.printf("병원에 몇마리 보낼까요? (1 or 2) : ");
            number1 = scanner.nextInt();

            if (number1 == 1) {
                System.out.printf("어떤 동물을 병원에 보낼까요? : ");
                number1 = scanner.nextInt();
                if (number1 == 1) {
                    spider.start();
                }
                else if (number1 == 2) {
                    octopus.start();
                }
                else if (number1 == 3) {
                    bee.start();
                }
            }

            else if (number1 == 2) {
                System.out.printf("어떤 동물을 병원에 보낼까요? : ");
                number1 = scanner.nextInt();
                number2 = scanner.nextInt();

                if (number1 == 1 && number2 == 2) {
                    spider.start();
                    octopus.start();
                    bee.health_down();
                }
                else if (number1 == 1 && number2 == 3) {
                    spider.start();
                    bee.start();
                    octopus.health_down();
                }
                else if (number1 == 2 && number2 == 3) {
                    octopus.start();
                    bee.start();
                    spider.health_down();
                }
            }

            if (spider.health_level==0 || octopus.health_level==0 || bee.health_level==0) { // 어느 동물의 건강 수치가 0일 경우, 실패
                end = 2;
            }
            day++;
            check_done[0]--;
            check_done[1]--;
            check_done[2]--;
        }

        if (end == 1) {
            System.out.printf("축하합니다! 모든 동물들이 건강하게 입양을 가게 되었습니다!!\n");
        }
        else if (end ==2) {
            System.out.printf("건강 수치가 0이 되어 실패하였습니다..\n");
        }
        System.out.printf("프로그램을 종료합니다.");
    }
}
