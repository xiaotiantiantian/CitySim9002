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
    
    public PeopleGenerator(int seed) {
        people = new People();
        Random rand = new Random(System.currentTimeMillis() + seed);
        int i = rand.nextInt(3) + 1;
        People.VisitorType vt = People.VisitorType.fromCode(i);
        List<Integer> PersonAlreadyGenerated = new ArrayList<Integer>();

        while (PersonAlreadyGenerated.size() < 5) {
            people.Visit(vt, seed, PersonAlreadyGenerated.size()+1);
            PersonAlreadyGenerated.add(i);
        }
    }
}
