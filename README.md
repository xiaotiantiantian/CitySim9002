IS2545 - DELIVERABLE 2: Unit Testing

Issues:

Firstly, I have some trouble to write the classes with the method of unit test, which means I should make the functions to be several different classes and the classes should call each other to run the program. Then I rewrite the program several times to make it better in testing and easier in testing.

Secondly, the original function has a return value in the main function, which is confused me because it was given by teacher. But then I find the return type of the main function in java should be void. So I change the return value to be nothing and use System.exit(0) and System.exit(1) as a return of problem or no error accrued.

Thirdly. there is also some problem in understanding the mock and stub. The difference, finally I thought, the former one would stimulate an external class and the stub is only stimulating a value in a function.


Classes and testing cases:

There are 4 classes in the program:
CitySim9002 is the main class, it use the class Validator, PeopleGenerator.
Class PeopleGenerator use Class People.