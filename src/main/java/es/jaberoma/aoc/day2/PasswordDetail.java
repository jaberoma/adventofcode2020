package es.jaberoma.aoc.day2;

public class PasswordDetail {

    private final Integer targetPosition1;
    private final Integer targetPosition2;
    private final Character letter;
    private final String password;
    private boolean valid;

    public PasswordDetail(Integer targetPosition1, Integer targetPosition2, Character letter, String password) {
        this.targetPosition1 = targetPosition1;
        this.targetPosition2 = targetPosition2;
        this.letter = letter;
        this.password = password;
        validate();
    }

    public boolean isValid() {
        return this.valid;
    }

    private void validate() {
        this.valid = (isTargetLetterIn(this.targetPosition1) && !isTargetLetterIn(this.targetPosition2)) ||
                (isTargetLetterIn(this.targetPosition2) && !isTargetLetterIn(this.targetPosition1));
    }

    private boolean isTargetLetterIn(Integer position) {
        int targetPosition = passwordPosition(position);
        return targetPosition < this.password.length() && this.password.charAt(targetPosition) == this.letter;
    }

    private Integer passwordPosition(Integer targetPosition) {
        return targetPosition - 1;
    }
}
