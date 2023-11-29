// ---------------------------------------------------------
// Assignment 4
// Written by: Etienne Beaumier - 40211362
// For COMP 248 Section T – Fall 2023
// ---------------------------------------------------------

// This class represents the sales of a PoS, containing the number of
// each size of meal sold.
public class Sales {

    public static final int JUNIOR_PRICE = 5;
    public static final int TEEN_PRICE = 10;
    public static final int MEDIUM_PRICE = 12;
    public static final int BIG_PRICE = 15;
    public static final int FAMILY_PRICE = 20;

    // Attributes
    private int junior;
    private int teen;
    private int medium;
    private int big;
    private int family;

    // Default constructor
    public Sales() {
        this(0, 0, 0, 0, 0);
    }


    // Parameterized constructor
    public Sales(int junior, int teen, int medium, int big, int family) {
        this.junior = junior;
        this.teen = teen;
        this.medium = medium;
        this.big = big;
        this.family = family;
    }

    // Copy constructor
    public Sales(Sales other) {
        this.junior = other.junior;
        this.teen = other.teen;
        this.medium = other.medium;
        this.big = other.big;
        this.family = other.family;
    }

    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }

    public int getTeen() {
        return teen;
    }

    public void setTeen(int teen) {
        this.teen = teen;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getBig() {
        return big;
    }

    public void setBig(int big) {
        this.big = big;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public void addSales(int add_jun, int add_teen, int add_med, int add_big, int add_fam) {
        this.junior += add_jun;
        this.teen += add_teen;
        this.medium += add_med;
        this.big += add_big;
        this.family += add_fam;

    }

    public int SalesTotal() {
        return (this.junior * JUNIOR_PRICE + this.teen * TEEN_PRICE + this.medium * MEDIUM_PRICE +
                this.big * BIG_PRICE + this.family * FAMILY_PRICE);
    }

    @Override
    public String toString() {
        return
                junior + "x $5 + "+ teen + " x $10 + " + medium + " x $12 + " + big + " x $15 + " +family + " x $20\n" ;
    }

    public boolean equals(Sales sales) {
        return getJunior() == sales.getJunior() && getTeen() == sales.getTeen() && getMedium() == sales.getMedium() && getBig() == sales.getBig() && getFamily() == sales.getFamily();
    }

}

