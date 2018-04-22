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
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>Jumper</code> jump for two cells. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Jumper extends Actor
{
    /**
     * Constructs a red Jumper
     */
    public Jumper()
    {
        setColor(Color.RED);
    }

    /**
     * Constructs a Jumper in a given color
     */
    public Jumper(Color jumperColor) {
        setColor(jumperColor);
    }
    
    /**
     *act method decide what a jumper will do
     */
    public void act() {
        if (canJump()) {
            jump();
        }
        else {
            turn();
        }
    }

    /**
     *when the jumper can't not jump to next location, it will turn right for 90 degrees.
     */
    public void turn() {
        setDirection(getDirection() + Location.RIGHT);
    }

    /**
     *decide whether the Jumper can jump to the next location(next two cell)
     *for cases:
     *1.If the location next two cells and next is inValid, can't not jump
     *2.If the two cell location is't null or flower, can't jump
     */
    public boolean canJump() {
        Grid<Actor> gr = getGrid();
            if (gr == null) {
                return false;
            }
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection());
            Location twocell = next.getAdjacentLocation(getDirection());
            if ((!gr.isValid(twocell)) || (!gr.isValid(next))) {
                return false;
            }
            Actor neighbor = gr.get(next);
            neighbor = gr.get(twocell);
            return (neighbor == null) || (neighbor instanceof Flower); 
    }

    /*
     *define the action jump
     *one jump for two cells
     */
    public void jump() {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location twocell = next.getAdjacentLocation(getDirection());
        if (gr.isValid(twocell)) {
            moveTo(twocell);
        }
    }


    
}
