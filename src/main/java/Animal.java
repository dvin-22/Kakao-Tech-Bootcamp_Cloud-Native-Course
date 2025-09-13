public class Animal extends Thread {
    protected String name; // 이름
    protected int age; // 나이
    protected int health_level; // 건강 레벨

    public String get_name() {
        return name;
    }

    public int get_age(){
        return age;
    }

    public int get_health_level() {
        return health_level;
    }

    public Animal(String name, int age, int health_level) {
        this.name = name;
        this.age = age;
        this.health_level = health_level;
    }

    public void eat_digest(int health_level) { // 건강 레벨에 따라 밥을 먹는지 확인
        if (health_level == 1) { // 건강 레벨이 1이면 밥을 먹지 않음
            System.out.printf("밥을 먹지 않는다..\n");
        }
        else if (health_level >= 2) { // 건강 레벨이 2이상이면 밥을 먹음
            System.out.printf("밥을 잘 먹는다!\n");
        }
    }

    public void checkup(){ // 동물을 검진함
        System.out.printf("'%s'을/를 검진합니다.\n", this.name);
        eat_digest(this.health_level);
    }

    public void start() { // 동물을 병원에 보냄
        System.out.printf("--- %s(이)를 병원으로 이동 중 ---\n", this.name);
        System.out.printf("--- %s 병원 접수 중 ---\n", this.name);
        System.out.printf("--- %s 진찰 중 ---\n", this.name);
        System.out.printf("--- %s 치료 중 ---\n", this.name);
        this.health_level = this.health_level + 2;
        try {
            throw new RuntimeException("치료 중 예외 발견");
        } catch (Exception e) {
            System.out.println("예외 처리됨: " + e.getMessage());
        }
    }

    public void health_down() {
        this.health_level--;
    }
}
