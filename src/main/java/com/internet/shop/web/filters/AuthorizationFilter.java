package com.internet.shop.web.filters;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Role;
import com.internet.shop.model.User;
import com.internet.shop.service.UserService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AuthorizationFilter implements Filter {
    Map<String, Set<Role.RoleName>> protectedUrls = new HashMap<>();
    private static final Injector injector = Injector.getInstance("com.internet.shop");
    private final UserService userService =
            (UserService) injector.getInstance(UserService.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        protectedUrls.put("/orders/admin", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/orders/admin/delete", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/products/add", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/products/admin", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/products/admin/delete", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/users/all", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/cart/products", Set.of(Role.RoleName.USER));
        protectedUrls.put("/cart/products/add", Set.of(Role.RoleName.USER));
        protectedUrls.put("/cart/products/delete", Set.of(Role.RoleName.USER));
        protectedUrls.put("/order/complete", Set.of(Role.RoleName.USER));
        protectedUrls.put("/orders/all", Set.of(Role.RoleName.USER));
        protectedUrls.put("/orders/info", Set.of(Role.RoleName.USER));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String requestedUrl = req.getServletPath();
        if (protectedUrls.get(requestedUrl) == null) {
            filterChain.doFilter(req, resp);
            return;
        }
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute("user_id");
        User user = userService.getById(userId);
        if (isAuthorized(user, protectedUrls.get(requestedUrl))) {
            filterChain.doFilter(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/access-denied.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
    }

    private boolean isAuthorized(User user, Set<Role.RoleName> authorizedRoles) {
        for (Role.RoleName authorizedRole : authorizedRoles) {
            for (Role userRole : user.getRoles()) {
                if (authorizedRole.equals(userRole.getRoleName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
