import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

            // HTTP connect
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient(); // pode usar VAR, ele sabe que é HttpClient
        var request = HttpRequest.newBuilder(endereco).GET().build(); // Http request
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();


            // Parse JSON (titulo, poster, nota)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // System.out.println(listaDeFilmes.size());

            // Exibir

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("imDbRating"));
            System.out.println(filme.get("imDbRatingCount"));
            System.out.println();
        }
    }
}
