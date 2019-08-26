package tanks;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatFilter
{
	protected ArrayList<String> badwords = new ArrayList<String>();
	
	public ChatFilter()
	{
		this.addBadWords();
	}
	
	public String filterChat(String msg)
	{	
		if (msg == null)
			return null;
		
		String rawMessage = msg.toLowerCase();
		String message = msg.toLowerCase();
		
		for (String badword: this.badwords)
		{
			String p = "\\w" + badword + "\\w";
			Matcher m = Pattern.compile(p).matcher(rawMessage);
			
			while (m.find())
			{
				if (rawMessage.substring(m.start(), m.end()).contains(" "))
					rawMessage = rawMessage.substring(0, m.start() + 1) + rawMessage.substring(m.end() - 1);
			}
						
			message = message.replaceAll(badword, "");
		}
		
		if (!message.equals(rawMessage))
		{
			msg = "\u00A7255000000255< Redacted >\u00A7000000000255";
		}

		return msg;
	}
	
	public void registerBadWord(String word)
	{
		String newWord = "";
		
		for (int i = 0; i < word.length(); i++)
		{
			char c = (char) (word.charAt(i) - 1);
			newWord += c + "(" + c + "*)\\W*";
		}
		
		this.badwords.add(newWord);
	}
	
	/** I've added 1 to every character in these bad words so that they look like nonsense.
	 *  This addition is removed when testing for bad words in chat*/
	public void addBadWords()
	{
		registerBadWord("cjudi");
		registerBadWord("gvdl");
		registerBadWord("tiju");
		registerBadWord("ojhhfs");
		registerBadWord("dvou");
		registerBadWord("ebno");
		registerBadWord("bttipmf");
		registerBadWord("tfy");
		registerBadWord("dpoepn");
		registerBadWord("qfojt");
		registerBadWord("wbhjob");
		registerBadWord("gbhhpu");
	}
}