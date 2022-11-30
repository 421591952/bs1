package ms;

import java.math.BigDecimal;

public interface PromotionStrategy {

    BigDecimal arithmetic(BigDecimal originalPrice);
}
