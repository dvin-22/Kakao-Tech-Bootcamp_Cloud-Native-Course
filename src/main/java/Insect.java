public class Insect extends Animal implements Six_legs {

    public Insect(String name, int age, int health_level) {
        super(name, age, health_level);
    }

    public void check_legs(int health_level) {
        if (health_level <= 2) {
            System.out.printf("다리 상태가 좋지 않다..\n");
        }
        else if (health_level > 3) {
            System.out.printf("6개 다리 모두 건강하다!\n");
        }
    }

    public void checkup() {
        int HL = this.health_level;
        System.out.printf("'%s'을/를 검진합니다.\n", this.name);

        eat_digest(HL);
        check_legs(HL);
    }
}
