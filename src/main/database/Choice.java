package main.database;

public class Choice{
    private String text;
    private boolean isCorrect;

    public static Choice correctOne(String text){
        return new Choice(text, true);
    }

    public static Choice wrongOne(String text){
        return new Choice(text, false);
    }

    private Choice(String text, boolean type) {
        this.text = text;
        this.isCorrect = type;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
