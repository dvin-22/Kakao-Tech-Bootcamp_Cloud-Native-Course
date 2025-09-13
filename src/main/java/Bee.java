public class Bee extends Insect implements Six_legs {

    Bee(String name, int age, int health_level) {
        super(name, age, health_level);
    }

    public void eat_honey(int health_level) {
        if (health_level <= 3) {
            System.out.printf("꽃에서 꿀을 빨아들이지 못한다..\n");
        }
        else if (health_level > 3) {
            System.out.printf("꽃에서 활발하게 꿀을 얻는다!\n");
        }
    }

    public void can_sting(int health_level) {
        if (health_level <= 4) {
            System.out.printf("침을 쏘지 못한다..\n");
        }
        else if (health_level > 4) {
            System.out.printf("침의 상태가 양호하다!\n");
        }
    }

    public void checkup() {
        int HL = this.health_level;
        System.out.printf("'%s'을/를 검진합니다.\n", this.name);

        eat_digest(HL);
        check_legs(HL);
        eat_honey(HL);
        can_sting(HL);
    }
}
