import java.io.*;
import java.util.Scanner;
interface Ins{
     int logInn(String user, char[] pass);
     String viewAssignment(String name);
}

public class Instructor implements Ins{
    String info;
    String tempUsername;

    public int logInn(String user, char[] pass) {
        String tempPassword;
        try {
            Scanner x = new Scanner(new File("C:\\Users\\hp 2540p\\OneDrive\\Documents\\Semester II\\OOP Lab\\Course Management System\\Instructor_Records.txt"));
            x.useDelimiter("[,\n]");

            while(x.hasNext()){
                tempUsername=x.next();
                tempPassword=x.next();

                if(tempUsername.equals(user)&&tempPassword.equals(String.valueOf(pass))){
                    info=tempUsername+"\n"+tempPassword+"\n"+x.next()+"\n"+x.next()+"\n"+x.next()+"\n"+x.next()+"\n"+x.next()+"\n"+x.next();
                    return 0;
                }
                x.nextLine();
            }
            x.close();
        }
        catch(Exception f){
            f.printStackTrace();
        }
        return 1;
    }


    public String viewAssignment(String name) {
        String assign="";
        try {
            Scanner x = new Scanner(new File(name+".txt"));

            while(x.hasNextLine()){
                assign+=x.nextLine()+"\n";
            }
            x.close();
        }
        catch(Exception f){
            return "No Submissions Found";
        }
      return assign;
    }
}
