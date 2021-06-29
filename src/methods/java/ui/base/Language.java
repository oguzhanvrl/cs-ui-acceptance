package ui.base;

public enum Language {

    SPAIN("en-es"),
    MEXICO("en-mx"),
    COLOMBIA("en-co");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
