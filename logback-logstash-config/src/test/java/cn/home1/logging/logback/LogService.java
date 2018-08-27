package cn.home1.logging.logback;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.LoggerContext;

/**
 * Created by: Song Feng
 * Created time: 2018/7/5
 * Description:
 */
@Service
public class LogService {

  public void doLog(final String loggerName, final Level level, final String message) {
    this.doLog(loggerName, null, level, message);
  }

  public void doLog(final String loggerName, final Marker marker, final Level level, final String message) {
    final Logger logger = isNotBlank(loggerName) ? //
        LoggerFactory.getLogger(loggerName) : LoggerFactory.getLogger(LogService.class);

    switch (level) {
      case TRACE: {
        logger.trace(marker, message);
        break;
      }
      case DEBUG: {
        logger.debug(marker, message);
        break;
      }
      case INFO: {
        logger.info(marker, message);
        break;
      }
      case WARN: {
        logger.warn(marker, message);
        break;
      }
      case ERROR: {
        logger.error(marker, message);
        break;
      }
      default: {
        throw new IllegalArgumentException("unknown log level: " + level.name());
      }
    }
  }

  public String getLogProperty(final String propertyName) {
    final LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    return lc.getProperty(propertyName);
  }
}
