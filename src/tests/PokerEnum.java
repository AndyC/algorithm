package tests;

/**
 * @author AndyCui
 * @date 2018/9/25 下午10:28
 * @description
 */
public enum PokerEnum {
    /**
     * 方片
     */
    FANGPIAN(1),
    /**
     * 红桃
     */
    HONGTAO(2),
    /**
     * 梅花
     */
    MEIHUA(3),
    /**
     * 黑桃
     */
    HEITAO(4);
    private int flowerIndex;
    PokerEnum(int flowerIndex) {
        this.flowerIndex=flowerIndex;
    }
}
