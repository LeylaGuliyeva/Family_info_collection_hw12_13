package hw12;

import java.util.*;

public class FamilyService {
    FamilyDao famDao;

    public void setFamDao(FamilyDao famDao) {
        this.famDao = famDao;
    }

    public List<Family> getAllFamilies() {
        return famDao.getAllFamilies();
    }
    public void displayAllFamilies() {
        System.out.println("Families :");
        famDao.getAllFamilies().stream().forEach(x->System.out.println(String.valueOf(getFamilyIndex(famDao.getAllFamilies(),x))+x.prettyFormat()));
    }
    public int getFamilyIndex(List<Family> fml,Family fm){
        for(int i=0;i<fml.size();i++){
            if(fml.get(i).equals(fm)){
                return i;
            }
        }
        return 0;}



    public List<Family> getFamiliesBiggerThan(int x) {
        List<Family> famBiggerThan = new ArrayList<>();
        famDao.getAllFamilies().forEach(z -> {
            if (z.countFamily() > x) {
                famBiggerThan.add(z);
            }
        });
        famBiggerThan.forEach(f->System.out.println(f.prettyFormat()));
        return famBiggerThan;
    }
    public List<Family> getFamiliesLessThan(int x) {
        List<Family> famLessThan = new ArrayList<>();
        famDao.getAllFamilies().forEach(z -> {
            if (z.countFamily() < x) {
                famLessThan.add(z);
            }
        });
        famLessThan.forEach(f->System.out.println(f.prettyFormat()));
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