package bank;

public class SavingsAccount implements MaintainanceCharge{
    @Override
    public Float calculateMaintancecharge(Float noOfYears) 
    {       
        Float maintainaceCharge = (float) 50;
        return 2*(maintainaceCharge*noOfYears)+50;
    }

}
