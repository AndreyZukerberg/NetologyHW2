public class PasswordChecker {
    private Integer amountNum = null;
    private Integer maxRepeats = null;

    public void setMinLength(int amountNum) throws IllegalArgumentException {
        if (amountNum <= 0) {
            throw new IllegalArgumentException("Значение не может быть меньше или равным нулю");
        }
        this.amountNum = amountNum;
    }

    public void setMaxRepeats(int maxRepeats) throws IllegalArgumentException {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Значение не может быть меньше или равным нулю");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (amountNum == null || maxRepeats == null) {
            throw new IllegalStateException("Настройки minLength и maxRepeats должны быть установлены перед проверкой");
        }

        if (password.length() < amountNum) {
            return false;
        }

        int count = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                count++;
                if (count > maxRepeats) {
                    return false;
                }
            } else {
                count = 1;
            }
        }

        return true;
    }
}
