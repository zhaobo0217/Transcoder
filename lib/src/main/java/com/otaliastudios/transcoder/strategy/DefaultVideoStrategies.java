package com.otaliastudios.transcoder.strategy;

import androidx.annotation.NonNull;

/**
 * Contains presets and utilities for defining a {@link DefaultVideoStrategy}.
 */
public class DefaultVideoStrategies {

    private DefaultVideoStrategies() {
    }

    /**
     * A {@link DefaultVideoStrategy} that uses 720x1280.
     * This preset is ensured to work on any Android &gt;=4.3 devices by Android CTS,
     * assuming that the codec is available.
     *
     * @return a default video strategy
     */
    @NonNull
    public static DefaultVideoStrategy for720x1280() {
        VideoQualityEnum videoQualityEnum = VideoQualityEnum.VIDEO_QUALITY_720P;
        return DefaultVideoStrategy.exact(720, 1280)
                .bitRate(videoQualityEnum.getBitRate())
                .frameRate(videoQualityEnum.getFrameRate())
                .keyFrameInterval(3F)
                .build();
    }

    /**
     * A {@link DefaultVideoStrategy} that uses 360x480 (3:4),
     * ensured to work for 3:4 videos as explained by
     * https://developer.android.com/guide/topics/media/media-formats
     *
     * @return a default video strategy
     */
    @SuppressWarnings("unused")
    @NonNull
    public static DefaultVideoStrategy for360x480() {
        VideoQualityEnum videoQualityEnum = VideoQualityEnum.VIDEO_QUALITY_480P;
        return DefaultVideoStrategy.exact(360, 480)
                .bitRate(videoQualityEnum.getBitRate())
                .frameRate(videoQualityEnum.getFrameRate())
                .keyFrameInterval(3F)
                .build();
    }
}
