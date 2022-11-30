package ms;

import java.math.BigDecimal;
import java.util.HashMap;

public class PromotionContext {

    private PromotionStrategy strategy;

    public static HashMap<PromotionEnum,PromotionStrategy>  psMap = new HashMap<>();
    //初始化打折实例
    static {
        psMap.put(PromotionEnum.EIGHTFOLD,new FoldPromotion(new BigDecimal("0.8")));
        psMap.put(PromotionEnum.SPECIAL_HUNDRED,new FullDecrementPromotion(new BigDecimal(100),new BigDecimal(10)));
    }

    public PromotionContext(PromotionEnum promotionEnum) {
        this.strategy = psMap.get(promotionEnum);
    }

    public BigDecimal getTotalPrice(BigDecimal originalPrice){
        return strategy.arithmetic(originalPrice);
    }

}
