package info.gridworld.maze;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown
	private int dir[] = {Location.NORTH, Location.EAST, Location.SOUTH, Location.WEST};
	public Stack<Location> myWay = new Stack<Location>();
	private int[] probility = {1,1,1,1};
	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {

		if(stepCount == 0) {
			Location myLoc = this.getLocation();
			myWay.push(myLoc);
		}
		
		boolean willMove = canMove();
		if (isEnd == true) {
		//to show step count when reach the goal		
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
			move();
			//increase step count when move 
		} 
		else {
			goBack();
			stepCount++;
		}

		
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 *
	 * If the adjacentActor == null OR adjacentActor is a RedRock which means the Exit,
	 *   add this adjacentLocation 
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;
		ArrayList<Location> valid = new ArrayList<Location>();
		Location adjacentLocation;
		Actor adjacentActor;
		for (int i = 0; i < 4; i++) {
			adjacentLocation = loc.getAdjacentLocation(dir[i]);
			if(gr.isValid(adjacentLocation)) {
				adjacentActor = gr.get(adjacentLocation);
				if (adjacentActor instanceof Rock && adjacentActor.getColor().equals(Color.RED)) {
					next = adjacentLocation;
					ArrayList<Location> findExit = new ArrayList<Location>();
					findExit.add(next);
					return findExit;
				}
				else if(adjacentActor == null) {
					valid.add(adjacentLocation);
				}
			}
		}
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		ArrayList<Location> valid = new ArrayList<Location>();
		valid = getValid(this.getLocation());
		if(valid.size() > 0) {
			return true;
		}
		return false;
	}
	/**
	 * We are only supposed to consider that canMove() is true in this method.
	 * Because condition that canMove() is false is implemented in act() method.
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location myLoc = this.getLocation();
		ArrayList<Location> valid = new ArrayList<Location>();
		valid = getValid(myLoc);


		if(valid.size() == 1) {
			next = valid.get(0);
			int direction = myLoc.getDirectionToward(next);
			probility[direction/90]++;
		}
		else {
			int n = valid.size();
			//find the max of probility[] related to these n Locations.
			//chose one location
			int maxPro = 0;
			int proIndex = 0;
			int count = 0;
			int chose = 0;
			for(Location l : valid) {
				int direction = myLoc.getDirectionToward(l);
				if(probility[direction/90] > maxPro) {
					proIndex = (int)direction/90;
					maxPro = probility[direction/90];
					chose = count;
				}
				count++;
			}

			double r = (double) (Math.random());
			if(r < 0.618 && r >= 0) {
				next = valid.get(chose);
				probility[proIndex]++;
			}
			else {
				int ran = (int) (Math.random() * n);
				next = valid.get(ran);
				int direction = myLoc.getDirectionToward(next);
				probility[direction/90]++;
			}
		}

		if (gr.isValid(next)) {
			Actor actor = (Actor)gr.get(next);

			if(actor instanceof Rock && actor.getColor().equals(Color.RED)) {
				isEnd = true;
			}
			setDirection(getLocation().getDirectionToward(next));
			moveTo(next);
			stepCount++;
			myWay.push(next);
		} else {
			removeSelfFromGrid();
		}
			
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, myLoc);
	}

	public void goBack() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location myLoc = this.getLocation();
		myWay.pop();
		last = myWay.peek();
		setDirection(getLocation().getDirectionToward(last));
		moveTo(last);
		int direction = last.getDirectionToward(myLoc);
		probility[direction/90]--;
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, myLoc);
		
	}
}
