package com.team.boot.controller;

import com.team.boot.utils.ValidateCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * @Author: wangqin
 * @Date: 2021/3/2 0002 - 03 -02 -18:02
 * @Description: com.team.boot.controller
 * @version: 1.0
 */
@RestController
public class UtilController {
    @RequestMapping(value = "/validateCode",produces = MediaType.IMAGE_PNG_VALUE,method = RequestMethod.GET)
    public byte[] getValidateCode(HttpSession session) throws IOException {
        ValidateCode vCode = new ValidateCode(140,40,5,50);
        session.setAttribute("validateCode",vCode.getCode());
        System.out.println("生成的vCode"+vCode.getCode());
        byte[] pic = vCode.write();
        return pic;

    }
    @RequestMapping(value = "/validateCode",method = RequestMethod.POST)
    public boolean verifyValidateCode(HttpSession session, @RequestParam("vCode") String vCode){
        System.out.println("浏览器来的vCode"+vCode);
        String validateCode = (String) session.getAttribute("validateCode");
        if (vCode!=null&&vCode.toUpperCase(Locale.ROOT).equals(validateCode)){
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }
}
