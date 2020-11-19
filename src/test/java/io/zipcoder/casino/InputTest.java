package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;

//@RunWith(EasyMockRunner.class)
public class InputTest {
    @Mock
    private Input input;

    @org.junit.Before
    public void setUp() throws Exception {
        input = new Input(System.in, System.out);
        MockitoAnnotations.initMocks(input);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void TestGetStringInput() throws Exception{
        //Input input = mock(Input.class);
        Mockito.when(input.getIntInput("prompt")).thenReturn("Yo");
        String expected = "Yo";
        Boolean actual = output.getPlayerType();
        Assert.assertEquals(expected, actual);
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
