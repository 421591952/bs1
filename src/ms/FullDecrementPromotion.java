package ms;

import java.math.BigDecimal;

public class FullDecrementPromotion implements PromotionStrategy {
    // 满足价格
    private BigDecimal fullPrice;
    // 减的价格
    private BigDecimal reductionPrice;

    public FullDecrementPromotion(BigDecimal fullPrice, BigDecimal reductionPrice) {
        this.fullPrice = fullPrice;
        this.reductionPrice = reductionPrice;
    }

    @Override
    public BigDecimal arithmetic(BigDecimal originalPrice) {
        if (originalPrice.compareTo(BigDecimal.ZERO) < 0){
            return BigDecimal.ZERO;
        }
        if (originalPrice.compareTo(fullPrice) < 0){
            return originalPrice;
        }
        return originalPrice.subtract(reductionPrice).setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
