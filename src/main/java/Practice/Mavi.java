package Practice;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mavi {
    public static void main(String args[]) throws IOException {
        String fileName=new String("myfileo0.txt");
        File file=new File(fileName);
      //  FileOutputStream os=new FileOutputStream(file);
//        try(
//        BufferedWriter bs=new BufferedWriter(new FileWriter(file,true))){
//        bs.write("Leyla");
//        bs.write("uioo\n");
//    }
        try(BufferedReader ss=new BufferedReader(new FileReader(file))){
            String line=new String();
            Stream<String> lines=ss.lines();
            while((line=ss.readLine())!=null){
            System.out.printf("line : %s",line);
        }


    }

}}
