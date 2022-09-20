package hw13;

import java.util.List;
import java.util.Optional;

public interface FamilyDao {
    public List<Family>  getAllFamilies();
    public Family getFamilyByIndex(int x);
    public boolean deleteFamily(int x);
    public boolean deleteFamily(Family f);
    public void saveFamily(Family f);
    public void loadData(List<Family> families);
    public void saveData(List<Family> families);
    public Optional<List<Family>> getPreviouslySavedData();

}
