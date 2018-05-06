package solution;

import jigsaw.Jigsaw;
import jigsaw.JigsawNode;

import java.util.*;


/**
 * 在此类中填充算法，完成重拼图游戏（N-数码问题）
 */
public class Solution extends Jigsaw {

    private List<JigsawNode> solutionPath;  // 解路径：用以保存从起始状态到达目标状态的移动路径中的每一个状态节点
    private int searchedNodesNum;           // 已访问节点数：用以记录所有访问过的节点的数量

    private Vector<JigsawNode> exploreList;  // 用以保存已发现但未访问的节点
    private Vector<JigsawNode> visitedList;  
    /**
     * 拼图构造函数
     */
    public Solution() {
    }

    /**
     * 拼图构造函数
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     */
    public Solution(JigsawNode bNode, JigsawNode eNode) {
        super(bNode, eNode);
    }

    /**
     *（实验一）广度优先搜索算法，求指定5*5拼图（24-数码问题）的最优解
     * 填充此函数，可在Solution类中添加其他函数，属性
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     * @return 搜索成功时为true,失败为false
     */
    public boolean BFSearch(JigsawNode bNode, JigsawNode eNode) {
        this.beginJNode = new JigsawNode(bNode);
        this.endJNode = new JigsawNode(eNode);
        this.currentJNode = new JigsawNode(bNode);
        //this.solutionPath = new List<JigsawNode>();
        this.exploreList = new Vector<JigsawNode>();
        this.visitedList = new Vector<JigsawNode>();
        //this.searchedNodesNum = 0;

       
        exploreList.add(bNode);
       


        while (!exploreList.isEmpty()) {
            currentJNode = exploreList.firstElement();
            if (currentJNode.equals(endJNode)) {
                visitedList.add(currentJNode);
                solutionPath = getPath();
                searchedNodesNum++;
                break;
            }
            else {
                visitedList.add(currentJNode);

                /* 
                 * Find all the node next to the currentJNode and not be find or visited before.
                 * Put them into the exploreList
                 */

                JigsawNode[] nextNodes = new JigsawNode[]{
                new JigsawNode(this.currentJNode), new JigsawNode(this.currentJNode),
                new JigsawNode(this.currentJNode), new JigsawNode(this.currentJNode)
                };

                for (int i = 0; i < 4; i++) {
                    if (nextNodes[i].move(i) && !this.visitedList.contains(nextNodes[i]) && !this.exploreList.contains(nextNodes[i])) {
                        this.exploreList.add(nextNodes[i]);
                    }
                }

                exploreList.remove(0);
                currentJNode = exploreList.firstElement();
                searchedNodesNum++;
            }
        }

        System.out.println("Jigsaw BFSearch Result:");
        System.out.println("Begin state:" + bNode.toString());
        System.out.println("End state:" + eNode.toString());
        // System.out.println("Solution Path: ");
        // System.out.println(this.getSolutionPath());
        System.out.println("Total number of searched nodes:" + this.searchedNodesNum);
        System.out.println("Depth of the current node is:" + this.getCurrentJNode().getNodeDepth());
        //System.out.println("The path is : \n");
        //System.out.println(this.getPath())

        return isCompleted();
    }


    /**
     *（Demo+实验二）计算并修改状态节点jNode的代价估计值:f(n)
     * 如 f(n) = s(n). s(n)代表后续节点不正确的数码个数
     * 此函数会改变该节点的estimatedValue属性值
     * 修改此函数，可在Solution类中添加其他函数，属性
     * @param jNode - 要计算代价估计值的节点
     */
    public void estimateValue(JigsawNode jNode) {
        
        int s = 0; // 后续节点不正确的数码个数
        int dimension = JigsawNode.getDimension();
        for (int index = 1; index < dimension * dimension; index++) {
            if (jNode.getNodesState()[index] + 1 != jNode.getNodesState()[index + 1]) {
                s++;
            }
        }
        jNode.setEstimatedValue(s);
        
        int len = (int)(Math.sqrt(jNode.getNodesState().length - 1));
        //int dimension = JigsawNode.getDimension();
        int ManhattanDis = 0;
        int EuclideanDis = 0;
        int ChebyshevDis = 0;
        for (int i = 1; i <=  dimension*dimension; i++) {
            for (int j = 1; j <= dimension*dimension; j++) {
                if (jNode.getNodesState()[i] != 0 && jNode.getNodesState()[i] == this.endJNode.getNodesState()[j]) {
                    int x1 = (i-1) / len;
                    int y1 = (i+4) % len;
                    int x2 = (j-1) / len;
                    int y2 = (j+4) % len;

                    int abs_x = (x1 > x2) ? (x1-x2) : (x2-x1);
                    int abs_y = (y1 > y2) ? (y1-y2) : (y2-y1);  

                    ManhattanDis += (int)(abs_x + abs_y);
                    ChebyshevDis += (int)(Math.max(abs_x, abs_y));
                    EuclideanDis += (int)(Math.sqrt(abs_x * abs_x + abs_y * abs_y));
                    break;
                }
            }
        }
        int aver = ManhattanDis * 2 + s + EuclideanDis;// + ChebyshevDis;
        jNode.setEstimatedValue(aver);
    }

    
}
