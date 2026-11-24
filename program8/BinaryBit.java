package program8;

public class BinaryBit extends AbstractBit
{
    public static final BinaryBit zero = new BinaryBit(false);
    public static final BinaryBit one = new BinaryBit(true);

    public BinaryBit()
    {
        super(false);
    }

    public BinaryBit(boolean bit)
    {
        super(bit);
    }

    public BinaryBit(int bit)
    {
        super(bit != 0);
    }

    public BinaryBit(BinaryBit guest)
    {
        super(guest);
    }

    public BinaryBit clone()
    {
        return new BinaryBit(this);
    }

    public boolean equals(BinaryBit guest)
    {
        if (guest == null)
            return false;

        return getBit() == guest.getBit();
    }

    public String toString()
    {
        if (getBit())
            return "1";
        else
            return "0";
    }

    public AbstractBit addBits(AbstractBit guest)
    {
        boolean sum = getBit() ^ guest.getBit();
        return new BinaryBit(sum);
    }

    public AbstractBit addBits(AbstractBit guest1, AbstractBit guest2)
    {
        int total = 0;

        if (getBit())
            total++;
        if (guest1.getBit())
            total++;
        if (guest2.getBit())
            total++;

        return new BinaryBit(total % 2 == 1);
    }

    public AbstractBit carryBit(AbstractBit guest)
    {
        boolean carry = getBit() && guest.getBit();
        return new BinaryBit(carry);
    }

    public AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2)
    {
        int total = 0;

        if (getBit())
            total++;
        if (guest1.getBit())
            total++;
        if (guest2.getBit())
            total++;

        return new BinaryBit(total >= 2);
    }
}