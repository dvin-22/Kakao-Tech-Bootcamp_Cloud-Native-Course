import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int result = 1; // 성공(2), 입양 실패(1), 치료 실패(0)
        int number1, number2; // 동물 번호
        int[] check_done = new int[] {0, 0, 0}; // 검진을 마친 동물

        Scanner scanner = new Scanner(System.in);
        Spider spider = new Spider("거밍", 3, 4);
        Octopus octopus = new Octopus("문엉", 23, 2);
        Bee bee = new Bee("꿀버리", 1, 1);

        System.out.printf("\n춘식이 동물 보호소의 아침이 밝았습니다!\n");
        System.out.printf("~~~ 오늘의 동물 리스트입니다. ~~~\n");
        System.out.printf("번호: 1 | 이름: %s | 나이: %d살\n", spider.get_name(), spider.get_age());
        System.out.printf("번호: 2 | 이름: %s | 나이: %d살\n", octopus.get_name(), octopus.get_age());
        System.out.printf("번호: 3 | 이름: %s | 나이: %d살\n\n", bee.get_name(), bee.get_age());

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
        System.out.printf("어떤 동물을 병원에 보낼까요? (2마리 선택) : ");
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

        // 스레드가 종료될 때까지 대기
        spider.join();
        octopus.join();
        bee.join();

        if (spider.health_level==0 || octopus.health_level==0 || bee.health_level==0) { // 어느 동물의 건강 수치가 0일 경우, 치료 실패
            result = 0;
        }
        else {
            if (spider.health_level >= 5) {
                System.out.printf("축하합니다! %s가 건강하게 입양을 가게 되었습니다!!\n", spider.get_name());
                result = 2;
            }
            if (octopus.health_level >= 5) {
                System.out.printf("축하합니다! %s가 건강하게 입양을 가게 되었습니다!!\n", octopus.get_name());
                result = 2;
            }
            if (bee.health_level >= 5) {
                System.out.printf("축하합니다! %s가 건강하게 입양을 가게 되었습니다!!\n", bee.get_name());
                result = 2;
            }
        }

        if (result == 0) {
            System.out.printf("\n건강 수치가 0이 되어 실패하였습니다..\n");
        }
        else if (result == 1) {
            System.out.printf("\n아무도 입양을 가지 못해 실패하였습니다..\n");
        }

        System.out.printf("프로그램을 종료합니다.");
    }
}
