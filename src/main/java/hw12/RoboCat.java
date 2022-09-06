package hw12;

import java.util.Set;
public class RoboCat extends Pet implements Foulable {
    public RoboCat() {
        super();
    }
    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }


    @Override
    public void respond() {
        System.out.println("Hi my dear friend, my name is "+this.nickname+" and I am a robo cat");
    }

    @Override
    public void foul() {
        System.out.println("It is time to suppress");
    }
}