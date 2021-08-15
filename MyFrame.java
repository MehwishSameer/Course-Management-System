import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class MyFrame extends JFrame{

    ImageIcon icon = new ImageIcon("Icons/main.jpg");
    ImageIcon stu = new ImageIcon("Icons/student.jpg");
    ImageIcon teach = new ImageIcon("Icons/teacher.jpg");
    ImageIcon courseCreation = new ImageIcon("Icons/course.jpg");
    Administrator admin1 = new Administrator();
    JFrame frame2 = new JFrame();
    Student stu1 = new Student();
    Instructor ins1 = new Instructor();

    MyFrame() {
        this.setVisible(true);
        this.setTitle("COURSE MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(icon.getImage());

        JPanel redPanel = new JPanel();
        redPanel.setBackground(new Color(0xFF6347));
        redPanel.setBounds(0,0,470,750);
        this.add(redPanel);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(new Color(0x2E8B57));
        greenPanel.setBounds(470,0,810,750);
        this.add(greenPanel);

        JLabel label =new JLabel();
        label.setText("COURSE MANAGEMENT SYSTEM");
        label.setForeground(Color.WHITE);
        label.setHorizontalTextPosition(label.SOUTH_EAST);
        label.setBounds(10,250,850,250);
        label.setFont(new Font("Arial",Font.ITALIC,45));
        label.setBackground(Color.black);
        label.setIcon(icon);

        JLabel name = new JLabel();
        name.setText("Username:");
        name.setForeground(Color.BLACK);
        name.setBounds(20,250,100,50);
        name.setFont(new Font("Arial",Font.ITALIC,20));
        JTextField field1 =new JTextField();
        field1.setBounds(140,260,200,30);
        field1.setFont(new Font("Arial",Font.PLAIN,15));

        JLabel pass = new JLabel();
        pass.setText("Password:");
        pass.setForeground(Color.BLACK);
        pass.setBounds(20,310,100,50);
        pass.setFont(new Font("Arial",Font.ITALIC,20));
        JPasswordField field2 =new JPasswordField();
        field2.setBounds(140,320,200,30);
        field2.setFont(new Font("Arial",Font.PLAIN,15));

        String[] login ={"Administrator","Student","Instructor"};
        JLabel loginInfo = new JLabel();
        loginInfo.setText("Login As:");
        loginInfo.setForeground(Color.BLACK);
        loginInfo.setBounds(20, 370, 100, 50);
        loginInfo.setFont(new Font("Arial", Font.ITALIC, 20));
        JComboBox field3 = new JComboBox(login);
        field3.setBounds(140, 375, 200, 30);
        field3.setSelectedIndex(0);
        field3.setFont(new Font("Arial", Font.PLAIN, 15));

        JButton submit = new JButton();
        submit.setText("Submit");
        submit.setFocusable(false);
        submit.setBounds(170,450,100,30);
        submit.addActionListener(e -> {if(field3.getSelectedItem()=="Administrator")
        {if((Administrator.logIn(field1.getText(), String.valueOf(field2.getPassword())))==1){
            JOptionPane.showMessageDialog(null,"Successfully Logged In As Admin","LOGGED IN",JOptionPane.PLAIN_MESSAGE);
            this.dispose();
            Frame2();
        }
        else{
            JOptionPane.showMessageDialog(null,"WRONG USERNAME OR PASSWORD\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        }
        else if(field3.getSelectedItem()=="Student"){
            if(stu1.logInn(field1.getText(),field2.getPassword())==1){
                JOptionPane.showMessageDialog(null,"WRONG USERNAME OR PASSWORD\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Successfully Logged In As Student","LOGGED IN",JOptionPane.PLAIN_MESSAGE);
                this.dispose();
                Frame3();
            }
        }
        else{
            if(ins1.logInn(field1.getText(),field2.getPassword())==1){
                JOptionPane.showMessageDialog(null,"WRONG USERNAME OR PASSWORD\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Successfully Logged In As Instructor","LOGGED IN",JOptionPane.PLAIN_MESSAGE);
                this.dispose();
                Frame4();
            }

        }});

        redPanel.add(submit);
        greenPanel.add(label);
        redPanel.add(field1);
        redPanel.add(name);
        redPanel.add(field2);
        redPanel.add(pass);
        redPanel.add(loginInfo);
        redPanel.add(field3);
        redPanel.setLayout(new BorderLayout());
        greenPanel.setLayout(new BorderLayout());
        this.getContentPane().setLayout(new BorderLayout());
    }
    void Frame2(){
        frame2.setVisible(true);
        JPanel redP = new JPanel();
        frame2.setTitle("COURSE MANAGEMENT SYSTEM");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setIconImage(icon.getImage());
        redP.setBackground(new Color(0xFF6347));
        redP.setBounds(0,0,1400,750);
        frame2.add(redP);

        MenuBar menuBar = new MenuBar();
        Menu createAccount = new Menu("Create Account");
        Menu Course = new Menu("Create Course");
        Menu exit1 = new Menu("Exit");
        MenuItem student = new MenuItem("Student");
        MenuItem instructor = new MenuItem("Instructor");
        MenuItem create = new MenuItem("Create Course");
        MenuItem view = new MenuItem("View course");
        MenuItem exit = new MenuItem("Exit");
        MenuItem signout = new MenuItem("Sign Out");

        menuBar.add(createAccount);
        menuBar.add(Course);
        menuBar.add(exit1);
        frame2.setMenuBar(menuBar);

        createAccount.add(student);
        createAccount.add(instructor);
        Course.add(create);
        Course.add(view);
        exit1.add(exit);
        exit1.add(signout);

        JLabel label =new JLabel();
        label.setText("Student Account Form");
        label.setForeground(Color.WHITE);
        label.setVerticalTextPosition(label.BOTTOM);
        label.setBounds(360,-5,850,200);
        label.setFont(new Font("Arial",Font.ITALIC,45));
        label.setBackground(Color.black);
        label.setIcon(stu);

        JLabel label1 =new JLabel();
        label1.setText("Instructor Account Form");
        label1.setForeground(Color.WHITE);
        label1.setVerticalTextPosition(label1.BOTTOM);
        label1.setBounds(360,-5,850,200);
        label1.setFont(new Font("Arial",Font.ITALIC,45));
        label1.setBackground(Color.black);
        label1.setIcon(teach);

        JLabel label2 =new JLabel();
        label2.setText("Course Creation Form");
        label2.setForeground(Color.WHITE);
        label2.setVerticalTextPosition(label2.BOTTOM);
        label2.setBounds(360,-5,850,200);
        label2.setFont(new Font("Arial",Font.ITALIC,45));
        label2.setBackground(Color.black);
        label2.setIcon(courseCreation);

        JLabel label3 =new JLabel();
        label3.setText("Courses");
        label3.setForeground(Color.WHITE);
        label3.setVerticalTextPosition(label3.BOTTOM);
        label3.setBounds(360,-5,850,200);
        label3.setFont(new Font("Arial",Font.ITALIC,45));
        label3.setBackground(Color.black);
        label3.setIcon(courseCreation);

        JLabel name = new JLabel();
        name.setText("Name:");
        name.setForeground(Color.BLACK);
        name.setBounds(500,140,100,50);
        name.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField field1 = new JTextField();
        field1.setBounds(620, 150, 200, 30);
        field1.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel section = new JLabel();
        section.setText("Section:");
        section.setForeground(Color.BLACK);
        section.setBounds(500, 190, 100, 50);
        section.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField field2 = new JTextField();
        field2.setBounds(620, 200, 200, 30);
        field2.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel nameC = new JLabel();
        nameC.setText("Course Name:");
        nameC.setForeground(Color.BLACK);
        nameC.setBounds(450,140,200,50);
        nameC.setFont(new Font("Arial", Font.ITALIC, 20));

        JLabel codeC = new JLabel();
        codeC.setText("Course Code:");
        codeC.setForeground(Color.BLACK);
        codeC.setBounds(450, 190, 200, 50);
        codeC.setFont(new Font("Arial", Font.ITALIC, 20));

        JLabel qualification = new JLabel();
        qualification.setText("Degree:");
        qualification.setForeground(Color.BLACK);
        qualification.setBounds(500, 190, 100, 50);
        qualification.setFont(new Font("Arial", Font.ITALIC, 20));

        JLabel email = new JLabel();
        email.setText("Email:");
        email.setForeground(Color.BLACK);
        email.setBounds(500, 240, 100, 50);
        email.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField field3 = new JTextField();
        field3.setBounds(620, 250, 200, 30);
        field3.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel age = new JLabel("Age:");
        age.setForeground(Color.BLACK);
        age.setBounds(500, 290, 100, 50);
        age.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField field4 = new JTextField();
        field4.setBounds(620, 300, 200, 30);
        field4.setFont(new Font("Arial", Font.PLAIN, 15));

        String[] sem ={"I","II","III","IV","V","VI","VII","VIII"};
        JLabel semester = new JLabel();
        semester.setText("Semester:");
        semester.setForeground(Color.BLACK);
        semester.setBounds(500, 340, 100, 50);
        semester.setFont(new Font("Arial", Font.ITALIC, 20));
        JComboBox field5 = new JComboBox(sem);
        field5.setSelectedIndex(0);
        field5.setBounds(620, 350, 200, 30);
        field5.setSelectedIndex(0);
        field5.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel course = new JLabel();
        course.setText("Courses:");
        course.setForeground(Color.BLACK);
        course.setBounds(500, 400, 100, 50);
        course.setFont(new Font("Arial", Font.ITALIC, 20));
        JRadioButton cs = new JRadioButton("Communication Skills");
        cs.setBackground(new Color(0xFF6347));
        cs.setBounds(620, 400, 200, 30);
        cs.setFocusable(false);
        JRadioButton dld = new JRadioButton("Digital Logic Design");
        dld.setBounds(620, 440, 200, 30);
        dld.setBackground(new Color(0xFF6347));
        dld.setFocusable(false);
        JRadioButton dldL = new JRadioButton("Digital Logic Design Lab");
        dldL.setBounds(620, 480, 200, 30);
        dldL.setBackground(new Color(0xFF6347));
        dldL.setFocusable(false);
        JRadioButton oop = new JRadioButton("Object Oriented Programming");
        oop.setBounds(820, 400, 300, 30);
        oop.setFocusable(false);
        oop.setBackground(new Color(0xFF6347));
        JRadioButton oopL = new JRadioButton("Object Oriented Programming Lab");
        oopL.setBounds(820, 440, 300, 30);
        oopL.setBackground(new Color(0xFF6347));
        oopL.setFocusable(false);
        JRadioButton prob = new JRadioButton("Probability");
        prob.setBounds(820, 480, 300, 30);
        prob.setBackground(new Color(0xFF6347));
        prob.setFocusable(false);

        JLabel only = new JLabel();
        only.setText("*Only one course from others can be selected(Optional)");
        only.setForeground(Color.BLACK);
        only.setBounds(500, 510, 500, 50);
        only.setFont(new Font("Arial", Font.ITALIC, 15));
        JLabel other = new JLabel();
        other.setText("Other Course:");
        other.setForeground(Color.BLACK);
        other.setBounds(500, 540, 300, 50);
        other.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField field6 = new JTextField();
        field6.setBounds(670, 550, 200, 30);
        field6.setFont(new Font("Arial", Font.PLAIN, 15));

        JButton submit1 = new JButton();
        submit1.setText("Submit");
        submit1.setFocusable(false);
        submit1.setBounds(640,600,100,30);
        submit1.addActionListener(e -> {
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
            if(field1.getText().equals("")|| field4.getText().equals("")||field3.getText().equals("")||field2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Kindly fill all the required fields.","ERROR",JOptionPane.WARNING_MESSAGE);
        }
        else if(!(coursesA.toString().contains(field6.getText()))){
            JOptionPane.showMessageDialog(null,"WRONG COURSES HAS BEEN ADDED\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        else if(field6.getText().matches("Communication Skills") || field6.getText().matches("Digital Logic Design") || field6.getText().matches("Digital Logic Design Lab") || field6.getText().matches("Object Oriented Programming") || field6.getText().matches("Object Oriented Programming Lab") || field6.getText().matches("Probability")){
                JOptionPane.showMessageDialog(null,"Select these subjects from above options.","ERROR",JOptionPane.WARNING_MESSAGE);
            }
            else if((admin1.instructorAccount(field1.getText(), Integer.parseInt(field4.getText()),field3.getText(),field2.getText(),field5.getSelectedItem()))==0){
                String[] courses={"","","","","",""};
             if(cs.isSelected())courses[0]+=cs.getText();
             if(oop.isSelected())courses[1]+=oop.getText();
             if(oopL.isSelected())courses[2]+=oopL.getText();
             if(prob.isSelected())courses[3]+=prob.getText();
             if(dld.isSelected())courses[4]+=dld.getText();
             if(dldL.isSelected())courses[5]+=dldL.getText();
             admin1.setCourses(courses);
             admin1.recordKeeping(1);
            JOptionPane.showMessageDialog(null,field1.getText()+"'s account has been created and password is "+admin1.getPassword(),"Account Created",JOptionPane.INFORMATION_MESSAGE);
            field1.setText("");
            field4.setText("");
            field3.setText("");
            field6.setText("");
            field2.setText("");
            }
        else{
            JOptionPane.showMessageDialog(null,"WRONG DETAILS HAS BEEN ADDED\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        });

        JButton submit = new JButton();
        submit.setText("Submit");
        submit.setFocusable(false);
        submit.setBounds(640,600,100,30);
        submit.addActionListener(e -> {
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
            if(field1.getText().equals("")|| field4.getText().equals("")||field3.getText().equals("")||field2.getText().equals("")||field5.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null,"Kindly fill all the required fields.","ERROR",JOptionPane.WARNING_MESSAGE);
        }
        else if(!(coursesA.toString().contains(field6.getText()))){
            JOptionPane.showMessageDialog(null,"WRONG COURSES HAS BEEN ADDED\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
        }
            else if(field6.getText().matches("Communication Skills") || field6.getText().matches("Digital Logic Design") || field6.getText().matches("Digital Logic Design Lab") || field6.getText().matches("Object Oriented Programming") || field6.getText().matches("Object Oriented Programming Lab") || field6.getText().matches("Probability")){
                JOptionPane.showMessageDialog(null,"Select these subjects from above options.","ERROR",JOptionPane.WARNING_MESSAGE);
            }
        else if((admin1.studentAccount(field1.getText(), Integer.parseInt(field4.getText()),field3.getText(),field2.getText(),field5.getSelectedItem()))==0){
            JOptionPane.showMessageDialog(null,field1.getText()+"'s account has been created and password is "+admin1.getPassword(),"Account Created",JOptionPane.INFORMATION_MESSAGE);
            String[] courses={"","","","","",""};
            if(cs.isSelected())courses[0]+=cs.getText();
            if(oop.isSelected())courses[1]+=oop.getText();
            if(oopL.isSelected())courses[2]+=oopL.getText();
            if(prob.isSelected())courses[3]+=prob.getText();
            if(dld.isSelected())courses[4]+=dld.getText();
            if(dldL.isSelected())courses[5]+=dldL.getText();
            admin1.setCourses(courses);
            admin1.recordKeeping();
            field1.setText("");
            field4.setText("");
            field3.setText("");
            field2.setText("");
            field6.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null,"WRONG DETAILS HAS BEEN ADDED\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        });

        JButton submit2 = new JButton();
        submit2.setText("Submit");
        submit2.setFocusable(false);
        submit2.setBounds(640,400,100,30);
        submit2.addActionListener(e -> {String coursesA=admin1.courses();
            if(field1.getText().equals("")||field2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Kindly fill all the required fields.","ERROR",JOptionPane.WARNING_MESSAGE);
        }else if((coursesA.contains(field1.getText()))||!(coursesA.contains(field2.getText()))){
                JOptionPane.showMessageDialog(null,"Course or Code is already there+"+"\n"+"Kindly add new course.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        else if((admin1.createCourse(field1.getText(),Integer.parseInt(field2.getText())))==0){
            JOptionPane.showMessageDialog(null,field1.getText()+" course has been added.","Course Created",JOptionPane.INFORMATION_MESSAGE);
            field2.setText("");
            field1.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null,"WRONG DETAILS HAS BEEN ADDED\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        });

        JTextPane coursesAll = new JTextPane();
        coursesAll.setForeground(Color.BLACK);
        coursesAll.setBounds(450, 190, 600, 550);
        coursesAll.setEditable(false);
        coursesAll.setBackground(new Color(0xFF6347));
        coursesAll.setFont(new Font("Arial", Font.ITALIC, 20));
        view.addActionListener(e -> {
            coursesAll.setText(admin1.courses());
            name.setVisible(false);
            section.setVisible(false);
            qualification.setVisible(false);
            age.setVisible(false);
            email.setVisible(false);
            field1.setVisible(false);
            field2.setVisible(false);
            field3.setVisible(false);
            field4.setVisible(false);
            semester.setVisible(false);
            field5.setVisible(false);
            submit.setVisible(false);
            submit1.setVisible(false);
            submit2.setVisible(false);
            label1.setVisible(false);
            label.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(true);
            cs.setVisible(false);
            dld.setVisible(false);
            oop.setVisible(false);
            prob.setVisible(false);
            dldL.setVisible(false);
            oopL.setVisible(false);
            course.setVisible(false);
            nameC.setVisible(false);
            codeC.setVisible(false);
            coursesAll.setVisible(true);
            other.setVisible(false);
            only.setVisible(false);
            field6.setVisible(false);
        });

        redP.add(submit);
        redP.add(submit1);
        redP.add(submit2);
        redP.add(name);
        redP.add(field1);
        redP.add(section);
        redP.add(field2);
        redP.add(age);
        redP.add(field3);
        redP.add(email);
        redP.add(field4);
        redP.add(semester);
        redP.add(field5);
        redP.add(label);
        redP.add(course);
        redP.add(cs);
        redP.add(dld);
        redP.add(dldL);
        redP.add(prob);
        redP.add(oop);
        redP.add(oopL);
        redP.add(label1);
        redP.add(label2);
        redP.add(qualification);
        redP.add(nameC);
        redP.add(codeC);
        redP.add(label3);
        redP.add(coursesAll);
        redP.add(other);
        redP.add(field6);
        redP.add(only);
        redP.setLayout(new BorderLayout());
        frame2.getContentPane().setLayout(new BorderLayout());

        name.setVisible(false);
        section.setVisible(false);
        age.setVisible(false);
        email.setVisible(false);
        field1.setVisible(false);
        field2.setVisible(false);
        field3.setVisible(false);
        field4.setVisible(false);
        semester.setVisible(false);
        field5.setVisible(false);
        submit.setVisible(false);
        submit1.setVisible(false);
        submit2.setVisible(false);
        label.setVisible(false);
        cs.setVisible(false);
        dld.setVisible(false);
        oop.setVisible(false);
        prob.setVisible(false);
        dldL.setVisible(false);
        oopL.setVisible(false);
        course.setVisible(false);
        nameC.setVisible(false);
        codeC.setVisible(false);
        coursesAll.setVisible(false);
        field6.setVisible(false);
        other.setVisible(false);

        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        qualification.setVisible(false);
        other.setVisible(false);
        only.setVisible(false);
        field6.setVisible(false);

        student.addActionListener(e -> {
            name.setVisible(true);
            section.setVisible(true);
            qualification.setVisible(false);
            age.setVisible(true);
            email.setVisible(true);
            field1.setVisible(true);
            field2.setVisible(true);
            field3.setVisible(true);
            field4.setVisible(true);
            semester.setVisible(true);
            field5.setVisible(true);
            submit1.setVisible(false);
            submit.setVisible(true);
            submit2.setVisible(false);
            label.setVisible(true);
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            coursesAll.setVisible(false);
            cs.setVisible(true);
            dld.setVisible(true);
            oop.setVisible(true);
            prob.setVisible(true);
            dldL.setVisible(true);
            oopL.setVisible(true);
            course.setVisible(true);
            nameC.setVisible(false);
            codeC.setVisible(false);
            field6.setVisible(true);
            other.setVisible(true);
            other.setVisible(true);
            only.setVisible(true);
            field6.setVisible(true);
        });

        instructor.addActionListener(e -> {
            name.setVisible(true);
            section.setVisible(false);
            qualification.setVisible(true);
            age.setVisible(true);
            email.setVisible(true);
            field1.setVisible(true);
            field2.setVisible(true);
            field3.setVisible(true);
            field4.setVisible(true);
            semester.setVisible(true);
            field5.setVisible(true);
            submit.setVisible(false);
            submit1.setVisible(true);
            submit2.setVisible(false);
            label1.setVisible(true);
            label.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            coursesAll.setVisible(false);
            cs.setVisible(true);
            dld.setVisible(true);
            oop.setVisible(true);
            prob.setVisible(true);
            dldL.setVisible(true);
            oopL.setVisible(true);
            course.setVisible(true);
            nameC.setVisible(false);
            codeC.setVisible(false);
            other.setVisible(true);
            only.setVisible(true);
            field6.setVisible(true);
        });

       create.addActionListener(e -> {
            name.setVisible(false);
            section.setVisible(false);
            qualification.setVisible(false);
            age.setVisible(false);
            email.setVisible(false);
            field1.setVisible(true);
            field2.setVisible(true);
            field3.setVisible(false);
            field4.setVisible(false);
            semester.setVisible(false);
            field5.setVisible(false);
            submit.setVisible(false);
            submit1.setVisible(false);
           submit2.setVisible(true);
            label1.setVisible(false);
            label.setVisible(false);
            label2.setVisible(true);
            label3.setVisible(false);
            coursesAll.setVisible(false);
            cs.setVisible(false);
            dld.setVisible(false);
            oop.setVisible(false);
            prob.setVisible(false);
            dldL.setVisible(false);
            oopL.setVisible(false);
            course.setVisible(false);
            nameC.setVisible(true);
            codeC.setVisible(true);
           other.setVisible(false);
           only.setVisible(false);
           field6.setVisible(false);
       });

       signout.addActionListener(e -> {
           new MyFrame();
           frame2.dispose();
               });

       exit.addActionListener(e-> System.exit(0));

        frame2.pack();
    }

    void Frame3(){
        frame2.setVisible(true);
        JPanel redP = new JPanel();
        frame2.setTitle("COURSE MANAGEMENT SYSTEM");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setIconImage(icon.getImage());
        redP.setBackground(new Color(0xFF6347));
        redP.setBounds(0,0,1400,750);
        frame2.add(redP);

        MenuBar menuBar = new MenuBar();
        Menu details = new Menu("Details");
        Menu Course = new Menu("Assignments");
        Menu exit1 = new Menu("Exit");
        MenuItem courses = new MenuItem("Courses");
        MenuItem info = new MenuItem("Personal Info");
        MenuItem submit = new MenuItem("Submit Assignment");
        MenuItem exit = new MenuItem("Exit");
        MenuItem signout = new MenuItem("Sign Out");

        menuBar.add(details);
        menuBar.add(Course);
        menuBar.add(exit1);
        frame2.setMenuBar(menuBar);

        details.add(info);
        Course.add(courses);
        Course.add(submit);
        exit1.add(exit);
        exit1.add(signout);

        JLabel label3 =new JLabel();
        label3.setText("Courses");
        label3.setForeground(Color.WHITE);
        label3.setVerticalTextPosition(label3.BOTTOM);
        label3.setBounds(360,-5,850,200);
        label3.setFont(new Font("Arial",Font.ITALIC,45));
        label3.setBackground(Color.black);
        label3.setIcon(courseCreation);

        JLabel label1 =new JLabel();
        label1.setText("Student Portal");
        label1.setForeground(Color.WHITE);
        label1.setVerticalTextPosition(label1.BOTTOM);
        label1.setBounds(360,-5,850,200);
        label1.setFont(new Font("Arial",Font.ITALIC,45));
        label1.setBackground(Color.black);
        label1.setIcon(stu);

        JLabel name = new JLabel();
        name.setText("Course Name:");
        name.setForeground(Color.BLACK);
        name.setBounds(400,140,300,50);
        name.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField field1 = new JTextField();
        field1.setBounds(620, 150, 200, 30);
        field1.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel instructor = new JLabel();
        instructor.setText("Instructor Name:");
        instructor.setForeground(Color.BLACK);
        instructor.setBounds(400, 190, 300, 50);
        instructor.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField field2 = new JTextField();
        field2.setBounds(620, 200, 200, 30);
        field2.setFont(new Font("Arial", Font.PLAIN, 15));

        Label only = new Label();
        only.setText("*Only one course from others can be selected");
        only.setForeground(Color.BLACK);
        only.setBounds(400, 200, 500, 50);
        only.setFont(new Font("Arial", Font.ITALIC, 15));

        JButton file = new JButton("Select a File");
        file.setForeground(Color.BLACK);
        file.setBounds(400, 260, 450, 50);
        file.setBackground(new Color(0x2E8B57));
        file.setFont(new Font("Arial", Font.ITALIC, 20));
        file.setFocusable(false);
        file.addActionListener(e -> {
            JFileChooser assignment = new JFileChooser();
            int response = assignment.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file1 = new File(assignment.getSelectedFile().getAbsolutePath());
                String ass1=file1.toString();
                if(field1.getText().equals("")||field2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Kindly fill all the required fields.","ERROR",JOptionPane.WARNING_MESSAGE);
                }
                else if(stu1.save(ass1,field2.getText(),stu1.tempUsername,field1.getText())==1){
                    JOptionPane.showMessageDialog(null,"WRONG DETAILS HAS BEEN ADDED\nTry Again","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,field1.getText()+" assignment has been submitted.","Course Created",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JTextPane title = new JTextPane();
        title.setForeground(Color.BLACK);
        title.setBounds(300, 190, 100, 550);
        title.setEditable(false);
        title.setBackground(new Color(0xFF6347));
        title.setFont(new Font("Arial", Font.ITALIC, 20));

        JTextPane coursesAll = new JTextPane();
        coursesAll.setForeground(Color.BLACK);
        coursesAll.setBounds(410, 190, 550, 550);
        coursesAll.setEditable(false);
        coursesAll.setBackground(new Color(0xFF6347));
        coursesAll.setFont(new Font("Arial", Font.ITALIC, 20));
        courses.addActionListener(e -> {
            coursesAll.setText(admin1.courses());
            coursesAll.setVisible(true);
            label1.setVisible(false);
            name.setVisible(false);
            instructor.setVisible(false);
            file.setVisible(false);
            label3.setVisible(true);
            title.setVisible(false);
            field1.setVisible(false);
            field2.setVisible(false);
            only.setVisible(false);
        });

        label1.setVisible(false);
        name.setVisible(false);
        instructor.setVisible(false);
        file.setVisible(false);
        label3.setVisible(false);
        title.setVisible(false);
        field1.setVisible(false);
        field2.setVisible(false);
        only.setVisible(false);

        redP.add(label1);
        redP.add(name);
        redP.add(instructor);
        redP.add(file);
        redP.add(coursesAll);
        redP.add(title);
        redP.add(field1);
        redP.add(field2);
        redP.add(label3);
        redP.add(only);
        redP.setLayout(new BorderLayout());
        frame2.getContentPane().setLayout(new BorderLayout());

        info.addActionListener(e -> {
            coursesAll.setText(stu1.info);
            coursesAll.setVisible(true);
            label1.setVisible(true);
            name.setVisible(false);
            instructor.setVisible(false);
            file.setVisible(false);
            label3.setVisible(false);
            title.setVisible(true);
            field1.setVisible(false);
            field2.setVisible(false);
            only.setVisible(false);
            title.setText("Name:\nPassword:\nAge:\nEmail:\nSection:\nSemester:\nYear:\nCourses:");
        });

        submit.addActionListener(e -> {
            label1.setVisible(true);
            name.setVisible(true);
            instructor.setVisible(true);
            file.setVisible(true);
            coursesAll.setVisible(false);
            label3.setVisible(false);
            title.setVisible(false);
            field1.setVisible(true);
            field2.setVisible(true);
            only.setVisible(true);
        });

        signout.addActionListener(e -> {
            new MyFrame();
            frame2.dispose();
        });

        exit.addActionListener(e-> System.exit(0));

    }

    void Frame4(){
        frame2.setVisible(true);
        JPanel redP = new JPanel();
        frame2.setTitle("COURSE MANAGEMENT SYSTEM");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setIconImage(icon.getImage());
        redP.setBackground(new Color(0xFF6347));
        redP.setBounds(0,0,1400,750);
        frame2.add(redP);

        MenuBar menuBar = new MenuBar();
        Menu details = new Menu("Details");
        Menu Course = new Menu("Assignments");
        Menu exit1 = new Menu("Exit");
        MenuItem courses = new MenuItem("Courses");
        MenuItem info = new MenuItem("Personal Info");
        MenuItem view = new MenuItem("View Assignments");
        MenuItem exit = new MenuItem("Exit");
        MenuItem signout = new MenuItem("Sign Out");

        menuBar.add(details);
        menuBar.add(Course);
        menuBar.add(exit1);
        frame2.setMenuBar(menuBar);

        details.add(info);
        Course.add(courses);
        Course.add(view);
        exit1.add(exit);
        exit1.add(signout);

        JLabel label3 =new JLabel();
        label3.setText("Courses");
        label3.setForeground(Color.WHITE);
        label3.setVerticalTextPosition(label3.BOTTOM);
        label3.setBounds(360,-5,850,200);
        label3.setFont(new Font("Arial",Font.ITALIC,45));
        label3.setBackground(Color.black);
        label3.setIcon(courseCreation);

        JLabel label1 =new JLabel();
        label1.setText("Instructor Portal");
        label1.setForeground(Color.WHITE);
        label1.setVerticalTextPosition(label1.BOTTOM);
        label1.setBounds(360,-5,850,200);
        label1.setFont(new Font("Arial",Font.ITALIC,45));
        label1.setBackground(Color.black);
        label1.setIcon(teach);


        JTextPane title = new JTextPane();
        title.setForeground(Color.BLACK);
        title.setBounds(300, 190, 100, 550);
        title.setEditable(false);
        title.setBackground(new Color(0xFF6347));
        title.setFont(new Font("Arial", Font.ITALIC, 20));

        JTextArea coursesAll = new JTextArea();
        coursesAll.setForeground(Color.BLACK);
        coursesAll.setBounds(410, 190, 600, 450);
        coursesAll.setEditable(false);
        coursesAll.setBackground(new Color(0xFF6347));
        coursesAll.setFont(new Font("Arial", Font.ITALIC, 20));
        coursesAll.setLineWrap(true);
        coursesAll.setWrapStyleWord(true);
        JScrollPane sc = new JScrollPane(coursesAll);
        sc.setPreferredSize(new Dimension(500,300));
        sc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        courses.addActionListener(e -> {
            coursesAll.setText(admin1.courses());
            coursesAll.setVisible(true);
            label1.setVisible(false);
            label3.setVisible(true);
            title.setVisible(false);
            sc.setVisible(false);
        });

        label1.setVisible(false);
        label3.setVisible(false);
        title.setVisible(false);
        sc.setVisible(false);

        redP.add(label1);
        redP.add(coursesAll);
        redP.add(title);
        redP.add(label3);
        redP.add(sc);
        redP.setLayout(new BorderLayout());
        frame2.getContentPane().setLayout(new BorderLayout());

        info.addActionListener(e -> {
            coursesAll.setText(ins1.info);
            coursesAll.setVisible(true);
            label1.setVisible(true);
            label3.setVisible(false);
            title.setVisible(true);
            sc.setVisible(false);
            title.setText("Name:\nPassword:\nAge:\nEmail:\nSection:\nSemester:\nYear:\nCourses:");
        });

        view.addActionListener(e -> {
            label1.setVisible(true);
            coursesAll.setVisible(true);
            label3.setVisible(false);
            coursesAll.setText(ins1.viewAssignment(ins1.tempUsername));
            title.setVisible(false);
            sc.setVisible(true);
        });

        signout.addActionListener(e -> {
            new MyFrame();
            frame2.dispose();
        });

        exit.addActionListener(e-> System.exit(0));

    }
}
