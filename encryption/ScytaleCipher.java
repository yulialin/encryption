package encryption; 

public class ScytaleCipher implements EncryptionStrategy {
    @Override
    public String encrypt(String text, int columns) {
        if (columns <= 0) columns = 1; 
        // so we make sure there is at least 1 column
        int rows = (int) Math.ceil((double) text.length() / columns); 
        StringBuilder encrypted = new StringBuilder();

        for (int col = 0; col < columns; col++) {
            int index = col;
            for (int row = 0; row < rows; row++) {
                if (index < text.length()) {
                    encrypted.append(text.charAt(index));
                } else {
                    encrypted.append(' '); //pad with space if needed
                }
                index += columns; 
            }
        }
        return encrypted.toString(); 
    }
    @Override
    public String decrypt(String text, int columns) {
        if (columns <= 0) columns = 1; // so at least 1 column 
        int rows = (int) Math.ceil((double) text.length() / columns);
        StringBuilder decrypted = new StringBuilder(); 

        //use transpose method to switch rows and columns 
        for (int row = 0; row < rows; row++){
            int index = row;
            for (int col = 0; col < columns; col++) {
                if (index < text.length()){
                    decrypted.append(text.charAt(index)); 
                }
                index += rows;
            }
        }
        return decrypted.toString(); 
    }

}