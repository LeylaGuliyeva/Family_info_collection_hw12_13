package Practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Bracket {
    public static boolean correspondBracket(char a,char b){
        switch(a){
            case ']':
                if(b=='[') return true;
                break;
            case '}':
                if(b=='{') return true;
                break;
            case '>':
                if(b=='<') return true;
                break;
            case ')':
                if(b=='(') return true;
                break;
        }
    return false;}

    public static boolean BracketApp(String line){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<line.length();i++) {
            char a=line.charAt(i);
            switch(a){
                case '{':
                case '[':
                case '(':
                case '<':
                    stack.push(a);
                    break;
                case '}':
                case ')':
                case ']':
                case '>':
                    if(stack.isEmpty()) return false;
                    if(correspondBracket(a,stack.lastElement())) stack.pop();
                    break;}}
        return stack.isEmpty();
        }
        public static void main(String args[]){
        String line1=new String("{{}{{}}}");
        String line2=new String("");
        String line3=new String("{(<})<>>");
        String line4=new String("{(<{}>)<{()}>}");
        System.out.println(BracketApp(line1));
        System.out.println(BracketApp(line2));
        System.out.println(BracketApp(line3));
        System.out.println(BracketApp(line4));
    }
    }

