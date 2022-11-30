package ms;

import java.math.BigDecimal;

public class FoldPromotion implements PromotionStrategy {
    /**
     * 折扣
     */
    private BigDecimal discount;

    public FoldPromotion (BigDecimal discount){
        this.discount = discount;
    }

    @Override
    public BigDecimal arithmetic(BigDecimal originalPrice) {
        if (originalPrice.compareTo(BigDecimal.ZERO) < 0){
            return BigDecimal.ZERO;
        }
        return originalPrice.multiply(discount).setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
