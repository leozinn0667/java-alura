import java.util.List;
import java.util.Map;

public class ImdbExtrator implements ConteudoExtrator {
    
    public List<Conteudo> extraiConteudos(String json) {

        // Parse JSON (titulo, poster, nota)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        return listaDeAtributos.stream()
        .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image"))).toList();

        // List<Conteudo> conteudos = new ArrayList<>();

        // // popular a lista de conteudos
        // for (Map<String, String> atributos : listaDeAtributos) {

        //     String titulo = atributos.get("title");
        //     String urlImagem = atributos.get("image");
        //     var conteudo = new Conteudo(titulo, urlImagem);

        //     conteudos.add(conteudo);
        // }

        // return conteudos;

    }

}
