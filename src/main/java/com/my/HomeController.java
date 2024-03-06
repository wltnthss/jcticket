package com.my;

import com.jcticket.user.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model m) throws Exception {
        System.out.println("여기는 인덱스!!");
        Map<String, Object> map = new HashMap<>();
//        map.put("category",category);

        List<Map<String,Object>> list = userService.selectImg(map);
        Object img_name = list.get(0).get("image_name");
        System.out.println("list.get(0).get(\"img_name\") = " + list.get(0).get("img_name"));


//        m.addAttribute("list",list);
        System.out.println("list = " + list);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    private String errorPage(){
        return "/error/error";
    }

    @GetMapping("/index/upload/{img_name}")
    public @ResponseBody byte[] adminProductImg(Model model, @PathVariable String img_name) throws Exception {

        try{
            String path = "C:/play_img/" + img_name + ".JPG";
//            System.out.println("path = " + path);

            InputStream in = new FileInputStream(path);

            return IOUtils.toByteArray(in);

        } catch (IOException e){
            throw new RuntimeException("이미지 업로드 실패", e);
        }
    }

}
