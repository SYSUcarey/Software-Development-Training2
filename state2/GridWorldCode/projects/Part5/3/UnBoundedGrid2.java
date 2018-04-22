/**
 * The UnBoundedGrid achieved which is a 16*16 first
 * If the grid is not large enough, extend the row and col double
 * Here is the UnBoundedGrid2.java
 * The UnBoundedGrid2 class inherits AbstractGrid class
 * @author: SYSUcarey
 * @Date: 2018-04-22
 */

import info.gridworld.grid.*;
import java.util.ArrayList;
import java.util.*;

/**
 * An <code>UnboundedGrid</code> is a rectangular grid with an
 * unbounded number of rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB Exam.
 */

public class UnBoundedGrid2<E> extends AbstractGrid<E> {
	/**
	 * the parameter:
	 * occArray to store the element of this grid using the two-dimensional object array
	 * dim is the current imensional
	 */
	private Object[][] occArray;
	private int dim;

	/**
	 * We need the Constructor for a beginning 16*16 grid
	 */
	public UnBoundedGrid2() {
		dim = 16;
		occArray = new Object[dim][dim];
	}

	/**
	 * Get method of number (int) numCols and (int) numRows.
	 * Both return -1
	 */
	public int getNumRows() {
		return -1;
	}
	public int getNumCols() {
		return -1;
	}

	/**
	 * Adjust if A Location(m,n) is Valid in this SparseBoundedGrid
	 */
	public boolean isValid(Location loc) {
		int m = loc.getRow();
		int n = loc.getCol();
		return ((m>=0)&&(n>=0));
	}

	/**
	 * Method getOccupiedLocations() return all the element -> Locations
	 *
	 */
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> result = new ArrayList<Location>();
		for (int r = 0; r < dim; r++) {
			for (int c = 0; c < dim; c++) {
				Location loc = new Location(r,c);
				if (get(loc) != null) {
					result.add(loc);
				}
			}
		}
		return result;
	}

	/**
	 * Method get(Location loc) return the element in the Location loc.
	 * If location invalid, throw exception
	 * If valid but out of grid, return null
	 */
	public E get(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Error! Location: " + loc + " is InValid.");
		}
		if (loc.getRow() >= dim || loc.getCol() >= dim) {
			return null;
		}
		return (E)occArray[loc.getRow()][loc.getCol()];
	}

	/**
	 * Put the element obj to the location
	 * Which means the old one should be removed
	 * Return the old element
	 * If the location out of the grid but valid, extend the grid.	
	 */
	public E put(Location loc, E obj) {
		if (loc == null) {
			throw new IllegalArgumentException("Error! Location: " + loc + " is InValid.");
		}
		if (obj == null) {
			throw new IllegalArgumentException("Error! obj == null");
		}

		//resize the occArray using the method resize()
		if (loc.getRow() >= dim || loc.getCol() >= dim) {
			resize(loc);
		}
		//get the old , put the new, return the old
		E old = get(loc);
		occArray [loc.getRow()][loc.getCol()] = obj;
		return old;
	}

	/**
	 * The remove method, remove the element in location
	 * And return the old element
	 */
	public E remove(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Error! Location: " + loc + " is InValid.");
		}
		if (loc.getRow() >= dim || loc.getCol() >= dim) {
			return null;
		}
		E old = get(loc);
		occArray[loc.getRow()][loc.getCol()] = null;
		return old;
	}

	/**
	 * The method resize is used to extend the grid in put() function
	 * extend double each time until can put.
	 */

	private void resize(Location loc) {
		int size = dim;
		while (loc.getRow() >= size || loc.getCol() >= size) {
			size *= 2;
		}
		Object[][] newArray = new Object[size][size];

		//copy the old
		for (int r = 0; r < dim; r++) {
			for (int c = 0; c < dim; c++) {
				newArray[r][c] = occArray[r][c];
			}
		}
		occArray = newArray;
		dim = size;
	}






}