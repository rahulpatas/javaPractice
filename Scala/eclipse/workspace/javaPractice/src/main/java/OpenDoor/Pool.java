package OpenDoor;

public enum Pool {

    PRIVATE((short)0),
    COMMUNITY((short)1),
    NONE((short)2);

    private short poolCode;

   private Pool(short poolCode) {
        this.poolCode = poolCode;
    }

    public short getPoolCode() {
        return poolCode;
    }
}
