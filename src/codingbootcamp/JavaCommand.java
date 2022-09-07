package codingbootcamp;

/**
 * @ClassName JavaCommand
 * @Description TODO
 * @Author katefu
 * @Date 9/6/22 9:08 PM
 * @Version 1.0
 **/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaCommand {
    static class ParsedCommand {
        ArrayList<String> argv;
        Set<String> switches;
        ParsedCommand() {
            argv = new ArrayList<String>();
            switches = new TreeSet<String>();
        }
    };

    /*
     * Complete the function below.
     */

    static boolean belongToSwitch(char c){
        if(c=='-') return true;
        if(c>='a' && c<='z') return true;
        if(c>='A' && c<='Z') return true;
        return false;
    }
    static ParsedCommand parseCommand(String cmdline) {
        if(cmdline.length()==0) return null;
        ParsedCommand pc = new ParsedCommand();
        int firstForward = cmdline.indexOf("/");

        String a;
        if(firstForward<0) {
            a = cmdline;
        }else{
            a = cmdline.substring(0, firstForward);
        }

        String[] names = a.split(" ");
        for(String name: names){
            if(name.length()>0) pc.argv.add(name);
        }

        if(firstForward<0) return pc;

        StringBuilder middleName = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();


        for(int i=firstForward; i<cmdline.length();){
            if(cmdline.charAt(i)=='/'){
                StringBuilder sb = new StringBuilder();
                int j = i+1;
                while(j<cmdline.length() && belongToSwitch(cmdline.charAt(j))){
                    sb.append(cmdline.charAt(j));
                    j++;
                }
                String swi = sb.toString().toUpperCase();
                swi.replaceAll("\\/", "");
                if(swi.length()>0){
                    if(swi.charAt(0)!='-'){
                        for(int p=0; p<swi.length(); p++){
                            map.put(swi.charAt(p), map.getOrDefault(swi.charAt(p), 0)+1);
                        }
                    }else{
                        for(int p=0; p<swi.length(); p++){
                            map.put(swi.charAt(p), map.getOrDefault(swi.charAt(p), 0)-1);
                        }
                    }
                }
                i=j;
            }else{
                middleName.append(cmdline.charAt(i));
                i++;
            }
        }

        String middle = middleName.toString();
        String[] newNames = middle.split(" ");
        for(String newName: newNames){
            if(newName.length()>0) pc.argv.add(newName);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()>0){
                String str = String.valueOf(entry.getKey());
                pc.switches.add(str);
            }
        }

        if(pc.argv.size()>0) return pc;
        else return null;

    }

    public static void main(String[] args) throws IOException {
        parseCommand("/A/B/-a/b/cdE");
    }
}

