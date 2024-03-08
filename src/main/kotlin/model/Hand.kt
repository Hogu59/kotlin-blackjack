package model

import model.card.Card
import model.card.Deck
import model.card.TrumpDeck
import model.card.ValueType

class Hand(private val deck: Deck = TrumpDeck) {
    private var _cards: MutableList<Card> = mutableListOf()
    val cards: List<Card>
        get() = _cards

    fun draw() {
        _cards.add(deck.pop())
    }

    fun getPoint(): Point {
        return _cards.sumOf { card ->
            card.valueType.amount
        }.run { Point(this) }
    }

    fun hasAce(): Boolean {
        return cards.any { it.valueType == ValueType.ACE }
    }
}
