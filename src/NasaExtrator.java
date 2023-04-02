import java.util.List;
import java.util.Map;

public class NasaExtrator implements ConteudoExtrator {
    
    public List<Conteudo> extraiConteudos(String json) {

        
        // Parse JSON (titulo, poster, nota)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);


        // popular a lista de conteudos
        return listaDeAtributos.stream()
            .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url"))).toList();
    

        // List<Conteudo> conteudos = new ArrayList<>();

        // for (Map<String, String> atributos : listaDeAtributos) {

        //     String titulo = atributos.get("title");
        //     String urlImagem = atributos.get("url");
        //     var conteudo = new Conteudo(titulo, urlImagem);

        //     conteudos.add(conteudo);
        // }

        // return conteudos;

    }

}
