package hw12;
import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;
    public String getSurname(){
        return father.surname;
    }

    public Human getMother() {
        return mother;
    }


    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }
    public int countFamily(){
        return 2+children.size();
    }
    public List<Human> getChildren() {
        return children;
    }
    public void addPet(Pet p){
        pet.add(p);
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children=new ArrayList<Human>();
        this.pet=new HashSet<Pet>();
    }

    public void addChild(Human a) {
        children.add(a);
        a.setFamily(this);
    }
    public String prettyFormat(){
        String.format("family: \n" +
                "   mother: {name='%s', surname='%s', birthDate='%s', iq=%d, schedule={%s},\n" +
                "   father: {name='Karl', surname='Bibo', birthDate='10/12/1990', iq=90, schedule={FRIDAY=library, MONDAY=library}},\n" +
                "   children: \n" +
                "           boy: {name='Donna', surname='Bibo', birthDate='23/10/2018', iq=92, schedule=null}\n" +
                "           girl: {name='Sun', surname='Bibo', birthDate='23/10/2018', iq=92, schedule=null}\n" +
                "           boy: {name='Kurt', surname='Kobein', birthDate='05/05/2003', iq=85, schedule={FRIDAY=music}}\n" +
                "   pets: [{species=DOG, nickname='Jack', age=3, trickLevel=35, habits=[sleep]}, {species=CAT, nickname='Oscar', age=5, trickLevel=81, habits=[eat, play]}]",mother.name,
    }
    public boolean deleteChild(Human child) {
        if(children.size() == 0){
            return false;}
        if(children.remove(child)==true) {
            child.family = null;
            return true;
        }
        return false;
    }
    public boolean deleteChild(int a) {
        if(a<=children.size()||a<=-1) {
            return false;
        }
        else{
            children.get(a).family = null;
            children.remove(a);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + (children != null ? children : "null") +
                ", pet=" + (pet != null ? pet : "null") +
                '}'+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(getMother(), family.getMother()) && Objects.equals(getFather(), family.getFather()) && Objects.equals(getChildren(), family.getChildren()) && Objects.equals(getPet(), family.getPet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMother(), getFather(), getChildren(), getPet());
    }

    @Override
    protected void finalize() {
        System.out.println("Family class element will be deleted!");
    }
}