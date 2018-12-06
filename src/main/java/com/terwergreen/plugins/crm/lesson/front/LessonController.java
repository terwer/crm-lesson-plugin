package com.terwergreen.plugins.crm.lesson.front;

import com.terwergreen.plugins.crm.lesson.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 *
 * @author Terwer
 * @version 1.0
 * 2018/11/29 1:23
 **/
@Controller
@RequestMapping("lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @RequestMapping(produces = {"text/plain;charset=utf-8"})
    @ResponseBody
    public String lesson() {
        return lessonService.getLessonInfo();
    }
}
