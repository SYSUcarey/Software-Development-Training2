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

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains RockHound. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public final class BlusterCritterRunner
{   
    private BlusterCritterRunner() {

    }

    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        for (int c = 0; c <= 9; c++) {
            world.add(new Location(6, c), new Rock());
        }
        for (int r = 8; r <= 9; r++) {
            for (int c = 0; c <= 9; c++) {
                world.add(new Location(r,c), new BlusterCritter(2));
            }
        }
        for (int c = 0; c <= 3; c++) {
            world.add(new Location(0, c), new BlusterCritter(2));
        }
        world.show();
    }
}