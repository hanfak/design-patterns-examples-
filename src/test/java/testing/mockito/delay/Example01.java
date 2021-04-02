package testing.mockito.delay;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.AnswersWithDelay;
import org.mockito.internal.stubbing.answers.Returns;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import testing.mockito.argumentcaptor.Person;
import testing.mockito.argumentcaptor.PersonRepository;
import testing.mockito.argumentcaptor.PersonService;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Example01 {

  private final PersonRepository personRepository = mock(PersonRepository.class);
  private final PersonService personService = new PersonService(personRepository);

  @Test
  public void delayResponseOfDelegatedMethodUsingThreadSleep() {
    Person firstPerson = new Person("first");
    Person secondPerson = new Person("second");
    Person thirdPerson = new Person("third");

    when(personRepository.select(firstPerson, secondPerson, thirdPerson)).thenAnswer(new Answer<Person>() {
      @Override
      public Person answer(InvocationOnMock invocation) throws InterruptedException {
        Thread.sleep(5000);
        return firstPerson;
      }
    });

    Person actual = personService.select(firstPerson, secondPerson, thirdPerson);

    Assertions.assertThat(actual).isEqualTo(firstPerson);
  }

  @Test
  public void delayResponseOfDelegatedMethodUsingMocktio() {
    Person firstPerson = new Person("first");
    Person secondPerson = new Person("second");
    Person thirdPerson = new Person("third");

    doAnswer(new AnswersWithDelay(5000, new Returns(firstPerson)))
        .when(personRepository).select(firstPerson, secondPerson, thirdPerson);

    Person actual = personService.select(firstPerson, secondPerson, thirdPerson);

    Assertions.assertThat(actual).isEqualTo(firstPerson);
  }
}
