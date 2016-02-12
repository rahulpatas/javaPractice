package OpenDoor;

public enum Dwelling {

    SFD((short)0),
    TOWNHOUSE((short)1),
    APARTMENT((short)2),
    PATIO((short)3),
    LOFT((short)4);

    private short dwelling;

    Dwelling(short dwelling) {
        this.dwelling = dwelling;
    }

    public short getDwelling() {
        return dwelling;
    }
}
