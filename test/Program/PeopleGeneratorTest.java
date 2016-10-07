/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author Zhirun Tian
 */
public class PeopleGeneratorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

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
    public PeopleGeneratorTest() {
    }

    //test double
    //test whether the class could return "it is right " when the input is right 
    @Test
    public void VisitTypeTest() {
        People testP = mock(People.class);
        when(testP.Visit(People.VisitorType.Student, 1, 1)).thenReturn(0);
        int i = testP.Visit(People.VisitorType.Student, 1, 1);
        Assert.assertEquals(0, i);

    }

    //test double
    //test the number of visitor is 5
    //it use the function Visit of exteral class People
    //so just mock the function Visit
    @Test
    public void VisitNumberIsFiveTest() {
        People people = mock(People.class);
        when(people.Visit(People.VisitorType.Student, 1, 1)).thenReturn(0);
        Random rand = new Random(System.currentTimeMillis() + 1);
        int i = rand.nextInt(3) + 1;

        List<Integer> PersonAlreadyGenerated = new ArrayList<Integer>();

        while (PersonAlreadyGenerated.size() < 5) {
            people.Visit(People.VisitorType.Student, 1, 1);
            PersonAlreadyGenerated.add(i);
        }
        verify(people, times(5)).Visit(People.VisitorType.Student, 1, 1);

    }

    @Test
    public void VisitNumberMoreThan5Test() {
        People people = mock(People.class);
        Random rand = new Random(System.currentTimeMillis() + 1);
        int i = rand.nextInt(3) + 1;
        People.VisitorType vt = People.VisitorType.fromCode(i);
        List<Integer> PersonAlreadyGenerated = new ArrayList<Integer>();

        while (PersonAlreadyGenerated.size() < 5) {
            people.Visit(vt, 1, PersonAlreadyGenerated.size() + 1);
            PersonAlreadyGenerated.add(i);
        }

        if (PersonAlreadyGenerated.size() > 5) {
            System.out.println("Error people more than 5");
        }
    }

    //stub test
    //if inputed argument is a negative number 
    //it would work as a positive number
    @Test
    public void WhenSeedIsNegativeTest() {
        int seed  = -1;
        PeopleGenerator p = new PeopleGenerator(seed);
        Assert.assertEquals(0, p.Generator(seed));

    }
    
    //stub test 
    //if the generated people is more than 5
    //it would return -1 as an error
    //make seed as a constant number in test and make peopel generated count more than 5
    @Test
    public void WhenGeneratedMoreThan5Test(){
        int seed = 2;
        PeopleGenerator p = new PeopleGenerator(seed);
        p.numbers = 6;
        Assert.assertEquals(p.Generator(seed), -1);
    }
    
    //stub test 
    //the output of GenerateRandomInt is from 1-4
    @Test
    public void GenerateRandom1to4Test(){
        int seed = 2;
        PeopleGenerator p = new PeopleGenerator(seed);
        Assert.assertTrue((p.GenerateRandomInt(seed)>=1)&&(p.GenerateRandomInt(seed)<=4));
        
    }

}
