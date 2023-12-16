//package com.policearsenalsystem.Config;
//
//import com.policearsenalsystem.Service.AccService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
////@EnableWebSecurity
//public class config {
//
//    @Autowired
//    AccService accService;
//
////    @Bean
////    public PasswordEncoder passwordEncoder(){
////        return new BCryptPasswordEncoder();
////    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsPasswordService(accService);
//        authProvider.setPasswordEncoder(new BCryptPasswordEncoder()); // Inject the PasswordEncoder from SecurityConfig
//        return authProvider;
//    }
//}
