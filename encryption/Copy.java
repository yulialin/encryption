package encryption; 

public class Copy implements EncryptionStrategy{
    @Override
    public String encrypt (String text, int key){
        return text; 
    }
    @Override
    public String decrypt (String text, int key){
        return text; 
    }
}