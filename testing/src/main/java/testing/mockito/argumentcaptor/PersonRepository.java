package testing.mockito.argumentcaptor;

public class PersonRepository {
  public void save(Person person) {
    System.out.println("Saving person");
  }

  public Person update(Person person) {
    return person;
  }

  public Person select(Person first, Person second, Person third) {
    return first;
  }

  public void delete(Person person) {
    System.out.println("Deleting");
  }
}
