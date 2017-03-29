package com.example.security;

import com.example.controller.Examination;
import com.example.model.Admin;
import com.example.service.AdminService;
import com.example.service.StudentService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.controller.Examination.TOKEN;


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// usage: each client is support a token which showed when it want to get or post data to
//        server 's databse.
//        this class is a filter which filter all request from client before meeting
//        @Controller
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Component
public final class TokenAuthenticationFilter extends GenericFilterBean {

    private Examination examination = new Examination();

    /**
     * variable state store state of request
     * if method of request is GET, its value is 1
     * if method of request is POST, its value is 2
     * @param httpRequest
     * @return true if have token and false if not have
     */

    @Autowired
     private StudentService studentService;
    @Autowired
    private AdminService adminService;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(" *** MyAuthenticationFilter.doFilter");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (examination.checkToken(httpRequest)) {

            switch (examination.state) {
                case 1:

                    chain.doFilter(httpRequest, httpResponse);
                    break;
                case 2:
                    String token = httpRequest.getHeader(TOKEN);


                    if (token != null) {

                        /**
                         *  get user by token retrived from client, user is instant by
                         *  {@link com.example.model.Students.codeStudent} for student
                         *  or {@link com.example.model.Admin.username} for admin
                         *
                         *  if user is exist, allow request to @Controller
                         */

//                        List<String> roles = new ArrayList<>();
//                        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//                        for (GrantedAuthority auth : authentication.getAuthorities()) {
//                            roles.add(auth.getAuthority());
//                        }
                        try {
                              String user = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token)
                                    .getBody().getSubject();

                            switch (examination.role){
                                case ADMIN:
                                    Admin admin = adminService.findByUsername(user);
                                    if(admin!= null){
                                        if(user.equals(admin.getUsername()))
                                            chain.doFilter(httpRequest,httpResponse);
                                    }

                                    break;
                                case STUDENT:
                                    if(studentService.findByCodeStudent(user)!=null){
                                        if(user.equals(studentService.findByCodeStudent(user).getCodeStudent())){
                                            chain.doFilter(httpRequest, httpResponse);
                                        }
                                    }

                                    break;

                            }

                        }catch (SignatureException e){
                            throw new ServletException("Invalid token.");
                        }
                    }
            }

            System.out.println(" === AUTHENTICATION: ");
        }



    }




//    private void checkLogout(HttpServletRequest httpRequest) {
//        if (currentLink(httpRequest).equals(logoutLink)) {
//            String token = httpRequest.getHeader(HEADER_TOKEN);
//            // we go here only authenticated, token must not be null
//            authenticationService.logout(token);
//            doNotContinueWithRequestProcessing(httpRequest);
//        }
//    }




}
