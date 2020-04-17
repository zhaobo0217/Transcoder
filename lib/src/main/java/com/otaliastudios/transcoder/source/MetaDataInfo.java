package com.otaliastudios.transcoder.source;

import java.io.Serializable;

/**
 * @author bozhao
 * date: 2020/4/17
 */
public class MetaDataInfo implements Serializable {
    private int width;
    private int height;
    private long duration;
    private int rotation;
    private float frameRate;
    private int bitRate;
    private String mimeType;
    private String date;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public float getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(float frameRate) {
        this.frameRate = frameRate;
    }

    public int getBitRate() {
        return bitRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MetaDataInfo{" +
                "width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", rotation=" + rotation +
                ", frameRate=" + frameRate +
                ", bitRate=" + bitRate +
                ", mimeType='" + mimeType + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
