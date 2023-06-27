package com.techelevator.dao;

import com.techelevator.model.StudentCourse;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStudentCourseDao implements StudentCourseDao {
    private JdbcTemplate dao;

    public JdbcStudentCourseDao(JdbcTemplate dao) {
        this.dao = dao;
    }

    @Override
    public void enrollInCourse(StudentCourse studentCourse) {
        String sql = "INSERT INTO course_student (student_id, course_id) " +
                "VALUES (?, ?) ";
        dao.update(sql, studentCourse.getStudentId(), studentCourse.getCourseId());
    }

    @Override
    public List<User> getStudentsByCourseId(int courseId) {
        List<User> resultList = new ArrayList<>();
        String sql = "SELECT" +
                "\tuser_id,\n"+
                "\tfirst_name,\n" +
                "\tlast_name\n" +
                "FROM users\n" +
                "\n" +
                "INNER JOIN course_student\n" +
                "\t  ON users.user_id = course_student.student_id\n" +
                "\t  \n" +
                "\t  where course_id= ?";
        SqlRowSet result = dao.queryForRowSet(sql, courseId);
        while (result.next()) {
            User user = mapRowToStudents(result);
            resultList.add(user);
        }
        return resultList;
    }

    private User mapRowToStudents(SqlRowSet result) {
        User user = new User();
        user.setFirstname(result.getString("first_name"));
        user.setLastname(result.getString("last_name"));
        user.setId(result.getInt("user_id"));
        return user;
    }


}
