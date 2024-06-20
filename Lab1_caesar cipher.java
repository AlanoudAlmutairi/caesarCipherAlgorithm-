import java.util.Scanner;

public class Lab1_2105088_AlanoudAlmutairi {


    static public String key ;

    public static void main(String[] args) {

// String contain all alphapatic letters
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //input from user (key)
        System.out.println("Enter the key: ");
        Scanner input = new Scanner(System.in);
        String key = input.next().toUpperCase();

        //here check if the key = 26 or not
        if(key.length()<26 || key.length()>26){
            //if the key not equal 26 stop the code
            System.out.println("The key length is : " +key.length());
            System.out.println("The key is less OR more than 26 ");
             System.exit(0);}

//ifwewishtoreplaceletter//dkvqfibjwpescxhtmyauolrgzn
        //here check the dublicated letters in the key
        for (int i = 0 ; i<key.length();i++){
            for (int j = 0 ; i<key.length() ; i++){
              if(i != j ) {

                  if (key.charAt(i) == key.charAt(j)) {
                      System.out.println(key.charAt(i));
                      System.out.println("There are duplicated letters");
                      System.exit(0);
                  }
              }
            }
        }




        //input from user (palin text)
        System.out.println("Enter the palintext : ");
        String plaintext = input.next().toUpperCase();
        //convert all plaintext to uppercase
        plaintext.toUpperCase();
        //invoke encrypt method
       String cipher =  encrypt(alpha , plaintext , key);
        //Print encrypted text
        System.out.println("The ciphertext is : " + cipher);
        /// print original text after decrypt
        System.out.println("The original text is : " + decrypt(alpha , cipher , key));

    }


    public static String encrypt(String alpha , String plaintext , String key ){
        //var to store the encrypted text
        String cipher = "";
        //index
        int alphaind = -1;
        //for loop throw the plain text
        for (int i =0 ; i < plaintext.length() ; i++){
            //take the letter from plaintext
            char x = plaintext.charAt(i);
            //second for loop throw the alpha(contains all letters in correct arrangement)
            for(int j =0 ; j<alpha.length() ; j++){
                //compaire the letter from plaintext with letters from alpha
                //if they are equal which means the same letter
                if(x == alpha.charAt(j)){
                    //take the index from alpha of the plain text letter
                   alphaind = j;
                   //get the letter from the key that take the same index of the planitext letter
                    char cipherChar = key.charAt(alphaind);
                    // add this letter to the var
                    cipher = cipher + cipherChar ;
                }}}
        //return the encrypted text
        return cipher;
    }

    public static String decrypt(String alpha , String ciphertext , String key ){
        //var to stor the original text after the decryption
        String plaintext = "";
        //index
        int plaintextind = -1;
        //for loop throw the encrypted text (cipher)
        for(int i = 0 ; i < ciphertext.length() ; i++){
            //another for loop throw the key
            for(int j =0 ; j< key.length() ; j++){
                //compare the letter from encrypted text(cipher) with letter from key
                //if they are equal which means the same letter
                if(ciphertext.charAt(i) == key.charAt(j)){
                    //take the index of leeter from key
                    plaintextind = j ;
                    //get the letter from alpha (contain all letters in correct arrangement)  with same index
                    //of letter in key
                    char b = alpha.charAt(plaintextind);
                    plaintext = plaintext + b;

                }}}
        //return decrypted text (original text)
        return plaintext;

    }



}