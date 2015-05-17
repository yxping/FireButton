package com.yxp.view.firebutton;

import android.view.View;

/** 
 * 让火焰移动的子线程，只是改变其每个particle的初始位置
 * 可以按矩形路径进行，我觉得只在底部滑动好看，就只让他在底部滑动啦。
 * @author yxp
 *
 */
public class RunThread extends Thread {
	//x,y值的边界值
	private int originX = FireButton.START_X;
	private int originY = FireButton.START_Y;
	private int mode = 1;
	private int maxX, maxY;
	
	public RunThread(View view){
		this.maxX = view.getWidth() - FireButton.shelter/2 - 10;
		this.maxY = view.getHeight() - FireButton.shelter/2 - 10;
	}
	
	@Override
	public void run() {
		while(ActivityState.isRun)
		{
			logic();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void logic(){
		switch(mode){
			case 1:
				FireButton.START_X += 3;
				if(FireButton.START_X >= maxX)
				{
					mode = 3;
					FireButton.START_X = maxX;
				}
				break;
			case 2:
				FireButton.START_Y += 2;
				if(FireButton.START_Y >= maxY)
				{
					mode = 3;
					FireButton.START_Y = maxY;
				}
				break;
			case 3:
				FireButton.START_X -= 3;
				if(FireButton.START_X <= originX)
				{
					mode = 1;
					FireButton.START_X = originX;
				}
				break;
			case 4:
				FireButton.START_Y -= 2;
				if(FireButton.START_Y <= originY)
				{
					mode = 1;
					FireButton.START_Y = originY;
				}
				break;
			default:
				break;
		}
	}
	
}
