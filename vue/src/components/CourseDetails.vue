<!-- <template>
  <div class="course-details">
    <div class="course-details-heading">
      <h2 class="course-title">
        {{ course.courseTitle }} | Level: {{ course.difficulty }}
      </h2>
      <edit-textarea
        v-if="displayEditDescription"
        v-bind:currentText="course.courseDescription"
        v-on:save-input-text="saveDescription"
      />
      <p v-if="!displayEditDescription" class="course-description">
        {{ course.courseDescription }}
      </p>
      {{ this.$store.state.editDescription }}
      <div class="edit-course-overview" v-bind="teacher" v-if="teacher">
        <button
          id="edit-course-overview-btn"
          v-on:click="toggleEditDescription"
          v-if="!displayEditDescription"
        >
          Edit Description
        </button>
      </div>
    </div>
  </div>
</template>

<script>
// import courseService from "../services/CourseService";
// import EditTextarea from "./EditTextarea.vue";

export default {
  name: "course-details",
  components: { EditTextarea },
  data() {
    return {
      course: {
        courseId: "",
        teacherId: "",
        courseTitle: "",
        courseDescription: "",
        difficulty: "",
        cost: "",
        isArchived: "",
      },
      teacher: this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      ),
      displayEditDescription: false,

    };
  },
  created() {
    courseService
  //     .getCourseByCourseId(this.$route.params.courseId)
  //     .then((response) => {
  //       if (response.status == 200) {
  //         this.course = response.data;
  //         // this.curricula = CurriculumService.getAllCurriculumInCourse(
  //         //   this.course.courseId
  //         // ).then((response) => {
  //         //   if (response.status == 200) {
  //         //     this.curricula = response.data;
  //         //   }
  //         });
  //       }
  //     });
  // },
  methods: {
    toggleEditDescription() {
      if (this.displayEditDescription == false) {
        this.displayEditDescription = true;
      } else {
        this.displayEditDescription = false;
      }
    },


    saveDescription(userInput) {
      this.course.courseDescription = userInput;
      courseService.updateCourse(this.course);
      this.toggleEditDescription();
    },

    },
  },
};
</script>

<style>
.course-container {
  padding: 20px;
  display: flex;
  flex-direction: column;
  height: 50vh;
  justify-content: flex-start;
}
.course-container div {
  margin: 10px;
}

/* .curriculum-details {
  border-top: 1px solid gray;
} */

.course-title {
  text-align: center;
}
.course-description {
  text-align: center;
}

.edit-course-overview,
/* .edit-curriculum-overview {
  text-align: right;
  margin-bottom: 10px;
} */

#edit-course-overview-btn {
  /* #edit-curriculum-overview-btn { */
  width: fit-content;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  padding-inline: 3%;
  background-color: #f76451;
  color: #f1f1f1;
  transition: all 0.3s ease-in-out;
}

#edit-course-overview-btn:hover {
  /* #edit-curriculum-overview-btn:hover { */
  background-color: #f9dc59;
  color: #5e6681;
}
</style> -->
