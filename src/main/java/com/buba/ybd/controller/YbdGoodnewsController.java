package com.buba.ybd.controller;

import com.buba.ybd.service.YbdGoodnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("goodnews")
public class YbdGoodnewsController {
    @Autowired
    private YbdGoodnewsService ybdGoodnewsService;
}
