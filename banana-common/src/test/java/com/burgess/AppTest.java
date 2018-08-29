package com.burgess;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.burgess.common.date.DateFormatFactory;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void currentStartTime() {
    	System.out.println(DateFormatFactory.currentStartTime());
    }
}
