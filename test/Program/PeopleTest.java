/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Program.People.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author Zhirun Tian
 */
public class PeopleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public PeopleTest() {
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    /**
     * Test of Visit method, of class People.
     */
    //test the function getcode of class Location
    @Test
    public void FromEnumLocationGetTest() {
        Location loc = Location.CathedralOfLearning;
        Assert.assertEquals(loc.getCode(), 1);

    }

    //test double
    //in the function Visit, it use external class Random
    //so just use mockito to mock the class and return certain vaule
    //then look would the visitor leave the 1st time
    @Test
    public void VisitNotLeaveFirstTimeTest() {
        boolean FirstVisit = true;
        Random mockRand = mock(Random.class);
        when(mockRand.nextInt(anyInt())).thenReturn(4);
        Location lo;
        lo = Location.fromCode(mockRand.nextInt(4) + 1);
        while ((lo == Location.Leave) && FirstVisit) {
            //lo:location 1-5 
            lo = Location.fromCode(1);
        }
        //the first time locatioin could not be Leave
        Assert.assertFalse(lo == Location.Leave);
    }

    //stub test
    //first set the location be SquirrelHill(2)
    //then test would the inner code is 2, which means the object is Squirrel Hill
    @Test
    public void FromEnumLocationSetByIntTest() {
        Location lo = Location.fromCode(2);
        Assert.assertEquals(lo.getCode(), 2);

    }

    //would the output stream have ***　when the visitor leave?
    @Test
    public void LeaveWithOutput3StarTest() {
        People people = new People();
        people.Visit(VisitorType.Student, 1, 1);
        Assert.assertTrue(outContent.toString().contains("***"));
    }

 
}
