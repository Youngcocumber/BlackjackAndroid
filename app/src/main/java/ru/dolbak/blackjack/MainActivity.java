package ru.dolbak.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    void putCard(int slot, Card card){
        int[] slots = {R.id.dealer_card_4, R.id.dealer_card_5, R.id.dealer_card_3,
                R.id.dealer_card_2, R.id.dealer_card_1, R.id.player_card_5, R.id.player_card_4,
                R.id.player_card_2, R.id.player_card_3, R.id.player_card_1};
        ImageView imageView = findViewById(slots[slot]);
        int cardDrawableID = CardMisc.CardToImageID(card);
        imageView.setImageDrawable(getResources().getDrawable(cardDrawableID));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Deck deck = new Deck();
        Card card = deck.take();
        card.rate.getPoints();
        putCard(0,card);
        Card card1 = deck.take();
        card1.rate.getPoints();
        Card card2 = deck.take();
        Card card3 = deck.take();
        Card card4 = deck.take();
        Card card5 = deck.take();
        Card card6 = deck.take();
//        Card card7 = deck.take();
        Card[] cards = {card,card1,card2,card3,card4,card5,card6};
        int sum = card.rate.getPoints()+card1.rate.getPoints();
        int i=1;
        while (sum < 17){
            sum += cards[i].rate.getPoints();
            i++;
        }
        putCard(5,deck.take());
        putCard(6,deck.take());
    }
    int takeCard = 7;
    public void TakeCard(View view, Card[] cards)
    {

        Deck deck = new Deck();
        putCard(7,deck.take());
        takeCard++;
    }
}