package com.terwergreen.plugins.crm.lesson;

import com.terwergreen.plugins.BugucmsPlugin;
import org.pf4j.PluginException;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 插件
 *
 * @author Terwer
 * @version 1.0
 * 2018/12/06 13:35:50
 **/
public class LessonPlugin extends BugucmsPlugin {
    private static final Logger logger = LoggerFactory.getLogger(LessonPlugin.class);

    public LessonPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() throws PluginException {
        super.start();
        logger.info("LessonPlugin started");
    }

    @Override
    public void stop() {
        super.stop();
        logger.info("LessonPlugin stoped");
    }
}
