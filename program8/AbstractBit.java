package program8;

public abstract class AbstractBit
{
    private boolean bit;

    public abstract AbstractBit clone();
    public abstract AbstractBit addBits(AbstractBit guest);
    public abstract AbstractBit addBits(AbstractBit guest1, AbstractBit guest2);
    public abstract AbstractBit carryBit(AbstractBit guest);
    public abstract AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2);

    protected void setBit(boolean value)
    {
        bit = value;
    }

    public boolean getBit()
    {
        return bit;
    }

    public AbstractBit()
    {
        bit = false;
    }

    public AbstractBit(boolean value)
    {
        bit = value;
    }

    public AbstractBit(AbstractBit guest)
    {
        bit = guest.getBit();
    }

    public boolean equals(AbstractBit guest)
    {
        if (guest == null)
            return false;

        return bit == guest.getBit();
    }

    public String toString()
    {
        if (bit)
            return "1";
        else
            return "0";
    }
}