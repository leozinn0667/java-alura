public enum API {
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ImdbExtrator()),
    NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json", new NasaExtrator());

    private String url;
    private ConteudoExtrator extrator;

    API(String url, ConteudoExtrator extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ConteudoExtrator getExtrator() {
        return extrator;
    }

}
