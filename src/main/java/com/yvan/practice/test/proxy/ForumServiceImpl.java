package com.yvan.practice.test.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yvan on 2016/12/19.
 */
public class ForumServiceImpl implements ForumService {

    Logger logger = LoggerFactory.getLogger(ForumServiceImpl.class);
    @Override
    public void removeTopic(int topicId) {
        logger.info("remove the Topic record: " + topicId);
    }

    @Override
    public void removeForum(int forumId) {
        logger.info("remove the Forum record: " + forumId);
    }
}
