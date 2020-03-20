package testing.mockito.argumentcaptor;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

// Use of annotations for mockito
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {


  @InjectMocks
  private PersonService personService;

  @Mock
  private PersonRepository personRepository;

  // The two above lines Same as
  // private final PersonRepository personRepository = mock(PersonRepository.class);
  // private final PersonService personService = new PersonService(personRepository);

  @Captor
  private ArgumentCaptor<Person> captor;
  // same as
  // private final ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class)

  @Test
  public void shouldCapture() {
    Person person = new Person("test");

    personService.delete(person);

    Mockito.verify(personRepository).delete(captor.capture());

    Person captured = captor.getValue();

    Assertions.assertThat(captured.getName()).isEqualTo("deleted");
  }

  @Test
  public void shouldCaptureMultipleTimes() {
    personService.delete(new Person("test"));
    personService.delete(new Person("test"));

    Mockito.verify(personRepository, Mockito.times(2)).delete(captor.capture());

    List<Person> allValues = captor.getAllValues();

    for (Person captured : allValues) {
      Assertions.assertThat(captured.getName()).isEqualTo("deleted");
    }
  }
}