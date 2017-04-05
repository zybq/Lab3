package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;

import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				
				if ((eSuit != eSuit.JOKER) && (eRank != eRank.JOKER))
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				
			}
			 
		}
		Collections.shuffle(deckCards);
	}
	
	public Deck(int NbrOfJokers) {
		this();
		
		for (int i = 0; i < NbrOfJokers; i++){
			deckCards.add(new Card(eSuit.JOKER, eRank.JOKER, 99));
		}
		Collections.shuffle(deckCards);
	}
	
	
	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		this(NbrOfJokers);
		
		for (Card c: Wilds){
			for	(Card d: deckCards){
				if (c.geteSuit() == d.geteSuit() && (c.geteRank()) == d.geteRank()) {
					c.setWild(true);
				}	
			}
		}
	}
	
	public Card Draw() throws DeckException{
		if(deckCards.size() == 0){
			throw new DeckException(this);
		}
		return deckCards.remove(0);
	}
	
	ArrayList<Card> getDeck(){
		return deckCards;
	}
}