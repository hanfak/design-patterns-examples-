package testing.mockito.priming;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import testing.mockito.argumentcaptor.Person;
import testing.mockito.argumentcaptor.PersonRepository;
import testing.mockito.argumentcaptor.PersonService;

import static org.mockito.Mockito.mock;

public class ExampleTest {

  // cannot use final due to  annotations
  @InjectMocks
  private PersonService personService;
  @Mock
  private PersonRepository personRepository;

  @Test
  public void shouldReturnFirstArg() {
    Person firstPerson = new Person("first");
    Person secondPerson = new Person("second");
    Person thirdPerson = new Person("third");
    Mockito.when(personRepository.select(firstPerson, secondPerson, thirdPerson))
            .then(AdditionalAnswers.returnsFirstArg());

    Person actual = personService.select(firstPerson, secondPerson, thirdPerson);

    Assertions.assertThat(actual).isEqualTo(firstPerson);
  }

  @Test
  public void shouldReturnSecondArg() {
    Person firstPerson = new Person("first");
    Person secondPerson = new Person("second");
    Person thirdPerson = new Person("third");

    Mockito.when(personRepository.select(firstPerson, secondPerson, thirdPerson))
            .then(AdditionalAnswers.returnsSecondArg());

    Person actual = personService.select(firstPerson, secondPerson, thirdPerson);

    Assertions.assertThat(actual).isEqualTo(secondPerson);
  }

  @Test
  public void shouldReturnLastArg() {
    Person firstPerson = new Person("first");
    Person secondPerson = new Person("second");
    Person thirdPerson = new Person("third");
    Mockito.when(personRepository.select(firstPerson, secondPerson, thirdPerson)).then(AdditionalAnswers.returnsLastArg());

    Person actual = personService.select(firstPerson, secondPerson, thirdPerson);

    Assertions.assertThat(actual).isEqualTo(thirdPerson);
  }

  @Test
  public void shouldReturnArgAt() {
    Person firstPerson = new Person("first");
    Person secondPerson = new Person("second");
    Person thirdPerson = new Person("third");
    Mockito.when(personRepository.select(firstPerson, secondPerson, thirdPerson))
            .then(AdditionalAnswers.returnsArgAt(1));

    Person actual = personService.select(firstPerson, secondPerson, thirdPerson);

    Assertions.assertThat(actual).isEqualTo(secondPerson);
  }

  @Test
  public void shouldReturnDefaultPerson() {
    PersonRepository personRepository = mock(PersonRepository.class);
    PersonService personService = new PersonService(personRepository);
    Person defaultPerson = new Person("default");
    Mockito.when(personRepository.update(Mockito.any(Person.class))).thenReturn(defaultPerson);

    Person actual = personService.update(new Person("test"));
    Assertions.assertThat(actual).isEqualTo(defaultPerson);
  }

  @Test
  public void shouldDefineMultipleExpectations() {
    PersonRepository personRepository = mock(PersonRepository.class);
    PersonService personService = new PersonService(personRepository);
    Person firstExpected = new Person("first");
    Person secondExpected = new Person("second");
    Mockito.when(personRepository.update(Mockito.any(Person.class))).thenReturn(firstExpected).thenReturn(secondExpected);

    Person firstPerson = personService.update(new Person("test"));

    Assertions.assertThat(firstPerson).isEqualTo(firstExpected);

    Person secondPerson = personService.update(new Person("test"));

    Assertions.assertThat(secondPerson).isEqualTo(secondExpected);
  }

  @Test // fails
  public void shouldNotDefineMultipleExpectations() {
    PersonRepository personRepository = mock(PersonRepository.class);
    PersonService personService = new PersonService(personRepository);
    Person firstExpected = new Person("first");
    Person secondExpected = new Person("second");
    Mockito.when(personRepository.update(Mockito.any(Person.class))).thenReturn(firstExpected);
    Mockito.when(personRepository.update(Mockito.any(Person.class))).thenReturn(secondExpected);
    Person firstPerson = personService.update(new Person("test"));
    // Will fail!
    Assertions.assertThat(firstPerson).isEqualTo(firstExpected);
    Person secondPerson = personService.update(new Person("test"));
    Assertions.assertThat(secondPerson).isEqualTo(secondExpected);
  }


}
