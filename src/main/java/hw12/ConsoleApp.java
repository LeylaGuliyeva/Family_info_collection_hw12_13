package hw12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConsoleApp {
    static Scanner sn=new Scanner(System.in);
    static String str=new String();
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
                    "- 9. Remove all children over the age of majority (all families remove children over the age of majority - let us assume they have grown up)\n");
            System.out.print("Please enter command : ");
            str=sn.nextLine();
            CollectionFamilyDao cfd=new CollectionFamilyDao();
            FamilyService famServ=new FamilyService();
            switch(str){
                case "1":
                    List<Family> famList=new ArrayList<>();
                    Man Samin=new Man("Samin","Alakbarov","30/07/1982");
                    Woman Lala=new Woman("Lala","Alakbarova","19/05/2000") ;
                    Human Mukhtar = new Human("Mukhtar", "Asgerli", "12/12/1984");
                    Woman Loya = new Woman("Loya", "Asgerli", "14/03/1990");
                    Human Ali = new Human("Ali", "Suleyanzada", "16/09/1988");
                    Woman Ayda = new Woman("Ayda", "Suleymanzada", "06/05/1992");
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
                    break;
                case "2":
                    famServ.displayAllFamilies();
                    break;
                case "3":
                    System.out.println("Please enter the number : ");
                    famServ.getFamiliesBiggerThan(sn.nextInt()).forEach(d->System.out.println(d.prettyFormat()));
                    break;
                case "4":
                    System.out.println("Please enter the number : ");
                    famServ.getFamiliesLessThan(sn.nextInt()).forEach(d->System.out.println(d.prettyFormat()));
                    break;
                case "5":
                    System.out.println("Please enter the number : ");
                    famServ.getAllFamilies().stream().forEach(x->{if(x.countFamily()==sn.nextInt()){
                        System.out.println(x.prettyFormat());
                    }});
                    break;
                case "6":
                    System.out.println("Please enter the name of mother");
                    String nameM=sn.nextLine();
                    System.out.println("Please enter the surname of mother");
                    String surnameM=sn.nextLine();
                    System.out.println("Please enter the birth year of mother");
                    String yearM=sn.nextLine();
                    System.out.println("Please enter the month of birth of mother");
                    String monthM=sn.nextLine();
                    System.out.println("Please enter the birthday of mother");
                    String dayM=sn.nextLine();
                    System.out.println("Please enter the iq of mother");
                    int iqM=sn.nextInt();
                    System.out.println("Please enter the name of fatther");
                    String nameF=sn.nextLine();
                    System.out.println("Please enter the surname of father");
                    String surnameF=sn.nextLine();
                    System.out.println("Please enter the birth year of father");
                    String yearF=sn.nextLine();
                    System.out.println("Please enter the month of birth of father");
                    String monthF=sn.nextLine();
                    System.out.println("Please enter the birthday of father");
                    String dayF=sn.nextLine();
                    System.out.println("Please enter the iq of father");
                    int iqF=sn.nextInt();
                    Woman mother=new Woman(nameM,surnameM,dayM+"/"+monthM+"/"+yearM);
                    Man father=new Man(nameF,surnameF,dayF+"/"+monthF+"/"+yearF);
                    mother.setIq(iqM);
                    father.setIq(iqF);
                    Family nfam=new Family(mother,father);
                    break;
                case "7":
                    System.out.println("Please enter the number : ");
                    famServ.deleteFamilyByIndex(sn.nextInt());
                    break;
                case "8":
                    System.out.println("Please enter the number : ");
                    switch(sn.nextInt()){

                    }

                case "9":
                default:
                    System.out.println("Enter valid command!");
                    break;
            }
        }while(str.equals("exit")!=true);

        }

}
