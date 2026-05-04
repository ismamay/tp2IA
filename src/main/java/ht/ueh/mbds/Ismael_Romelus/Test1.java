package ht.ueh.mbds.Ismael_Romelus;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class Test1 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY"); // ou GEMINI_API_KEY selon ta config

        ChatModel modele = GoogleAiGeminiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .build();

        String reponse = modele.chat("Quelle heure est-il eh haiti ?");
//        System.out.println(reponse);
        String reponse1 = modele.chat("Bonjour, je m'appelle Ismael Romelus.");
        System.out.println(reponse1);
        String reponse2 = modele.chat("Comment je m'appelle ?");
        System.out.println(reponse2);
    }
}
