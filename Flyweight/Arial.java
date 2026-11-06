public class Arial implements Character {
    private String color;
    private int size;
    private char letter;

    @Override
    public String getFont() {
        return "Arial";
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setLetter(char letter) {
        this.letter = letter;
    }
    @Override
    public char getLetter() {
        return letter;
    }
}