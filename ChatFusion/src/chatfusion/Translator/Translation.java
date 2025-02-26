package chatfusion.Translator;

import com.darkprograms.speech.translator.GoogleTranslate;
import java.io.IOException;

public class Translation {

    public String translateText(String fromLang, String toLang, String text) {
        try {
            String translatedText = GoogleTranslate.translate(fromLang, toLang, text);
            return translatedText;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return "Unknown Error in translating";
        }
    }

    public String translateText(String toLang, String text) {
        try {
            String translatedText = GoogleTranslate.translate(toLang, text);
            return translatedText;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return "Unknown Error in translating";
        }
    }
}
