package pl.julka99.libraryservice.api.controller;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    public static boolean isAdmin(HttpServletRequest request) {
        return request.getSession() != null && request.getSession().getAttribute("admin") != null &&
                (boolean) request.getSession().getAttribute("admin");
    }

    public static Integer getUserId(HttpServletRequest request) {
        if (request.getSession() == null || request.getSession().getAttribute("userId") == null) {
            return null;
        }
        return (int) request.getSession().getAttribute("userId");
    }
}