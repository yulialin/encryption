import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptionTest {

    static class CopyTest {
        
        CopyEncryption copy = new CopyEncryption();

        @Test
        void testCopyEncryptDecrypt() {
            String original = "nothing should change";
            int key = 10; // key is irrelevant here 
            assertEquals(original, copy.encrypt(original, key));
            assertEquals(original, copy.decrypt(original, key));
        }

        @Test
        void testEmptyString() {
            String original = "";
            int key = 5;
            assertEquals(original, copy.encrypt(original, key));
            assertEquals(original, copy.decrypt(original, key));
        }
    }


    static class CaesarCipherTest {

        CaesarCipher caesarCipher = new CaesarCipher();

        @Test
        void testEncryptDecryptYulia() {
            String original = "Yulia is so lucky!";
            int key = 4;
            // expected encrypted calculated with a key of 4
            String expectedEncrypted = "]ypme$mw$ws$pygo}%";
            String encrypted = caesarCipher.encrypt(original, key);
            assertEquals(expectedEncrypted, encrypted, "Encryption did not match expected output.");

            // decrypting to see if we get back the original
            String decrypted = caesarCipher.decrypt(encrypted, key);
            assertEquals(original, decrypted, "Decryption did not return the original string.");
        }
    }


    static class ScytaleCipherTest {

        ScytaleCipher scytaleCipher = new ScytaleCipher();

        @Test
        void testScytaleEncryptDecrypt() {
            String original = "this is just test";
            int columns = 4;
            String encrypted = scytaleCipher.encrypt(original, columns);
            assertEquals(original, scytaleCipher.decrypt(encrypted, columns));
        }

        @Test
        void testScytaleWithOneColumn() {
            String original = "single column";
            int columns = 1;
            assertEquals(original, scytaleCipher.decrypt(scytaleCipher.encrypt(original, columns), columns));
        }

        @Test
        void testEmptyString() {
            String original = "";
            int columns = 3;
            assertEquals(original, scytaleCipher.decrypt(scytaleCipher.encrypt(original, columns), columns));
        }
    }
}