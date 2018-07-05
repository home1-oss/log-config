package cn.home1.logging.logback.service;

import ch.qos.logback.classic.LoggerContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

/**
 * Created by: Song Feng
 * Created time: 2018/7/5
 * Description:
 */

@Service
public class LogService {

    public void doLog(String loggerName, Level level, String message) throws RuntimeException {
        Logger logger;
        if (StringUtils.isNotBlank(loggerName)) {
            logger = LoggerFactory.getLogger(loggerName);
        } else {
            logger = LoggerFactory.getLogger(LogService.class);
        }

        switch (level) {
            case TRACE:
                logger.trace(message);
                break;
            case DEBUG:
                logger.debug(message);
                break;
            case INFO:
                logger.info(message);
                break;
            case WARN:
                logger.warn(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            default:
                throw new RuntimeException("unknown log level: " + level.name());
        }

    }

    public String getLogProperty(String propertyName) {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        return lc.getProperty(propertyName);
    }
}
