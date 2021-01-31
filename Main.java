//**************************************************************************************************
// CLASS: Main
//
// DESCRIPTION
// The Main class for Project 2.
//
//
// GROUP: G
// AUTHOR 1: Addison Corey, tjcorey, addison.corey@asu.edu
// AUTHOR 2: Keatyn Garton, kgarton, kgarton@asu.edu
// AUTHOR 3: Jonathan Kilgore, jpkilgor, jpkilgor@asu.edu
//**************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main.run();
    }

    private static void run

    {
        ArrayList<Student> studentList = new ArrayList<Student>(null);
        String mInputFileStudent = "p02-students.txt";

        try {
            studentList = readFile(mInputFileStudent);


        } catch (FileNotFoundException pException) {
            System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
            System.exit(-1);
        }

        calcTuition(studentList);
        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);

        try {
            writeFile(studentList)
        } catch (FileNotFoundException pException) {
            System.out.println("Sorry, could not open 'p02-tuition.txt' for writing. Stopping");
            System.exit(-1);
        }
    }


    /**
     * Calculates the tuition for each Student in pStudentList. Write an enhanced for loop that
     * iterates over each Student in pStudentList. For each Student, call calcTuition() on that
     * Student object. Note: this is a polymorphic method call. What does that mean?
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
        for (Student student : pStudentList) {
            student.calcTuition();
        }
    }

    /**
     * Reads the student information from "p02-students.txt" and returns the list of students as
     * an ArrayList<Student> object. Note that this method throws FileNotFoundException if the
     * input file could not be opened. The exception is caught and handled in run().
     * <p>
     * PSEUDOCODE
     * Declare and create an ArrayList<Student> object named studentList
     * Open "p02-students.txt" for reading using a Scanner object named in
     * While in.hasNext() returns true Do
     * String studentType <= read next string from in
     * If studentType is "C" Then
     * studentList.add(readOnCampusStudent(in))
     * Else
     * studentList.add(readOnlineStudent(in))
     * End If
     * End While
     * Close the scanner
     * Return studentList
     */
    private ArrayList<Student> readFile(String mInputFileStudent) throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<Student>();
        Scanner in = new Scanner(new File(mInputFileStudent));
        while (in.hasNext()) {
            String studentType = in.next();
            if (studentType.equals("C")) {
                studentList.add(readOnCampusStudent(in));
            } else {
                studentList.add(readOnlineStudent(in));
            }

        }
        in.close();
        return studentList;

    }

    /**
     * Reads the information for an on-campus student from the input file.
     * <p>
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
     * Declare String object named res and assign pIn.next() to res
     * Declare double variable named fee and assign pIn.nextDouble() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If res.equals("R") Then
     * Call setResidency(OnCampusStudent.RESIDENT) on student
     * Else
     * Call setResidency(OnCampusStudent.NON_RESIDENT) on student
     * End If
     * Call setProgramFee(fee) on student
     * Call setCredits(credits) on student
     * Return student
     *
     * @return
     */
    private OnCampusStudent readOnCampusStudent(Scanner pIn) {
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        OnCampusStudent student = new OnCampusStudent(id, fname, lname);
        String res = pIn.next();
        double fee = pIn.nextDouble();
        int credits = pIn.nextInt();
        if (res.equals("R")) {
            student.setResidency(OnCampusStudent.NON_RESIDENT);
        } else {
            student.setResidency(OnCampusStudent.NON_RESIDENT);
        }
        student.setProgramFee(fee);
        student.setCredits(credits);
        return student;
    }


    /**
     * Reads the information for an online student from the input file.
     * <p>
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnlineStudent student. Pass id, fname, lname as params to the ctor.,
     * Declare String object named fee and assign pIn.next() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If fee.equals("T")) Then
     * Call setTechFee(true) on student
     * Else
     * Call setTechFee(false) on student
     * End If
     * Call setCredits(credits) on student
     * Return student
     */
    private OnlineStudent readOnlineStudent(Scanner pIn) {
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        OnlineStudent student = new OnlineStudent(id, fname, lname);
        String fee = pIn.next();
        int credits = pIn.nextInt(0);
        if (fee.equals("T")) {
            student.setTechFee(true);
        } else {
            student.setTechFee(false);
        }
        student.setCredits(credits);
        return student;
    }

    /**
     * Writes the output to "p02-tuition.txt" per the software requirements. Note that this method
     * throws FileNotFoundException if the output file could not be opened. The exception is caught
     * and handled in run().
     * <p>
     * PSEUDOCODE
     * Declare and create a PrintWriter object named out, opening "p02-tuition.txt" for writing
     * Enhanced ForEach student in pStudentList Do
     * Using out.printf() output the student information per SW Requiremment 3
     * End Enhanced ForEach
     * Close the output file
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("p02-tuition.txt");
        for (Student student : pStudentList) {
            out.printf(Student.getId() + " " + Student.getLastName() + " " + Student.getFirstName() + " " +
                    Student.getTuition() + "\n");
        }
        out.close();
    }

}
