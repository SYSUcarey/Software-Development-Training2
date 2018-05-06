/*++++++++++++++++++++++++++++++++++++++++++++++
 * SYSU Software-Development-Training2
 * state3.ImageReader.ImageProcessorTest.java
 * @author: SYSUcarey
 * @date: 2018-05-03
 * @
 * Using Junit
 * Test the methods implemented in ImplementImageProcessor.java
 *++++++++++++++++++++++++++++++++++++++++++++++ 
 */
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;  
import java.io.FileInputStream;  

public class ImageProcessorTest {

	private int tempOfInt = 0xff;
	/* Store the path:String of 16 bmp file.
     * The goal folder is given .
     *   which is used to check whether it is the same
     *     as the ouput answers.
     * The result folder is created by me
     *   storing the output BMP file.
     */
	private String pathOfBlueGoalBmp1 = "../bmptest/goal/1_blue_goal.bmp";
	private String pathOfBlueResultBmp1 = "../bmptest/saveResult/1_blue_result.bmp";
	private String pathOfGrayGoalBmp1 = "../bmptest/goal/1_gray_goal.bmp";
	private String pathOfGrayResultBmp1 = "../bmptest/saveResult/1_gray_result.bmp";
	private String pathOfGreenGoalBmp1 = "../bmptest/goal/1_green_goal.bmp";
	private String pathOfGreenResultBmp1 = "../bmptest/saveResult/1_green_result.bmp";
	private String pathOfRedGoalBmp1 = "../bmptest/goal/1_red_goal.bmp";
	private String pathOfRedResultBmp1 = "../bmptest/saveResult/1_red_result.bmp";

	private String pathOfBlueGoalBmp2 = "../bmptest/goal/2_blue_goal.bmp";
	private String pathOfBlueResultBmp2 = "../bmptest/saveResult/2_blue_result.bmp";
	private String pathOfGrayGoalBmp2 = "../bmptest/goal/2_gray_goal.bmp";
	private String pathOfGrayResultBmp2 = "../bmptest/saveResult/2_gray_result.bmp";
	private String pathOfGreenGoalBmp2 = "../bmptest/goal/2_green_goal.bmp";
	private String pathOfGreenResultBmp2 = "../bmptest/saveResult/2_green_result.bmp";
	private String pathOfRedGoalBmp2 = "../bmptest/goal/2_red_goal.bmp";
	private String pathOfRedResultBmp2 = "../bmptest/saveResult/2_red_result.bmp";


	/*
	 * Test1:
	 * Test the width of the root bmp and result bmp.
	 * Using the self-defined method getWidthOfBmp() to get the width.
	 */
	@Test
	public void testWidth() {
		int rootBlueWidth = getWidthOfBmp(pathOfBlueGoalBmp1);
		int resultBlueWidth = getWidthOfBmp(pathOfBlueResultBmp1);

		int rootGrayWidth = getWidthOfBmp(pathOfGrayGoalBmp1);
		int resultGrayWidth = getWidthOfBmp(pathOfGrayResultBmp1);

		int rootGreenWidth = getWidthOfBmp(pathOfGreenGoalBmp1);
		int resultGreenWidth = getWidthOfBmp(pathOfGreenResultBmp1);

		int rootRedWidth = getWidthOfBmp(pathOfRedGoalBmp1);
		int resultRedWidth = getWidthOfBmp(pathOfRedResultBmp1);

		int rootBlueWidth2 = getWidthOfBmp(pathOfBlueGoalBmp2);
		int resultBlueWidth2 = getWidthOfBmp(pathOfBlueResultBmp2);

		int rootGrayWidth2 = getWidthOfBmp(pathOfGrayGoalBmp2);
		int resultGrayWidth2 = getWidthOfBmp(pathOfGrayResultBmp2);

		int rootGreenWidth2 = getWidthOfBmp(pathOfGreenGoalBmp2);
		int resultGreenWidth2 = getWidthOfBmp(pathOfGreenResultBmp2);

		int rootRedWidth2 = getWidthOfBmp(pathOfRedGoalBmp2);
		int resultRedWidth2 = getWidthOfBmp(pathOfRedResultBmp2);
		
		assertEquals(rootBlueWidth, resultBlueWidth);
		assertEquals(rootGrayWidth, resultGrayWidth);
		assertEquals(rootGreenWidth, resultGreenWidth);
		assertEquals(rootRedWidth, resultRedWidth);

		assertEquals(rootBlueWidth2, resultBlueWidth2);
		assertEquals(rootGrayWidth2, resultGrayWidth2);
		assertEquals(rootGreenWidth2, resultGreenWidth2);
		assertEquals(rootRedWidth2, resultRedWidth2);
	}

	/*
	 * Test2:
	 * Test the height of the root bmp and result bmp.
	 * Using the self-defined method getHeightOfBmp() to get the height.
	 */
	@Test
	public void testHeight() {
		int rootBlueHeight = getHeightOfBmp(pathOfBlueGoalBmp1);
		int resultBlueHeight = getHeightOfBmp(pathOfBlueResultBmp1);

		int rootGrayHeight = getHeightOfBmp(pathOfGrayGoalBmp1);
		int resultGrayHeight = getHeightOfBmp(pathOfGrayResultBmp1);

		int rootGreenHeight = getHeightOfBmp(pathOfGreenGoalBmp1);
		int resultGreenHeight = getHeightOfBmp(pathOfGreenResultBmp1);

		int rootRedHeight = getHeightOfBmp(pathOfRedGoalBmp1);
		int resultRedHeight = getHeightOfBmp(pathOfRedResultBmp1);

		int rootBlueHeight2 = getHeightOfBmp(pathOfBlueGoalBmp2);
		int resultBlueHeight2 = getHeightOfBmp(pathOfBlueResultBmp2);

		int rootGrayHeight2 = getHeightOfBmp(pathOfGrayGoalBmp2);
		int resultGrayHeight2 = getHeightOfBmp(pathOfGrayResultBmp2);

		int rootGreenHeight2 = getHeightOfBmp(pathOfGreenGoalBmp2);
		int resultGreenHeight2 = getHeightOfBmp(pathOfGreenResultBmp2);

		int rootRedHeight2 = getHeightOfBmp(pathOfRedGoalBmp2);
		int resultRedHeight2 = getHeightOfBmp(pathOfRedResultBmp2);
		
		assertEquals(rootBlueHeight, resultBlueHeight);
		assertEquals(rootGrayHeight, resultGrayHeight);
		assertEquals(rootGreenHeight, resultGreenHeight);
		assertEquals(rootRedHeight, resultRedHeight);

		assertEquals(rootBlueHeight2, resultBlueHeight2);
		assertEquals(rootGrayHeight2, resultGrayHeight2);
		assertEquals(rootGreenHeight2, resultGreenHeight2);
		assertEquals(rootRedHeight2, resultRedHeight2);
	}

	/*
	 * Test3:
	 * Test the whole InfoBmpBytes
	 * Using the self-defined method getHeightOfBmp()  to get the infoBytes
	 * Notes: must use assertArrayEqual() to test the two byte[]
	 *            not use the assertEqual()
	 */

	@Test
	public void testInfoByte() {
		byte[] rootInfo;
		byte[] resultInfo;

		rootInfo = getInfoOfBmp(pathOfBlueGoalBmp1);
		resultInfo = getInfoOfBmp(pathOfBlueResultBmp1);
		assertArrayEquals(rootInfo, resultInfo);

		rootInfo = getInfoOfBmp(pathOfGrayGoalBmp1);
		resultInfo = getInfoOfBmp(pathOfGrayResultBmp1);
		assertArrayEquals(rootInfo, resultInfo);

		rootInfo = getInfoOfBmp(pathOfGreenGoalBmp1);
		resultInfo = getInfoOfBmp(pathOfGreenResultBmp1);
		assertArrayEquals(rootInfo, resultInfo);

		rootInfo = getInfoOfBmp(pathOfRedGoalBmp1);
		resultInfo = getInfoOfBmp(pathOfRedResultBmp1);
		assertArrayEquals(rootInfo, resultInfo);

		rootInfo = getInfoOfBmp(pathOfBlueGoalBmp2);
		resultInfo = getInfoOfBmp(pathOfBlueResultBmp2);
		assertArrayEquals(rootInfo, resultInfo);

		rootInfo = getInfoOfBmp(pathOfGrayGoalBmp2);
		resultInfo = getInfoOfBmp(pathOfGrayResultBmp2);
		assertArrayEquals(rootInfo, resultInfo);

		rootInfo = getInfoOfBmp(pathOfGreenGoalBmp2);
		resultInfo = getInfoOfBmp(pathOfGreenResultBmp2);
		assertArrayEquals(rootInfo, resultInfo);

		rootInfo = getInfoOfBmp(pathOfRedGoalBmp2);
		resultInfo = getInfoOfBmp(pathOfRedResultBmp2);
		assertArrayEquals(rootInfo, resultInfo);
		
	}



	/*
	 * Method getWidthOfBmp(String filePath) return the width of the Bmp file.
	 * Using FileInputStream to read the file into byte[].
	 * The imformation of width is stored in the byte[18] ~ byte[21]
	 * Translate byte[18] ~ byte[21] to (int) width.
	 */
	public int getWidthOfBmp(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);

			byte bmpHeader[] = new byte[54];

			fis.read(bmpHeader, 0, 54);

			int width = (int) ( (bmpHeader[21] & tempOfInt) << 24 
									| (bmpHeader[20] & tempOfInt) << 16
									| (bmpHeader[19] & tempOfInt) << 8 
									| (bmpHeader[18] & tempOfInt) );
			return width;
		}catch (Exception e) {
			return -1;
		}
	}

	/*
	 * Method getWidthOfBmp(String filePath) return the height of the Bmp file.
	 * Using FileInputStream to read the file into byte[].
	 * The imformation of height is stored in the byte[22] ~ byte[25]
	 * Translate byte[22] ~ byte[25] to (int) height.
	 */
	public int getHeightOfBmp(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);

			byte bmpHeader[] = new byte[54];

			fis.read(bmpHeader, 0, 54);

			int height = (int) ( (bmpHeader[25] & tempOfInt) << 24 
									| (bmpHeader[24] & tempOfInt) << 16
									| (bmpHeader[23] & tempOfInt) << 8 
									| (bmpHeader[22] & tempOfInt) );
			return height;
		}catch (Exception e) {
			return -1;
		}
	}

	

	/*
	 * Method getInfoBmp(String filePath) return the byte[] of the Bmp infomation .
	 * Using FileInputStream to read the file into byte[].
	 * The imformation of bmpfile is stored after the first byte[54]
	 * we first get the size of those Infobyte[] stored in headbyte[34~37]
	 * Translate them into byte[]
	 */
	public byte[] getInfoOfBmp(String filePath) {
		try{
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);

			byte bmpHeader[] = new byte[54];
			fis.read(bmpHeader, 0, 54);

			int biSizeImage = (int) ( (bmpHeader[37] & tempOfInt) << 24 
									| (bmpHeader[36] & tempOfInt) << 16
									| (bmpHeader[35] & tempOfInt) << 8 
									| (bmpHeader[34] & tempOfInt) );

			
			byte allBmpByte[] = new byte[biSizeImage];

			fis.read(allBmpByte, 0, biSizeImage);
			return allBmpByte;
		} catch (Exception e) {
			return null;
		}
	}

}