// ---------------------------------------------------------
// Assignment 4
// Written by: Etienne Beaumier - 40211362
// For COMP 248 Section T – Fall 2023
// ---------------------------------------------------------
public class PoS {

    private Sales sales;
    private PrePaiCard[] prePaiCards;


    public PoS() {
        this.sales = new Sales();
        this.prePaiCards = new PrePaiCard[100];
    }

    public PoS(Sales sales, PrePaiCard[] prePaiCard) {
        this.sales = sales;

        if (prePaiCard != null) {
            this.prePaiCards = prePaiCard;
        } else {
            this.prePaiCards = null;
        }
    }

    public boolean equalValue(PoS pos) {
        return this.sales.SalesTotal() == pos.sales.SalesTotal();
    }

    public boolean equalQty(PoS pos1, PoS pos2) {
        return pos1.sales.equals(pos2.sales);
    }

    public int totalSales() {
        return this.sales.SalesTotal();
    }

    public int nbPrepaiCard() {
        if (prePaiCards != null) {
            return prePaiCards.length;
        } else {
            return 0;
        }
    }

    public int addPrePaiCard(PrePaiCard card) {
        if (prePaiCards == null) {
            prePaiCards = new PrePaiCard[1];
            prePaiCards[0] = card;
        } else {
            // Create a new array that is one element larger
            PrePaiCard[] newPrePaiCards = new PrePaiCard[prePaiCards.length + 1];
            // Copy existing cards into the new array
            for (int i = 0; i < prePaiCards.length; i++) {
                newPrePaiCards[i] = prePaiCards[i];
            }
            // Add the new card to the end of the new array
            newPrePaiCards[newPrePaiCards.length - 1] = card;
            // Replace the old array with the new array
            prePaiCards = newPrePaiCards;
        }
        return prePaiCards.length;
    }

    // Method to remove a prepaid card
    public boolean removePrePaiCard(int arrayPosition) {

        // Check if the card is in the array before removing it
        if (arrayPosition >= 0 && arrayPosition < prePaiCards.length) {
            // Create a new array that is one element smaller
            PrePaiCard[] newPrePaiCards = new PrePaiCard[prePaiCards.length - 1];
            // Copy all the cards except the one at the index to remove
            for (int i = 0; i < prePaiCards.length; i++) {
                if (i < arrayPosition) {
                    newPrePaiCards[i] = prePaiCards[i];
                } else if (i > arrayPosition) {
                    newPrePaiCards[i - 1] = prePaiCards[i];
                }
            }
            // Replace the old array with the new array
            prePaiCards = newPrePaiCards;
            return true;
        } else {
            return false;
        }
    }

    public void updateExpiryDate(PrePaiCard card, int newDay, int newMonth) {
        if (prePaiCards == null) {
            return;
        }
        for (PrePaiCard prePaiCard : prePaiCards) {
            if (prePaiCard.equals(card)) {
                prePaiCard.setExpDay(newDay);
                prePaiCard.setExpMonth(newMonth);
                break;
            }
        }
    }

    public void updateExpiryDate(int arrayPosition, int newDay, int newMonth) {
        this.updateExpiryDate(this.prePaiCards[arrayPosition], newDay, newMonth);
    }

    public int addSales(int add_jun, int add_teen, int add_med, int add_big, int add_fam) {
        sales.addSales(add_jun, add_teen, add_med, add_big, add_fam);
        return sales.SalesTotal();
    }

    public boolean equals(PoS pos) {

        return this.equalValue(pos) && prePaiCards.equals(pos.prePaiCards);
    }

    @Override
    public String toString() {
        String result = sales.toString();

        if (prePaiCards != null && prePaiCards.length > 0) {
            for (PrePaiCard card : prePaiCards) {
                if (card != null) {
                    result += card.toString() + "\n";
                }
            }
        } else {
            result += "No pre-paid cards\n";
        }

        return result;
    }



    public String salesBreakdown() {
        return sales.toString();
    }
}

