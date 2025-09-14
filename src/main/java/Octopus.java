public class Octopus extends Fish {

    Octopus(String name, int age, int health_level) {
        super(name, age, health_level);
    }

    public void spew_ink(int health_level) {
        if (health_level <= 3) {
            System.out.printf("먹물을 뿜지 못한다..\n");
        }
        else if (health_level > 3) {
            System.out.printf("먹물을 자유자재로 뿜는다!\n");
        }
    }

    public void change_color(int health_level) {
        if (health_level <= 4) {
            System.out.printf("탁한 색을 유지한다..\n");
        }
        else if (health_level > 4) {
            System.out.printf("숨기 위해 스스로 색을 바꾼다!\n");
        }
    }

    public void checkup() {
        int HL = this.health_level;

        super.checkup();
        spew_ink(HL);
        change_color(HL);
    }
}
