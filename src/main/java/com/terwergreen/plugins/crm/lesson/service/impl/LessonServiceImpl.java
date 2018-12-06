package com.terwergreen.plugins.crm.lesson.service.impl;

import com.alibaba.fastjson.JSON;
import com.terwergreen.core.CommonDAO;
import com.terwergreen.plugins.crm.lesson.service.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务实现
 *
 * @author Terwer
 * @version 1.0
 * 2018/12/06 13:35:50
 **/
@Service
public class LessonServiceImpl implements LessonService {
    private static final Logger log = LoggerFactory.getLogger(LessonServiceImpl.class);

    @Autowired
    private CommonDAO commonDAO;

    @Override
    public String getLessonInfo() {
        List list = null;
        try {
            Map paramMap = new HashMap();
            paramMap.put("optionGroup", "siteConfig");
            list = commonDAO.queryListByMap("getOptionByGroup", paramMap);
        } catch (Exception e) {
            log.error("获取配置项异常", e);
            return "current version:BuguCMS 2.0.0";
        }
        //多个结果返回List，只有一个结果的时候直接返回
        if (!CollectionUtils.isEmpty(list)) {
            return JSON.toJSONString(list);
        }
        return "no data";
    }
}
