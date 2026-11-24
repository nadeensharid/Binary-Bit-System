package program8;

public class Binary extends BitString
{
    public Binary()
    {
        super();
        addBit(new BinaryBit(false));
    }

    private void encode(long val)
    {
        getAbstractBitList().clear();

        if (val == 0)
        {
            addBit(new BinaryBit(false));
            return;
        }

        while (val > 0)
        {
            long remainder = val % 2;
            addBit(new BinaryBit((int) remainder));
            val = val / 2;
        }
    }

    public Binary(long val)
    {
        super();
        encode(val);
    }

    public Binary(BitString guest)
    {
        super(guest);
    }

    public Binary(Binary guest)
    {
        super(guest);
    }

    public Binary clone()
    {
        return new Binary(this);
    }

    public Binary addition(Binary guest)
    {
        Binary result = new Binary();
        result.getAbstractBitList().clear();

        AbstractBit carry = new BinaryBit(false);

        int maxLength;
        if (this.length() > guest.length())
            maxLength = this.length();
        else
            maxLength = guest.length();

        for (int i = 0; i < maxLength; ++i)
        {
            AbstractBit hostBit;
            AbstractBit guestBit;

            if (i < this.length())
                hostBit = this.bitAt(i);
            else
                hostBit = new BinaryBit(false);

            if (i < guest.length())
                guestBit = guest.bitAt(i);
            else
                guestBit = new BinaryBit(false);

            AbstractBit sumBit = hostBit.addBits(guestBit, carry);
            AbstractBit newCarry = hostBit.carryBit(guestBit, carry);

            result.addBit(sumBit);
            carry = newCarry;
        }

        if (carry.getBit())
            result.addBit(carry);

        return result;
    }
}