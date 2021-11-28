package testing.mockito.argumentcaptor;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import testing.mockito.MyList;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExampleTest {
  @Test
  public void _1() {
    List<String> mockedList = mock(MyList.class);
    mockedList.addAll(Lists.newArrayList("someElement"));
    ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
    verify(mockedList).addAll(argumentCaptor.capture());
    List<String> capturedArgument = argumentCaptor.getValue();
    assertThat(capturedArgument, hasItem("someElement"));
  }
}
