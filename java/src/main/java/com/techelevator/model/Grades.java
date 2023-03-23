package com.techelevator.model;

public class Grades {
    private int gradeId;
    private int studentId;

    private int courseId;
    private int totalPoints;
    private int earnedPoints;
    private String status;
    private String submissionContent;
    private String feedback;

    public Grades(int gradeId, int studentId, int courseId, int totalPoints, int earnedPoints, String status, String submissionContent, String feedback) {
        this.gradeId = gradeId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.totalPoints = totalPoints;
        this.earnedPoints = earnedPoints;
        this.status = status;
        this.submissionContent = submissionContent;
        this.feedback = feedback;
    }

    public Grades() {
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(int earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmissionContent() {
        return submissionContent;
    }

    public void setSubmissionContent(String submissionContent) {
        this.submissionContent = submissionContent;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
