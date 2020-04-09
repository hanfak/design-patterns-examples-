package testing.mockito.inorder;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import testing.mockito.MyList;

import java.util.List;

import static org.mockito.Mockito.mock;

public class InOrderTest {

  @Test
  public void exampleOne() {
    List<String> mockedList = mock(MyList.class);
    mockedList.size();
    mockedList.add("a parameter");
    mockedList.clear();

    InOrder inOrder = Mockito.inOrder(mockedList);
    inOrder.verify(mockedList).size();
    inOrder.verify(mockedList).add("a parameter");
    inOrder.verify(mockedList).clear();
  }
}