package randwod.randwod;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by simon on 2017-02-21.
 */

public class StrikethroughableTextView extends TextView {

    private boolean strike;

    public StrikethroughableTextView(Context context) {
        super(context);
    }

    public StrikethroughableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StrikethroughableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void strike() {
        strike = true;
        invalidate();
    }

    public void unstrike() {
        strike = false;
        invalidate();
    }

    public void toggleStrike() {
        strike = !strike;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (strike) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrikeThruText(true);
            paint.setStrokeWidth(10);
            paint.setFlags(Paint.ANTI_ALIAS_FLAG);
            paint.setAlpha(120);
            paint.setStrokeCap(Paint.Cap.ROUND);
            super.onDraw(canvas);
            float width = getWidth();
            float heigth = getHeight();
            if (Math.random() > 0.5) {
                canvas.drawLine(width / 10, heigth / 10, width - width / 10, heigth - heigth / 10, paint);
            } else {
                canvas.drawLine(width / 10, heigth - heigth / 10, width - width / 10, heigth / 10, paint);
            }
        } else {
            super.onDraw(canvas);
        }
    }

}
