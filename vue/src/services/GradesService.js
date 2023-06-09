import axios from "axios";

export default {
  addGrade(grade) {
    console.log(grade.courseId);
    return axios.post(`/course/${grade.courseId}`, grade);
  },

  getAllGrades() {
    return axios.get("/grades");
  },

  getAllJoinedGrades() {
    return axios.get("/j/grades");
  },

  allGradesForAssignment(assignmentId) {
    return axios.get(`/course/${assignmentId}/grades`);
  },

  allJoinedGradesForCourse(courseId) {
    return axios.get(`/j/${courseId}/grades`);
  },

  // allJoinedGradesForAssignment(assignmentId) {
  //   return axios.get(`/j/course/${assignmentId}/grades`);
  // },

  allGradesForStudentInCourse(courseId, studentId) {
    return axios.get(`/${courseId}/grades/${studentId}`);
  },

  allJoinedGradesForStudentInCourse(courseId, studentId) {
    return axios.get(`/j/${courseId}/assignment/grades/${studentId}`);
  },

  // getGrade(assignmentId, studentId) {
  //   return axios.get(`/course/curriculum/${assignmentId}/${studentId}`);
  // },

  getCourseAverageForStudent(courseId, studentId) {
    return axios.get(`/course/averages/${courseId}/${studentId}`);
  },

  updateGrade(grade) {
    return axios.put("/course/work", grade);
  },

  deleteGrade(grade) {
    return axios.delete("/course/work", grade);
  },

  getStudentInCourse(courseId) {
    return axios.get(`/course/${courseId}/students`);
  },
};
