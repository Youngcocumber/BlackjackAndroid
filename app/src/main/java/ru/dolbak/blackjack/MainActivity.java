package ru.dolbak.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        putCard(1,card1);
        Card card2 = deck.take();
        Card card3 = deck.take();
        Card card4 = deck.take();
        Card[] cards = {card,card1,card2,card3,card4};
        int sum = card.rate.getPoints()+card1.rate.getPoints();
        int i=2;
        while (sum < 16){
            putCard(i, cards[i]);
            sum += cards[i].rate.getPoints();
            i++;
        }
        putCard(5,deck.take());
        putCard(6,deck.take());





        //TODO: используйте putCard(номер слота, карта), чтобы отрисовать карту на столе


        Card myCard = new Card(Rate.QUEEN, Suit.Hearts);
        int p = myCard.rate.getPoints(); //таким образом можно получить "очки" карты
    }
}