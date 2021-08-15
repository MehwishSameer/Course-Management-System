import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class Administrator {
    private String[] courses = {""};
    private String name_std, section, email_std, name_ins, email_ins, password, degree;
    Object semester;
    private int age_std, age_ins, dob_std, dob_ins;
    private final static String admin_pass = "welcome";

    public int instructorAccount(String name, int age, String email, String degree, Object semester) {

        if (!(name.matches("^[A-Za-z]*+\s?+[A-Za-z]*$")))
            return 1;
        name_ins = name;

        if (!(email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")))
            return 1;
        email_ins = email;

        if (age > 65)
            return 1;
        age_ins = age;

        if (!(degree.matches("^([^0-9]*)$")))
            return 1;
        this.degree = degree;
        this.semester = semester;

        dob_ins = (LocalDate.now().minusDays(age_ins * 365L)).getYear();

        password = new DecimalFormat("#").format(Math.random() * (999999 - 111111 + 1) + 111111);

        return 0;

    }


    //------------------------------------------------------------------------------------


    public int studentAccount(String name, int age, String email, String section, Object semester) {
        if (!(name.matches("^[A-Za-z]*+\s?+[A-Za-z]*$")))
            return 1;
        name_std = name;


        if (!(section.matches("^([A-Ea-e][1,2])$")))
            return 1;
        this.section = section;

        if (!(email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")))
            return 1;
        email_std = email;

        if ((age > 23) || age < 17)
            return 1;
        age_std = age;

        dob_std = (LocalDate.now().minusDays(age_std * 365L)).getYear();
        this.semester = semester;

        password = new DecimalFormat("#").format(Math.random() * (999999 - 111111 + 1) + 111111);
        return 0;
    }

    public void recordKeeping(){
        try {
            FileWriter fw = new FileWriter("Student_Records.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(name_std+","+password+","+age_std+","+ email_std+","+section+","+ semester +","+dob_std+",");
            for (String cours : courses) {
                pw.print(cours + " ");
            }
            pw.print("\n");
            pw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void recordKeeping(int i){
        try {
            FileWriter fw1 = new FileWriter("Instructor_Records.txt", true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter(bw1);
            pw1.print(name_ins+","+password+","+age_ins+","+ email_ins+","+ degree+","+ semester +","+dob_ins+",");
            for (String cours : courses) {
                pw1.print(cours + " ");
            }
            pw1.print("\n");
            pw1.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public int createCourse(String course,int code){
        if (!(course.matches("^[A-Za-z]*+\s?+[A-Za-z]*$")))
            return 1;

        if (code<1000||code>9999)
            return 1;
        try {
            FileWriter fw1 = new FileWriter("Courses.txt", true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter(bw1);
            pw1.print(course+"\t"+code+"\n");
            pw1.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    public String courses(){
        StringBuilder coursesA= new StringBuilder();
        int count=1;
        try {
            File myObj = new File("C:\\Users\\hp 2540p\\OneDrive\\Documents\\Semester II\\OOP Lab\\Course Management System\\Courses.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                coursesA.append(count).append(").").append(data);
                coursesA.append("\n");
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }
        return coursesA.toString();
    }

    public static int logIn(String username, String pass) {
        if ((pass.matches(admin_pass) && username.matches("admin")))
            return 1;
        else
            return 0;
    }

    public void setCourses(String[] courses) {
        this.courses= Arrays.copyOf(courses,courses.length);
    }

    public String getEmail_ins() {
        return email_ins;
    }

    public String getEmail_std() {
        return email_std;
    }

    public String getName_ins() {
        return name_ins;
    }

    public String getName_std() {
        return name_std;
    }

    public String getSection() {
        return section;
    }

    public int getAge_ins() {
        return age_ins;
    }

    public int getAge_std() {
        return age_std;
    }

    public String[] getCourses() {
        return courses;
    }

    public int getDob_ins() {
        return dob_ins;
    }

    public int getDob_std() {
        return dob_std;
    }

    public Object getSemester() {
        return semester;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String args[]) {
        MyFrame frame = new MyFrame();
    }
}

