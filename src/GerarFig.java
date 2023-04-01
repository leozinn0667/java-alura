import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GerarFig {
    
    public void criar(InputStream inputStream, String nomeArquivo) throws Exception {

            // ler imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

            // criar nova imagem(transparente e tamanho novo)
        int largura = imagemOriginal.getWidth(); 
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

            // copiar a imagem original
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // centralizar
        String texto = "BOTTOM TEXT";
        FontMetrics metrics = graphics.getFontMetrics();
        int larguraTexto = metrics.stringWidth(texto);
        // int meio = (largura - larguraTexto) / 2;
        // int metadeTexto = (larguraTexto / 2);

        int posX = (largura - larguraTexto) / 2 - (larguraTexto / 4);

            // escrever comentário na imagem
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        graphics.drawString(texto, posX, novaAltura - 100);
        

            // escrever a nova imagem em um arquivo

            File diretorio = new File("saida");
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }

        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }

}
