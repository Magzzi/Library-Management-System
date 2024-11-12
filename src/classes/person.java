package classes;

class Person {
    private String name;
    private int age;
    private String address;
    private int personId;

    
    //Constructor w/ no parameters
    public Person(){
        System.out.println("Java");
    }

    //Constructor w/ parameters
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getAge() {
            return age;
        }

    public String getAddress() {
        return address;
    }

    public int getPersonId(){
        return personId;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPersonId(int personId){
        this.personId = personId;
    }
}