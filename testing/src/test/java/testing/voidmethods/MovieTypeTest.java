package testing.voidmethods;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTypeTest {

    @Test
    public void newMovieShouldCalculateCorrectTotal() {
        double actualTotal = MovieType.NEW.calculateTotal(1);
        assertEquals(5.0, actualTotal, 0.0);
    }

}