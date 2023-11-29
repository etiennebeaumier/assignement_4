// ---------------------------------------------------------
// Assignment 4
// Written by: Etienne Beaumier - 40211362
// For COMP 248 Section T – Fall 2023
// ---------------------------------------------------------
public class PrePaiCard {

    private final String type;
    private final String ID_CardHolder;
    private int expDay;
    private int expMonth;

    public PrePaiCard() {
        this(null, null, 0, 0);
    }

    public PrePaiCard(String type, String ID_CardHolder, int expDay, int expMonth) {

        this.type = type;
        this.ID_CardHolder = ID_CardHolder;
        if (expDay >= 1 && expDay <= 31) {
            this.expDay = expDay;
        } else {
            this.expDay = 0; // Set to 0 if the day is invalid
        }

        // Validate and set expiryMonth
        if (expMonth >= 1 && expMonth <= 12) {
            this.expMonth = expMonth;
        } else {
            this.expMonth = 0; // Set to 0 if the month is invalid
        }

    }


    // Copy constructor
    public PrePaiCard(PrePaiCard other) {
        this.type = other.type;
        this.ID_CardHolder = other.ID_CardHolder;
        this.expDay = other.expDay;
        this.expMonth = other.expMonth;
    }

    public boolean equals(PrePaiCard prePaiCard) {
        return getExpDay() == prePaiCard.getExpDay() && getExpMonth() == prePaiCard.getExpMonth() &&
                getType().equals(prePaiCard.getType()) && getID_CardHolder().equals(prePaiCard.getID_CardHolder());
    }

    public String getType() {
        return type;
    }


    public String getID_CardHolder() {
        return ID_CardHolder;
    }


    public int getExpDay() {
        return expDay;
    }

    public void setExpDay(int expDay) {
        if (expDay >= 1 && expDay <= 31) {
            this.expDay = expDay;
        } else {
            this.expDay = 0; // Set to 0 if the day is invalid
        }
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        if (expMonth >= 1 && expMonth <= 12) {
            this.expMonth = expMonth;
        } else {
            this.expMonth = 0; // Set to 0 if the month is invalid
        }
    }

    @Override
    public String toString() {
        String expDayStr;
        String expMonthStr;

        if (expDay < 10) {
            expDayStr = "0" + expDay;
        } else {
            expDayStr = String.valueOf(expDay);
        }
        if (expMonth < 10) {
            expMonthStr = "0" + expMonth;
        } else {
            expMonthStr = String.valueOf(expDay);
        }

        return "PrePaiCard is" + " of type='" + type + '\'' + ", ID_CardHolder='" + ID_CardHolder + '\'' + ", expiry= " + expDayStr + "/" + expMonthStr;
    }


}
