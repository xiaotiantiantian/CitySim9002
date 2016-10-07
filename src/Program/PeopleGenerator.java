/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Zhirun Tian
 */
public class PeopleGenerator {

    private People people;
    public int numbers;

    public PeopleGenerator(int seed) {
        numbers = 0;
        this.Generator(seed);
    }

    public int Generator(int seed) {
        people = new People();

        int i = GenerateRandomInt(seed + (int) System.currentTimeMillis());
        People.VisitorType vt = People.VisitorType.fromCode(i);
//        List<Integer> PersonAlreadyGenerated = new ArrayList<Integer>();

//        while (PersonAlreadyGenerated.size() < 5) {
        while (numbers < 5) {
            people.Visit(vt, i, numbers + 1);
//            PersonAlreadyGenerated.add(i);
            numbers++;
        }

        if (numbers> 5) {
            System.out.println("Error people more than 5");
            return -1;
        }

        return 0;
    }

    public int GenerateRandomInt(int seed) {
        Random rand = new Random(seed);
        //control the range from 1-4
        int i = rand.nextInt(3) + 1;
        return i;
    }

//    public boolean ControlPersonNumber(int p){
//        
//    }
}
