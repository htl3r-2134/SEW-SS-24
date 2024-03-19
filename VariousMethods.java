package Heyderer.ue11_textio;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VariousMethods {
    public static void convertFileToUpperCase(String srcFile, String destFile) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(
                        Paths.get(srcFile),
                        Charset.forName("UTF-8")
                );

                BufferedWriter out = Files.newBufferedWriter(
                        Paths.get(destFile),
                        Charset.forName("UTF-8")
                );
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line.toUpperCase() + System.lineSeparator());
            }
        }
    }

    public static void convertFileToLowerCase(String srcFile, String destFile) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(
                        Paths.get(srcFile),
                        Charset.forName("UTF-8")
                );

                BufferedWriter out = Files.newBufferedWriter(
                        Paths.get(destFile),
                        Charset.forName("UTF-8")
                );
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line.toLowerCase() + System.lineSeparator());
            }
        }
    }

    public static boolean compareFiles(String srcFile1, String srcFile2) throws IOException {
        try (
                BufferedReader one = Files.newBufferedReader(
                        Paths.get(srcFile1),
                        Charset.forName("UTF-8")
                );

                BufferedReader two = Files.newBufferedReader(
                        Paths.get(srcFile2),
                        Charset.forName("UTF-8")
                );
        ) {
            String fileone;
            String filetwo;

            if (srcFile1.toString().isEmpty() && srcFile2.toString().isEmpty()) {
                return true;
            }
            while ((filetwo = two.readLine()) != null && (fileone = one.readLine()) != null) {
                if (!fileone.equals(filetwo)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void encryptFileCaesar(String srcFile, String destFile, int key) throws IOException {
        try (
                BufferedReader fileone = Files.newBufferedReader(
                        Paths.get(srcFile),
                        Charset.forName("UTF-8")
                );
                BufferedWriter filetwo = Files.newBufferedWriter(
                        Paths.get(destFile),
                        Charset.forName("UTF-8")
                )
        ) {

            int character;
            while ((character = fileone.read()) != -1) {
                char encryptedChar;
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    encryptedChar = (char) ((character - base + key) % 26 + base);
                } else {
                    encryptedChar = (char) character;
                }
                filetwo.write(encryptedChar);
            }
        }
    }

    public static void decryptFileCaesar(String srcFile, String destFile, int key) throws IOException {
        int decryptionKey = 26 - key;

        try (
                BufferedReader reader = Files.newBufferedReader(
                        Paths.get(srcFile),
                        Charset.forName("UTF-8")
                );

                BufferedWriter writer = Files.newBufferedWriter(
                        Paths.get(destFile),
                        Charset.forName("UTF-8")
                )
        ) {

            int character;
            while ((character = reader.read()) != -1) {
                char decryptedChar;
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    decryptedChar = (char) ((character - base + decryptionKey + 26) % 26 + base);
                } else {
                    decryptedChar = (char) character;
                }
                writer.write(decryptedChar);
            }
        }
    }
/*
    public static char vigenereTable(char src, char key) {
        int verschubfakotor = Character.toLowerCase(key) - 'a';
        if (src >= 'A' && src <= 'Z') {
            src += verschubfakotor;
            if (src > 'Z') {
                src -= 26;
            }
            return src;
        }
        else if (src >= 'a' && src <= 'z') {
            // TODO
        }
        return src;
    }
    public static void encryptFileVigenere(String srcFile, String destFile, String key) throws IOException {
        BufferedReader reader = Files.newBufferedReader(
                Paths.get(srcFile),
                Charset.forName("UTF-8")
        );
        BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(destFile),
                Charset.forName("UTF-8")
        );
        String line;
        while ((line = reader.readLine() ) != null) {

        }
        writer.close();
    }

 */

}
