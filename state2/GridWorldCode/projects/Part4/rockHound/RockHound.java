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

import java.util.ArrayList;

/**
 * A <code>RockHound</code> act as a critter but can clear the rock nearby <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class RockHound extends Critter
{	
	public RockHound() {

	}


    /**
     * The only part we need to change is the processActors() method
     * We are supposed to chose the Rock in the neighbourdhood locations
     * And then clean it.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors) {
        	if (a instanceof Rock) {
        		a.removeSelfFromGrid();
        	}
        }
    }
}
