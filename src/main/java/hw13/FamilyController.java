package hw13;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FamilyController {
    FamilyService famSer=new FamilyService();

    public void setFamSer(FamilyService famSer) {
        this.famSer = famSer;
    }

    public List<Family> getAllFamilies() {
        return famSer.getAllFamilies();
    }
    public void displayAllFamilies() {
        famSer.displayAllFamilies();
    }
    public List<Family> getFamiliesBiggerThan(int x) {
        return famSer.getFamiliesBiggerThan(x);
    }
    public List<Family> getFamiliesLessThan(int x) {
        return famSer.getFamiliesLessThan(x);
    }
    public int countFamiliesWithMemberNumber(int x) {
        return famSer.countFamiliesWithMemberNumber(x);
    }
    public void createNewFamily(Human mother, Human father){
        famSer.createNewFamily(mother,father);
    }
    public void deleteFamilyByIndex(int x){
        famSer.deleteFamilyByIndex(x);
    }
    public Family bornChild(Family fam, GenderOfPerson gen, String name){
        if(fam.countFamily()<5){
            return famSer.bornChild(fam,gen,name);
        }
        else{throw new FamilyOverflowException("Family member number is already reached the limit");}
    }
    public Family adoptChild(Family fam, Human h){
        if(fam.countFamily()<5){
            return famSer.adoptChild(fam,h);
        }
        else {throw new FamilyOverflowException("Family member number is already reached the limit");}
    }
    public void deleteAllChildrenOlderThen(int x){
        famSer.deleteAllChildrenOlderThen(x);
    }
    public int count(){
        return famSer.count();
    }
    public Family getFamilyById(int x){
        return famSer.getFamilyById(x);
    }
    public Set<Pet> getPets(int x){
        return famSer.getPets(x);
    }
    public void addPet(int x, Pet pet){
        famSer.addPet(x,pet);
    }
    public void loadData(List<Family> families){
        famSer.loadData(families);
    }
    public void saveData(List<Family> families){
        famSer.saveData(families);
    }
    public Optional<List<Family>> getPreviouslySavedData(){
        return famSer.getPreviouslySavedData();
    }
}