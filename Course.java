/******************************************************************************

Eura Pulliam
2.12.26
Lab: Course and grades data

*******************************************************************************/
    public class Course {
    private String courseName;
    private int numA;
    private int numB;
    private int numC;
    private int numD;
    private int numF;
    public Course(String courseName, int numA, int numB, int numC, int numD, int numF) {
        this.courseName = courseName;
        this.numA = numA;
        this.numB = numB;
        this.numC = numC;
        this.numD = numD;
        this.numF = numF;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getNumA() {
        return numA;
    }
    public int getNumB() {
        return numB;
    }
    public int getNumC() {
        return numC;
    }
    public int getNumD() {
        return numD;
    }
    public int getNumF() {
        return numF;
    }
    public int getTotalStudents() {
        return numA + numB + numC + numD + numF;
    }
    public double getPercentA() {
        if (getTotalStudents() == 0) {
            return 0;
        }
        return (numA * 100.0) / getTotalStudents();
    }
}
