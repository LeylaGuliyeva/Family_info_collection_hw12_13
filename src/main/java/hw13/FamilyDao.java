package hw13;

import java.util.List;

public interface FamilyDao {
    public List<Family>  getAllFamilies();
    public Family getFamilyByIndex(int x);
    public boolean deleteFamily(int x);
    public boolean deleteFamily(Family f);
    public void saveFamily(Family f);
}
