package com.hotelapi.config.security.jwt;

import com.hotelapi.config.security.UserDetailsImpl;
import com.hotelapi.config.security.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;


    private String getJwtTokenFormRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    private void setAuthenticationContext(String token, UserDetails user, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String token = getJwtTokenFormRequest(request);
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request, response);
            return;
        }

        final String userName = jwtService.getTokenUsername(token);
        final String role = jwtService.getTokenRole(token);

        if(userName != null && role != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetailsImpl user = this.userDetailsService.loadUserByUsername(userName + ":" + role);
            if(jwtService.validateToken(token, user)) {
                setAuthenticationContext(token, user, request);
            }
        }
        filterChain.doFilter(request, response);
    }
}
