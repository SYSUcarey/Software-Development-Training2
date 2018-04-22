/**
 * The lindedList SparseBoundedGrid need the rode in the rowList
 * Here is the SparseGridNode.java
 *
 * @author: SYSUcarey
 * @Date: 2018-04-22
 */
public class SparseGridNode
{
 	private Object occupant;
	private int col;
 	private SparseGridNode next;

 	/**
 	 * The constructor with parameter object , colnum, next
 	 */
 	public SparseGridNode(Object occ, int colNum, SparseGridNode initNext) {
 		occupant = occ;
 		col = colNum;
 		next = initNext;
 	}

 	/**
 	 * Get and Set method to Object occupant
 	 */
	public Object getOccupant() {
		return occupant;
	}
	public void setOccupant(Object occ) {
		occupant = occ;
	}

	/**
	 * Get method to the number of col
	 */
	public int getColumn() {
		return col;
	}
	
	/**
	 * Get and Set method to the nextNode
	 */
	public void setNext(SparseGridNode newNext){
		next = newNext;
	}

	public SparseGridNode getNext() {
		return next;
	}
} 