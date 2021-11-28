package testing.mockito.spies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import testing.mockito.MyList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SpiesTest {
  @Test
  public void _1() {
    //verify simple invocation on mock
    List<String> mockedList = mock(MyList.class);
    mockedList.size();
    verify(mockedList).size();
  }

  @Test
  public void _2() {
    //verify number of interactions with mock
    List<String> mockedList = mock(MyList.class);
    mockedList.size();
    mockedList.size();
    verify(mockedList, times(2)).size();
    verify(mockedList, never()).clear();
  }

  @Test
  public void _3() {
    //verify no interactions with mock
    List<String> mockedList = mock(MyList.class);

    verify(mockedList, Mockito.never()).size();
    verifyZeroInteractions(mockedList);
    verify(mockedList, times(0)).size();
  }

  @Test
  public void _4() {
    // verify there are no unexpected interactions – this should fail
    List<String> mockedList = mock(MyList.class);
    mockedList.size();
    mockedList.clear();
    verify(mockedList).size();
//    verifyNoMoreInteractions(mockedList); //fails
  }

  @Test
  public void _5() {
    //verify an interaction has occurred at least certain number of times
    List<String> mockedList = mock(MyList.class);
    mockedList.clear();
    mockedList.clear();
    mockedList.clear();

    verify(mockedList, atLeast(1)).clear();
    verify(mockedList, atMost(10)).clear();
  }

  @Test
  public void _6() {
//    verify interaction with exact argument
    List<String> mockedList = mock(MyList.class);
    mockedList.add("test");
    verify(mockedList).add("test");
  }

  @Test
  public void _7() {
//    verify interaction with flexible/any argument
    List<String> mockedList = mock(MyList.class);
    mockedList.add("test");
    verify(mockedList).add(anyString());
    verify(mockedList).add(any());
//    verify(mockedList, never()).add(anyInt());
  }

  @Test
  public void _8() {
    MyList instance = new MyList();
    MyList spy = Mockito.spy(instance);

    doThrow(NullPointerException.class).when(spy).size();
    spy.size(); // will throw the exception
  }

  @Spy
  List<String> spyList = new ArrayList<>();

  @Test
  public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
    spyList.add("one");
    spyList.add("two");

    Mockito.verify(spyList).add("one");
    Mockito.verify(spyList).add("two");

    assertEquals(2, spyList.size());
  }
/**
 *  the spy will wrap an existing instance. It will still behave in the same way as the normal instance
 *  – the only difference is that it will also be instrumented to track all the interactions with it.*/
  @Test
  public void whenStubASpy_thenStubbed() {
    List<String> list = new ArrayList<>();
    List<String> spyList = Mockito.spy(list);

    assertEquals(0, spyList.size());

    Mockito.doReturn(100).when(spyList).size();
    assertEquals(100, spyList.size());
  }
}
