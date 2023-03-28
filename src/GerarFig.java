import java.awt.Color;
import java.awt.Font;
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


            // escrever comentário na imagem
            
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        
        graphics.drawString("Nota", 0, novaAltura - 100);

            // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }

}