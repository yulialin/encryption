package encryption; 

public class CaesarCipher implements EncryptionStrategy {
    @Override
    public String encrypt(String text, int key) {
        return shiftText(text ,key); 
    }
    @Override
    public String decrypt(String text, int key) {
        return shiftText(text, -key); 
    }
    
    private String shiftText(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char shiftedChar = (char) ((c + shift) % 256);
            if (shiftedChar < 0) { 
                //make sure it will wrap around right if it's negative
                shiftedChar += 256;
            }
            sb.append(shiftedChar);
        }
        return sb.toString();
    }
}