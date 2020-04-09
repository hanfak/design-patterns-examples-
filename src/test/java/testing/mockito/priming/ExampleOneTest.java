package testing.mockito.priming;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import testing.mockito.MyList;
import testing.mockito.argumentcaptor.Person;
import testing.mockito.argumentcaptor.PersonRepository;
import testing.mockito.argumentcaptor.PersonService;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class ExampleOneTest {

  private PersonRepository personRepository = mock(PersonRepository.class);
  private PersonService personService = new PersonService(personRepository);

  @Test
  public void shouldReturnFirstPerson() {
    Person firstPerson = new Person("first");
    Person secondPerson = new Person("second");
    Person thirdPerson = new Person("third");

    Mockito.when(personRepository.select(firstPerson, secondPerson, thirdPerson))
            .thenAnswer((Answer<Person>) invocation -> invocation.getArgument(0));

    Person actual = personService.select(firstPerson, secondPerson, thirdPerson);

    Assertions.assertThat(actual).isEqualTo(firstPerson);
  }

  @Test
  public void shouldCallRealMethod() {
    Person firstPerson = new Person("first");
    Person secondPerson = new Person("second");
    Person thirdPerson = new Person("third");
    Person other = new Person("other");
    Mockito.when(personRepository.select(firstPerson, secondPerson, thirdPerson))
            .thenAnswer((Answer<Person>) invocation -> (Person) invocation.callRealMethod());
//    doAnswer(invocationOnMock -> invocationOnMock.callRealMethod()).when(personRepository).select(firstPerson, secondPerson, thirdPerson);
    Person actual = personService.select(firstPerson, secondPerson, thirdPerson);
    Assertions.assertThat(actual).isEqualTo(firstPerson);

  }

  @Test
  public void _3() {
    MyList listMock = mock(MyList.class);
    doAnswer(invocation -> "Always the same").when(listMock).get(anyInt());

    String element = listMock.get(1);
    assertThat(element, is(equalTo("Always the same")));

  }
}
