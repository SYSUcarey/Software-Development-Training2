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
 * A <code>KingCrab</code> looks at a limited set of neighbourhood like a CrabCritter
 * And it will push the rock near by away
 * This class is not tested on the AP CS A and AB exams.
 */
public class KingCrab extends CrabCritter
{
    public KingCrab()
    {
        setColor(Color.RED);
    }

    /**
     * The KingCrab is dirrerent from CrabCritter, that
     * It can push the rock away
     * So we are supposed to change the processActors() method.
     */

    /*
     * First, we need a method disMoreThanOne to help us adjust
     * whether the distance of the two location is more than one
     * because the row and col are all interger, we have a simple solution
     */
    private boolean disMoreThanOne(Location locfir, Location locsec) {
    	int x = locfir.getRow() - locsec.getRow();
    	int y = locfir.getCol() - locsec.getCol();
    	return ((x+y) > 1);
    }

    /**
     * Second, we need a method pushAway to help us adjust
     * if we can push the Actor away, if yes, push it away. if not, return false;
     */

    private boolean pushAway(Actor a) {
    	ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(a.getLocation());
    	for (Location loc : locs) {
    		if (disMoreThanOne(getLocation(), loc)) {
    			a.moveTo(loc);
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * Now, we write the processActors() method to achieve the act of KingCrab
     * Using the two above function
     */
    
    public void processActors(ArrayList<Actor> actors) {
    	for (Actor a : actors) {
    		if (!pushAway(a)) {
    			a.removeSelfFromGrid();
    		}
    	}
    }



    
}
