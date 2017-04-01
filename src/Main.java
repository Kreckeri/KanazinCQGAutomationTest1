import Exception.SyntaxException;
import java.io.IOException;

public class Main {
    public static void main(String [] args) throws SyntaxException, IOException {
        ReplaceByLexeme obj = new ReplaceByLexeme();

        obj.setFromFile(args[0],obj.getLexeme());
        System.out.println("Список лексем: "+ obj.getLexeme()+"\n");

        obj.setFromFile(args[1],obj.getText());
        System.out.println("Исходный текст: "+ obj.getText()+"\n");

        obj.replaceText();
        obj.writeFile(args[1]);

        System.out.println("Изменённый txt: "+ obj.getText());

    }
}