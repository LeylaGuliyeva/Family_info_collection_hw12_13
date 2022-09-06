package hw12;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
public class HumanTest {
    @Test
    public void toStringTest(){
        DomesticCat cat=new DomesticCat("Meow");
        byte iq=100;
        Map<DayOfWeek, String> sl = new HashMap<DayOfWeek, String>();
        sl.put(DayOfWeek.MONDAY, "Playing piano");
        sl.put(DayOfWeek.TUESDAY, "Playing piano");
        sl.put(DayOfWeek.WEDNESDAY,"Yoga");
        sl.put(DayOfWeek.THURSDAY,"Reading book");

        Human Samin=new Human("Samin","Alakbarov","30/07/1982");
        Human Lala=new Human("Lala","Alakbarova","19/05/2000") ;
        Family fami=new Family(Lala,Samin);
        Human Eren=new Human("Eren","Alakbarov","12/13/2021",iq=100,sl,fami,cat);
        System.out.println(Eren);
        assertTrue(Eren.toString().equals("Human{name='Eren', surname='Alakbarov', birth date=12/13/2021, iq=100, schedule={TUESDAY=Playing piano, MONDAY=Playing piano, WEDNESDAY=Yoga, THURSDAY=Reading book}}"));
    }
}
