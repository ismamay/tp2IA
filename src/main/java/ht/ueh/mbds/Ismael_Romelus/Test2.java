package ht.ueh.mbds.Ismael_Romelus;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.data.message.UserMessage;

public class Test2 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel modele = GoogleAiGeminiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .build();

        ChatRequest requete = ChatRequest.builder()
                .messages(UserMessage.from("Je dois partir dans 2 jours à Paris. Est-ce que je dois mettre un parapluie dans mes valises ?"))
                .build();

        ChatResponse reponse = modele.chat(requete);

        double prixEntree = 0.30 / 1_000_000;
        double prixSortie = 2.50 / 1_000_000;

        System.out.println("Réponse : " + reponse.aiMessage().text());
        System.out.println("Tokens en entrée : " + reponse.tokenUsage().inputTokenCount());
        System.out.println("Tokens en sortie : " + reponse.tokenUsage().outputTokenCount());
        System.out.println("Total tokens : " + reponse.tokenUsage().totalTokenCount());

        double coutRequete = (reponse.tokenUsage().inputTokenCount() * prixEntree)
                + (reponse.tokenUsage().outputTokenCount() * prixSortie);

        System.out.println("Coût de la requête : " + coutRequete + " $");
        System.out.println("Nombre de requêtes pour 1$ : " + (long)(1.0 / coutRequete));
    }
}
