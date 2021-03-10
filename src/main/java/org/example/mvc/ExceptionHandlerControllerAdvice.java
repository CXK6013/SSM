package org.example.mvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author XingKe
 * @date 2021-03-07 11:54
 */
// 这个注解会处理所有方法的异常
//@ControllerAdvice
//public class ExceptionHandlerControllerAdvice {
//    // 该注解中声明要处理哪些异常
//    @ExceptionHandler({Exception.class})
//    public  String error(Exception ex , Model model){
//        // 向请求域中放入异常信息
//        model.addAttribute("errorMsg",ex.getMessage());
//        // 跳转至error页面
//        return "error";
//    }
//}
