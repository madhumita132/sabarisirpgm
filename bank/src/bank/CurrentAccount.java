package bank;

public class CurrentAccount implements MaintainanceCharge {
    @Override
    public Float calculateMaintancecharge(Float noOfYears) {
        Float maintainaceCharge = (float) 100;
        return (maintainaceCharge*noOfYears)+200;
    }
}
