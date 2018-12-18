package com.example.demo.interceptor;

import net.minidev.json.JSONObject;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static com.sun.xml.internal.ws.api.message.Packet.State.ServerResponse;

/**
 * @Auther fanhanxi
 * @Date 2018/12/18
 * @Description:
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag;
        String test = (String) request.getSession().getAttribute("admin");
        if (test == null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");

            JSONObject json = new JSONObject();
            json.put("msg","拦截器拦截，请登录");
            PrintWriter pw = response.getWriter();
            pw.write(json.toString());

            pw.flush();
            pw.close();

            response.flushBuffer();
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
