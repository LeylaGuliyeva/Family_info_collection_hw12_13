package hw12;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FamilyController fc=new FamilyController();
        DomesticCat cat=new DomesticCat("Kandela",2,99, Arrays.stream(new String[]{"Eating","Sleeping","Creating a mess"}).collect(Collectors.toSet()));
        Dog maxie = new Dog("Max");
        Human Milan=new Human("Milan","Muradov","10/10/2014");
        fc.addPet(0,maxie);
        fc.addPet(2,cat);
        fc.displayAllFamilies();
        fc.adoptChild(fc.getFamilyById(2),Milan);
        fc.bornChild(fc.getFamilyById(0), GenderOfPerson.FEMININE);
        fc.getFamiliesBiggerThan(5);
        fc.getFamiliesLessThan(6);
        fc.displayAllFamilies();
        System.out.println(fc.getPets(0));
        fc.deleteFamilyByIndex(1);
        fc.displayAllFamilies();
    }
}