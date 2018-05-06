/*++++++++++++++++++++++++++++++++++++++++++++++
 * SYSU Software-Development-Training2
 * state3.ImageReader.ImplementImageIO.java
 * @author: SYSUcarey
 * @date: 2018-05-03
 * @
 * ImplementImageIO.java implements IImageIO Interface in imagereader.jar
 * To implement the operation of reading and writing Image
 *++++++++++++++++++++++++++++++++++++++++++++++ 
 */
import java.awt.Graphics2D;  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.awt.image.BufferedImage;  
import java.awt.image.ImageProducer;  
import java.awt.image.MemoryImageSource;  
import java.awt.image.*;
import java.io.File;  
import java.io.FileInputStream;  
  
import javax.imageio.ImageIO;  
  
import imagereader.IImageIO;

public class ImplementImageIO implements IImageIO {
	 private Image img;
	private int tempOfInt = 0xff;
	/* Using FileInputStream to read the file into byte[].
 	 * Using byte[] imformation to create pixArray[].
 	 * Using method Toolkit.getDefaultToolkit().createImage(ImageProducer producer)
 	 *   to creat Image for returning.
 	 *  
 	 */
	public Image myRead(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream fins = new FileInputStream(file);

			byte bmpFileHeader[] = new byte[14];
			byte bmpInfoHeader[] = new byte[40];
			
			fins.read(bmpFileHeader, 0, 14);
			fins.read(bmpInfoHeader, 0, 40);
			/* if byte b = -127;  b = (10000001)B
			 * int a1 = (int) b;  a = -127 = (11111111 11111111 11111111 10000001)B
			 * int a2 = (int) (b & tempOfInt); a = 129 = (00000000 00000000 00000000 10000001)B
			 * So here we use (byte & tempOfInt) and | to get the int data. 
			 */
			
			int biWidth = (int) ( (bmpInfoHeader[7] & tempOfInt) << 24 
									| (bmpInfoHeader[6] & tempOfInt) << 16
									| (bmpInfoHeader[5] & tempOfInt) << 8 
									| (bmpInfoHeader[4] & tempOfInt) );

			int biHeight = (int) ( (bmpInfoHeader[11] & tempOfInt) << 24 
									| (bmpInfoHeader[10] & tempOfInt) << 16
									| (bmpInfoHeader[9] & tempOfInt) << 8 
									| (bmpInfoHeader[8] & tempOfInt) );

			int biBitCount = (int) ( (bmpInfoHeader[15] & tempOfInt) << 8 
									| (bmpInfoHeader[14] & tempOfInt));

			int biSizeImage = (int) ( (bmpInfoHeader[23] & tempOfInt) << 24 
									| (bmpInfoHeader[22] & tempOfInt) << 16
									| (bmpInfoHeader[21] & tempOfInt) << 8 
									| (bmpInfoHeader[20] & tempOfInt) );
			
			if (biBitCount == 24) {
				
				//count the empty bit Nums
				int numOfEmptyByte = biSizeImage / biHeight - 3 * biWidth;
				// numOfEmptyByte from 4 to 0
				if (numOfEmptyByte == 4) {
					numOfEmptyByte = 0;
				}
				int temp = 0;

				int pixel[] = new int [biWidth * biHeight];
				byte allBmpByte[] = new byte[biSizeImage];
				fins.read(allBmpByte, 0, biSizeImage);
				

				//From botton to top, from left to right
				for (int i = biHeight-1; i >= 0; i--) {
					for (int j = 0; j < biWidth; j++) {
						pixel[i*biWidth+j] = (tempOfInt << 24 
									| (allBmpByte[temp+2] & tempOfInt) << 16
									| (allBmpByte[temp+1] & tempOfInt) << 8 
									| (allBmpByte[temp] & tempOfInt));
						temp += 3; 
					}
					temp += numOfEmptyByte;
				}
				img = Toolkit.getDefaultToolkit().createImage(
					(ImageProducer) new MemoryImageSource(biWidth, biHeight, pixel, 0, biWidth));
				
			}
			fins.close();
			return img;
			
		}catch (Exception e) {
			return (Image)null;
		}
		
	}
	
	/* 
	 * Using BufferedImage(int width, int height, int imageType) method.
	 * Using ImageIO.write(RenderedImage im,String formatName,File output) method. 
	 */
	public Image myWrite(Image image, String filePath) {
		try {
			File file = new File(filePath + ".bmp");
			BufferedImage buffer = new BufferedImage(image.getWidth((ImageObserver)null), image.getHeight((ImageObserver)null), BufferedImage.TYPE_INT_RGB);
			Graphics2D graph = buffer.createGraphics();
			graph.drawImage(image, 0, 0, null);
			graph.dispose();
			ImageIO.write(buffer, "bmp", file);
			return image;
		} catch (Exception e) {
			return (Image)null;
		}
	}

}

