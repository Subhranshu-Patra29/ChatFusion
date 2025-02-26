
package testing;

import chatfusion.Chat.blurHash.BlurHash;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class TestBlurHash {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("D:\\photos a22\\howrah bridge.jpg"));
            String blurhashStr = BlurHash.encode(image);
            System.out.println(blurhashStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
