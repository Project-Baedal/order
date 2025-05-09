package com.baedal.order.util;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AuthenticationExtractor {

  private static final String ROLE_PREFIX = "ROLE_";

  public Authentication getAuthentication(HttpServletRequest req) {
    String id = extractUserId(req);
    String authority = extractAuthority(req);
    validate(id, authority);

    return new UsernamePasswordAuthenticationToken(
        id, null, List.of(new SimpleGrantedAuthority(authority))
    );
  }

  private String extractUserId(HttpServletRequest req) {
    return req.getHeader("X-User-Id");
  }

  private String extractAuthority(HttpServletRequest req) {
    String role = req.getHeader("X-User-Role");
    return (role.isEmpty()) ? null : ROLE_PREFIX + role;
  }

  private void validate(String id, String authority) {
    if (isInvalid(id, authority)) {
      throw new RuntimeException("잘못된 인증 정보입니다.");
    }
  }

  private boolean isInvalid(String id, String authority) {
    return (id == null || id.isEmpty()) && (authority != null && !authority.isEmpty()) ||
        (id != null && !id.isEmpty()) && (authority == null || authority.isEmpty());
  }
}
