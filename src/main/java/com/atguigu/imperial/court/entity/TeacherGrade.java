package com.atguigu.imperial.court.entity;

public class TeacherGrade {
    private String courseNo;
    private String courseTitle;
    private String studentId;
    private String studentName;
    private String gradeValue;
    private String comment;
    private String existGrade;

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExistGrade() {
        return existGrade;
    }

    public void setExistGrade(String existGrade) {
        this.existGrade = existGrade;
    }
}
