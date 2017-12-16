package gamejam151217.soundrecognition.audio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class GraphView extends View {
    private final Paint paint = new Paint(Color.BLACK);
    double[] vals = new double[1];

    public GraphView(Context context) {
        super(context);
    }

    public GraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GraphView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        double[] vals = this.vals;
        float xScale = (float) vals.length / canvas.getWidth();
        xScale *= 2;
        float yScale = canvas.getHeight() / 130.0f;
        int last = 0;
        double lastVal = vals[last];
        for (int i = 1; i < vals.length; i++) {
            canvas.drawLine(last * xScale, (float) -(lastVal * yScale),
                    i * xScale, (float) -(vals[i] * yScale), paint);
            last = i;
            lastVal = vals[last];
        }
    }

    public void update(double[] vals) {
        this.vals = vals;
    }
}
