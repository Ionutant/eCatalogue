package com.techelevator.dao;

import com.techelevator.model.StudentCourse;
import com.techelevator.model.User;

import java.util.List;

public interface StudentCourseDao {

    void enrollInCourse(StudentCourse studentCourse);

    List<User> getStudentsByCourseId(int courseId);
}
