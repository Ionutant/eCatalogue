<template>
  <div>
    <form class="add-grade-form" v-on:submit.prevent="saveGrade">
      <h2 id="add-grade-form-header">Set a grade</h2>
      <div class="joinClass">
        <form action="join-class" v-on:submit.prevent="enrollInCourse">
          <select name="students" id="students" v-model="student">
            <option v-for="student in students" v-bind:key="student.id">
              {{ student.firstname }} {{ student.lastname }}
            </option>
          </select>
        </form>
      </div>
      <table id="student-score-table">
        <thead>
          <tr id="score-header-row">
            <td id="score-label">SCORE</td>
            <td id="total-label">TOTAL</td>
          </tr>
          <tr id="score-body-row">
            <td>
              <input
                id="earned-points-input"
                type="number"
                v-model="earnedPoints"
                max="10"
                min="0"
              />
            </td>
            <td id="total-points-value">10</td>
          </tr>
        </thead>
      </table>
      <div class="submission-section">
        <label for="submission-content" id="submission-content-label"
          >STUDENT SUBMISSION:</label
        >
      </div>
      <input type="submit" value="Save" id="add-grade-submit-btn" />
      <button id="add-grade-cancel-btn" v-on:click.prevent="cancelGrade">
        Cancel
      </button>
    </form>
  </div>
</template>

<script>
// import gradesService from "../services/GradesService";
import studentService from "../services/StudentService";
export default {
  name: "add-grade-form",
  data() {
    return {
      students: [],
      student: {},
      earnedPoints: "",
      maxPoints: 10,
      addGradeModel: {},
    };
  },
  created() {
    // this.updatedGradeObject = this.currentGradeObject;
    // this.feedback = this.currentGradeObject.feedback;
    // this.earnedPoints = this.currentGradeObject.earnedPoints;

    studentService
      .getStudentsByCourseId(this.$route.params.courseId)
      .then((response) => {
        // console.log(response.data);
        if (response.status == 200) {
          this.students = response.data;
        }
      });
  },
  methods: {
    // saveGrade() {
    //   (this.updatedGradeObject.earnedPoints = this.earnedPoints),
    //     (this.updatedGradeObject.feedback = this.feedback);
    //   this.updatedGradeObject.status = "Graded";
    //   gradesService.updateGrade(this.updatedGradeObject).then((response) => {
    //     if (response.status == 200) {
    //       this.$emit("save-add-grade", false);
    //       alert("The assignment grade have been saved successfully!");
    //     }
    //   });
    // },
    saveGrade() {
      this.addGradeModel.gradeId = null;
      this.addGradeModel.studentId = null;
      this.addGradeModel.courseId = null;
      this.addGradeModel.totalPoints = null;
      this.addGradeModel.earnedPoints = null;
      this.addGradeModel.status = null;
      this.addGradeModel.submissionContent = null;
      this.addGradeModel.feedback = null;

      console.log(this.student);
      console.log(this.students);

      // this.updatedGradeObject.status = "Graded";
      // gradesService.updateGrade(this.updatedGradeObject).then((response) => {
      //   if (response.status == 200) {
      //     this.$emit("save-add-grade", false);
      //     alert("The assignment grade have been saved successfully!");
      //   }
      // });
    },
    cancelGrade() {
      this.$emit("save-add-grade");
    },
  },
};
</script>

<style>
.add-grade-form {
  background-color: #e4e4e4fd;
  box-shadow: 0 0 6px 4px rgba(44, 43, 43, 0.233);
  border-radius: 10px;
  padding-left: 40px;
  padding-right: 40px;
  padding-top: 20px;
  padding-bottom: 30px;
  font-family: sans-serif;
}
#add-grade-form-header {
  text-align: center;
  color: #032647b4;
  padding-bottom: 10px;
}

#student-assignment-info {
  width: 100%;
  margin-bottom: 30px;
  box-shadow: 0 0 4px 3px rgba(97, 97, 97, 0.151);
  border: none;
  border-radius: 5px;
}

#grade-header-row {
  font-weight: bold;
  font-size: 1rem;
  background-color: #ddddddb0;
  line-height: 1.5rem;
  color: #040f31de;
  border-bottom: 2px solid rgba(58, 58, 58, 0.425);
  border-top: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
}
#grade-body-row {
  background-color: #f3f3f3b4;
  line-height: 1.5rem;
}

#submission-content {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  background: white;
  width: 95%;
  padding-top: 15px;
  padding-bottom: 20px;
  padding-left: 15px;
  padding-right: 15px;
  margin-top: 0px;
  min-height: 20vh;
  max-height: 20vh;
  box-shadow: 0 0 2px 1px rgba(71, 71, 71, 0.205);
  border: none;
  border-radius: 5px;
}
#submission-content-label,
#feedback-label {
  font-weight: bold;
  font-size: 1rem;
  line-height: 1.5rem;
  color: #040f31de;
}

#grade-student-name-head {
  width: 30%;
}

#student-score-table {
  width: fit-content;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  border-collapse: collapse;
  text-align: center;
  margin-left: 5%;
  margin-bottom: 10px;
  box-shadow: 0 0 4px 4px rgba(97, 97, 97, 0.151);
  border: none;
  border-radius: 10px;
}

#score-header-row {
  font-weight: bold;
  font-size: 1rem;
  background-color: #abdb9fb0;
  line-height: 1.5rem;
  color: #040f31de;
  border-bottom: 2px solid rgba(58, 58, 58, 0.425);
  border-top: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
}

#score-label {
  padding: 10px;
}
#total-label {
  background-color: #fcb069d8;
  padding: 10px;
}

#earned-points-input {
  align-items: center;
  width: 50px;
  padding: 5px;
}

#total-points-value {
  text-align: center;
  font-weight: bold;
  font-size: 1rem;
  line-height: 1.5rem;
  color: #040f31de;
  border-top: 2px solid rgba(58, 58, 58, 0.164);
  border-left: 2px solid rgba(58, 58, 58, 0.164);
}

.add-grade-form > label {
  display: block;
}

.add-grade-form > input[type="submit"] {
  display: block;
}

#feedback {
  width: 95%;
  min-height: 10vh;
  background-color: #fff8d9fd;
  padding: 20px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 1rem;
  box-shadow: 0 0 4px 3px rgba(97, 97, 97, 0.151);
  border: 1px solid rgba(173, 26, 26, 0.637);
  border-radius: 5px;
}

#add-grade-submit-btn,
#add-grade-cancel-btn {
  display: inline;
  width: 15%;
  text-align: center;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  background-color: #6ddf99;
  color: #040f31de;
}

#add-grade-cancel-btn {
  background-color: #d66c6c;
  color: #040f31de;
}

#add-grade-submit-btn:hover,
#add-grade-cancel-btn:hover {
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 40%);
  transform: translateX(1%);
  transform: translate3d(2%, 2%, 2%);
  background-color: #a71d1d;
  color: #fff8e2;
}
#add-grade-submit-btn:hover {
  background-color: #18a04c;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 40%);
}
</style>
