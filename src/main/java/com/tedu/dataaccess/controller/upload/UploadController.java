package com.tedu.dataaccess.controller.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenjl
 * @date 2022/5/6
 * @desc TODO
 */
@Controller
@RequestMapping(value = "/upload/file/")
public class UploadController {
    
    @ResponseBody
    @RequestMapping(value = "/userinfo")
    public String backSuccess() {
        return "Success";
    }

    
}
