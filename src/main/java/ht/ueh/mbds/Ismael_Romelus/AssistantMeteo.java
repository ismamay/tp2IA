package ht.ueh.mbds.Ismael_Romelus;

import dev.langchain4j.service.SystemMessage;

public interface AssistantMeteo {
    @SystemMessage("Tu es un assistant polyvalent. Tu peux répondre à toutes les questions. " +
            "Tu as accès à des outils pour obtenir les prévisions météo et les coordonnées des villes.")
    String chat(String userMessage);
}
