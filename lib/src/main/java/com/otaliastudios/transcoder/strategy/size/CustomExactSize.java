package com.otaliastudios.transcoder.strategy.size;

/**
 * A special {@link Size} that knows about which dimension is width
 * and which is height.
 * <p>
 * See comments in {@link Resizer}.
 */
public class CustomExactSize extends ExactSize {
    private int x;
    private int y;

    public CustomExactSize(int x, int y, int width, int height) {
        super(width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
