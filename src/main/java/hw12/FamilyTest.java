package hw12;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class FamilyTest {
    @Test
    public void addChildTest(){
        List<Human> x = new ArrayList<>();
        Human Dion=new Human("Dion","Bellamy","23/02/1994");
        Human Esperanza=new Human("Esperanza","Bellamy","12/09/1996");
        Human Aurora=new Human("Aurora","Bellamy","30/06/2020");
        Human Esmeralda=new Human("Esmeralda","Bellamy","12/10/2019");
        Human Omar=new Human("Omar","Bellamy","12/09/2017");
        x.add(Aurora);
        x.add(Esperanza);
        x.add(Omar);
        Family bestFamily=new Family(Esperanza,Dion);
        Human Amal=new Human("Amal","Bellamy","10/12/2020");
        bestFamily.setChildren(x);
        List<Human> x1 = new ArrayList<>(x);
        bestFamily.addChild(Amal);
        x1.add(Amal);
        assertTrue(x1.equals(bestFamily.getChildren()));
    }
    @Test
    public void toStringTest(){
        Human Dion=new Human("Dion","Bellamy","23/02/1994");
        Human Esperanza=new Human("Esperanza","Bellamy","12/09/1996");
        Human Aurora=new Human("Aurora","Bellamy","30/06/2020");
        Family bestFamily=new Family(Esperanza,Dion);
        bestFamily.addChild(Aurora);
        String str="Family{mother=Human{name='Esperanza', surname='Bellamy', birth date=12/09/1996, iq=null, schedule=null}, father=Human{name='Dion', surname='Bellamy', birth date=23/02/1994, iq=null, schedule=null}, children=[Human{name='Aurora', surname='Bellamy', birth date=30/06/2020, iq=null, schedule=null}], pet=[]}\n";
        assertTrue(bestFamily.toString().equals(str));}}
