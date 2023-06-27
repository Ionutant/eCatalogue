//package com.techelevator.controller;
//
//import com.techelevator.dao.CourseDao;
//import com.techelevator.dao.UserDao;
//import com.techelevator.model.Course;
//import com.techelevator.security.JwtAccessDeniedHandler;
//import com.techelevator.security.JwtAuthenticationEntryPoint;
//import com.techelevator.security.WebSecurityConfig;
//import com.techelevator.security.jwt.JWTConfigurer;
//import com.techelevator.security.jwt.JWTFilter;
//import com.techelevator.security.jwt.TokenProvider;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.MediaType;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(CourseController.class)
//@ContextConfiguration(classes = WebSecurityConfig.class)
//class CourseControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    CourseDao courseDao;
//    @MockBean
//    UserDao userDao;
//
//    @MockBean
//    TokenProvider tokenProvider;
//    @MockBean
//    WebSecurityConfig webSecurityConfig;
//
//    @MockBean
//    JwtAccessDeniedHandler jwtAccessDeniedHandler;
//
//    @MockBean
//    JWTFilter jwtFilter;
//
//    @MockBean
//    JWTConfigurer jwtConfigurer;
//
//    @MockBean
//    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//
//    @WithMockUser(roles = "USER")
//    @Test
//    void testGetWeatherBasedOnCoordinates() throws Exception {
//
//        Course course = new Course();
//        course.setCourseDescription("desc");
//        course.setCourseId(1);
//        course.setCourseTitle("title");
//
//        when(courseDao.getCourseById(anyInt()))
//                .thenReturn(course);
//
//
//        mockMvc
//                .perform(
//                        MockMvcRequestBuilders.get("/course/1")
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//}