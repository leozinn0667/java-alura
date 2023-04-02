import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // ConteudoExtrator extrator = new ImdbExtrator();
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        // ConteudoExtrator extrator = new NasaExtrator();

        // pega a config da enum API
        API api = API.NASA;
        String url = api.getUrl();
        ConteudoExtrator extrator = api.getExtrator();

        var http = new httpClient();
        String json = http.buscaDados(url);

        var geradora = new GerarFig();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // for (Map<String,String> conteudo : listaDeConteudos) {

            for (int i = 0; i < 3; i++) {
                Conteudo conteudo = conteudos.get(i);

                InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
                String nomeArquivo = conteudo.titulo().replace(":", "-")  + ".png";
    
                geradora.criar(inputStream, nomeArquivo);
    
                System.out.println(conteudo.titulo());
                System.out.println();

            }
    }
}
