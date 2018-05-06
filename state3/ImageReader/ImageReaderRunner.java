/*++++++++++++++++++++++++++++++++++++++++++++++
 * SYSU Software-Development-Training2
 * state3.ImageReader.ImageReaderRunner.java
 * @author: SYSUcarey
 * @date: 2018-05-03
 * @
 * ImplementImageIO.java implements IImageIO Interface in imagereader.jar
 * To implement the operation of reading and writing Image
 *++++++++++++++++++++++++++++++++++++++++++++++ 
 */
import imagereader.IImageIO;
import imagereader.IImageProcessor;
import imagereader.Runner;

public final class ImageReaderRunner {
	private ImageReaderRunner() {

	}
    public static void main(String[] args) {
        IImageIO imageioer = new ImplementImageIO();
        IImageProcessor processor = new ImplementImageProcessor();
        Runner.run(imageioer, processor);
    }
}