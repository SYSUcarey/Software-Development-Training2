/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>BlusterCritter</code> act like a critter but has its own special<br />
 * The operating locations include all of the neighbors within two steps of its current location.
 * If there are fewer than c critters, the BlusterCritter’s color gets brighter
 * Else gets darker.
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{	
	private int courageFactor;

	//default constructor method set the parameter courageFactor to 2.
	public BlusterCritter() {
		super();
		courageFactor = 2;
	}

	//a constructor method with parameter c
	public BlusterCritter(int c) {
		super();
		courageFactor = c;
	}

    /**
     * The neighbourhood is defined wider, so we are supposed to change the getActors() method.
     * We are supposed to chose the Actors in the location within two steps far away
     * Return a list of actors
     */
    public ArrayList<Actor> getActors() {
    	ArrayList<Actor> actors = new ArrayList<Actor>();
    	Location loc = getLocation();
    	for (int r = loc.getRow()-2; r <= loc.getRow()+2; r++) {
    		for (int c = loc.getCol()-2; c <= loc.getCol()+2; c++) {
    			Location temp = new Location(r, c);
    			if (getGrid().isValid(temp)) {
    				Actor a = getGrid().get(temp);
    				if (a != null && a != this) {
    					actors.add(a);
    				}
    			}
    		}
    	}
    	return actors;
    }

    /**
     * To count the number of the BlusterCritter near by,
     * We should chose the Critter from the whole actors array.
     * If the count number smaller than the parameter courageFactor, lighten
     * Else darken
     * So we are supposed to change the method processActors()
     */
    public void processActors(ArrayList<Actor> actors) {
    	int count = 0;
    	for (Actor a : actors) {
    		if (a instanceof Critter) {
    			count++;
    		}
    	}
    	if (count < courageFactor) {
    		lighten();
    	}
    	else {
    		darken();
    	}
    }

    /**
     * define the method lighten() and darken() which will used in processActors() method
     * Considering the lighten() method can't be written in the way like that in Flower
     * Because 0 <= red, green, blue <= 255
     * So we changed another method to achieve lighten and darken
     */
    private void darken() {
    	Color c = getColor();
    	int red = c.getRed();
    	int green = c.getGreen();
    	int blue = c.getBlue();
    	if (red > 10) {
    		red-=10;
    	}
    	if (green > 10) {
    		green-=10;
    	}
    	if (blue > 10) {
    		blue-=10;
    	}
    	setColor(new Color(red, green, blue));
    }

    private void lighten() {
    	Color c = getColor();
    	int red = c.getRed();
    	int green = c.getGreen();
    	int blue = c.getBlue();
    	if (red < 245) {
    		red+=10;
    	}
    	if (green < 245) {
    		green+=10;
    	} 
    		
    	if (blue < 245) {
    		blue+=10;
    	}
    	setColor(new Color(red, green, blue));
    }

}
