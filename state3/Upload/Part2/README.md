
[大二实训（三）MazeBug](https://blog.csdn.net/cbb944131226/article/details/80216236)
@author: SYSUcarey
@date: 2018-05-06
@blog: [https://blog.csdn.net/cbb944131226](https://blog.csdn.net/cbb944131226)
@[本人学院](http://sdcs.sysu.edu.cn/)
目录：
	
[TOC]

##Upload文件结构
```
.
├── MazeBug.java
├── README.java
└── ...
```
##项目实验介绍
**实验介绍：**
改进`gridworld`的软件装置，实现深度优先搜索算法，使虫子走出迷宫。课程网页上提供了软件装置`mazebug_code.zip`
**配置环境**
配置一个Jar包的环境变量，新生成的`gridworld.jar`。

```
export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_91
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:/home/administrator/Downloads/junit-4.9.jar:/home/administrator/Downloads/gridworld.jar:/home/administrator/Downloads/ImageReader.jar:/home/administrator/Downloads/swing-worker-1.1.jar:/home/administrator/Downloads/appframework-1.0.3.jar:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH:$HOME/bin
```
ps：上述三行代码， `vim ~/.bashrc`后，在文件末尾中添加。
pps: 上述三行代码，是整个第三阶段的环境变量配置代码。

##代码文件说明
MazeBug类介绍：
属性 | 介绍
----- | ---
`Location next` | 记录下一步要行走到的位置
`Location last` | 记录上一步的位置，便于在走到死路尽头时返回
`Stack<ArrayList<Location>>crossLocation` | 记录树的节点的栈
`Integer stepCount` | 记录本迷宫走到出口所用的步数

方法 | 介绍
----- | ---
`void act()` | 虫子行动函数，每走一步会加一点步数，找到出口时显示步数
`ArrayList<Location> getValid(Location loc)` |寻找可行走方向
`boolean canMove()` | 判断是否可以行走
`void move()` | 如何行走


##使用说明
编译运行`MazeBugRunner.java`
![这里写图片描述](https://img-blog.csdn.net/20180506173521268?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NiYjk0NDEzMTIyNg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
##更多
[Talk is cheap, show you the code.](https://github.com/SYSUcarey/Software-Development-Training2)

