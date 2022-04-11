package beer;

public class Chars {
    private boolean filtered;
    private float calories;
    private TypeOfFilling typeOfFilling;
    private float numberOfTurns;
    private String transparency;
    
    public Chars() {}
    
    public boolean getFiltered() {
        return filtered;
    }
    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }
    public float getCalories() {
        return calories;
    }
    public void setCalories(float calories) {
        this.calories = calories;
    }
    public TypeOfFilling getTypeOfFilling() {
        return typeOfFilling;
    }
    public void setTypeOfFilling(TypeOfFilling typeOfFilling) {
        this.typeOfFilling = typeOfFilling;
    }
    public float getNumberOfTurns() {
        return numberOfTurns;
    }
    public void setNumberOfTurns(float numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }
    public String getTransparency() {
        return transparency;
    }
    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }
    
    @Override 
    public String toString() {
	return "  filtered: "+filtered+"\n  calories: "+calories+"\n  type of filling: "+typeOfFilling+"\n  number of turns: "+numberOfTurns+"\n  transparency: "+transparency;
    }
    
}
