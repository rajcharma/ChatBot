package com.example.zy5545269.seapp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvisorTest {

    private String data= Advisor.getData().get(0).toString();


    String advisor = "Advisor：" + "Nice to meet you！";

    @Test
    public void testAdvisorSay()
    {
        assertEquals(advisor, data);
    }
}
