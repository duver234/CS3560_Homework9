import java.util.ArrayList; 
import java.util.Random; 

public class Driver {
    private static String word = "HelloWorldCS3560";
    static ArrayList<Character> characterList = new ArrayList<Character>(); 
    static CharacterFactory characterFactory = new CharacterFactory();

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < word.length(); i++) {
            int randInt = random.nextInt(24) + 1; // Generate a random number between 1 and 24
            Character character = characterFactory.getCharacter("Calibri");
            switch (randInt % 3) {
                case 1:
                    character.setColor("Red");
                    break;
                case 2:
                    character.setColor("Blue");
                    break;
                default:
                    character.setColor("Black");
                    break;
            }
            character.setSize(randInt);
            character.setLetter(word.charAt(i));
            System.out.println("New Character: Font: " + character.getFont() + ", Color: " + character.getColor() + ", Size: " + character.getSize() + "\n Letter: " + character.getLetter());
            characterList.add(character);
        }
        
    }
}