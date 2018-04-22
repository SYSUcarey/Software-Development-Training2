/**
 * The lindedList SparseBoundedGrid achieved by using ArrayList and Node.
 * Here is the GridRunner.java
 * The SparseBoundedGrid class inherits AbstractGrid class
 * Using the SparseGridNode class to make up the Grid
 * @author: SYSUcarey
 * @Date: 2018-04-22
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
/**
 * This class runs a world with additional grid choices.
 */
public final class SparseGridRunner
{	
    private SparseGridRunner() {
    
    }
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.addGridClass("SparseBoundedGrid");
        world.add(new Location(2, 2), new Critter());
        world.show();
    }
}
