package com.hannt.example.sequence.config;

import com.hannt.example.sequence.dao.SequenceDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SequenceRootConfigTest {
    @Test
    public void sequenceDaoTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceRootConfig.class);
        SequenceDao sequenceDao = context.getBean(SequenceDao.class);

        assertNotNull(sequenceDao);

        assertEquals(10000, sequenceDao.getNextValue("IT"));
        assertEquals(10001, sequenceDao.getNextValue("IT"));
    }
}
