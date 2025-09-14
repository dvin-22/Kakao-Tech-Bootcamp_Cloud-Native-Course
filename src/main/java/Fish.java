public class Fish extends Animal implements Can_breath_water {

    public Fish(String name, int age, int health_level) {
        super(name, age, health_level);
    }

    public void breath_water(int health_level) {
        if (health_level <= 2) {
            System.out.printf("물에서 숨을 쉬기 힘들어 보인다..\n");
        }
        else if (health_level > 3) {
            System.out.printf("물에서 활발하게 움직인다!\n");
        }
    }

    public void checkup() {
        int HL = this.health_level;

        super.checkup();
        breath_water(HL);
    }
}
