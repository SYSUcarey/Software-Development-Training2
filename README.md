# Software-Development-Training2
大二下软件工程实训

@author: SYSUcarey  
@date: 2018-05-06  
@blog: [https://blog.csdn.net/cbb944131226](https://blog.csdn.net/cbb944131226)  
@github: [https://github.com/SYSUcarey/Software-Development-Training2](https://github.com/SYSUcarey/Software-Development-Training2)  
@[本人学院](http://sdcs.sysu.edu.cn/)  



## 阶段一

**实验目的：**    
为本次实训项目做基本的技术准备，学会使用`Vi`（or） `Vim`、`JAVA`、`Ant`、`Junit`、`sonar-qube`，以及熟悉`GridWorld`的使用。  
**实验内容：**    
1.学习`Vi`或`Vim`编辑器的使用，包括`Vim`更人性化的配置、命令模式下的各种命令的学习和熟悉。  
2.配置`JDK`，配置`JAVA`环境变量，学会在终端下编译并运行简单的`JAVA`代码文件——`HelloWorld.java`。  
3.学习`Ant`的使用，学习利用`Ant`进行代码的编译、运行、生成Jar包。  
4.用`JAVA`完成简单的计算器设计。  
5.学习使用Junit来进行对`Java`文件的测试。  
6.学习使用`sonar-qube`对`Java`文件进行规范性检查。  


## 阶段二

**实验目的：**     
进行GridWorld项目的探究，熟悉GridWorld项目的整个文件结构和运行结构。特别是熟悉关于：  
·各种`Grid`的布局设计，以及各种各样的成员类的实现。  
**实验内容：**      
1.熟悉各种不一样的基础成员类：`Actor`、`Bug`、`Rock`、`Flower`等的实现方法，它们的行为表现和实现方法。  
2实现各种复杂一点继承成员类：`ZBug`、`BlusterCritter`、`KingCrab`、`QuickCrab`等，它们的行为决定了它们如何去实现它们的`Override`方法。  
3.实现不一样的`Grid`布局，包括`BoundedGrid`和`UnboundedGrid`，可以通过节点`SparseGridNode` + `ArrayList<>`\ `Array[]`来实现，可以通过`LinkedList<OccupantInCol>`实现，可以通过`HashMap`来实现，也可以通过`TreeMap`实现，比较这几种方式实现的优劣，以及它们实现的复杂度。  
4.完成与项目相关的多个问答题。


## 阶段三

**实验目的：**    
基于GridWorld项目下的拓展项目：图像处理、迷宫、拼图。  
**实验内容：**    
1.图像处理:
利用课程网页上提供的实验软装置`ImageReader_code.zip`和测试图片集`bmptest.zip`简单实现和测试一个利用二进制流读取Bitmap图像，并且能够进行简单的色彩处理和保存的软件。  
2.迷宫：
基于GridWorld项目下，利用深搜算法和启发式算法，让虫子`MazeBug`走出迷宫。  
3.拼图：
N-数码问题，利用广搜算法和Astar算法（启发函数）来完成拼图任务。
