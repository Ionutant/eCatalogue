<template>
  <div class="home">
    <nav-bar />
    <home-page-hero />


       <div class= "classes-container">
          <h1 class= "classes-title">Your Classes Dashboard</h1>
         <course-list />
       </div>
   
     
     <div class= "quote-container"> 
       <div class= "quote-box">
         <h1 class="einstein-quote">"The roots of education are bitter, but the fruit is sweet"</h1>
         <h2 class= "quoter">-Aristotle</h2>
       </div>
     </div>
     <footer-section class="footer"/>
 </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';
import NavBar from '../components/NavBar.vue';
import HomePageHero from '../components/HomePageHero.vue';
import FooterSection from '../components/FooterSection.vue';


export default {
  name: "home",
  components: {
    NavBar,
    CourseList,
    HomePageHero,
    FooterSection,
    
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Schoolbell&display=swap');


  .classes-container {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin-top: 0px;
    margin-bottom: 0px;
    width: 100%;
    height: 10%;
    /* background-color: white; */
    background-color: #f6f4f7;
    justify-content: center;
    display: flex;
    flex-direction: column;
    min-height: 25%;
    padding-bottom: 50px;
  }
  .classes-title {
    text-align: center;
    padding: 5px;
    font-size: 1.8rem;
    margin-left: 20%;
    margin-right: 20%;
    margin-top: 20px;
    text-transform: uppercase;
    border-bottom: 1px solid #040f3142;
    color: #040f31de;
    font-weight: 400;
  }
  /* .text-container {
    background-color: white;
    justify-content: center;
    display: flex;
    /* gap: 70px; */
    /* flex-direction: row; */
    /* height: 150px; */
  /* } */
  /* .text-container div { */
    /* height: 100px; */
    /* width: 100px;
    text-align: center;
    color: #1F2937;
    margin-top: 10px;
    font-weight: bolder;
  } */ 
  .quote-container {
     font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    display: flex;
    height: 20vh;
    background-color: #E5E7EB;
    justify-content: center;
    align-items: center;
  }
  .quote-box {
    color: #001a33c7;
    display: flex;
    flex-direction: column;
    justify-content: center;
    background-color: #E5E7EB;
    text-align: center;
    font-size: 14px;
    font-style: italic;
    font-weight: lighter;
    margin: 0px;
  }

.footer {
  margin-top: 0%;
  margin-bottom: 0%;
}

</style>
