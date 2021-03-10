package org.example.mvc;

import org.example.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author XingKe
 * @date 2021-03-06 19:06
 */
@Controller
public class UploadFileController {

    @RequestMapping(value = "mvcUpload" , method = RequestMethod.POST)
    public void testUpload1(@RequestBody  User u , MultipartFile pic){


    }

    public void testUpload2(MultipartFile multipartFile){


    }
}
