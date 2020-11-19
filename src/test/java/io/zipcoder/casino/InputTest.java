package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;
import org.junit.Assert;

import static org.mockito.Mockito.mock;

public class InputTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void TestGetStringInput() throws Exception{
        //Input input = new Input(System.in, System.out);
        Input input = mock(Input.class);
        when(input.getIntInput("prompt")).thenReturn("Yo");
        String expected = "Yo";
        Boolean actual = output.getPlayerType();
        Assert.assertEquals(,actual);
    }

    @org.junit.Test
    public void TestGetDoubleInput() throws Exception{
        //expected
        //when
        //actual
        //assert
    }

    @org.junit.Test
    public void TestGetLongInput() throws Exception{
        //expected
        //when
        //actual
        //assert
    }

    @org.junit.Test
    public void TestGetIntegerInput() throws Exception{
        //expected
        //when
        //actual
        //assert
    }
}
