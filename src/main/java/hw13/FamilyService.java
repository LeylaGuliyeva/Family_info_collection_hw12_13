package hw13;

import java.util.*;

public class FamilyService {
    FamilyDao famDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies() {
        return famDao.getAllFamilies();
    }
    public void displayAllFamilies() {
        System.out.println("Families :");
        famDao.getAllFamilies().stream().forEach(System.out::print);
    }

    public List<Family> getFamiliesBiggerThan(int x) {
        List<Family> famBiggerThan = new ArrayList<>();
        famDao.getAllFamilies().forEach(z -> {
            if (z.countFamily() > x) {
                famBiggerThan.add(z);
            }
        });
        System.out.println(famBiggerThan.toString());
        return famBiggerThan;
    }
    public List<Family> getFamiliesLessThan(int x) {
        List<Family> famLessThan = new ArrayList<>();
        famDao.getAllFamilies().forEach(z -> {
            if (z.countFamily() < x) {
                famLessThan.add(z);
            }
        });
        System.out.println(famLessThan.toString());
        return famLessThan;
    }
    public int countFamiliesWithMemberNumber(int x) {
        List<Family> famWithMemberNumber= new ArrayList<>();
        famDao.getAllFamilies().forEach(z -> {
            if (z.countFamily()==x) {
                famWithMemberNumber.add(z);
            }
        });
        return famWithMemberNumber.size();
    }
    public void createNewFamily(Human mother, Human father){
        famDao.saveFamily(new Family(mother,father));
    }
    public void deleteFamilyByIndex(int x){
        famDao.deleteFamily(x);
    }
    public Family bornChild(Family fam, GenderOfPerson gen){
        Human baby=new Human(gen== GenderOfPerson.FEMININE?"Ada":"Aidan",fam.getSurname(), Integer.toString(Calendar.getInstance().get(Calendar.YEAR))+"/"+Integer.toString(Calendar.getInstance().get(Calendar.MONTH))+"/"+Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
        fam.addChild(baby);
        famDao.saveFamily(fam);
        return fam;}
    public Family adoptChild(Family fam, Human h){
        fam.addChild(h);
        famDao.saveFamily(fam);
        return fam;
    }
    public void deleteAllChildrenOlderThen(int x){
        DataConverter dc=new DataConverter();
        for(int i=0;i<famDao.getAllFamilies().size();i++){
            for(int j=0;j<famDao.getFamilyByIndex(i).getChildren().size();j++){
                if((Calendar.getInstance().get(Calendar.YEAR)-dc.GetYearfrmBD(famDao.getFamilyByIndex(i).getChildren().get(j).getBirthDate()))>x){
                    famDao.getFamilyByIndex(i).deleteChild(famDao.getFamilyByIndex(i).getChildren().get(j));}}
            famDao.saveFamily(famDao.getFamilyByIndex(i));
        }}
    public int count(){
        return famDao.getAllFamilies().size();
    }
    public Family getFamilyById(int x){
        return famDao.getFamilyByIndex(x);
    }
    public Set<Pet> getPets(int x){
        Set<Pet> pets=new HashSet<>(famDao.getFamilyByIndex(x).getPet());
        return pets;
    }
    public void addPet(int x, Pet pet){
        famDao.getFamilyByIndex(x).addPet(pet);
        famDao.saveFamily(famDao.getFamilyByIndex(x));

    }
}