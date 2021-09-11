package CreationalDesignPatterns;

/*
Where to use
-This is used when creating Complex Immutable Object (Properties shouldn't be changed once initialized)
Having too many parameters, which are difficult to specify in the constructor
This can be a problem when someone want to create an object
He needs to know what that parameters mean and pass them in correct sequence

-we have a complex process to construct an Object involving multiple steps

Builder Pattern Helps us to avoid writing such constructors
and still have our objects immutable


In Builder we remove the logic related to Object Construction
from "client" code  and abstract it in seperate class


 */


import java.util.Date;
import java.util.List;

public class BuilderIntro {

}


class Address{
        public Address(String HouseNumber,String street){

        }

}

class User{
    //Address Object and Roles Object are the parts used to assemble our User Object
    //Also We have to First Create the Address Object and Multiple Roles Object
    //so there are steps that we need to follow before creating the user object

    public User(String name, Address address, Date birthDate, List<Role> roles )
    {

    }

}

class Role{
    public Role(){

    }
}