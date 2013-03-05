import org.jibble.pircbot.PircBot;
import twitter4j.*;
import java.util.List;


public class NewBot extends PircBot {
	public NewBot() {
		this.setName("TwerkBot"); //name of bot
		
	}
	public void onMessage(String channel, String sender,
			String login, String hostname, String message) {
		String stuff = "derp da derp this is stuff I would want to find out regularly";
		//start twitter 2//
		 int x = 0;
			if (message.equalsIgnoreCase("!westwit")) {
			     Twitter twitter2 = new TwitterFactory().getInstance();
			    
			        try {
			            Query query = new Query("westeroscraft");
			            QueryResult result;
			            do {
			         
			                result = twitter2.search(query);
			                List<Status> tweets = result.getTweets();
			                for (Status tweet : tweets) {
			                	try {
			                		  Thread.sleep(2500);
			                	 	  x++;
			  			          	if (x > 15) {
			  				              
			  		                	  sendMessage(channel, " - Done!");
			  		                	 x = 0;
			  		                	return;
			  		  		     
			  		  		            }
			                	
			                		} catch (InterruptedException ie) {
			                		  
			                		}		               
			                	sendMessage(channel, (" "+ x + ".-- @" + tweet.getUser().getScreenName() + " - " + tweet.getText()));
			                }
			                
			            } while ((query = result.nextQuery()) != null);
			          
			        } catch (TwitterException te) {
			            te.printStackTrace();
			            sendMessage(channel, sender + "Failed to search tweets: " + te.getMessage());
			        
			        }
			       
			    }
		
		//end
		
		
		//time
		if (message.equalsIgnoreCase("!time")) {
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now " + time);
		}
		//op
		if (message.equalsIgnoreCase("!op")) {
			sendMessage(channel, "/op yourname" );
		}
		//extras
		if (message.equalsIgnoreCase("!extras")) {
			sendMessage(channel, sender + ": " + stuff);
		}
	
		
//start twitter 1//
		 int i = 0;
		if (message.equalsIgnoreCase("!twerk")) {
		     Twitter twitter = new TwitterFactory().getInstance();
		     sendMessage(channel, "Gettin all the hot twitter twerks!!killa");
		        try {
		            Query query = new Query("twerk");
		            QueryResult result;
		            do {
		            	
		                result = twitter.search(query);
		                List<Status> tweets = result.getTweets();
		                for (Status tweet : tweets) {
		                	try {
		                		  Thread.sleep(2500);
		                		  i++;
		                		  if (i > 15) {
		  		                	
				                	  sendMessage(channel, "Done!");
				                	  i = 0;
				                	 return;
				  		           
				  		            }
		                		  
		                		} catch (InterruptedException ie) {
		                		  
		                		}		               
		                	sendMessage(channel, (" "+ i + ".-- @" + tweet.getUser().getScreenName() + " - " + tweet.getText()));
		                }
		              
		            } while ((query = result.nextQuery()) != null);
		          
		        } catch (TwitterException te) {
		            te.printStackTrace();
		            sendMessage(channel, sender + "Failed to search tweets: " + te.getMessage());
		        
		        }
		       
		    }
	}
}




