package marksList;

public class StudentRecord {
    private String studentId;
    private double assignmentMark;
    private double midtermMark;
    private double examMark;
    private double finalMark;
    private String letterGrade;

    public StudentRecord() {this("", 0, 0, 0 );}

    public StudentRecord(String id, double assignment, double midterm, double exam ){

        setStudentId(id);
        setAssignmentMark(assignment);
        setMidtermMark(midterm);
        setExamMark(exam);
        setFinalMark(calculateFinalMark(this.assignmentMark, this.midtermMark, this.examMark));
        setLetterGrade(determineLetterGrade(this.finalMark));
    }

    public void setStudentId(String id){ studentId = id; }
    public String getStudentId(){ return studentId;}

    public void setAssignmentMark(double mark){ assignmentMark = mark; }
    public double getAssignmentMark(){ return assignmentMark;}

    public void setMidtermMark(double mark){ midtermMark = mark; }
    public double getMidtermMark(){ return midtermMark;}

    public void setExamMark(double mark){ examMark = mark; }
    public double getExamMark(){ return examMark;}

    public void setFinalMark(double mark){ finalMark = mark;}
    public double getFinalMark(){ return finalMark;}

    public void setLetterGrade(String grade) {letterGrade = grade;}
    public String getLetterGrade() {return letterGrade;}

    private double calculateFinalMark (double assignmentMark, double midtermMark, double examMark) {
        return ((0.2*assignmentMark)+(0.3*midtermMark)+(0.5*examMark));
    }

    private String determineLetterGrade(double finalMark) {
        
        if (finalMark >= 80.0 && finalMark <= 100.0) { return "A"; }
        if (finalMark >= 70.0 && finalMark <= 79.9999) { return "B"; }
        if (finalMark >= 60.0 && finalMark <= 69.9999) { return "C"; }
        if (finalMark >= 50.0 && finalMark <= 59.9999) { return "D"; }
        if (finalMark <= 49.9999) { return "F"; }
        else{return "invalid"; }
    }

}
