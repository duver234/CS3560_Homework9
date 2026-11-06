import java.util.HashMap; 

public class CharacterFactory {
    private HashMap<String, Character> character = new HashMap<>();

    public Character getCharacter(String font) {
        String key = font;
        if (!character.containsKey(key)) {
            switch (font) {
                case "Arial":
                    character.put(key, new Arial());
                    break;
                case "Verdana":
                    character.put(key, new Verdana());
                    break;
                case "Calibri":
                    character.put(key, new Calibri());
                    break;
            }
        }
        return character.get(key);
    }
}