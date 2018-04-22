/**
 * The lindedList SparseBoundedGrid achieved by using ArrayList and Node.
 * Here is the SparseBoundedGrid.java
 * The SparseBoundedGrid class inherits AbstractGrid class
 * Using the SparseGridNode class to make up the Grid
 * @author: SYSUcarey
 * @Date: 2018-04-22
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * A <code>SparseBoundedGrid</code> is a rectangular grid with a finite
 * number of rows and columns using the version of LinkedList to achieve. <br />
 * The implementation of this class is testable on the AP C
 */

public class SparseBoundedGrid<E> extends AbstractGrid<E> {

	/**
	 * the parameter:
	 * occArray to store the element of this grid
	 * numCols and numRows is the col and row of the grid
	 */
	private SparseGridNode[] occArray;
	private int numCols;
	private int numRows;

	/**
	 * We need the Constructor with parameter col and row.
	 * col(int) and row(int) is the numbers of col and row of the grid.
	 */
	public SparseBoundedGrid(int rows, int cols) {
		if (rows <= 0) {
			throw new IllegalArgumentException("Error! Rows <= 0");
		}
		if (cols <= 0) {
			throw new IllegalArgumentException("Error! Cols <= 0");
		}
		numRows = rows;
		numCols = cols;
		occArray = new SparseGridNode[rows];
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

		//search from the whole node ArrayList
		for (int r = 0; r < getNumRows() ; r++) {
			//get the row nodeList and p is the head
			SparseGridNode p = occArray[r];
			while (p != null) {
				Location temp = new Location(r, p.getColumn());
				result.add(temp);
				p = p.getNext();
			}
		}
		return result;
	}

	/**
	 * Method get(Location loc) return the element in the Location loc.
	 *
	 */
	public E get(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Error! Location: " + loc + " is InValid.");
		}
		//get the head of the NodeList[row]
		SparseGridNode p = occArray[loc.getRow()];
		while (p != null) {
			if (loc.getCol() == p.getColumn()) {
				return (E)p.getOccupant();
			}
			p = p.getNext();
		}
		return null;
	}

	/**
	 * Put the element obj to the location
	 * Which means the old one should be removed
	 * Return the old element
	 */

	public E put(Location loc, E obj) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Error! Location: " + loc + " is InValid.");
		}
		if (obj == null) {
			throw new IllegalArgumentException("Error! obj == null.");
		}
		//Remove the old element
		E old = remove(loc);

		//Get the node next.
		SparseGridNode p = occArray[loc.getRow()];
		//Add the new element 
		//Using the constructor SparseGridNode(obj, colNum, initnext)
		occArray[loc.getRow()] = new SparseGridNode(obj, loc.getCol(), p); 
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

		//Get the old element
		E obj = get(loc);
		if (obj == null) {
			return null;
		}

		//get the head of nodeList int the row of loc
		SparseGridNode p = occArray[loc.getRow()];
		if (p != null) {

			if (p.getColumn() == loc.getCol()) {
				occArray[loc.getRow()] = p.getNext();
			}
			else {
				//Node q search for the next node of the Array to adjust if it is the end
				//Node p is used to removed
				SparseGridNode q = p.getNext();
				while (q != null && q.getColumn() != loc.getCol()) {
					p = p.getNext();
					q = q.getNext();
				}

				//founded! q points to the element
				//remove ant retain the List
				if (q != null) {
					p.setNext(q.getNext());
				}
			}
		}
		return obj;
	}
}
