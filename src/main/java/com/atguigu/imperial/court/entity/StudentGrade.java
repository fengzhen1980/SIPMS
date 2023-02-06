package com.atguigu.imperial.court.entity;

public class StudentGrade {

    private String courseNo;
    private String courseTitle;
    private String studentUserId;
    private String gradeValue;
    private String gradeComment;

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
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
