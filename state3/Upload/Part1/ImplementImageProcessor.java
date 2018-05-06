/*++++++++++++++++++++++++++++++++++++++++++++++
 * SYSU Software-Development-Training2
 * state3.ImageReader.ImplementImageProcessor.java
 * @author: SYSUcarey
 * @date: 2018-05-03
 * @
 * ImplementImageIO.java implements IImageProcessor Interface in imagereader.jar
 *++++++++++++++++++++++++++++++++++++++++++++++ 
 */
import imagereader.IImageProcessor;  
  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.awt.image.FilteredImageSource;  
import java.awt.image.RGBImageFilter;  

public class ImplementImageProcessor implements IImageProcessor {

	public Image showChanelR(Image sourceImage) {
		ColorFilter redFilter = new ColorFilter(1);  
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), redFilter));  
        
	}

	public Image showChanelG(Image sourceImage) {
		ColorFilter greenFilter = new ColorFilter(2);  
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), greenFilter));  
       
	}

	public Image showChanelB(Image sourceImage) {
		ColorFilter blueFilter = new ColorFilter(3);   
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), blueFilter));  
   
	}

	public Image showGray(Image sourceImage) {
		ColorFilter grayFilter = new ColorFilter(4);  
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), grayFilter));  
        
	}

}

/*
 * Create a colorFilter to chose the RGB color we need
 * the parameter: int is used to defined the kind of ColorFilter
 * 1 for the redFilter
 * 2 for the greenFilter
 * 3 for the blueFilter
 * other is the grayFilter 
 */
class ColorFilter extends RGBImageFilter{  
    private int colorNum;  
  
    public ColorFilter(int c){  
        colorNum = c;  
        canFilterIndexColorModel = true;  
    }  
      
    public int filterRGB(int x, int y, int rgb){   
        if(colorNum==1){  
            return ( rgb & 0xffff0000 );  
        }else if(colorNum==2){  
            return ( rgb & 0xff00ff00 );  
        }else if(colorNum==3){  
            return ( rgb & 0xff0000ff );  
        }else{  
            int g = (int)( ((rgb & 0x00ff0000) >> 16)*0.299 + ((rgb & 0x0000ff00) >> 8 )*0.587  
                    + ((rgb & 0x000000ff))*0.114 );  
            return (rgb & 0xff000000) + (g << 16) + (g << 8) + g;  
        }  
    }  
}  
