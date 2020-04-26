package com.otaliastudios.transcoder.strategy.size;

import androidx.annotation.NonNull;

/**
 * @author bozhao
 * date: 2020/4/17
 */
public class CustomCropResizer implements Resizer {
    private final int width;
    private final int height;
    private final int x;
    private final int y;

    /**
     * @param width  the width
     * @param height the height
     */
    public CustomCropResizer(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @NonNull
    @Override
    public Size getOutputSize(@NonNull Size inputSize) throws Exception {
        if (inputSize instanceof ExactSize) {
            ExactSize exactSize = (ExactSize) inputSize;
            int inputWidth = exactSize.getWidth();
            int inputHeight = exactSize.getHeight();
            int cropLeft = x < 0 || x > inputWidth ? 0 : x;
            int cropTop = y < 0 || y > inputHeight ? 0 : y;
            int outWidth = x + width > inputWidth ? inputWidth - x : width;
            int outHeight = y + height > inputHeight ? inputHeight - y : height;
            return new CustomExactSize(cropLeft, cropTop, outWidth, outHeight);
        }
        return new Size(width, height);
    }
}
