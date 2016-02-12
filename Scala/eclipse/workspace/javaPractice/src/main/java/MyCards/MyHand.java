package MyCards;

import java.util.ArrayList;
import java.util.List;

public class MyHand {

    private List<MyCard> hand;

    public MyHand(){
        hand = new ArrayList<MyCard>();
    }

    public void clear(){
        hand.clear();
    }

    public void addCard(MyCard card) {
        if (card == null) {
            throw new IllegalArgumentException("This card is empty please select correct card");
        } else {
            hand.add(card);
        }
    }

    public void removeCard(MyCard card){
        if(hand.contains(card)){
            hand.remove(card);
        }else {
            throw new IllegalArgumentException("Hand does not have this Card " + card.toString() + " Please select a card present in this hand");
        }
    }

    public void removeCard(int position){
        if(position>0 && position<= hand.size()){
            hand.remove(position);
        }else {
            throw new IllegalArgumentException("User only have " + hand.size() +
                    "cards. use have selected position " + position + " please select correct position");
        }
    }

    public int getNumberCards(){
        return hand.size();
    }

    public void sortBySuit(){
        List<MyCard> newHand = new ArrayList<MyCard>();
        while (hand.size()>0){
            MyCard c = hand.get(0);

            for (int i = 1; i <hand.size() ; i++) {
                MyCard c1 = hand.get(i);
                if(c1.getSuit()< c.getSuit() || (c1.getSuit() == c.getSuit() && c1.getValue() <c.getValue())){
                    c = c1;
                }
            }
            newHand.add(c);
            hand.remove(c);
        }
        hand = newHand;
    }
}
