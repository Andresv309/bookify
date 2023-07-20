
package utils;

public enum Colors {
    BACKGROUND_COLOR ("#272525"),
    PRIMARY_COLOR_BLUE ("#41bcff"),
    SECONDARY_COLOR_BLUE ("#a1ddff"),
    PRIMARY_COLOR_PURPLE ("#bf83d6"),
    SECONDARY_COLOR_PURPLE ("#9680d5");
    
    
    private final String hexColor;
    
    Colors(String hexColor) {
        this.hexColor = hexColor;
    }
    
    @Override
    public String toString() {
        return this.hexColor;
    }
}
