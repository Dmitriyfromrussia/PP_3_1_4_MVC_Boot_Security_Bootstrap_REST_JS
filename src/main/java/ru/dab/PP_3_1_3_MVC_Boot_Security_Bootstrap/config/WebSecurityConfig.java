package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final SuccessUserHandler successUserHandler;

    public WebSecurityConfig(SuccessUserHandler successUserHandler) {
        this.successUserHandler = successUserHandler;
    }

    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/index").permitAll() // доступно всем
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN") // доступ к /admin только для пользователей с ролью admin
                        //.requestMatchers("/user").hasAnyRole("USER", "ADMIN") // доступ к /user для ролей user и admin
                        .requestMatchers("/user/user").hasAnyAuthority("USER", "ADMIN")
                        .anyRequest().authenticated() // все остальные запросы требуют аутентификации
                )
                .formLogin((form) -> form

                        .loginPage("/login")
                        .successHandler(successUserHandler) // обрабатываем успешный логин эту строку можно убрать
                        .permitAll()
                )
//                .logout((logout) -> logout.permitAll()
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/", "GET"))
//                );
                .logout((logout) -> logout
                        .logoutUrl("/logout") // стандартный URL для выхода
                        .permitAll()
                );


        return http.build();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/index").permitAll() // доступно всем
//                        .requestMatchers("/admin/**").hasRole("ADMIN") // доступ к /admin только для пользователей с ролью admin
//                        //.requestMatchers("/user").hasAnyRole("USER", "ADMIN") // доступ к /user для ролей user и admin
//                        .requestMatchers("/user").hasRole("USER")
//                        .anyRequest().authenticated() // все остальные запросы требуют аутентификации
//                )
//                .formLogin((form) -> form
//
//                        .loginPage("/login")
//                        .successHandler(successUserHandler) // обрабатываем успешный логин эту строку можно убрать
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());// .logout(LogoutConfigurer::permitAll
//
//        return http.build();
//    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() { //если пользователь существует -- daoAuthenticationProvider помещает его в SpringSecurityContext
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder()); // назначили passwordEncoder из метода ниже

        authenticationProvider.setUserDetailsService(userDetailsService); // назначили setUserDetailsService чтобы предоставить юзера либо проверить его наличие

        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{bcrypt}$2a$12$jgkQ8uqr.hwnmBTRpej2LuOyMUGrFftyua6XJv6/xe/RVwjmGhcCu")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$12$sWHEI.Ex0KsVDxtdG1mfmen3WSFEwS4KW5/ffDQsCNVNIkNPXLrM6")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }


//jdbcAutentification

//    @Bean
//    public JdbcUserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.builder() // оказывается обязательно шифровать надо!!!
//                .username("user")
//                .password("{bcrypt}$2a$12$jgkQ8uqr.hwnmBTRpej2LuOyMUGrFftyua6XJv6/xe/RVwjmGhcCu") // "{bcrypt}$2a$12$jgkQ8uqr.hwnmBTRpej2LuOyMUGrFftyua6XJv6/xe/RVwjmGhcCu" user
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$12$sWHEI.Ex0KsVDxtdG1mfmen3WSFEwS4KW5/ffDQsCNVNIkNPXLrM6")
//                .roles("ADMIN") // "USER",
//                .build();
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        if (jdbcUserDetailsManager.userExists(user.getUsername())) {
//            jdbcUserDetailsManager.deleteUser(user.getUsername());
//        }
//        if (jdbcUserDetailsManager.userExists(admin.getUsername())) {
//            jdbcUserDetailsManager.deleteUser(admin.getUsername());
//        }
//        jdbcUserDetailsManager.createUser(user);
//        jdbcUserDetailsManager.createUser(admin);
//        return jdbcUserDetailsManager;
//    }
