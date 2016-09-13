package ca.qc.johnabbott.cs.cs616.colorpicker;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements SeekBar.OnSeekBarChangeListener{

    // UI components
    private SeekBar red;
    private SeekBar green;
    private SeekBar blue;
    private SeekBar alpha;
    private ImageView preview;
    private int color;

    /**
     *
     */
    public MainActivityFragment() {
        // No UI initialization in constructor!
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // capture the root of the inflated layout
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        // find UI components
        red = (SeekBar) root.findViewById(R.id.red_SeekBar);
        green = (SeekBar) root.findViewById(R.id.green_SeekBar);
        blue = (SeekBar) root.findViewById(R.id.blue_SeekBar);
        alpha = (SeekBar) root.findViewById(R.id.alpha_SeekBar);
        preview = (ImageView) root.findViewById(R.id.preview_ImageView);


        /* Versions 1 & 2
        PreviewUpdateHandler handler = new PreviewUpdateHandler();
        */

        // Version 3: anonymous inner class
/*        SeekBar.OnSeekBarChangeListener handler = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updatePreview();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        };

        // all Seekbar's have the same handler
        red.setOnSeekBarChangeListener(handler);
        green.setOnSeekBarChangeListener(handler);
        blue.setOnSeekBarChangeListener(handler);
        alpha.setOnSeekBarChangeListener(handler);*/


        //Version 4
        red.setOnSeekBarChangeListener(this);
        blue.setOnSeekBarChangeListener(this);
        green.setOnSeekBarChangeListener(this);
        alpha.setOnSeekBarChangeListener(this);

        return root;
    }

    /**
     * Update the preview image with state of the Seekbars
     */
    private void updatePreview() {
        // convert components to Android color integer
        color = Color.argb(
                alpha.getProgress(),
                red.getProgress(),
                green.getProgress(),
                blue.getProgress()
        );

        // update preview
        preview.setBackgroundColor(color);
    }

    public String getColorHTML() {
        int red = Color.red(color);
        int blue = Color.blue(color);
        int green = Color.green(color);
        int alpha = Color.alpha(color);

        return String.format("Color(%d,%d,%d,%d)",red,blue,green,alpha);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        updatePreview();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
            //not used
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //not used
    }


    /**
     * Version 2 of event handler: inner class
     */
    private class PreviewUpdateHandler implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            updatePreview();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

}
