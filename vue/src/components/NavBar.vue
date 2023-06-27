<template>
  <nav class="nav-top">
    <router-link :to="{ name: 'home' }"
      ><div class="title-div">
        <img src="../../public/images/icon3.png" alt="icon3" />
        <h2>eCatalogue</h2>
      </div>
    </router-link>

    <ul>
      <li><router-link :to="{ name: 'home' }">Home</router-link></li>
      <li><router-link :to="{ name: 'account' }">Account</router-link></li>
      <li>
        <router-link :to="{ name: 'logout' }" v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </li>
    </ul>
  </nav>
</template>

<script>
import gradesService from "../services/GradesService";

export default {
  name: "nav-bar",
  components: {},
  created() {
    gradesService.getAllGrades().then((response) => {
      if (response.status == 200) {
        const grades = response.data;
        this.submittedGrades = grades.filter((grade) => {
          return grade.status == "Submitted";
        });
      }
    });
  },

  data() {
    return {
      submittedGrades: [],
      teacher: this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      ),
    };
  },
  methods: {
    goToGradePage() {
      this.$router.push(`/course/${this.submittedGrades[0].courseId}`);
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Schoolbell&display=swap");
body {
  margin: 0;
}
.nav-top {
  grid-area: navbar;
  padding: 0;
  margin: 0;
  width: auto;
}

.title-div {
  display: flex;
  align-items: center;
}
.title-div h2 {
  font-family: "Schoolbell", cursive;
  color: #f9dc59;
}
.title-div img {
  height: 30px;
  margin-right: 5%;
}
.nav-top {
  display: flex;
  justify-content: space-between;
  padding: 1rem 2rem;
  background-color: #002a62;
}
.nav-top ul {
  display: flex; /* 5 */
  list-style: none; /* 6 */
}
.nav-top img {
  width: 25px;
  height: 25px;
}
.nav-top li {
  padding-left: 1rem; /* 7! */
  font-size: 1.2rem;
}
.nav-top a {
  text-decoration: none;
  color: #f9dc59;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
.nav-top li a:hover,
.title-div h2:hover {
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
  color: #f6f4f7;
}
</style>
