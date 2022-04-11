package beer;

public class TypeOfFilling {
private float volume;
private MaterialType materialType;

public float getVolume() {
    return volume;
}
public void setVolume(float volume) {
    this.volume = volume;
}
public MaterialType getMaterialType() {
    return materialType;
}
public void setMaterialType(MaterialType materialType) {
    this.materialType = materialType;
}

@Override
public String toString() {
    return "volume: "+volume+" | material type: "+materialType;
}

}
