package filesapi.domain;

public class PersonOne {
    private String name;
    private Integer age;
    private Boolean male;
    private String pets;
    private String city;

    public PersonOne(String name, Integer age, Boolean male, String pets, String city) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.pets = pets;
        this.city = city;
    }

    public PersonOne() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
