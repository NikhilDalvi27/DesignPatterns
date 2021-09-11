package Builder;

public class User
{
    //All final attributes of the User Class
    //which will be initialized only once in the Constructor

    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional


    //Parameterized Constructor which will receive Builder Object as the Parameter
    //Fields of the User Class are initialised using Builder Object

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //All getter, and NO setter to provide immutability  NOTE
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }

    // Note Make Builder as a Static Class,
    // so that no need to create an Object of User Class First
    // so as to create Object of UserBuilder

    public static class UserBuilder
    {
        //Only the Mandatory fields are Final
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        //Initialize with the Mandatory Parameters
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        //In all the below methods set the return type to be UserBuilder itself
        // Methods are for setting the Optional Parameters

        public UserBuilder age(int age) {
            this.age = age;     //Note set the input parameters on the Current Object
            return this;        //And then return the Current Object
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        //Return the finally constructed User object
        //This method will return the Object of type User and not UserBuilder
        //and will call the constructor of User passing UserBuilder Object as a Parameter

        public User build() {

            //Here
            User user =  new User(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(User user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
    public static void main(String[] args) {
        //Initialize Builder Object with the Mandatory Parameters
        //For the optional Parameter use the methods of the Builder Class


        User user1 = new User.UserBuilder("Lokesh", "Gupta")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();

        System.out.println(user1);

        User user2 = new User.UserBuilder("Jack", "Reacher")
                .age(40)
                .phone("5655")
                //no address
                .build();

        System.out.println(user2);

        User user3 = new User.UserBuilder("Super", "Man")
                //No age
                //No phone
                //no address
                .build();

        System.out.println(user3);
    }
}

