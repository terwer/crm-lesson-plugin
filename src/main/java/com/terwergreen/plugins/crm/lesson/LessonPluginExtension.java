package com.terwergreen.plugins.crm.lesson;

import com.terwergreen.plugins.PluginInterface;
import com.terwergreen.plugins.crm.lesson.front.LessonApi;
import com.terwergreen.plugins.crm.lesson.front.LessonController;
import com.terwergreen.plugins.crm.lesson.service.impl.LessonServiceImpl;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 扩展点
 *
 * @author Terwer
 * @version 1.0
 * 2018/12/06 13:35:50
 **/
@Extension
public class LessonPluginExtension implements PluginInterface {
    private static final Logger logger = LoggerFactory.getLogger(LessonPluginExtension.class);
    private GenericApplicationContext applicationContext;

    public LessonPluginExtension(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        logger.info("LessonPluginExtension contructor");
        // 注册插件依赖
        registerBeans();
    }

    private void registerBeans() {
        applicationContext.registerBean(LessonController.class);
        logger.info("LessonPluginExtension registerBean " + LessonController.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(LessonApi.class);
        logger.info("LessonPluginExtension registerBean " + LessonApi.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(LessonServiceImpl.class);
        logger.info("LessonPluginExtension registerBean " + LessonServiceImpl.class + " in applicationContext " + applicationContext);
    }

    @Override
    public String identify() {
        return "LessonPlugin identify in plugin";
    }

    @Override
    public List<?> reactiveRoutes() {
        return new ArrayList<RouterFunction<?>>() {{
        }};
    }

    @Override
    public Map data() {
        Map dataMap = new HashMap();
        dataMap.put("lesson", "Lesson");
        return dataMap;
    }
}
