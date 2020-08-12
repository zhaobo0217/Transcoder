package com.otaliastudios.transcoder;

/**
 * @author bozhao
 * date: 2020/4/22
 */
public final class TranscoderContants {
    public static final long BITRATE_480 = 2L * 1000 * 1000;
    public static final long BITRATE_720 = 4L * 1000 * 1000;
    public static final long BITRATE_1080 = 10L * 1000 * 1000;
    public static final int FRAMERATE = 30;
    /**
     * Offset of proportional scaling of video
     */
    public static final String KEY_OFFSET_RATIO = "key_offset_ratio";
    public static final String KEY_EXTRA_NEED_CLIP = "key_extra_need_clip";
}
