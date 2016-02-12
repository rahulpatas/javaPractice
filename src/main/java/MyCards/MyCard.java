package MyCards;

public class MyCard {

    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    private final int suit;
    private final int value;

    public MyCard(){
        suit = JOKER;
        value = 1;
    }

    public MyCard(int theValue, int theSuit){
        if(theSuit != SPADES&& theSuit != HEARTS && theSuit != DIAMONDS && theSuit != CLUBS && theSuit !=JOKER){
            throw new IllegalArgumentException("Please use correct suit");
        }
        if(theSuit != JOKER && (theValue <1 || theValue >13)){
            throw new IllegalArgumentException("please use correct Value");
        }

        suit = theSuit;
        value = theValue;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuitAsString(){
        switch (suit){
            case SPADES:   return "Spade";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS:    return "Clubs";
            default:       return "Joker";
        }
    }

    public String getValueToString(){

         if(value<=10 && value>1 ){
            return String.valueOf(value);
        }else {
            switch (value){
                case ACE: return "Ace";
                case JACK: return "Jack";
                case QUEEN: return "Queen";
                default: return "King";
            }
        }
    }

    @Override
    public String toString() {
        if(suit == JOKER){
            if(value ==1){
                return "Joker";
            }else {
                return "Joker # " + value;
            }
        }else {
            return getValueToString() + " of " + getSuitAsString();
        }
    }

}
