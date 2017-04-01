import Exception.SyntaxException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReplaceByLexeme {
    private ArrayList<String> lexeme; //список конфигураций
    private ArrayList<String> text; //список строк текстового файла

    public ReplaceByLexeme() {
        this.lexeme = new ArrayList<>();
        this.text = new ArrayList<>();
    }

    public ArrayList<String> getLexeme() {
        return lexeme;
    }

    public ArrayList<String> getText() {
        return text;
    }


    /*Чтение строк из файла*/
    public void setFromFile(String filename, ArrayList<String> arrayList) throws FileNotFoundException
    {
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNext()) {
                arrayList.add(scanner.next());
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("Ошибка: Файл не найден!\n");
        }
    }

    /*Замена символов текстового файла*/
    public void replaceText() throws SyntaxException {
        int errorIndex = 1;
        for (String lexem : lexeme) {
            if (lexem.length() == 3) {
                char[] charArray = lexem.toCharArray();
                if (charArray[1] == '=') {
                    int i = 0;
                    for (String result : text) {
                        text.set(i, result.replace(charArray[0], charArray[2]));
                        i++;
                    }
                }
                else throw new SyntaxException("Ошибка файла конфигурации: не найден знак равенства в строке № " + errorIndex + "!");
            }
            else throw new SyntaxException("Ошибка файла конфигурации: значения должны быть односимвольными, без пробелов");
            errorIndex++;
        }
    }

    /*Построчная запись текста в файл*/
    public void writeFile (String filename) throws IOException {
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            for (String result : text)
            {
                bufferedWriter.write(result+"\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (IOException e)
        {
            throw new IOException("Ошибка: Файл не найден!\n");
        }
    }
}