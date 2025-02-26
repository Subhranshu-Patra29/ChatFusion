package chatfusion.chatbotAI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author subha
 */
public class aiReplier {
    public static String generateAIReply(String prompt) {
        StringBuilder response = new StringBuilder();
        try {
            // Define the Python command and the path to the script
            String pythonCommand = "python";
            String scriptPath = "D:\\\\Projects\\\\ChatBot\\\\chatbot.py";

            // Create the process builder to run the Python script
            ProcessBuilder processBuilder = new ProcessBuilder(pythonCommand, scriptPath);
            processBuilder.environment().put("PYTHONIOENCODING", "utf-8");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Send the prompt to the Python script
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(process.getOutputStream(), "UTF-8"), true);
            writer.println(prompt);
            writer.close();

            // Capture the output from the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            // Close the reader
            reader.close();

            // Output the response
            System.out.println("Response from Python script:");
            System.out.println(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
