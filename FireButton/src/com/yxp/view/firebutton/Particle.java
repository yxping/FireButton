package com.yxp.view.firebutton;

import android.graphics.Color;

/** 
 * particle类
 * @author yxp
 */
public class Particle {
	private int firstColor = Color.RED;
	private int radius = 10;
	private int color = firstColor;
	private int startX;
	private int startY;
	private int x;
	private int y;
	private int startTime = 0;
	private int endTime;
	private int speedY;
	private int speedX;
	private int FIRST_STATE = 60;//第一层和第二层火焰的分离点
	private int SECOND_STATE = 25;//第二层和第三层火焰的分离点
	private int mode = 1;
	private int redColor = 255;
	
	public Particle(int startX, int startY){
		this.startX = startX;
		this.startY = startY;
		this.x = startX;
		this.y = startY;
	}
	
	public void setFirstColor(int firstColor) {
		this.firstColor = firstColor;
	}
	
	public void setRedColor(int redColor) {
		this.redColor = redColor;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		if(y > FIRST_STATE){
			changeMode(1);
		}else if(y > SECOND_STATE){
			changeMode(2);
		}else{
			changeMode(3);
		}
	}
	
	/**
	 * 设置火焰三层的不同状态
	 * @param mode
	 */
	public void changeMode(int mode){
		this.setMode(mode);
		switch (mode){
			case 1:
				this.color = firstColor;
				break;
			case 2:
				if(redColor > 150)
				{
					redColor -= 15;
					this.color = Color.rgb(redColor, 0, 0);
				}else{
					this.color = Color.rgb(redColor, 0, 0);
				}
				break;
			case 3:
				this.color = Color.rgb(150, 0, 0);
				break;
			default :
				break;
		}
	}
	
	public int getRadius() {
		return radius;
	}

	public int getColor() {
		return color;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getSpeedY() {
		return speedY;
	}
	
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
	public int getSpeedX() {
		return speedX;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
