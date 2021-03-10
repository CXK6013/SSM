package org.example.mvc;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.example.ioc.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author XingKe
 * @date 2021-03-06 9:41
 */
//@WebServlet("/servlet")
//public class ServletDemo extends HttpServlet {
//
//    @SneakyThrows
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 统一编码
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=UTF-8");
//        boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
//        // 表单中有上传文件,method中必须有enctype这个属性
//        if (isMultipartContent) {
//            FileItemFactory fileItemFactory = new DiskFileItemFactory();
//            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
//            List<FileItem> items = servletFileUpload.parseRequest(req);
//            for (FileItem item : items) {
//                if (item.isFormField()){
//                    // 处理表单的非文件字段
//                }else{
//                    // 将上传文件写入到文件服务器中
//                    item.write(new File("服务器的路径/"));
//                }
//            }
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        System.out.println("处理post请求");
//        super.doPost(req, resp);
//    }
//}
