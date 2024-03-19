package Heyderer.ue11_textio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VariousMethodsTest {

    @org.junit.jupiter.api.Test
    void convertFileToUpperCase0() {
        String __msg = "";
        try {
            VariousMethods.convertFileToUpperCase("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.upper");
            List<String> result = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.upper"));
            __msg = "result.get(0)";
            assertEquals("HELLO",
                    result.get(0)
                    , __msg);
            __msg = "result.get(1)";
            assertEquals("WORLD",
                    result.get(1)
                    , __msg);
            __msg = "result.size()";
            assertEquals(2,
                    result.size()
                    , __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void convertFileToUpperCase1() {
        String __msg = "";
        try {
                VariousMethods.convertFileToLowerCase("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.upper");
                List<String> result = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.upper"));
                __msg = "result.size()";
                assertEquals(0,
                        result.size()
                        , __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void convertFileToUpperCase2() {
        String __msg = "convertFileToUpperCase(\"resources/bad.txt\", \"resources/bad.upper\")";
        assertThrows(IOException.class, () -> {
            VariousMethods.convertFileToUpperCase("resources/bad.txt", "resources/bad.upper")
            ; }, __msg);
    }

    @org.junit.jupiter.api.Test
    void convertFileToUpperCase3() {
        String __msg = "convertFileToUpperCase(\"nosuchfile\", \"resources/bad.upper\")";
        assertThrows(IOException.class, () -> {
            VariousMethods.convertFileToUpperCase("nosuchfile", "resources/bad.upper")
            ; }, __msg);
    }


    @org.junit.jupiter.api.Test
    void convertFileToLowerCase0() {
        String __msg = "";
        try {
            VariousMethods.convertFileToLowerCase("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.lower");
            List<String> result = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.lower"));
            __msg = "result.get(0)";
            assertEquals("hello",
                    result.get(0)
                    , __msg);
            __msg = "result.get(1)";
            assertEquals("world",
                    result.get(1)
                    , __msg);
            __msg = "result.size()";
            assertEquals(2,
                    result.size()
                    , __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void convertFileToLowerCase1() {
        String __msg = "";
        try {
                VariousMethods.convertFileToLowerCase("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.lower");
                List<String> result = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.lower"));
                __msg = "result.size()";
                assertEquals(0,
                        result.size()
                        , __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void convertFileToLowerCase2() {
        String __msg = "convertFileToLowerCase(\"resources/bad.txt\", \"resources/bad.lower\")";
        assertThrows(IOException.class, () -> {
            VariousMethods.convertFileToLowerCase("resources/bad.txt", "resources/bad.lower")
            ; }, __msg);
    }

    @org.junit.jupiter.api.Test
    void compareFiles0() {
        String __msg = "";
        try {
            __msg = "compareFiles(\"resources/simple.txt\", \"resources/simple.txt\")";
            assertTrue(VariousMethods.compareFiles("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.txt"), __msg);
            assertTrue(VariousMethods.compareFiles("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.txt"), __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void compareFiles1() {
        String __msg = "compareFiles(\"resources/bad.txt\", \"resources/empty.txt\")";
        assertThrows(IOException.class, () -> {
            VariousMethods.compareFiles("resources/bad.txt", "resources/empty.txt")
            ; }, __msg);
    }

    @org.junit.jupiter.api.Test
    void compareFiles2() {
        String __msg = "compareFiles(\"resources/empty.txt\", \"resources/bad.txt\")";
        assertThrows(IOException.class, () -> {
            VariousMethods.compareFiles("resources/empty.txt", "resources/bad.txt")
            ; }, __msg);
    }

    @org.junit.jupiter.api.Test
    void encryptDecryptFileCaesar0() {
        String __msg = "";
        try {
            VariousMethods.encryptFileCaesar("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.encr", 3);
            VariousMethods.decryptFileCaesar("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.encr", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.decr", 3);

            List<String> result = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\simple.decr"));
            __msg = "result.get(0)";
            assertEquals("Hello",
                    result.get(0)
                    , __msg);
            __msg = "result.get(1)";
            assertEquals("World",
                    result.get(1)
                    , __msg);
            __msg = "result.size()";
            assertEquals(2,
                    result.size()
                    , __msg);

        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void encryptDecryptFileCaesar1() {
        String __msg = "encryptFileCaesar(\"resources/bad.txt\", \"resources/bad.encr\")";
        assertThrows(IOException.class, () -> {
            VariousMethods.encryptFileCaesar("resources/bad.txt", "resources/bad.encr",3)
            ; }, __msg);
    }

    @org.junit.jupiter.api.Test
    void encryptDecryptFileCaesar2() {
        String __msg = "";
        try {
            VariousMethods.encryptFileCaesar("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.encr", 3);
            VariousMethods.encryptFileCaesar("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.encr", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.decr", 3);
            List<String> result = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\empty.decr"));
            __msg = "result.size()";
            assertEquals(0,
                    result.size()
                    , __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void encryptDecryptFileCaesar3() {
        String __msg = "";
        try {
            List<String> orig = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\all.txt"));
            VariousMethods.encryptFileCaesar("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\all.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\all.encr", 3);
            VariousMethods.decryptFileCaesar("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\all.encr", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\all.decr", 3);

            List<String> encr = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\all.encr"));
            List<String> encrdecr = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\all.decr"));
            __msg = "orig";
            assertEquals(encrdecr,
                    orig
                    , __msg);
            __msg = "orig.get(0).equals(encr.get(0))";
            assertNotEquals(orig.get(0), encr.get(0), __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void encryptCaesar0() {
        String __msg = "";
        try {
            VariousMethods.encryptFileCaesar("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\zauberlehrling.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\zauberlehrling.encr", 3);

            List<String> encr = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\zauberlehrling.encr"));
            List<String> encrOrig = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\zauberlehrling.encr"));
            __msg = "check encrypted files";
            assertEquals(encrOrig,
                    encr
                    , __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }
/*
    @org.junit.jupiter.api.Test
    void encryptVigenere0() {
        String __msg = "";
        try {
            VariousMethods.encryptFileVigenere("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\zauberlehrling.txt", "C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\zauberlehrling.encr", "APFEL");

            List<String> encr = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\zauberlehrling.encr"));
            List<String> encrOrig = Files.readAllLines(Paths.get("C:\\Users\\julia\\IdeaProjects\\_2BI\\src\\resources\\zauberlehrling_vigenere.encr"));
            __msg = "check encrypted files";
            assertEquals(encrOrig,
                    encr
                    , __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void encryptDecryptFileVigenere0() {
        String __msg = "";
        try {
            VariousMethods.encryptFileVigenere("resources/simple.txt", "resources/simple.encr", "APFEL");
            VariousMethods.decryptFileVigenere("resources/simple.encr", "resources/simple.decr", "APFEL");

            List<String> result = Files.readAllLines(Paths.get("resources/simple.decr"));
            __msg = "result.get(0)";
            assertEquals("Hello",
                    result.get(0)
                    , __msg);
            __msg = "result.get(1)";
            assertEquals("World",
                    result.get(1)
                    , __msg);
            __msg = "result.size()";
            assertEquals(2,
                    result.size()
                    , __msg);

        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void encryptDecryptFileVigenere1() {
        String __msg = "encryptFileVigenere(\"resources/bad.txt\", \"resources/bad.encr\")";
        assertThrows(IOException.class, () -> {
            VariousMethods.encryptFileVigenere("resources/bad.txt", "resources/bad.encr","APFEL");
            ; }, __msg);
    }

    @org.junit.jupiter.api.Test
    void encryptDecryptFileVigenere2() {
        String __msg = "";
        try {
            VariousMethods.encryptFileVigenere("resources/empty.txt", "resources/empty.encr", "APFEL");
            VariousMethods.encryptFileVigenere("resources/empty.encr", "resources/empty.decr", "APFEL");
            List<String> result = Files.readAllLines(Paths.get("resources/empty.decr"));
            __msg = "result.size()";
            assertEquals(0,
                    result.size()
                    , __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void encryptDecryptFileVigenere3() {
        String __msg = "";
        try {
            List<String> orig = Files.readAllLines(Paths.get("resources/all.txt"));
            VariousMethods.encryptFileVigenere("resources/all.txt", "resources/all.encr", "APFEL");
            VariousMethods.decryptFileVigenere("resources/all.encr", "resources/all.decr", "APFEL");

            List<String> encr = Files.readAllLines(Paths.get("resources/all.encr"));
            List<String> encrdecr = Files.readAllLines(Paths.get("resources/all.decr"));
            __msg = "orig";
            assertEquals(encrdecr,
                    orig
                    , __msg);
            __msg = "orig.get(0).equals(encr.get(0))";
            assertNotEquals(orig.get(0), encr.get(0), __msg);
        } catch (Exception e) {
            fail(__msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void countChar0() {
        String msg = "";
        try {
            VariousMethods.countChar("resources/simple.txt", "resources/simple.cnt");
            List<String> result = Files.readAllLines(Paths.get("resources/simple.cnt"));
            msg = "result.size()";
            assertEquals(26,
                result.size()
                , msg);
            msg = "result.get(0)";
            assertEquals("l;108;3;0.3000",
                result.get(0)
                , msg);
            msg = "result.get(1)";
            assertEquals("o;111;2;0.2000",
                result.get(1)
                , msg);
            msg = "result.get(25).contains(\";0;0.0000\")";
            assertEquals(true,
                result.get(25).contains(";0;0.0000")
                , msg);
        } catch (Exception e) {
            fail(msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }

    @org.junit.jupiter.api.Test
    void countChar1() {
        String msg = "";
        try {
            VariousMethods.countChar("resources/empty.txt", "resources/empty.cnt");
            List<String> result = Files.readAllLines(Paths.get("resources/empty.cnt"));
            msg = "result.size()";
            assertEquals(26,
                    result.size()
                    , msg);
        } catch (Exception e) {
            fail(msg + ": got Exception " + e.getClass() + ": \"" + e.getMessage() + "\"");
        }
    }
*/
    @org.junit.jupiter.api.Test
    void convertToMorse() {
    }

    @org.junit.jupiter.api.Test
    void convertToText() {
    }
}