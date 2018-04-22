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
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;

import java.util.ArrayList;
import java.awt.Color;

/**
 * A <code>ChameleonKid</code> takes on the color of neighboring actors immediately in front 
 * or behind as it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public final class ChameleonKid extends ChameleonCritter
{	 
    public ChameleonKid() {

    }
	/*
     * The only part we need to change from ChameleonCritter is getActors() method.
     * Get the actors that in the neighboring location and may be in front or behind as it moves
     * Return the list of those actors
     */
    public ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        ArrayList<Location> locs = new ArrayList<Location>();

        //locs to store the location in front of and behind
        Grid gr = getGrid();
        Location loc = getLocation();

        // the location in front of
        Location neighborLoc = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(neighborLoc)) {
            locs.add(neighborLoc);
        }
        //the location behind
        neighborLoc = loc.getAdjacentLocation(getDirection() + Location.HALF_CIRCLE);
        if (gr.isValid(neighborLoc)) {
            locs.add(neighborLoc);
        }
        //find the actors in the locs
        for (Location l: locs) {
            Actor a = getGrid().get(l);
            if (a != null) {
                actors.add(a);
            }
        }
        return actors;
    }
    
    
}
