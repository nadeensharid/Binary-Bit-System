package program8;

import java.util.ArrayList;

public class BitString
{
    private ArrayList<AbstractBit> bitString;

    private void setAbstractBitList(ArrayList<AbstractBit> bitList)
    {
        bitString = bitList;
    }

    protected ArrayList<AbstractBit> getAbstractBitList()
    {
        return bitString;
    }

    public void addBit(AbstractBit bit)
    {
        bitString.add(bit);
    }

    public AbstractBit bitAt(int loc)
    {
        return bitString.get(loc);
    }

    public BitString()
    {
        bitString = new ArrayList<AbstractBit>();
    }

    protected BitString(ArrayList<AbstractBit> bitList)
    {
        setAbstractBitList(bitList);
    }

    public BitString(BitString guest)
    {
        bitString = new ArrayList<AbstractBit>();

        for (int i = 0; i < guest.length(); ++i)
            bitString.add(guest.bitAt(i).clone());
    }

    public boolean isEmpty()
    {
        return bitString.isEmpty();
    }

    public int length()
    {
        return bitString.size();
    }

    public BitString clone()
    {
        return new BitString(this);
    }

    public boolean equals(BitString guest)
    {
        if (guest == null)
            return false;

        if (length() != guest.length())
            return false;

        for (int i = 0; i < length(); ++i)
        {
            if (!bitAt(i).equals(guest.bitAt(i)))
                return false;
        }

        return true;
    }

    public String toString()
    {
        if (isEmpty())
            return "";

        String answer = "";

        for (int i = length() - 1; i >= 0; --i)
            answer += bitAt(i).toString();

        return answer;
    }
}