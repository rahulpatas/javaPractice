package MyCards;

import java.util.*;

public class MyDeck {

    private List<MyCard> deck = new ArrayList<>();
    private int cardsUsed;

    public MyDeck(){
        this(false);
    }
    public MyDeck(boolean withJoker){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 13; j++) {
                 deck.add(new MyCard(j, i));
            }
        }

        if(withJoker){
            deck.add(new MyCard(1, MyCard.JOKER));
            deck.add(new MyCard(2, MyCard.JOKER));
        }

        cardsUsed = 0;
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public int cardsLeft(){
        return deck.size();
    }

    public MyCard deal(){
        if(deck.size()==cardsUsed){
            throw new IllegalStateException("All cards are used");
        }else{

            cardsUsed++;
            return deck.get(cardsUsed - 1);
        }
    }

    public boolean hasJokers() {
        return (deck.contains(new MyCard(1, MyCard.JOKER)) || deck.contains(new MyCard(2, MyCard.JOKER)));
    }

}
