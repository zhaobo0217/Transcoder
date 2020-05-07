package com.otaliastudios.transcoder.strategy.size;

import androidx.annotation.NonNull;

/**
 * A {@link Resizer} that crops the input size to match the given
 * aspect ratio, respecting the source portrait or landscape-ness.
 */
public class AspectRatioResizer implements Resizer {

    private final float aspectRatio;
    private float offsetRatio = -1f;

    /**
     * Creates a new resizer.
     *
     * @param aspectRatio the desired aspect ratio
     */
    public AspectRatioResizer(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public AspectRatioResizer(float offsetRatio, float aspectRatio) {
        this.aspectRatio = aspectRatio;
        this.offsetRatio = offsetRatio;
    }

    @NonNull
    @Override
    public Size getOutputSize(@NonNull Size inputSize) {
        if (inputSize instanceof ExactSize) {
            ExactSize exactSize = (ExactSize) inputSize;
            int width = exactSize.getWidth();
            int height = exactSize.getHeight();
            float ratio = (float) width / height;
            if (ratio < aspectRatio) {
                int outWidth = width;
                int outHeight = (int) (width / aspectRatio);
                if (outWidth % 2 != 0) outWidth--;
                if (outHeight % 2 != 0) outHeight--;
                return new OffsetRatioSize(offsetRatio, outWidth, outHeight);
            } else if (ratio > aspectRatio) {
                int outHeight = height;
                int outWidth = (int) (height * aspectRatio);
                if (outWidth % 2 != 0) outWidth--;
                if (outHeight % 2 != 0) outHeight--;
                return new OffsetRatioSize(offsetRatio, outWidth, outHeight);
            } else {
                return inputSize;
            }
        } else {
            float inputRatio = (float) inputSize.getMajor() / inputSize.getMinor();
            float outputRatio = aspectRatio > 1 ? aspectRatio : 1F / aspectRatio;
            // now both are greater than 1 (major / minor).
            if (inputRatio > outputRatio) {
                int major = (int) (outputRatio * inputSize.getMinor());
                int minor = inputSize.getMinor();
                if (minor % 2 != 0) minor--;
                if (major % 2 != 0) major--;
                // input is "wider". We must reduce the input major dimension.
                return new Size(minor, major);
            } else if (inputRatio < outputRatio) {
                int major = inputSize.getMajor();
                int minor = (int) (inputSize.getMajor() / outputRatio);
                if (minor % 2 != 0) minor--;
                if (major % 2 != 0) major--;
                // input is more square. We must reduce the input minor dimension.
                return new Size(major, minor);
            } else {
                return inputSize;
            }
        }
    }
}
