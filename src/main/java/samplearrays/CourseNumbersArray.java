package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        //Question 1
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        //Question 2
        int[] updatedCourses = new int[registeredCourses.length + 1];
        for (int i = 0; i < registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[updatedCourses.length - 1] = 2170;
        //Question 3
        System.out.println("Updated course numbers : ");
        for(int i=0;i< updatedCourses.length;i++){
            System.out.println("Course "+(i+1)+" : "+updatedCourses[i]);
        }
        //Question 4
        int checkNumber=2170;
        boolean found=false;
        for (int courseNm : updatedCourses) {
            if (courseNm == checkNumber) {
                found = true;
                break;
            }
        }
        if(found){
            System.out.println("Found : "+ checkNumber);
        }else{
            System.out.println("Didn't find : "+ checkNumber);
        }
    }
}
