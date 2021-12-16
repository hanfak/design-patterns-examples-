package gangoffour.strategy.exampletwo;

import java.math.BigDecimal;

public interface Discounter {
  BigDecimal applyDiscount(BigDecimal amount);
}
