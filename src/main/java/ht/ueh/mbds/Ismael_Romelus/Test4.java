package ht.ueh.mbds.Ismael_Romelus;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.googleai.GoogleAiEmbeddingModel;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.store.embedding.CosineSimilarity;

import java.time.Duration;

public class Test4 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        EmbeddingModel modele = GoogleAiEmbeddingModel.builder()
                .apiKey(cle)
                .modelName("gemini-embedding-001")
                .taskType(GoogleAiEmbeddingModel.TaskType.SEMANTIC_SIMILARITY)
                .outputDimensionality(300)
                .timeout(Duration.ofSeconds(10))
                .build();

        Embedding embedding1 = modele.embed("Le chat dort sur le lit.").content();
        Embedding embedding2 = modele.embed("Le chien se repose sur la chaise.").content();
        Embedding embedding3 = modele.embed("La voiture roule sur l'autoroute.").content();

        double sim12 = CosineSimilarity.between(embedding1, embedding2);
        double sim13 = CosineSimilarity.between(embedding1, embedding3);

        System.out.println("Similarité phrases similaires : " + sim12);
        System.out.println("Similarité phrases différentes : " + sim13);
    }
}
