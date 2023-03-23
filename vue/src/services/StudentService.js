import axios from "axios";

export default {
  getStudentsByCourseId(courseId) {
    return axios.get(`/course/${courseId}/students`);
  },
};
