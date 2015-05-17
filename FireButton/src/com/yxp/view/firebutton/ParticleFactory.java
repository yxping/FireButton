package com.yxp.view.firebutton;

import android.graphics.Color;

/** 
 * 生产particle的工厂，在工厂中进行配置相关属性，比如初始位置，颜色，速度，生命时间
 * @author yxp
 *
 */
public class ParticleFactory {

	/** 
	 * 生产particle，并进行配置相关属性
	 * @param startX 初始的X点
	 * @param startY 初始的Y点
	 * @return
	 */
	public static Particle create(int startX, int startY){
		Particle particle = new Particle(startX, startY);
		particle.setSpeedX((int) ((Math.random() + 1) * 5 - 7.5));
		if(particle.getSpeedX() == 0)
			particle.setSpeedX((int) ((Math.random() + 1) * 5 - 7.5));
		if(particle.getSpeedX() == 0)
			particle.setSpeedX((int) ((Math.random() + 1) * 5 - 7.5));
		particle.setFirstColor(Color.RED);
		particle.setSpeedY((int) (8 - Math.random() * 5 + Math.abs(particle.getSpeedX())));
		particle.setEndTime((int) ((Math.random() + 1) * 3.5));
		return particle;
	}
	
	/**
	 * 重置particle的属性，让其重新开始
	 * @param particle
	 */
	public static void reset(Particle particle){
		particle.setSpeedX((int) ((Math.random() + 1) * 5 - 7.5));
		if(particle.getSpeedX() == 0)
			particle.setSpeedX((int) ((Math.random() + 1) * 5 - 7.5));
		if(particle.getSpeedX() == 0)
			particle.setSpeedX((int) ((Math.random() + 1) * 5 - 7.5));
		particle.setFirstColor(Color.RED);
		particle.setSpeedY((int) (8 - Math.random() * 5 + Math.abs(particle.getSpeedX())));
		particle.setStartTime(0);
		particle.setEndTime((int) ((Math.random() + 1) * 3.5));
		particle.setRedColor(255);
		particle.setRadius(10);
		particle.setStartX(FireButton.START_X);
		particle.setStartY(FireButton.START_Y);
	}
}
