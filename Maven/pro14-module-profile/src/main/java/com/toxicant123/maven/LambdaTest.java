package com.toxicant123.maven;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-04-06 20:16
 */
public class LambdaTest {
    public static void main(String[] args) {

        new Thread(()-> System.out.println("hello")).start();

    }
}
