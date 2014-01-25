package sample;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import com.restfb.types.User;

public class Connections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FacebookClient facebookClient = new DefaultFacebookClient("CAADfeK9tc9sBAHEpoZAyMC8FuCBfJBC0bJIcqpf6VsvIZAw0ZAybHNlo6PPIabK7zJCYnnFGGNwItXU5NfrAyUzAAZBsjQwn9RjgleZBoI0DLZC86qHpEbZArcHWCZBG0CSojFGwRZAG7Dcal0A5PFDZCYmGwoZCkayHy8ZBum6zZAjNAWmu6MyRJzgnZCZCg7zKvsneuIZD");

		// It's also possible to create a client that can only access
		// publicly-visible data - no access token required. 
		// Note that many of the examples below will not work unless you supply an access token! 

		FacebookClient publicOnlyFacebookClient = new DefaultFacebookClient();
		
		Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
		Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);

		System.out.println("Count of my friends: " + myFriends.getData().size());
		System.out.println("First item in my feed: " + myFeed.getData().get(0));


			System.out.println(myFriends.getData().get(1).getFirstName());
		
		
		
		// Connections support paging and are iterable

		/*for (List<Post> myFeedConnectionPage : myFeed)
		  for (Post post : myFeedConnectionPage)
		    System.out.println("Post: " + post);
*/
			
			FacebookClient facebook = new DefaultFacebookClient("CAADfeK9tc9sBAHEpoZAyMC8FuCBfJBC0bJIcqpf6VsvIZAw0ZAybHNlo6PPIabK7zJCYnnFGGNwItXU5NfrAyUzAAZBsjQwn9RjgleZBoI0DLZC86qHpEbZArcHWCZBG0CSojFGwRZAG7Dcal0A5PFDZCYmGwoZCkayHy8ZBum6zZAjNAWmu6MyRJzgnZCZCg7zKvsneuIZD");
			Connection<InstalledUser> installedFacebookUsers = facebook.fetchConnection("/" + "245709432255451" + "/friends", InstalledUser.class, Parameter.with("fields", "installed"));        
			for (List<InstalledUser> friends : installedFacebookUsers) {
			    for (InstalledUser friend : friends) {
			        if (friend.getInsatlled()) {
			            // Add friend.getId() to a list of ID, or whatever
			        	System.out.println(friends.get(1)+"-------");
			        }
			    }
			}
			
			
	}

}
class InstalledUser extends User {

    @Facebook
    private boolean installed;

    public InstalledUser() {        
    }

    public boolean getInsatlled() {
        return installed;
    }
}