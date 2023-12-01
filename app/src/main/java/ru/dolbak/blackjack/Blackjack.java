package ru.dolbak.blackjack;

import java.util.Random;

class Deck {
    int pointer = 0;

    Card[] cards = new Card[52];
    public Card take(){
        Card card = cards[pointer];
        pointer++;
        return card;
    }

    //TODO: конструктор, в котором перемешиваются карты
    // создать карту - вызвать new Card(Rate, Suit)

    //TODO:" функция take() - взять карту из колоды
    Rate[] rates = {Rate.TWO,
            Rate.THREE, Rate.FOUR, Rate.FIVE, Rate.SIX, Rate.SEVEN, Rate.EIGHT, Rate.NINE, Rate.TEN, Rate.JACK, Rate.QUEEN, Rate.KING, Rate.ACE};
    Suit[] suits = {Suit.Diamonds, Suit.Clubs, Suit.Diamonds, Suit.Hearts};

    public Deck() {
        for (int i = 0; i < rates.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cards[i * 4 + j] = new Card(rates[i], suits[j]);
            }
        }
        Random rnd = new Random();
        for (int i = 0; i < cards.length; i++) {
            int index = rnd.nextInt(i + 1);
            cards[index] = cards[i];
        }
    }
}

enum Suit{
    Diamonds,
    Hearts,
    Spades,
    Clubs
}

enum Rate{
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(1),
    COVER(0);
    private int points;
    Rate(int points){
        this.points = points;
    }
    public int getPoints(){
        return this.points;
    }
}

class Card{
    Rate rate;
    Suit suit;
    int points = 0;
    public Card(Rate rate, Suit suit){
        this.rate = rate;
        this.suit = suit;
    }

    //TODO: в points записать очки карты
}

class Game{
    //TODO переменные для очков игрока и крупье
    //методы для взятия карты игроком и крупье
    //метод для вывода очков игрока и крупье
    //метод для вывода карт игрока и крупье
    //определить, кто победил

}

