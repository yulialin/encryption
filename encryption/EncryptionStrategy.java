package encryption; 

public interface EncryptionStrategy {
    String encrypt(String text, int key);
    String decrypt(String text, int key);
    }