import org.jibble.pircbot.*;

public class NewBotMain {

	public static void main(String[] args) throws Exception {
		NewBot bot = new NewBot();
		bot.setVerbose(true);
		bot.connect("irc.freenode.net");
		//joins with pw
		bot.joinChannel("#chan", "hunter2");
		
		
	}
}
