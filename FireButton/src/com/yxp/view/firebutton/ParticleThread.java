package com.yxp.view.firebutton;

import java.util.HashSet;

import android.graphics.Canvas;
import android.view.View;
/** 
 * 产生火焰的主要子线程，主要修改particle的X和Y的值来达到目的，当然随机性这些都是形成火焰的要点
 * @author yxp
 *
 */
public class ParticleThread extends Thread {
	HashSet<Particle> set;
	private View view;
	
	public ParticleThread(ParticleSet set, View view){
		this.set = set.getSet();
		this.view = view;
	}

	@Override
	public void run() {
		while(ActivityState.isRun)
		{
			for(Particle particle : set)
			{
				if(particle.getStartTime() > particle.getEndTime())
				{
					ParticleFactory.reset(particle);
				}
				particle.setY(particle.getStartY() - particle.getStartTime() * particle.getSpeedY());
				particle.setX(particle.getStartX() - particle.getStartTime() * particle.getSpeedX());
				particle.setStartTime(particle.getStartTime()+1);
			}
			view.postInvalidate();
			try {
				sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
