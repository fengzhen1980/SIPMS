package com.atguigu.imperial.court.entity;


public class TGrade {

    private String courseNo;
    private String studentUserName;
    private String gradeValue;
    private String gradeComment;

    public TGrade() {
    }

    public TGrade(String courseNo, String studentUserName, String gradeValue, String gradeComment) {
        this.courseNo = courseNo;
        this.studentUserName = studentUserName;
        this.gradeValue = gradeValue;
        this.gradeComment = gradeComment;
    }

    @Override
    public String toString() {
        return "TGrade{" +
                "courseNo=" + courseNo +
                ", studentUserName=" + studentUserName +
                ", gradeValue=" + gradeValue +
                ", gradeComment=" + gradeComment + "}";
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }


    public String getStudentUserName() {
        return studentUserName;
    }

    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }


    public String getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }


    public String getGradeComment() {
        return gradeComment;
    }

    public void setGradeComment(String gradeComment) {
        this.gradeComment = gradeComment;
    }

}
