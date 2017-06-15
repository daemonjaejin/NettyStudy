package study.funzin.main7;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by JE on 2017-06-14.
 */
public class GenerateCharacters {

    public static void main(String [] args){
        System.out.println("test");
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.println(b);
            }
        };

        try {
            generateCharacters(out);
        }catch (IOException ioe){
            ExceptionUtils.getStackTrace(ioe);
        }

    }

    public static void generateCharacters(OutputStream out) throws IOException{

        int firstPrintableCharacter =       33;
        int numberOfPrintableCharacters =   94;
        int numberOfCharactersPerLine =     72;

        int start = firstPrintableCharacter;

        // +는 캐리지리턴과 라인피드를 위함이다.
        byte [] line = new byte[numberOfCharactersPerLine + 2];


        while (true){ /* 무한 루프 */
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                out.write((
                        (i - firstPrintableCharacter) % numberOfPrintableCharacters)
                        + firstPrintableCharacter);
            }
//            out.write('\r'); // 캐리지 리턴
//            out.write('\n'); // 라인피드
            line[72] = (byte) '\r'; // CR(캐리지리턴)
            line[73] = (byte) '\n'; // CR(라인피드)
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter;
        }

    }

}
