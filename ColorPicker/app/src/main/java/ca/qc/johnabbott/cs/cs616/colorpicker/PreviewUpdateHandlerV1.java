package ca.qc.johnabbott.cs.cs616.colorpicker;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Version 1 of event handler
 */
public class PreviewUpdateHandlerV1 implements SeekBar.OnSeekBarChangeListener {

    // UI components
    private SeekBar red;
    private SeekBar green;
    private SeekBar blue;
    private SeekBar alpha;
    private ImageView preview;

    /**
     * Create a handler to update the image preview
     * @param red
     * @param green
     * @param blue
     * @param alpha
     * @param preview
     */
    public PreviewUpdateHandlerV1(SeekBar red, SeekBar green, SeekBar blue, SeekBar alpha, ImageView preview) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        this.preview = preview;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        // convert components to Android color integer
        int color = Color.argb(
                alpha.getProgress(),
                red.getProgress(),
                green.getProgress(),
                blue.getProgress()
        );

        // update preview
        preview.setBackgroundColor(color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
