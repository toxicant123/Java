package com.toxicant123.maven;

import org.junit.Test;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-29 1:04
 */
public class HelloTest {
    @Test
    public void testHello(){
        Hello hello = new Hello();
        hello.showMessage();
    }
}
