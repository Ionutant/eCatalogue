package com.techelevator.dao;

import com.techelevator.model.JoinedGrades;

import java.util.List;

public interface JoinedGradesDao {

//
//    int addJoinedGrade(JoinedGrades joinedGrades);

    //
    List<JoinedGrades> getAllJoinedGrades();

//    List<JoinedGrades> allJoinedGradesForAssignment(int assignmentId);

    List<JoinedGrades> allJoinedGradesForStudentInCourse(int courseId, int studentId);

    List<JoinedGrades> allJoinedGradesForCourse(int courseId);

//    JoinedGrades getJoinedGrade(int assignmentId, int studentId);

    double getJoinedCourseAverageForStudent(int courseId, int studentId);

    //
    void updateJoinedGrade(JoinedGrades joinedGrades);


    //
    void deleteJoinedGrade(JoinedGrades joinedGrades);
}
