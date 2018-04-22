/**
 * The Hash SparseBoundedGrid achieved by using HashMap to implement
 * Here is the SparseBoundedGrid.java
 * The SparseBoundedGrid class inherits AbstractGrid class
 * Using the SparseGridNode class to make up the Grid
 * @author: SYSUcarey
 * @Date: 2018-04-22
 */

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * An <code>UnboundedGrid</code> is a rectangular grid with an
 * unbounded number of rows and columns. <br />
 * Here we make SparseBoundedGrid(Hash) implementate of this class.
 * The implementation of this class is testable on the AP CS AB Exam.
 */ 

public class SparseBoundedGrid<E> extends AbstractGrid<E> {
	/**
	 * the parameter:
	 * occMap to store the element of this grid using the Map
	 * numCols and numRows is the col and row of the grid
	 */
	private Map<Location, E> occMap;
	private int numRows;
	private int numCols;


	/**
	 * We need the Constructor with parameter col and row.
	 * col(int) and row(int) is the numbers of col and row of the grid.
	 */
	public SparseBoundedGrid(int rows, int cols) {

		occMap = new HashMap<Location, E>();
		numRows = rows;
		numCols = cols;
	}

	/**
	 * Get method of number (int) numCols and (int) numRows.
	 */
	public int getNumRows() {
		return numRows;
	}
	public int getNumCols() {
		return numCols;
	}

	/**
	 * Adjust if A Location(m,n) is Valid in this SparseBoundedGrid
	 */
	public boolean isValid(Location loc) {
		int m = loc.getRow();
		int n = loc.getCol();
		return ((m>=0) && (m<getNumRows()) && (n>=0) && (n<=getNumCols()));
	}

	/**
	 * Method getOccupiedLocations() return all the node -> Locations
	 *
	 */
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> result = new ArrayList<Location>();
		for (Location loc : occMap.keySet()) {
			result.add(loc);
		}
		return result;
	}

	/**
	 * Method get(Location loc) return the element in the Location loc.
	 *
	 */
	public E get(Location loc) {
		if (loc == null) {
			throw new IllegalArgumentException("Error! Location: " + loc + " is InValid.");
		}
		return occMap.get(loc);
	}

	/**
	 * Put the element obj to the location
	 * Which means the old one should be removed
	 * Return the old element
	 */
	public E put(Location loc, E obj) {
		if (loc == null) {
			throw new IllegalArgumentException("Error! Location: " + loc + " is InValid.");
		}
		if (obj == null) {
			throw new IllegalArgumentException("Error! obj == null");
		}
		return occMap.put(loc, obj);
	}

	/**
	 * The remove method, remove the element in location
	 * And return the old element
	 */
	public E remove(Location loc) {
		if (loc == null) {
			throw new IllegalArgumentException("Error! Location: " + loc + " is InValid.");
		}
		return occMap.remove(loc);
	}



}

