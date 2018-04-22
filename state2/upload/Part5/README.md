[toc]
#Part5
##1.File Introduction

**In the "gridworld" porject, Part5 creates 3 Grids：**
**Grid 1 in Folder "1":**
　　Use a “sparse array” to implement a SparseBounderGrid. More specifically， we use the raw list nodes to build an array list to describe the grid.
**Grid 2 in Folder "2":**
　　Use HashMap to implement a sparseBounderGrid.
**Grid 3 in Folder "3":**
　　Use two-dimensional object array to implement an UnboundedGrid.
　　Init the grid of a 16*16 size. Every time we need a larger grid, the number of row and column change two times larger.

##2.File Direction Structure

```
.
├── 1
│   ├── SparseGridNode.java
│   └── SparseBoundedGrid.java
│   └── SparseGridRunner.java
│   └── sonar-project.properties
├── 2
│   ├── SparseBoundedGrid.java
│   └── SparseGridRunner.java
│   └── sonar-project.properties
├── 3
│   ├── UnBoundedGrid2.java
│   └── UnBoundedGridRunner.java
│   └──sonar-project.properties
├── README.md
└── ...
```
*Ps: sonar-project.properties is used for sonar-runner.*
