package com.otaliastudios.transcoder.strategy.size;

/**
 * @author bozhao
 * date: 2020/4/22
 */
public class OffsetRatioSize extends Size {
    //默认设置的值，真实的值应该是大于等于0的值
    private float offsetRatio = -1F;

    /**
     * The order does not matter.
     *
     * @param offsetRatio offset ratio
     * @param firstSize   one dimension
     * @param secondSize  the other
     */
    public OffsetRatioSize(float offsetRatio, int firstSize, int secondSize) {
        super(firstSize, secondSize);
        this.offsetRatio = offsetRatio;
    }

    public float getOffsetRatio() {
        return offsetRatio;
    }
}
