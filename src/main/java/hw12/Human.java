package hw12;
import java.util.Calendar;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static hw12.DataConverter.LongToString;


public class Human implements prettyFormat{
    protected String name;
    protected String surname;
    protected long birthDate;
    protected int iq;
    protected Map<DayOfWeek, String> schedule;;
    protected Family family;
    protected Pet pet;


    public void greetPet(){System.out.println("Hi, dear "+this.pet.getNickname()+"!");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Map<DayOfWeek, String> getSchedule() {
        return this.schedule.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    public String describeAge(){
        Calendar clndr=Calendar.getInstance();
        long diff=clndr.getTimeInMillis()-birthDate;
        clndr.setTimeInMillis(diff);
        int y=clndr.get(Calendar.YEAR)-1970;
        int m=clndr.get(Calendar.MONTH);
        int d=clndr.get(Calendar.DAY_OF_MONTH);
        return y+"Year, "+m+"Month, "+d+"Day";
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String bd) {
        DataConverter dc=new DataConverter();
        this.birthDate = dc.StringToLong(bd);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public String toString(){
        DataConverter dc=new DataConverter();
        return "Human{name='" + this.name + "', surname='" + this.surname  + "', birth date="+ LongToString(this.birthDate) + ", iq=" + (this.iq!=0?this.iq:"null") + ", schedule="+this.schedule+"}";
    }


    protected Human() {

    }
    protected Human(String nm, String snm, String bd){
        DataConverter dc=new DataConverter();
        this.name = nm;
        this.surname = snm;
        this.birthDate= dc.StringToLong(bd);
    }
    protected Human(String nm, String snm, String bd,byte iq){
        DataConverter dc=new DataConverter();
        this.name = nm;
        this.surname = snm;
        this.birthDate= dc.StringToLong(bd);
        this.iq=iq;
    }
    protected Human(String nm, String snm, String bd,byte iq,Map<DayOfWeek, String> sdle){
        DataConverter dc=new DataConverter();
        this.name = nm;
        this.surname = snm;
        this.birthDate= dc.StringToLong(bd);
        this.iq=iq;
        this.schedule=sdle;
    }

    protected Human(String nm, String snm, String bd, byte iq, Map<DayOfWeek, String> sdle, Family fam, Pet pet) {
        DataConverter dc=new DataConverter();
        this.name = nm;
        this.surname = snm;
        this.birthDate= dc.StringToLong(bd);
        this.iq=iq;
        this.schedule=sdle;
        this.family=fam;
        this.pet=pet;
    }
    @Override
    public String prettyFormat(){
        String str=String.format(": {name='%s', surname='%s', birthDate='%s', iq=%s, schedule=%s},\n",getName(),getSurname(),LongToString(getBirthDate()),getIq()==0?"null":String.valueOf(getIq()),schedule);
        return str;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getBirthDate() == human.getBirthDate() && getIq() == human.getIq() && getName().equals(human.getName()) && getSurname().equals(human.getSurname()) && getFamily().equals(human.getFamily());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthDate(), getFamily());
    }
    @Override
    protected void finalize(){
        System.out.println("Human class element will be deleted!");
    }
}