package es.jaberoma.aoc.day2;

public class PasswordDetail {

    private Integer minOccurs;
    private Integer maxOccurs;
    private Character letter;
    private String password;
    private boolean valid;

    public PasswordDetail(String detail) {
        String[] inputParts = detail.split(" ");
        parseOccurs(inputParts[0]);
        parseLetter(inputParts[1]);
        parsePassword(inputParts[2]);
        fillValidity();
    }

    private void parseOccurs(String range) {
        String[] rangeParts = range.split("-");
        this.minOccurs = Integer.valueOf(rangeParts[0]);
        this.maxOccurs = Integer.valueOf(rangeParts[1]);
    }

    private void parseLetter(String letter) {
        this.letter = letter.charAt(0);
    }

    private void parsePassword(String password) {
        this.password = password;
    }

    private void fillValidity() {
        long numberOfLetterAppearanceInPassword = password.chars()
                .filter(letter -> letter == this.letter)
                .count();
        this.valid = this.minOccurs <= numberOfLetterAppearanceInPassword && numberOfLetterAppearanceInPassword <= this.maxOccurs;
    }

    public boolean isValid() {
        return this.valid;
    }

}
