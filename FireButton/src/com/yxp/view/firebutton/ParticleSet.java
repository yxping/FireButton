package com.yxp.view.firebutton;

import java.util.HashSet;

/** 
 * 存放particle的hashset
 * @author Administrator
 *
 */
public class ParticleSet {
	private HashSet<Particle> set = new HashSet<Particle>(100);
	
	public ParticleSet(){
		
	}
	
	public void add(Particle particle){
		set.add(particle);
	}
	
	public HashSet<Particle> getSet() {
		return set;
	}

}
