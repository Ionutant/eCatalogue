<template>
  <div class="teacher-grade-list">
    <AddGradeForm
      id="add-grade-form"
      v-if="displayAddGradeForm"
      v-on:save-add-grade="toggleAddGradeForm"
    ></AddGradeForm>
    <edit-grade-form
      id="edit-grade-form"
      v-if="displayEditGradeForm"
      v-on:save-edit-grade="toggleEditGradeForm"
      v-bind:currentGradeObject="currentGradeObject"
    ></edit-grade-form>

    <button
      id="add-grade-detail-btn"
      v-on:click="toggleAddGradeForm(), setCurrentGradeObject(grade)"
    >
      Add Grade
    </button>
    <table class="student-grades-table" v-show="grades.length > 0">
      <thead>
        <tr>
          <th id="course-name">Name</th>
          <th id="grade-status">Grade</th>
          <th id="grade-points">View</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="grade in grades"
          v-bind:key="grade.gradeId"
          v-bind:grade="grade"
          v-bind:class="{
            'submitted-highlight': grade.status == 'Submitted',
            'incomplete-highlight': grade.status == 'Incomplete',
          }"
        >
          <td class="grade-name">
            {{ grade.firstName + " " + grade.lastName }}
          </td>

          <td id="points">{{ grade.earnedPoints }}/{{ grade.totalPoints }}</td>
          <td id="view-grade-btn-container">
            <button
              id="view-grade-detail-btn"
              v-on:click="toggleEditGradeForm(), setCurrentGradeObject(grade)"
            >
              Grade
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import gradesService from "../services/GradesService";
import EditGradeForm from "../components/EditGradeForm.vue";
import AddGradeForm from "../components/AddGradeForm.vue";

export default {
  name: "teacher-grade-list",
  data() {
    return {
      grades: [],
      // assignments: [],
      currentGradeObject: {},
      displayEditGradeForm: false,
      displayAddGradeForm: false,
    };
  },
  components: {
    EditGradeForm,
    AddGradeForm,
  },
  created() {
    // AssignmentService.getAllAssignmentsInCourse(
    //   this.$route.params.courseId
    // ).then((response) => {
    //   if (response.status == 200) {
    //     this.assignments = response.data;
    //     console.log(response.data);
    //   }
    // });
    // AssignmentService.getStudentsByCourseId(this.$route.params.courseId).then(
    //   (response) => {
    //     console.log(response);
    //     if (response.status == 200) {
    //       this.student = response.data;
    //       console.log(response.data);
    //     }
    //   }
    // );

    gradesService
      .getStudentInCourse(this.$route.params.courseId)
      .then((response) => {
        // console.log(response.data);
        if (response.status == 200) {
          // this.grades = response.data;
        }
      });

    gradesService.getAllJoinedGrades().then((resp) => {
      if (resp.status == 200) {
        this.grades = resp.data.filter(
          (grade) => grade.courseId == this.$route.params.courseId
        );
      }
    });
    gradesService
      .allJoinedGradesForCourse(this.$route.params.courseId)
      .then((response) => {
        if (response.status == 200) {
          this.grades = response.data;
        }
      });
  },
  methods: {
    toggleEditGradeForm() {
      if (this.displayEditGradeForm == false) {
        this.displayEditGradeForm = true;
      } else {
        this.displayEditGradeForm = false;
      }
    },

    toggleAddGradeForm() {
      if (this.displayAddGradeForm == false) {
        this.displayAddGradeForm = true;
      } else {
        this.displayAddGradeForm = false;
      }
    },

    setCurrentGradeObject(grade) {
      this.currentGradeObject = grade;
    },
  },
};
</script>

<style>
.teacher-grade-list {
  display: flex;
  flex-direction: column;
}
.templete-div- .assignment-div > a {
  text-decoration: none;
  color: #0564bd;
}
.assignment-div > a:hover {
  text-decoration: none;
  color: #9521b8de;
}

#assignment-grade-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-end;
  margin-left: 4%;
  margin-right: 4%;
  margin-bottom: 5px;
}

#assignment-grade-title {
  font-size: 1.3rem;
}

#due-date {
  font-size: 1.1rem;
  color: #040f31c0;
}

.grades-table thead {
  font-weight: bold;
  font-size: 1rem;
  background-color: #ddddddb0;
  color: #040f31de;
  border-bottom: 2px solid rgba(58, 58, 58, 0.425);
  border-top: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
}

.grades-table {
  width: 90%;
  border: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
  border-radius: 10px;
  border-collapse: collapse;
  margin-left: 5%;
  margin-bottom: 40px;
}

.student-grade-row {
  background-color: #f6f4f7;
  border-top: 1px solid gray;
}

.submitted-highlight {
  background-color: #fae89a38;
}

.incomplete-highlight {
  background-color: rgba(235, 145, 145, 0.13);
}

.grades-table td {
  border: 1px solid rgba(105, 105, 105, 0.11);
  padding-left: 5px;
  padding-bottom: 5px;
  padding-top: 5px;
  padding-right: 5px;
}

.grade-name {
  width: 20%;
  font-weight: 1600;
  font-family: "Franklin Gothic Medium", "Arial Narrow bold", Arial, sans-serif;
  color: #040f31c4;
  text-align: center;
}

.grade-points {
  font-weight: 1600;
  font-family: "Franklin Gothic Medium", "Arial Narrow bold", Arial, sans-serif;
  color: #040f31c4;
  text-align: center;
}

.grade-status {
  width: 12%;
}

.grade-feedback {
  width: 50%;
}
#teacher-feedback {
  font-style: italic;
  color: rgb(83, 83, 83);
}

.view-column {
  width: fit-content;
  text-align: center;
}

#grade-score-btn {
  width: 90%;
}

#view-grade-btn {
  width: fit-content;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  padding-inline: 8%;
  background-color: #f33e26a9;
  color: #f1f1f1;
}

#view-grade-btn:hover {
  background-color: #f9dc59;
  color: #001a33d0;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
  transform: translateX(1%);
  transform: translate3d(2%, 2%, 2%);
}

#edit-grade-form {
  position: fixed;
  left: 50%;
  right: 0%;
  transform: translate(-50%, -45%);
}
</style>
