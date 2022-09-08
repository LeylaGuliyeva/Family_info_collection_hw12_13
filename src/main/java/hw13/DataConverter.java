package hw13;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataConverter {
    static DateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
    public static String LongToString(long MilliS){
        Date dt=new Date(MilliS);
        return sdf.format(dt);
    }
    public static long StringToLong(String s){
        try{
            return sdf.parse(s).getTime();
        }
        catch(ParseException excp){
            System.out.println("Exception, wrong string date pattern");
            throw new RuntimeException();
        }}
    public static int GetYearfrmBD(long bd){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(bd);
        int year=calendar.get(Calendar.YEAR)-1970;
        return year;
    }

}