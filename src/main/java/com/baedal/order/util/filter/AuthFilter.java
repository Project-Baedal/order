package com.baedal.order.util.filter;

import com.baedal.order.util.AuthenticationExtractor;
import com.baedal.order.util.ContextHolderProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class AuthFilter extends OncePerRequestFilter {

  private final AuthenticationExtractor authenticationExtractor = new AuthenticationExtractor();
  private final ContextHolderProvider contextHolderProvider = new ContextHolderProvider();

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain
  ) throws IOException, ServletException {

    Authentication authentication = authenticationExtractor.getAuthentication(request);
    contextHolderProvider.setAuthentication(authentication);

    chain.doFilter(request, response);
  }
}