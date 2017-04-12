package randwod.randwod;

import android.view.View;

/**
 * Created by simon on 2017-02-21.
 */

public class ToggleStrikethroughOnClickListener implements View.OnClickListener {

    private StrikethroughableTextView textView;

    public ToggleStrikethroughOnClickListener(StrikethroughableTextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        textView.toggleStrike();
    }

}
