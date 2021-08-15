import java.io.*;
import java.util.Scanner;
abstract class Stu{
    abstract int logInn(String user, char[] pass);
    abstract int save(String assignment,String instructor,String student,String course);
}

public class Student extends Stu {
    String info;
    String tempUsername;

    public int logInn(String user, char[] pass) {
        String tempPassword;
        try {
            Scanner x = new Scanner(new File("C:\\Users\\hp 2540p\\OneDrive\\Documents\\Semester II\\OOP Lab\\Course Management System\\Student_Records.txt"));
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

    String assign="";
    String tempUsername1;
    String temp;
    public int save(String assignment,String instructor,String student,String course){
        try {
            Scanner x = new Scanner(new File("C:\\Users\\hp 2540p\\OneDrive\\Documents\\Semester II\\OOP Lab\\Course Management System\\Instructor_Records.txt"));

            while(x.hasNextLine()){
                temp=x.nextLine();
                tempUsername1 = temp.split(",")[0];
                temp=temp.split(",")[7];

                if(tempUsername1.equals(instructor)&&temp.contains(course)) {
                    try {
                        Scanner x1 = new Scanner(new File(assignment));

                        while (x1.hasNextLine()) {
                            assign += x1.nextLine();
                        }
                        x1.close();
                    } catch (Exception f) {
                        f.printStackTrace();
                    }
                    try {
                        FileWriter fw = new FileWriter(instructor + ".txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        pw.print("Student Name:" + student + "\n" + assign + "\n******************Submission******************\n");
                        pw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            }
        x.close();}
            catch(Exception f){
                f.printStackTrace();
            }
            return 1;
        }
    }


