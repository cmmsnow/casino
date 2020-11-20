package io.zipcoder.casino.Utilities;

import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;

import static org.mockito.Mockito.mock;

//@RunWith(EasyMockRunner.class)
public class InputTest {
    @Mock
    private Input input;

    public static byte[] toByteArray(double value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble(value);
        return bytes;
    }

    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }

    @org.junit.Before
    public void setUp() throws Exception {
        input = new Input(System.in, System.out);
        MockitoAnnotations.initMocks(input);
    }
//    public void setUp() throws Exception {
//        //MockitoAnnotations.initMocks(this);
//
//    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void TestGetStringInput() throws Exception{
        String expectedInput = "christine";
        System.setIn(new ByteArrayInputStream(expectedInput.getBytes()));

        Input input = new Input(System.in, System.out);
        String actualInput = input.getStringInput(expectedInput);
        Assert.assertEquals(expectedInput, actualInput);
    }

    @org.junit.Test
    public void TestGetDoubleInput() throws Exception{
        Double expectedInput = Double.parseDouble("9.9");
        System.setIn(new ByteArrayInputStream("9.9".getBytes()));

        Input input = new Input(System.in, System.out);
        Double actualInput = input.getDoubleInput("9.9");
        Assert.assertEquals(expectedInput, actualInput);
    }

    @org.junit.Test
    public void TestGetLongInput() throws Exception{
        Long expectedInput = Long.decode("9");
        System.setIn(new ByteArrayInputStream("9".getBytes()));

        Input input = new Input(System.in, System.out);
        Long actualInput = input.getLongInput("9");
        Assert.assertEquals(expectedInput, actualInput);
    }

    @org.junit.Test
    public void TestGetIntegerInput() throws Exception{
        Integer expectedInput = Integer.decode("9");
        System.setIn(new ByteArrayInputStream("9".getBytes()));

        Input input = new Input(System.in, System.out);
        Integer actualInput = input.getIntegerInput("9");
        Assert.assertEquals(expectedInput, actualInput);
    }
}
