package com.zh.io.input;

import org.junit.Test;


public class inputTest {
    @Test
    public void testInput(){
        input input = new input();
        try {
            input.testFileOutStrem();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}