package com.atguigu.imperial.court.entity;


public class TGrade {

    private String courseNo;
    private String studentUserId;
    private String gradeValue;
    private String gradeComment;

    public TGrade() {
    }

    public TGrade(String courseNo, String studentUserId, String gradeValue, String gradeComment) {
        this.courseNo = courseNo;
        this.studentUserId = studentUserId;
        this.gradeValue = gradeValue;
        this.gradeComment = gradeComment;
    }

    @Override
    public String toString() {
        return "TGrade{" +
                "courseNo=" + courseNo +
                ", studentUserName=" + studentUserId +
                ", gradeValue=" + gradeValue +
                ", gradeComment=" + gradeComment + "}";
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(String studentUserId) {
        this.studentUserId = studentUserId;
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
