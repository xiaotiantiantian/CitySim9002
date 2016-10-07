/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.Validator;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers
 * @author Zhirun Tian
 */
public class CitySim9002 {

    public static String errorMessage = "Please enter one integer argument, seed";

    public static void main(String[] args) {
        if (new Validator().validateArguments(args)) {
            PeopleGenerator gen = new PeopleGenerator(Integer.parseInt(args[0]));
            System.exit(0);
        } else {
            System.out.println(errorMessage);
            System.exit(-1);
        }
    }
}
