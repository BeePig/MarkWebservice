//package com.example.security;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.authentication.AuthenticationDetailsSource;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
//import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetailsSource;
//import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
//import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class OAuth2AuthenticationProcessingFilter implements Filter, InitializingBean {
//
//  private final static Log logger = LogFactory.getLog(OAuth2AuthenticationProcessingFilter.class);
//
//  private AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
//
//  private AuthenticationManager authenticationManager;
//
//  private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new OAuth2AuthenticationDetailsSource();
//
//  private TokenExtractor tokenExtractor = new BearerTokenExtractor();
//
//  /**
//   * @param authenticationEntryPoint the authentication entry point to set
//   */
//  public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
//    this.authenticationEntryPoint = authenticationEntryPoint;
//  }
//
//  /**
//   * @param authenticationManager the authentication manager to set (mandatory with no default)
//   */
//  public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//    this.authenticationManager = authenticationManager;
//  }
//
//  /**
//   * @param tokenExtractor the tokenExtractor to set
//   */
//  public void setTokenExtractor(TokenExtractor tokenExtractor) {
//    this.tokenExtractor = tokenExtractor;
//  }
//
//    /**
//     * @param authenticationDetailsSource
//     *            The AuthenticationDetailsSource to use
//     */
//    public void setAuthenticationDetailsSource(AuthenticationDetailsSource<HttpServletRequest,?> authenticationDetailsSource) {
//        Assert.notNull(authenticationDetailsSource, "AuthenticationDetailsSource required");
//        this.authenticationDetailsSource = authenticationDetailsSource;
//    }
//
//  public void afterPropertiesSet() {
//    Assert.state(authenticationManager != null, "AuthenticationManager is required");
//  }
//
//  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
//          ServletException {
//
//    final boolean debug = logger.isDebugEnabled();
//    final HttpServletRequest request = (HttpServletRequest) req;
//    final HttpServletResponse response = (HttpServletResponse) res;
//
//    try {
//
//      Authentication authentication = tokenExtractor.extract(request);
//
//      if (authentication == null) {
//        if (debug) {
//          logger.debug("No token in request, will continue chain.");
//        }
//      }
//      else {
//        request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE, authentication.getPrincipal());
//        if (authentication instanceof AbstractAuthenticationToken) {
//          AbstractAuthenticationToken needsDetails = (AbstractAuthenticationToken) authentication;
//          needsDetails.setDetails(authenticationDetailsSource.buildDetails(request));
//        }
//        Authentication authResult = authenticationManager.authenticate(authentication);
//
//        if (debug) {
//          logger.debug("Authentication success: " + authResult);
//        }
//
//        SecurityContextHolder.getContext().setAuthentication(authResult);
//
//      }
//    }
//    catch (OAuth2Exception failed) {
//      SecurityContextHolder.clearContext();
//
//      if (debug) {
//        logger.debug("Authentication request failed: " + failed);
//      }
//
//      authenticationEntryPoint.commence(request, response,
//          new InsufficientAuthenticationException(failed.getMessage(), failed));
//
//      return;
//    }
//
//    chain.doFilter(request, response);
//  }
//
//  public void init(FilterConfig filterConfig) throws ServletException {
//  }
//
//  public void destroy() {
//  }
//
//}
