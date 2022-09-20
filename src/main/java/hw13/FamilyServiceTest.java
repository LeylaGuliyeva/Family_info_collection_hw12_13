package hw13;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FamilyServiceTest {
    FamilyService famSerT=new FamilyService();
    @Test
    public void getAllFamilies() {
        assertTrue(famSerT.getAllFamilies().get(0).equals(famSerT.getFamilyById(0))&&famSerT.getAllFamilies().get(1).equals(famSerT.getFamilyById(1))&&famSerT.getAllFamilies().get(2).equals(famSerT.getFamilyById(2)));
    }
    @Test
    public void getFamiliesBiggerThan() {
        List<Family> famBigT=new ArrayList<>();
        famBigT.add(famSerT.getFamilyById(0));
        assertTrue(famSerT.getFamiliesBiggerThan(3).equals(famBigT));
    }
    @Test
    public void getFamiliesLessThan() {
        List<Family> famLessT=new ArrayList<>();
        famLessT.add(famSerT.getFamilyById(1));
        famLessT.add(famSerT.getFamilyById(2));
        assertTrue(famSerT.getFamiliesLessThan(4).equals(famLessT));
    }
    @Test
    public void countFamiliesWithMemberNumber() {
        assertTrue(famSerT.countFamiliesWithMemberNumber(4)==1);
    }
    @Test
    public void createNewFamily(){
        Human mother=new Human("Ayla","Huseynzada","31/08/1990");
        Human father=new Human("Isa","Huseynzada","31/08/1988");
        famSerT.createNewFamily(mother,father);
        assertTrue(famSerT.getFamilyById(3).getMother()==mother&&famSerT.getFamilyById(3).getFather()==father);
    }
    @Test
    public void deleteFamilyByIndex(){
        famSerT.deleteFamilyByIndex(1);
        assertTrue(famSerT.getAllFamilies().size()==2);
    }
    @Test
    public void bornChild(){
        famSerT.bornChild(famSerT.getFamilyById(2), GenderOfPerson.MASCULINE,"Bell");
        assertTrue(famSerT.getFamilyById(2).getChildren().get(1).name.equals("Bell")&&famSerT.getFamilyById(2).getChildren().size()==2);
    }
    @Test
    public void adoptChild(){
        Human hmn=new Human("Denis","Bellamy","31/08/2019", (byte) 100);
        famSerT.adoptChild(famSerT.getFamilyById(1),hmn);
        assertTrue(famSerT.getFamilyById(1).getChildren().get(1).name.equals("Denis")&&famSerT.getFamilyById(1).getChildren().size()==2);
    }
    @Test
    public void deleteAllChildrenOlderThen(){
        famSerT.deleteAllChildrenOlderThen(16);
        assertTrue(famSerT.getFamilyById(0).getChildren().size()==1&&famSerT.getFamilyById(0).getChildren().get(0).name=="Eren");
    }
    @Test
    public void count(){
        assertTrue(famSerT.count()==famSerT.getAllFamilies().size());
    }
    @Test
    public void getFamilyById(){
        assertTrue(famSerT.getFamilyById(1).equals(famSerT.getAllFamilies().get(1)));
    }
    @Test
    public void getPets(){
        assertTrue(famSerT.getPets(1).equals(famSerT.getFamilyById(1).getPet()));
    }
    @Test
    public void addPet(){
        Dog curry=new Dog("Curry");
        famSerT.addPet(0,curry);
        assertTrue(famSerT.getPets(0).size()==1);
    }
}