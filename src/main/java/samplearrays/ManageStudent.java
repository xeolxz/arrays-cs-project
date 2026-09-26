package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Double.NaN;
import static java.lang.Double.longBitsToDouble;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest=students[0];
        for(int i=0;i<students.length;i++){
            if(students[i].getAge()>oldest.getAge()){
                oldest=students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int counter=0;
        for(int i=0;i<students.length;i++){
            if(students[i].isAdult()){
                counter++;
            }
        }
        return counter;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if(students.length==0){
            return NaN;
        }else{
            double sum=0;
            for(int i=0;i<students.length;i++){
                sum+=students[i].getGrade();
            }
            if(sum==0.0){
                return NaN;
            }else{
                return sum/students.length;
            }
        }
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(int i=0;i<students.length;i++){
            if(students[i].getName().equalsIgnoreCase(name)){
                return students[i];
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(int i=0;i<students.length;i++){
            if(students[i].getGrade()>=15){
                System.out.println(students[i].getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(int i=0;i<students.length;i++){
            if(students[i].getId()==id){
                students[i].setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        boolean hasDuplicate=false;
        for(int i=0;i<students.length;i++){
            for(int j=0;j<students.length;j++){
                if(i!=j){
                    if(students[i].getName().equals(students[j].getName())){
                        hasDuplicate=true;
                    }
                }
            }
        }
        return hasDuplicate;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents=new Student[students.length+1];
        for(int i=0;i<students.length;i++){
            newStudents[i]=students[i];
        }
        newStudents[newStudents.length-1]=newStudent;
        return newStudents;
    }
    //11) School manipulation
    public static Student findTopper(Student[] students){
        Student topper=students[0];
        for(int i=0;i<students.length;i++){
            if(topper.getGrade()<students[i].getGrade()){
                topper=students[i];
            }
        }
        return topper;
    }
    public static Student[] topStudents(Student[][] school){
        Student[] toppers=new Student[school.length];
        for(int i=0;i<school.length;i++){
            toppers[i]=findTopper(school[i]);
        }
        return toppers;
    }
    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student s1 = new Student(1, "Ahmed");
        Student s2 = new Student(2, "Sara", 20);
        Student s3 = new Student(3, "Youssef", 21, 16);
        Student s4 = new Student(4, "Salma");
        Student s5 = new Student(5, "Anass", 19, 18);
        Student[] students={s1,s2,s3,s4,s5};

        // Print all
        System.out.println("== All Students ==");
        for (Student s : students) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("== Oldest student ==");
        Student oldest=ManageStudent.findOldest(students);
        System.out.println("The oldest student is : "+oldest.getName());
        // 3) Count adults
        System.out.println("== Adults counter ==");
        System.out.println("The number of adult student is : "+ManageStudent.countAdults(students));
        // 4) Average grade
        System.out.println("== Average grades ==");
        System.out.println("The average students grades : "+ManageStudent.averageGrade(students));
        // 5) Find by name
        System.out.println("== Find bt name ==");
        String nameToFind="Youssef";
        Student searchedStd=ManageStudent.findStudentByName(students,nameToFind);
        if(searchedStd!=null){
            System.out.println("Found : "+nameToFind);
        }else{
            System.out.println("Didn't find : "+nameToFind);
        }

        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        ManageStudent.sortByGradeDesc(students);
        for (Student s : students) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(students);

        // 8) Update grade by id
        // function
        boolean updated=ManageStudent.updateGrade(students,4,19);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(students, "Dina"));

        // 9) Duplicate names
        System.out.println("== Duplicate check ==");
        if(ManageStudent.hasDuplicateNames(students)){
            System.out.println("Duplicates found");
        }else{
            System.out.println("Duplicates not found");
        }
        // 10) Append new student
        System.out.println("== Append new student ==");
        Student newStudent = new Student(6, "Amine", 20, 17);
        Student[] newStudents=ManageStudent.appendStudent(students,newStudent);
        for (Student s : newStudents) System.out.println(s);
        //11) School manipulation
        Student[][] school={
                {s1,s2,s3},
                {s4,s5,newStudent}
        };
        System.out.println("=== Printing students per class ===");
        for(int i=0;i<school.length;i++){
            System.out.println("Class "+(i+1)+" : ");
            for(int j=0;j<school[i].length;j++){
                System.out.println(school[i][j]);
            }
        }
        System.out.println("=== Top student in each class ===");
        Student[] toppers=ManageStudent.topStudents(school);
        for(int i=0;i<toppers.length;i++){
            System.out.println("Class "+(i+1)+" : "+toppers[i].getName());
        }
    }
}

