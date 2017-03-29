//package com.example.security;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//@Component
//public class JwtFilter extends GenericFilterBean {
//
//    @Override
//    public void doFilter(final ServletRequest req,
//                         final ServletResponse res,
//                         final FilterChain chain) throws IOException, ServletException {
//        final HttpServletRequest request = (HttpServletRequest) req;
//
//
////        final String authHeader = request.getHeader("Authorization");
////        if (authHeader == null || !authHeader.startsWith("Bee ")) {
////            System.out.print("error");
////           throw new ServletException("Missing or invalid Authorization header.");
////        }
////
////        final String token = authHeader.substring(4); // The part after "Bearer "
////
////        try {
////            final Claims claims = Jwts.parser().setSigningKey("secretkey")
////                .parseClaimsJws(token).getBody();
////            request.setAttribute("claims", claims);
////        }
////        catch (final SignatureException e) {
////            throw new ServletException("Invalid token.");
////        }
//
//        chain.doFilter(req, res);
//    }
//
//}
