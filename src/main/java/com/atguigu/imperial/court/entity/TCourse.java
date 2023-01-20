package com.atguigu.imperial.court.entity;


public class TCourse {

    private String courseNo;
    private String courseTitle;
    private long courseHours;
    private String teacherUserName;
    private String courseDescription;

    public TCourse() {
    }

    public TCourse(String courseNo, String courseTitle, long courseHours, String teacherUserName,
                   String courseDescription) {
        this.courseNo = courseNo;
        this.courseTitle = courseTitle;
        this.courseHours = courseHours;
        this.teacherUserName = teacherUserName;
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "TCourse{" +
                "courseNo=" + courseNo +
                ", courseTitle=" + courseTitle +
                ", courseHours=" + courseHours +
                ", teacherUserName=" + teacherUserName +
                ", courseDescription=" + courseDescription + "}";
    }

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


    public long getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(long courseHours) {
        this.courseHours = courseHours;
    }


    public String getTeacherUserName() {
        return teacherUserName;
    }

    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

}
