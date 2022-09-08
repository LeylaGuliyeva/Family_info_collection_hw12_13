package hw13;

import java.util.Set;

public class Dog extends Pet implements Foulable {
    public Dog() {
        super();
    }
    public Dog(String nickname){
        super(nickname);}

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Hi my dear friend, my name is "+this.nickname+" and I am a dog");
    }

    @Override
    public void foul() {
        System.out.println("It is time to suppress");
    }

}