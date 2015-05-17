package com.yxp.view.firebutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.Button;

/** 
 * 重写Button的想法主要是利用原有的View的基础上增加一个透明边框，放在Button上面像是加大了空间一样，
 * 使得新添加的View火焰可以跃出原有的BUTTON
 * @author yxp 
 *
 */
public class FireButton extends Button{
	private Paint paint = new Paint();
	private PorterDuffXfermode xor_mode = new PorterDuffXfermode(Mode.XOR);
	private ParticleSet particleSet;
	private ParticleThread particleThread;
	private RunThread runThread;
	public static int START_X = 50;
	public static int START_Y = 90;
	/** 
	 * 边框的大小
	 */
	public static int shelter = 40;

	public FireButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public FireButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FireButton(Context context) {
		super(context);
	}
	
	public void init(Canvas canvas){
		START_X = shelter/2;
		START_Y = this.getHeight() - shelter/2 - 10;
		particleSet = new ParticleSet();
		runThread = new RunThread(this);
		runThread.start();
		particleThread = new ParticleThread(particleSet, this);
		particleThread.start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if(particleSet == null || particleThread == null)
			init(canvas);
		if(particleSet.getSet().size()  < 60)
		{
			for(int i = 0; i < 3; i++)
				particleSet.add(ParticleFactory.create(START_X, START_Y));
		}
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(shelter);
		paint.setColor(Color.RED);
		paint.setXfermode(xor_mode);
		canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
		super.onDraw(canvas);//绘制原有的BUTTON
		paint.reset();
		paint.setXfermode(null);
		for(Particle particle : particleSet.getSet())
		{
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(particle.getColor());
			paint.setAlpha(170);
			canvas.drawOval(new RectF(particle.getX(), particle.getY(),
					particle.getX()+particle.getRadius(), particle.getY()+particle.getRadius()),
					paint);
		}
	}

}
