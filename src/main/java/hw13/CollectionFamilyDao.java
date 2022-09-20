package hw13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionFamilyDao implements FamilyDao {
    List<Family> allFam;
    private static final String fileName = "Families.txt";

    public CollectionFamilyDao() {
        List<Family> famList = new ArrayList<>();
        Man Samin = new Man("Samin", "Alakbarov", "30/07/1982");
        Woman Lala = new Woman("Lala", "Alakbarova", "19/05/2000");
        Human Mukhtar = new Human("Mukhtar", "Asgerli", "12/12/1984");
        Woman Loya = new Woman("Loya", "Asgerli", "14/03/1990");
        Human Ali = new Human("Ali", "Suleymanzada", "16/09/1988");
        Woman Ayda = new Woman("Ayda", "Suleymanzada", "06/05/1992");
        Man Eren = new Man("Eren", "Alakbarov", "12/10/2021");
        Man Erem = new Man("Erem", "Asgerli", "11/08/2010");
        Woman Mikasa = new Woman("Mikasa", "Alakbarova", "12/04/2004");
        Woman Aurora = new Woman("Aurora", "Suleymanzada", "08/09/2013");
        DomesticCat kitten = new DomesticCat("Shine");

        Family family1 = new Family(Lala, Samin);
        family1.addChild(Mikasa);
        family1.addChild(Eren);
        Family family2 = new Family(Loya, Mukhtar);
        family2.addPet(kitten);
        family2.addChild(Erem);
        Family family3 = new Family(Ayda, Ali);
        family3.addChild(Aurora);
        this.allFam = new ArrayList<>();
        allFam.add(family1);
        allFam.add(family2);
        allFam.add(family3);
    }


    public void setAllFam(List<Family> allFam) {
        this.allFam = allFam;
    }

    public CollectionFamilyDao(List<Family> a) {
        allFam = a;
    }

    ;

    @Override
    public List<Family> getAllFamilies() {
        List<Family> allFamilies = allFam;
        return allFamilies;
    }

    @Override
    public Family getFamilyByIndex(int x) {
        if (x >= 0 && x < allFam.size()) {
            return allFam.get(x);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteFamily(int x) {
        if (x >= 0 && x < allFam.size()) {
            allFam.remove(x);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family f) {
        boolean flag = false;
        for (int i = 0; i < allFam.size(); i++) {
            if (f.equals(allFam.get(i))) {
                flag = true;
                break;
            }
        }
        if (flag) {
            allFam.remove(f);
        }
        return flag;
    }

    @Override
    public void saveFamily(Family f) {
        int x = allFam.indexOf(f);
        if (x >= 0 && x < allFam.size()) {
            allFam.set(x, f);
        } else {
            allFam.add(f);
        }
    }

    @Override
    public void loadData(List<Family> allFamilies) {
        allFam = allFamilies;
        System.out.println("Data downloaded");
    }

    @Override
    public void saveData(List<Family> families) {
        File file = new File(fileName);
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Family x : families) {
                os.writeObject(x);
            }
            System.out.println("Saved data succesfully");
        } catch (IOException x) {
            System.out.println("Cannot save data");
        }
    }
    @Override
    public Optional<List<Family>> getPreviouslySavedData(){
        File file = new File(fileName);
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
            List<Family> families = new ArrayList<>();
            try {
                while(true) {
                    Family fam=(Family) is.readObject();
                    families.add(fam);
                }
            } catch (EOFException e) {
                return Optional.of(families);
            }
        } catch (FileNotFoundException x) {
          System.out.println("File is not found");
            return Optional.empty();
        } catch (IOException x) {
          System.out.println("Error occured");
            return Optional.empty();
        } catch (ClassNotFoundException e) {
          System.out.println("Class is not found");
            return Optional.empty();
        }
    }
}




