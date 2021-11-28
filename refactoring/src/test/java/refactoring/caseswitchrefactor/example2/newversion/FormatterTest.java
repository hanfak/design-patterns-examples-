package refactoring.caseswitchrefactor.example2.newversion;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FormatterTest implements WithAssertions {

  @Test
  public void returnNull() {
    Service mockService = mock(Service.class);

    Formatter formatter = new Formatter(mockService);
    assertThatThrownBy(() -> formatter.doTheJob("blah"))
            .isInstanceOf(NullPointerException.class);
  }

  @Test
  public void returnError() {
    Service mockService = mock(Service.class);
    when(mockService.askForPermission()).thenReturn(Response.FAIL);

    Formatter formatter = new Formatter(mockService);
    assertThat(formatter.doTheJob("blah")).isEqualTo("error");
  }

  @Test
  public void returnFormattedString() {
    Service mockService = mock(Service.class);
    when(mockService.askForPermission()).thenReturn(Response.OK);

    Formatter formatter = new Formatter(mockService);
    assertThat(formatter.doTheJob("blah")).isEqualTo("blahblah");
  }
}