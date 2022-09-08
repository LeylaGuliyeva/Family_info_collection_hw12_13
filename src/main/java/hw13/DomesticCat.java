package hw13;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {
    public DomesticCat() {
        super();
    }
    public DomesticCat(String nickname) {
        super(nickname);
    }
    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }
    @Override
    public void respond() {
        System.out.println("Hi my dear friend, my name is "+this.nickname+" and I am a cat");
    }

    @Override
    public void foul() {
        System.out.println("It is time to suppress");
    }
}