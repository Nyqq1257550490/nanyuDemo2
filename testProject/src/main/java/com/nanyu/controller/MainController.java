package com.nanyu.controller;

import com.nanyu.model.T_Position;
import com.nanyu.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by NCZ on 2018/7/25.
 */
@Controller
public class MainController {
    @Resource
    private MainService mainService;

    /**
     * 进入主界面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goMainPage")
    public String goMainPage()throws Exception{
        return "mainpages/mainPage";
    }

    /**
     * 得到所有部门
     * @param dep_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getPosition")
    @ResponseBody
    public Object getPosition(int dep_id)throws Exception{
        List<T_Position> positions = mainService.getPosition(dep_id);
        return positions;
    }

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    /**
     * 生成不重复8位
     * @return
     * @throws Exception
     */
    @RequestMapping("/createCode")
    @ResponseBody
    public String createCode()throws Exception{
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }



}
