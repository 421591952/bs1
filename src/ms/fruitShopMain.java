package ms;

import java.math.BigDecimal;

public class fruitShopMain {

    private static BigDecimal oneQuestion(int apply, int strawberry) {
        return new BigDecimal(apply * 8 + strawberry * 13);
    }

    private static BigDecimal towQuestion(int apply, int strawberry, int mango) {
        return new BigDecimal(mango * 20).add(oneQuestion(apply, strawberry));
    }

    private static BigDecimal treeQuestion(int apply, int strawberry, int mango) {
        PromotionContext promotionContext = new PromotionContext(PromotionEnum.EIGHTFOLD);
        return new BigDecimal(apply * 8 + mango * 20).add(promotionContext.getTotalPrice(new BigDecimal(strawberry * 13)));
    }

    private static BigDecimal fourQuestion(int apply, int strawberry, int mango) {
        PromotionContext promotionContext1 = new PromotionContext(PromotionEnum.SPECIAL_HUNDRED);
        return promotionContext1.getTotalPrice(treeQuestion(apply, strawberry, mango));
    }


    public static void main(String[] args) {
        // 第一题
        System.out.println("商品总价为：" + oneQuestion(10, 10).toString());
        // 第一题
        System.out.println("商品总价为：" + towQuestion(10, 10, 10).toString());
        // 第一题
        System.out.println("商品总价为：" + treeQuestion(10, 10, 10).toString());
        // 第一题
        System.out.println("商品总价为：" + fourQuestion(10, 10, 10).toString());
    }
}
