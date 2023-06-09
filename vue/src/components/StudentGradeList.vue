<template>
  <div class="student-grade-list">
    <view-grade-form
      id="view-grade-form"
      v-if="displayViewGradeForm"
      v-on:exit-view-grade="toggleViewGradeForm"
      v-bind:currentGradeObject="currentGradeObject"
    />
    <h1 id="course-progress-title">Your Course Progress</h1>
    <table class="student-grades-table">
      <thead>
        <tr>
          <th id="grade-points">Grade</th>
          <th id="view-column">Details</th>
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
          <td id="points">{{ grade.earnedPoints }}/{{ grade.totalPoints }}</td>
          <td id="view-grade-btn-container">
            <button
              id="view-grade-detail-btn"
              v-on:click="toggleViewGradeForm(), setCurrentGradeObject(grade)"
            >
              View
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <div class="total-course-score">
      <h2 id="course-score-text">Current Course Score:</h2>
      <h2 id="course-score-number">{{ totalCourseScore }}</h2>
    </div>
  </div>
</template>

<script>
import gradesService from "../services/GradesService";
import ViewGradeForm from "./ViewGradeForm.vue";
export default {
  name: "student-grade-list",
  components: { ViewGradeForm },
  data() {
    return {
      grades: [],
      currentGradeObject: {},
      displayViewGradeForm: false,
    };
  },
  created() {
    gradesService
      .allGradesForStudentInCourse(
        this.$route.params.courseId,
        this.$store.state.user.id
      )
      .then((response) => {
        if (response.status == 200) {
          this.grades = response.data;
        }
      });
  },
  methods: {
    toggleViewGradeForm() {
      if (this.displayViewGradeForm == false) {
        this.displayViewGradeForm = true;
      } else {
        this.displayViewGradeForm = false;
      }
    },
    setCurrentGradeObject(grade) {
      this.currentGradeObject = grade;
    },
  },
  computed: {
    totalCourseScore() {
      let earned = 0;
      let count = 0;
      this.grades.forEach((grade) => {
        if (grade.gradeId > 0) {
          earned += parseInt(grade.earnedPoints);
          count++;
        }
      });

      if (count === 0) {
        return "You have no grade yet";
      }

      const average = earned / count;
      return average.toFixed(2);
    },
  },
};
</script>

<style>
#course-progress-title {
  text-align: center;
  padding: 5px;
  font-size: 1.5rem;
  margin-left: 20%;
  margin-right: 20%;
  margin-top: -40px;
  margin-bottom: 20px;
  text-transform: uppercase;
  border-bottom: 1px solid #040f3142;
  color: #040f31a1;
  font-weight: 500;
}
.student-grade-list {
  display: flex;
  flex-direction: column;
}

.student-grades-table {
  width: 90%;
  border: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
  border-radius: 10px;
  border-collapse: collapse;
  margin-left: 5%;
  margin-bottom: 40px;
}
.student-grades-table thead {
  font-weight: bold;
  font-size: 1rem;
  background-color: #ddddddb0;
  color: #040f31de;
  border-bottom: 2px solid rgba(58, 58, 58, 0.425);
  border-top: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
}

.student-grades-table td {
  border: 1px solid rgba(105, 105, 105, 0.11);
  padding-left: 5px;
  padding-bottom: 5px;
  padding-top: 5px;
  padding-right: 5px;
}

#course-name {
  width: 60%;
}

#grade-points {
  width: 10%;
  text-align: center;
}

#grade-status {
  width: 15%;
  text-align: center;
}

#view-column {
  width: 10%;
  text-align: center;
}

#grade-score-btn {
  width: 90%;
}

#view-grade-detail-btn {
  margin-left: 15%;
  margin-left: auto;
  margin-right: auto;
  display: block;

  width: fit-content;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  padding-inline: 8%;
  background-color: #002a62;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
#add-grade-detail-btn {
  margin-left: 0%;
  margin-bottom: 0.5cm;
  width: fit-content;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  padding-inline: 8%;
  background-color: #002a62;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}

#add-grade-detail-btn:hover {
  background-color: #0b60ce;
  color: #fcfbf7;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 50%);
  transform: translateX(1%);
  transform: translate3d(2%, 2%, 2%);
}

#view-grade-detail-btn:hover {
  background-color: #0b60ce;
  color: #fcfbf7;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 50%);
  transform: translateX(1%);
  transform: translate3d(2%, 2%, 2%);
}

#view-grade-form {
  position: fixed;
  left: 50%;
  right: 0%;
  max-height: 90vh;
  transform: translate(-50%, -55%);
}

.submitted-highlight {
  background-color: #fae89a38;
}

.incomplete-highlight {
  background-color: rgba(235, 145, 145, 0.13);
}

#points {
  font-weight: 1600;
  font-family: "Franklin Gothic Medium", "Arial Narrow bold", Arial, sans-serif;
  color: #040f31c4;
  text-align: center;
}

.total-course-score {
  text-align: right;
  margin-right: 10%;
  text-transform: uppercase;
  color: #032647b4;
  padding-bottom: 10px;
  display: inline-flex;
  justify-content: flex-end;
  align-items: center;
}
#course-score-number {
  color: #0b60ce;
  margin-left: 10px;
  font-size: 2rem;
}
</style>
