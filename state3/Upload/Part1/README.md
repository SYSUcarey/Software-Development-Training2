#大二实训（三）ImageReader

@author: SYSUcarey
@date: 2018-05-06
@blog: [https://blog.csdn.net/cbb944131226](https://blog.csdn.net/cbb944131226)
@[本人学院](http://sdcs.sysu.edu.cn/)
目录：
	
[TOC]

##Upload文件结构
```
.
├── ImageProcessorTest.java
├── ImplementImageIO.java
├── ImplementImageProcessor.java
├── README.md
└── ...
```
##项目实验介绍
**实验介绍：**
利用课程网页上提供的实验软装置`ImageReader_code.zip`和测试图片集`bmptest.zip`简单实现和检验一个利用二进制流读取Bitmap图像，并且能够进行简单的色彩处理和保存的软件。
**实验要求：**
1.利用二进制流读取Bitmap位图文件。注意，这里要求不能使用Java提供的API直接读取图像，根据二进制数据创建Image时可以使用API；
2.把读取彩色图像转换成灰度图像；
3.提取并且显示彩色图像各个色彩通道；
4.把处理完的图像保存为bmp格式图像。注意，这里可以使用Java提供的API完成，但本文档不提供，希望各位同学自行上网查找资料自学。如果学有余力的同学，可以实现按照二进制流输出保存bmp图像；
5.编写Junit测试程序，测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度以及像素值）
**配置环境**
配置三个Jar包的环境变量，`ImageReader.jar`、`swing-worker-1.1.jar`、`appframework-1.0.3.jar`，三个Jar包都在`ImageReader_code.zip`里。
```
export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_91
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:/home/administrator/Downloads/junit-4.9.jar:/home/administrator/Downloads/gridworld.jar:/home/administrator/Downloads/ImageReader.jar:/home/administrator/Downloads/swing-worker-1.1.jar:/home/administrator/Downloads/appframework-1.0.3.jar:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH:$HOME/bin
```
ps：上述三行代码， `vim ~/.bashrc`后，在文件末尾中添加。
pps: 上述三行代码，是整个第三阶段的环境变量配置代码。本次实验只涉及之中三个环境变量。

##代码文件说明
`ImplementImageIO.java`与`ImplementImageProcessor.java`是实现`ImageReader.jar`包中的`IImageIO`与`IImageProcessor`接口。
![这里写图片描述](https://img-blog.csdn.net/20180506165449112?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NiYjk0NDEzMTIyNg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180506165500410?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NiYjk0NDEzMTIyNg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

`ImageProcessorTest.java`是实验的Junit测试文件，用来检测，打开、进行简单色彩处理、保存图片之后，保存的新BMP文件是否与goal文件夹下的图片一致。（通过比较位图宽度、位图高度以及像素数据）

##使用说明
编译运行`ImageReaderRunner.java`
![这里写图片描述](https://img-blog.csdn.net/20180506170450323?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NiYjk0NDEzMTIyNg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180506170502827?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NiYjk0NDEzMTIyNg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
##更多
[Talk is cheap, show you the code.](https://github.com/SYSUcarey/Software-Development-Training2)