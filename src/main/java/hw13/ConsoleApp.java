package hw13;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;


public class ConsoleApp {
        static Scanner scan=new Scanner(System.in);
        static String str=new String();

        static CollectionFamilyDao cfd=new CollectionFamilyDao();
        static FamilyService famServ=new FamilyService();
        static List<Family> famList=new ArrayList<>();
        static FamilyController famCont=new FamilyController();
        public static void consoleApplication(){
            do{
                System.out.println("- 1. Fill with test data (create several families and save them in the database)\n" +
                        "- 2. Display the entire list of families (displays a list of all families with indexation starting with 1)\n" +
                        "- 3. Display a list of families where the number of people is greater than the specified number\n" +
                        "- 4. Display a list of families where the number of people is less than the specified number\n" +
                        "- 5. Calculate the number of families where the number of members is\n" +
                        "- 6. Create a new family\n" +
                        "- 7. Delete a family by its index in the general list\n" +
                        "- 8. Edit a family by its index in the general list\n" +
                        "  - 1. Give birth to a baby\n" +
                        "  - 2. Adopt a child\n" +
                        "  - 3. Return to main menu  \n" +
                        "- 9. Remove all children over the age of majority (all families remove children over the age of majority - let us assume they have grown up)\n" +
                        "- 10. Get saved data\n"+
                        "- 11. Save Data\n"+
                        "- 12. Download data to database\n");
                System.out.print("Please enter command : ");
                str=scan.nextLine();
                Scanner sn=new Scanner(System.in);
                switch(str){
                    case "1":
                        Man Samin=new Man("Samin","Alakbarov","30/07/1982");
                        Woman Lala=new Woman("Lala","Alakbarova","19/05/2000") ;
                        Human Mukhtar = new Human("Mukhtar", "Asgerli", "12/12/1984");
                        Woman Loya = new Woman("Loya", "Asgerli", "14/03/1990");
                        Human Ali = new Human("Ali", "Suleyanzada", "16/09/1988");
                        Woman Ayda = new Woman("Ayda", "Suleymanzada", "10/05/1992");
                        Man Eren=new Man("Eren","Alakbarov","12/10/2021");
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
                        famList.add(family1);
                        famList.add(family2);
                        famList.add(family3);
                        cfd.setAllFam(famList);
                        famServ.setFamDao(cfd);
                        famCont.setFamSer(famServ);
                        break;
                    case "2":
                        famServ.displayAllFamilies();
                        break;
                    case "3":
                        System.out.println("Please enter the number : ");
                        int p=sn.nextInt();
                        famServ.getFamiliesBiggerThan(p).forEach(d->d.prettyFormat());
                        break;
                    case "4":
                        System.out.println("Please enter the number : ");
                        famServ.getFamiliesLessThan(sn.nextInt()).forEach(d->System.out.println(d.prettyFormat()));
                        break;
                    case "5":
                        System.out.println("Please enter the number : ");
                        int ageFE=sn.nextInt();
                        famServ.getAllFamilies().stream().forEach(x->{if(x.countFamily()==ageFE){
                            System.out.println(x.prettyFormat());
                        }});
                        break;
                    case "6":
                        System.out.println("Please enter the name of mother");
                        String nameM=sn.next();
                        System.out.println("Please enter the surname of mother");
                        String surnameM=sn.next();
                        System.out.println("Please enter the birth year of mother");
                        String yearM=sn.next();
                        System.out.println("Please enter the month of birth of mother");
                        String monthM=sn.next();
                        System.out.println("Please enter the birthday of mother");
                        String dayM=sn.next();
                        System.out.println("Please enter the iq of mother");
                        int iqM=sn.nextInt();
                        System.out.println("Please enter the name of father");
                        String nameF=sn.next();
                        System.out.println("Please enter the surname of father");
                        String surnameF=sn.next();
                        System.out.println("Please enter the birth year of father");
                        String yearF=sn.next();
                        System.out.println("Please enter the month of birth of father");
                        String monthF=sn.next();
                        System.out.println("Please enter the birthday of father");
                        String dayF=sn.next();
                        System.out.println("Please enter the iq of father");
                        int iqF=sn.nextInt();
                        Woman mother=new Woman(nameM,surnameM,dayM+"/"+monthM+"/"+yearM);
                        Man father=new Man(nameF,surnameF,dayF+"/"+monthF+"/"+yearF);
                        mother.setIq(iqM);
                        father.setIq(iqF);
                        famServ.createNewFamily(mother,father);
                        break;
                    case "7":
                        System.out.println("Please enter the index of family : ");
                        int index=sn.nextInt();
                        if(index>0&&index<famServ.getAllFamilies().size()){
                            famServ.deleteFamilyByIndex(sn.nextInt());}
                        else{System.out.println("No such family exits with the index "+index);}
                        break;
                    case "8":
                        Scanner sn1=new Scanner(System.in);
                        System.out.println("Please enter the number : ");
                        int r=sn1.nextInt();
                        switch(r){
                            case 1:
                                System.out.println("Please enter the ID of family : ");
                                int famID=sn.nextInt();
                                if(famID<0&&famID>=famServ.getAllFamilies().size()){
                                    System.out.println("No such family exits with the index "+famID);
                                    break;}
                                System.out.println("Please enter the gender of baby (masculine/feminine) : ");
                                String gen=sn.next();
                                GenderOfPerson genB=GenderOfPerson.FEMININE;
                                if(gen.toUpperCase().equals("MASCULINE")){
                                    genB=GenderOfPerson.MASCULINE;
                                }
                                System.out.println("Please enter the name of baby : ");
                                String name=sn.next();
                                famCont.bornChild(famServ.getFamilyById(famID),genB, name);
                                break;
                            case 2:
                                System.out.println("Please enter the ID of family : ");
                                int famID1=sn.nextInt();
                                if(famID1<0&&famID1>=famServ.getAllFamilies().size()){
                                    System.out.println("No such family exits with the index "+famID1);
                                    break;}
                                System.out.println("Please enter the name and surname of the child : ");
                                String name1=sn.next();
                                String surname1=sn.next();
                                System.out.println("Please enter the birth date of the child (dd/mm/yyyy) : ");
                                String birthD=sn.next();
                                System.out.println("Please enter the IQ of the child : ");
                                int iq1=sn.nextInt();
                                System.out.println("Please enter the gender of the child (masculine/feminine) : ");
                                String gen1=sn.next();
                                Man child=new Man(name1,surname1,birthD,(byte)iq1);
                                Woman child1=new Woman(name1,surname1,birthD,(byte)iq1);
                                if(gen1.toUpperCase().equals("MASCULINE")){
                                    famCont.adoptChild(famServ.getFamilyById(famID1),child);
                                }
                                else{ famCont.adoptChild(famServ.getFamilyById(famID1),child1);}
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Enter a valid command! (1,2,3) ");
                                break;}
                        break;
                    case "9":
                        Scanner sm=new Scanner(System.in);
                        System.out.println("Please enter the age : ");
                        int age1=sm.nextInt();
                        famServ.deleteAllChildrenOlderThen(age1);
                        break;
                    case "10":
                        Optional<List<Family>> a=famCont.getPreviouslySavedData();
                        a.ifPresent(o->IntStream.rangeClosed(0,o.size()-1).forEach(id->System.out.println(String.valueOf(id+1)+"."+o.get(id).prettyFormat())));
                        if(a.isPresent()==false){
                            System.out.println("No saved data");
                        }
                        break;
                    case "11":
                        famServ.saveData(famServ.getAllFamilies());
                        break;
                    case "12":
                        famServ.getPreviouslySavedData().ifPresent(o->famServ.loadData(o));
                        if(famServ.getPreviouslySavedData().isPresent()==false){
                            System.out.println("No saved data");
                        }
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println("Enter a valid command! (1-9) ");
                        break;}
            }while(str.equals("exit")!=true);

        }

    }

