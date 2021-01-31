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
        new Main().run();
    }

    /**
     * The method that drives the whole program and is called in main
     */
    private void run() {
        ArrayList<Student> studentList = new ArrayList(null);

        try {
            studentList = readFile();


        } catch (FileNotFoundException pException) {
            System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
            System.exit(-1);
        }

        calcTuition(studentList);
        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);

        try {
            writeFile(studentList);
        } catch (FileNotFoundException pException) {
            System.out.println("Sorry, could not open 'p02-tuition.txt' for writing. Stopping");
            System.exit(-1);
        }
    }


    /**
     * Calculates the tuition for each Student in pStudentList. Write an enhanced for loop that
     * iterates over each Student in pStudentList. For each Student, call calcTuition() on that
     * Student object.
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
     */
    private ArrayList<Student> readFile() throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList();
        Scanner in = new Scanner(new File("p02-students.txt"));
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
     * Writes the output to "p02-tuition.txt" per the software requirements.
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        String outPutFile = "p02-tuition.txt";
        PrintWriter out = new PrintWriter(outPutFile);
        for (Student student : pStudentList) {
            out.printf(student.getId() + " " + student.getLastName() + " " + student.getFirstName() + " " +
                    student.getTuition() + "\n");
        }
        out.close();
    }


}
