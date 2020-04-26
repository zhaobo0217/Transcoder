package com.otaliastudios.transcoder.strategy;

import com.otaliastudios.transcoder.TranscoderContants;

/**
 * @author bozhao
 * date: 2020/4/26
 */
public enum VideoQualityEnum {
    VIDEO_QUALITY_480P(TranscoderContants.BITRATE_480, TranscoderContants.FRAMERATE),
    VIDEO_QUALITY_720P(TranscoderContants.BITRATE_720, TranscoderContants.FRAMERATE),
    VIDEO_QUALITY_1080P(TranscoderContants.BITRATE_1080, TranscoderContants.FRAMERATE);

    private long bitRate;
    private int frameRate;

    VideoQualityEnum(long bitRate, int frameRate) {
        this.bitRate = bitRate;
        this.frameRate = frameRate;
    }

    public long getBitRate() {
        return bitRate;
    }

    public int getFrameRate() {
        return frameRate;
    }
}
