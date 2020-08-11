package com.otaliastudios.transcoder.validator;

import androidx.annotation.NonNull;

import com.otaliastudios.transcoder.engine.TrackStatus;

/**
 * The default {@link Validator} to understand whether to keep going with the
 * transcoding process or to abort and notify the listener.
 */
public class DefaultValidator implements Validator {

    @Override
    public boolean validate(@NonNull TrackStatus videoStatus, @NonNull TrackStatus audioStatus) {
        if (videoStatus == TrackStatus.COMPRESSING || audioStatus == TrackStatus.COMPRESSING) {
            // If someone is compressing, keep going.
            return true;
        }
        // Both tracks are either absent, passthrough or being removed. Would be tempted
        // to return false here, however a removal might be a intentional action: Keep going.
        // noinspection RedundantIfStatement
        if (videoStatus == TrackStatus.REMOVING || audioStatus == TrackStatus.REMOVING) {
            return true;
        }
        //pass_though
        if (videoStatus == TrackStatus.PASS_THROUGH && audioStatus == TrackStatus.PASS_THROUGH) {
            return false;
        }

        // At this point it's either ABSENT so we are safe aborting
        // the process.
        return false;
    }
}
