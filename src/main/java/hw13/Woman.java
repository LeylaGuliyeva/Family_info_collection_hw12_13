package hw13;

import java.util.Map;

final public class Woman extends Human {
    public Woman() {
        super();
    }
    public Woman(String name, String surname, String bd) {
        super(name, surname, bd);
    }

    public Woman(String name, String surname, String bd,byte iq) {
        super(name, surname, bd,iq);
    }


    public Woman(String name, String surname, String bd, byte iq, Map<DayOfWeek, String> schedule, Family fam, Pet pet) {
        super(name, surname, bd, iq, schedule,fam, pet);
    }


    @Override
    public void greetPet() {
        System.out.printf("Hi my dear friend :  %s\n", this.pet);
    }

    void morning() {
        System.out.println("Good morning my dear family!!!");
    }
}