                                                                                                                                                                                                                                                                                       /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.EnumMap;
import java.util.Random;

/**
 *
 * @author Zhirun Tian
 */
public class People {

    public String Visitor;
    EnumMap<VisitorType, EnumMap<Location, Integer>> PeoplePreferLocation;
    EnumMap<Location, Integer> PreferLocation;
    public People() {
        PeoplePreferLocation = new EnumMap<VisitorType, EnumMap<Location, Integer>>(VisitorType.class);
        PreferLocation = new EnumMap<Location, Integer>(Location.class);

        //the preference of student
        PreferLocation.put(Location.CathedralOfLearning, -1);
        PreferLocation.put(Location.ThePoint, 1);
        PreferLocation.put(Location.SquirrelHill, 1);
        PreferLocation.put(Location.Downtown, 1);
        PreferLocation.put(Location.Leave, 1);
//        new EnumMap<Location, Integer>
        PeoplePreferLocation.put(VisitorType.Student, new EnumMap<Location, Integer>(PreferLocation));
        PreferLocation.clear();
        //the preference of Professor
        PreferLocation.put(Location.CathedralOfLearning, 1);
        PreferLocation.put(Location.ThePoint, 1);
        PreferLocation.put(Location.SquirrelHill, 1);
        PreferLocation.put(Location.Downtown, 1);
        PreferLocation.put(Location.Leave, 1);
        PeoplePreferLocation.put(VisitorType.Professor,  new EnumMap<Location, Integer>(PreferLocation));
        PreferLocation.clear();
        //the preference of BusinessPerson
        PreferLocation.put(Location.CathedralOfLearning, -1);
        PreferLocation.put(Location.ThePoint, -1);
        PreferLocation.put(Location.SquirrelHill, 1);
        PreferLocation.put(Location.Downtown, 1);
        PreferLocation.put(Location.Leave, 1);
        PeoplePreferLocation.put(VisitorType.BusinessPerson,  new EnumMap<Location, Integer>(PreferLocation));
        PreferLocation.clear();
        //the preference of Blogger
        PreferLocation.put(Location.CathedralOfLearning, -1);
        PreferLocation.put(Location.ThePoint, -1);
        PreferLocation.put(Location.SquirrelHill, -1);
        PreferLocation.put(Location.Downtown, -1);
        PreferLocation.put(Location.Leave, 1);
        PeoplePreferLocation.put(VisitorType.Blogger,  new EnumMap<Location, Integer>(PreferLocation));
        PreferLocation.clear();

    }

    public enum VisitorType {
        Student(1), Professor(2), BusinessPerson(3), Blogger(4);
        private int code;

        private VisitorType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static VisitorType fromCode(int id) {
            for (VisitorType type : VisitorType.values()) {
                if (type.getCode() == id) {
                    return type;
                }
            }
            return null;
        }
    }

    public enum Location {
        CathedralOfLearning(1), SquirrelHill(2), ThePoint(3), Downtown(4), Leave(5);
        private int code;

        private Location(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static Location fromCode(int id) {
            for (Location type : Location.values()) {
                if (type.getCode() == id) {
                    return type;
                }
            }
            return null;
        }

    }

    //times means the times the function be run, in another word, the Xnd visitor
    public int Visit(VisitorType vt, int seed, int times) {
        System.out.println("Visitor "+times+" is a "+vt.name());
        boolean FirstVisit = true;
        Random rand = new Random(System.currentTimeMillis() + seed);
        Location lo;
        lo = Location.fromCode(rand.nextInt(4) + 1);
        while ((lo == Location.Leave) && FirstVisit) {
            //lo:location 1-5 
            lo = Location.fromCode(rand.nextInt(4) + 1);
        }

        while (lo != Location.Leave) {
            System.out.println("Visitor "+times+" is going to" + lo);
            String prefer = "";
            int p = PeoplePreferLocation.get(vt).get(lo);
            if (p == 1) {
                prefer = "like";
            } else {
                prefer = "not like";
            }
            System.out.println("Visitor "+times+" did " + prefer + " " + lo);
            lo = Location.fromCode(rand.nextInt(5) + 1);
        }
        while (lo == Location.Leave) {
            System.out.println("Visitor "+times+" has left the city");
            System.out.println("***");
            return 0;
        }

        return 0;
    }

}
