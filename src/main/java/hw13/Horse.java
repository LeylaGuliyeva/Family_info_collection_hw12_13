package hw13;

import java.util.Set;

public class Horse extends Pet {
    public Horse() {
        super();
    }
    public Horse(String nickname) {
        super(nickname);
    }
    public Horse(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public void respond() {
        System.out.println("Hi my dear friend, my name is "+this.nickname+" and I am a horse");
    }
}