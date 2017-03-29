//package com.example.security;
//
///**
// * Created by beepi on 16/04/2016.
// */
//
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//import org.springframework.web.filter.CompositeFilter;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.util.WebUtils;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configurable
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
////    @Autowired
////    UserRepository userRepository;
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
////        List<com.example.model.User> userList=userRepository.findAll();
////        auth.inMemoryAuthentication().withUser("admin").password("1234").roles("USER");
////        for(User user : userList){
////            auth
////                    .inMemoryAuthentication()
////                    .withUser(user.getUsername()).password(user.getPassword()).roles("USER");
////
////        }
//
//
//
//    }
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/users/create/displayName/{names}/number/{numbers}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/users/delete/{id}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"users/delete").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "users/update/{id}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/contacts/update/id/{id}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/contacts/update/user_id/{id_user}/id/{id_contact}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/contacts/delete/user_id/{id_user}/id/{id}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/contacts/delete/user_id/{id_user}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/contacts/delete").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/contacts/create").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/messages/create").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/messages/delete/contact_id/{contactId}/message_id/{messageId}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/messages/delete/contact_id/{contactId}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/messages/delete").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
//                .and().logout().logoutSuccessUrl("/").permitAll()
//                .and().csrf().disable()
////                .and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
////                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
//        ;
//
//
//
//    }
//
//
//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName("X-XSRF-TOKEN");
//        return repository;
//    }
//
//
//    private Filter csrfHeaderFilter() {
//        return new OncePerRequestFilter() {
//            @Override
//            protected void doFilterInternal(HttpServletRequest request,
//                                            HttpServletResponse response, FilterChain filterChain)
//                    throws ServletException, IOException {
//                CsrfToken csrf = (CsrfToken) request
//                        .getAttribute(CsrfToken.class.getName());
//                if (csrf != null) {
//                    Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//                    String token = csrf.getToken();
//                    if (cookie == null
//                            || token != null && !token.equals(cookie.getValue())) {
//                        cookie = new Cookie("XSRF-TOKEN", token);
//                        cookie.setPath("/");
//                        response.addCookie(cookie);
//                    }
//                }
//                filterChain.doFilter(request, response);
//            }
//        };
//    }
//
//    private Filter ssoFilter() {
//        CompositeFilter filter = new CompositeFilter();
//        List<Filter> filters = new ArrayList<>();
////        filters.add(ssoFilter(facebook(), "/login/facebook"));
////        filters.add(ssoFilter(github(), "/login/github"));
//        filter.setFilters(filters);
//        return filter;
//    }
//}
//
//
//
//
