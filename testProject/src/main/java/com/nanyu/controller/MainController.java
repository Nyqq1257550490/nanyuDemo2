package com.nanyu.controller;

import com.nanyu.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
}
