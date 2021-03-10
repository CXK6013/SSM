package org.example.mvc;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author XingKe
 * @date 2021-03-07 16:00
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    /**
     * 返回true代表将请求交给真正的控制器
     * 返回false代表将请求放给下一个拦截器,如果找不到下一个拦截器,
     * 则该请求不会到达真正的拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("在方法执行之前执行................");
        return true;
    }

    /**
     * 在处理器方法执行之后执行
     * ModelAndView中存放方法返回的数据和要跳转的视图
     * 方法未成功执行,不会触发此方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("在方法执行之后执行................");
    }

    /**
     * 在页面渲染之后获取
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 打印方法的异常信息
        System.out.println("在视图渲染完毕执行之后执行................");
    }
}
