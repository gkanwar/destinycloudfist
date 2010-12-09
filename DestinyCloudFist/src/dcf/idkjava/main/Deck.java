package dcf.idkjava.main;

import java.util.ArrayList;

public class Deck
{
	private ArrayList<Card> m_cards;
	
	public Deck()
	{
		//Do nothing
	}
	public Deck(Board fillSource)
	{
		int size = fillSource.getTerritories().size();
		for(int i = 0; i < size; i++)
		{
			addCard(i%3, fillSource.getTerritories().get(i));
		}
		
		shuffle();
	}
	
	public Card drawCard()
	{
		Card drawnCard = m_cards.get(m_cards.size() - 1);
		m_cards.remove(m_cards.size() - 1);
		
		return drawnCard;
	}
	
	private void addCard(int type, Territory terr)
	{
		m_cards.add(new Card(type, terr));
	}
	private void shuffle()
	{
		//TODO: Implement this
	}
}
