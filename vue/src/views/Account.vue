<template>
  <div class="account">
    <nav-bar />
    <profile />
    <footer-section />
  </div>
</template>

<script>
import FooterSection from "../components/FooterSection.vue";
import NavBar from "../components/NavBar.vue";
import Profile from "../components/Profile.vue";

export default {
  name: "account",
  components: {
    Profile,
    NavBar,
    FooterSection,
  },
};
</script>

<style>
.account {
  display: flex;
  flex-direction: column;
  background-image: radial-gradient(circle farthest-side, #fffffffd, #d8d6d6fd);
}
</style>
