
package convolution;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
public class Convolution 
{
public static void main( String[] args )
{
try {
int kernelSize = 9;
System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
Mat source = Highgui.imread("grayscale.jpg",
Highgui.CV_LOAD_IMAGE_GRAYSCALE);
Mat destination = new Mat(source.rows(),source.cols(),source.type());
Mat kernel = Mat.ones(kernelSize,kernelSize, CvType.CV_32F);
for(int i=0; i<kernel.rows(); i++){
for(int j=0; j<kernel.cols(); j++){
double[] m = kernel.get(i, j);
for(int k =0; k<m.length; k++){
m[k] = m[k]/(kernelSize * kernelSize);
}
kernel.put(i,j, m);
}
}
Imgproc.filter2D(source, destination, -1, kernel);
Highgui.imwrite("output.jpg", destination);
} catch (Exception e) {
System.out.println("Error: " + e.getMessage());
}
}
}