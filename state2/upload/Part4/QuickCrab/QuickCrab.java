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
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>QuickCrab</code> looks at a limited set of neighbors only right and left 
 * when it eats and moves.<br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter
{
    public QuickCrab()
    {
        setColor(Color.RED);
    }

    /**
     * The QuickCrab is dirrerent from CrabCritter, that
     * Move 2 steps each time But only left or right
     * And the one cell near location must also be empty.
     * So we are supposed to change the getMoreLocation() method.
     */
    public ArrayList<Location> getMoveLocations() {
    	ArrayList<Location> locs = new ArrayList<Location>();
    	Grid g = getGrid();
    	Location loc = getLocation();
    	//for the case left
    	Location left = loc.getAdjacentLocation(getDirection() + Location.LEFT);
    	if (g.isValid(left) && g.get(left)==null) {
    		Location twoWayLeft = left.getAdjacentLocation(getDirection() + Location.LEFT);
    		if (g.isValid(twoWayLeft) && g.get(twoWayLeft) == null) {
    			locs.add(twoWayLeft);
    		}
    	}
    	//for the case right
    	Location right = loc.getAdjacentLocation(getDirection() + Location.RIGHT);
    	if (g.isValid(right) && g.get(right)==null) {
    		Location twoWayRight = right.getAdjacentLocation(getDirection() + Location.RIGHT);
    		if (g.isValid(twoWayRight) && g.get(twoWayRight) == null) {
    			locs.add(twoWayRight);
    		}
    	}
    	return locs;
    }  
}
