package com.xenoamess.x8l.springframework.context;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathX8lApplicationContextTest {
    /**
     * this test is for original xml test.
     * if even this test fails please recheck your environment.
     */
    @Test
    public void testOriginalXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("testBean.xml");
        TestClass testClass = context.getBean("test", TestClass.class);
        Assertions.assertEquals("testtesttest",testClass.getA());
    }

    @Test
    public void testX8l() {
        ClassPathX8lApplicationContext context = new ClassPathX8lApplicationContext("testBean.xml.gen.x8l");
        TestClass testClass = context.getBean("test", TestClass.class);
        Assertions.assertEquals("testtesttest",testClass.getA());
    }

    @Test
    public void testGeneratedXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("testBean.xml.gen.x8l.gen.xml");
        TestClass testClass = context.getBean("test", TestClass.class);
        Assertions.assertEquals("testtesttest",testClass.getA());
    }

    @Test
    public void testXml() {
        ClassPathX8lApplicationContext context = new ClassPathX8lApplicationContext("testBean.xml");
        TestClass testClass = context.getBean("test", TestClass.class);
        Assertions.assertEquals("testtesttest",testClass.getA());
    }

}
