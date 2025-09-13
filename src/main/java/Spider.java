public class Spider extends Insect implements Six_legs {

    Spider(String name, int age, int health_level) {
        super(name, age, health_level);
    }

    public void spin_web(int health_level) {
        if (health_level <= 3) {
            System.out.printf("거미줄을 치지 못한다..\n");
        }
        else if (health_level > 3) {
            System.out.printf("거미줄로 집을 짓는다!\n");
        }
    }

    public void check_eyes(int health_level) {
        if (health_level <= 4) {
            System.out.printf("눈 상태가 좋지 않다..\n");
        }
        else if (health_level > 4) {
            System.out.printf("6개의 눈 모두 건강하다!\n");
        }
    }

    public void checkup() {
        int HL = this.health_level;
        System.out.printf("'%s'을/를 검진합니다.\n", this.name);

        eat_digest(HL);
        check_legs(HL);
        spin_web(HL);
        check_eyes(HL);
    }
}
