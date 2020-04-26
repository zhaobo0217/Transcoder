package com.otaliastudios.transcoder.strategy.size;

/**
 * @author bozhao
 * date: 2020/4/22
 */
public class OffsetRatioSize extends ExactSize {
    //默认设置的值，真实的值应该是大于等于0的值
    private float offsetRatio = -1F;

    /**
     * The order does not matter.
     *
     * @param offsetRatio offset ratio
     * @param width   one dimension
     * @param height  the other
     */
    public OffsetRatioSize(float offsetRatio, int width, int height) {
        super(width, height);
        this.offsetRatio = offsetRatio;
    }

    public float getOffsetRatio() {
        return offsetRatio;
    }
}
