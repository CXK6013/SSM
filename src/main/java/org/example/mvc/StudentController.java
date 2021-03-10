package org.example.mvc;

import org.apache.commons.io.FileUtils;
import org.example.mvc.entity.User;
import org.example.mybatis.BlogMapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author XingKe
 * @date 2021-03-04 22:22
 */

@Controller
public class StudentController {

    private BlogMapper blogMapper;

    @Autowired
    public StudentController(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @RequestMapping(value = "/servlet", method = RequestMethod.GET)
    public String testGet(@RequestParam(value = "name") String userName, @SessionAttribute(value = "password", required = false) String password) {
        System.out.println("username:" + userName);
        System.out.println("password:" + password);
        System.out.println(blogMapper.selectAllReturnMap());
        return "success";
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public void test(@RequestHeader("User-Agent") String useAgent, @CookieValue("JSESSIONID") String jsesionId) {
        System.out.println(useAgent);
        System.out.println(jsesionId);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String getInfo(@PathVariable(value = "id") String id) {
        System.out.println("id:" + id);
        return id;
    }

    @RequestMapping(value = "/obj", method = RequestMethod.GET)
    public String testOBj(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping(value = "testPost", method = RequestMethod.POST)
    public void testPostRequest(@RequestBody User user) {
        System.out.println(user);
    }

    @RequestMapping(value = "testUpload")
    public void downloadFile(Long id, HttpServletResponse resp, HttpServletRequest request) throws IOException {
        // 根据id去查文件的位置
        resp.setContentType("application/x-msdownload");
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("IE")) {
            resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("文件名", StandardCharsets.UTF_8.name()));
        } else {
            resp.setHeader("Content-Disposition", "attachment;filename=" + new String("文件名".getBytes("UTF-8"), StandardCharsets.ISO_8859_1.name()));
        }
        Files.copy(Paths.get("文件夹", "文件名"), resp.getOutputStream());
    }

    @RequestMapping(value = "testUpload2")
    public ResponseEntity<byte[]> testUpload(Long id, HttpServletResponse resp, HttpServletRequest request) throws IOException {
        // 根据id去查文件的位置
        resp.setContentType("application/x-msdownload");
        String userAgent = request.getHeader("User-Agent");
        HttpHeaders httpHeaders = new HttpHeaders();
        if (userAgent.contains("IE")) {
            resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("文件名", StandardCharsets.UTF_8.name()));
        } else {
            resp.setHeader("Content-Disposition", "attachment;filename=" + new String("文件名".getBytes("UTF-8"), StandardCharsets.ISO_8859_1.name()));
        }
        Files.copy(Paths.get("文件夹", "文件名"), resp.getOutputStream());
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] array = FileUtils.readFileToByteArray(new File("文件夹", "文件名"));
        return new ResponseEntity<byte[]>(array, httpHeaders, HttpStatus.CREATED);
    }

}
