package module_08.tinder_like;

import java.util.*;

public class TinderLike {
    Map<User, Set<Interest>> usersByInterest = new HashMap<>();

    public void insertUserWithInterests(User user, Set<Interest> interests) {
        if(usersByInterest.containsKey(user)) //add if present
            usersByInterest.get(user).addAll(interests);
        else
            usersByInterest.put(user, interests);
    }

    public void removeUser(User user) {
        usersByInterest.remove(user);
    }

    public void removeInterestsForUser(User user, Set<Interest> interests) {
        if(usersByInterest.containsKey(user))
            usersByInterest.get(user).removeAll(interests);
    }

    public User getMostSimilarUser(User user) {
        if(user == null || !usersByInterest.containsKey(user))
            return null;
        Set<Interest> userInterests = usersByInterest.get(user);
        User mostSimilarUser = null;
        int interestsInCommonCount = 0;
        for(User u : usersByInterest.keySet()) {
            //skip user
            if(u.equals(user))
                continue;
            Set<Interest> interestsInCommon = new HashSet<>(usersByInterest.get(u));
            interestsInCommon.retainAll(userInterests);
           if(mostSimilarUser == null || interestsInCommon.size() > interestsInCommonCount) {
               mostSimilarUser = u;
               interestsInCommonCount = interestsInCommon.size();
           }
        }
        return mostSimilarUser;
    }

    public User[] getMostSimilarUsers() {
        User mostSimilarUser1 = null;
        User mostSimilarUser2 = null;
        int interestsInCommonCount = 0;

        for(User user : usersByInterest.keySet()){
            User mostSimilarUser = getMostSimilarUser(user);
            Set<Interest> interestsInCommon = new HashSet<>(usersByInterest.get(user));
            interestsInCommon.retainAll(usersByInterest.get(mostSimilarUser));
            if(interestsInCommon.size() > interestsInCommonCount) {
                mostSimilarUser1 = user;
                mostSimilarUser2 = mostSimilarUser;
                interestsInCommonCount = interestsInCommon.size();
            }
        }
        User[] mostSimilarUsers = {mostSimilarUser1, mostSimilarUser2};
        return mostSimilarUsers;
    }

    public static void main(String[] args) {
        Interest i1 = new Interest("1", "football");
        Interest i2 = new Interest("2", "tennis");
        Interest i3 = new Interest("3", "cricket");
        Interest i4 = new Interest("4", "jumping");
        Interest i5 = new Interest("5", "gym");
        Interest i6 = new Interest("6", "jogging");
        Interest i7 = new Interest("7", "cards");
        User u1 = new User("1", "mario");
        User u2 = new User("2", "giovanni");
        User u3 = new User("3", "andrea");
        User u4 = new User("4", "jonathan");
        Set<Interest> s1 = new HashSet<>();
        s1.add(i1);
        s1.add(i2);
        s1.add(i3);
        Set<Interest> s2 = new HashSet<>();
        s2.add(i1);
        s2.add(i5);
        Set<Interest> s3 = new HashSet<>();
        s3.add(i2);
        s3.add(i3);
        Set<Interest> s4 = new HashSet<>();
        s4.add(i1);
        s4.add(i2);
        s4.add(i3);
        s4.add(i7);
        TinderLike tinderLike = new TinderLike();
        tinderLike.insertUserWithInterests(u1, s1);
        tinderLike.insertUserWithInterests(u2, s2);
        tinderLike.insertUserWithInterests(u3, s3);
        User u = tinderLike.getMostSimilarUser(u1);
        System.out.println(u.getName().equals("andrea"));
        tinderLike.insertUserWithInterests(u4, s4);
        User[] mostSimilarUsers = tinderLike.getMostSimilarUsers();
        System.out.println(mostSimilarUsers[0].getName().equals("mario"));
        System.out.println(mostSimilarUsers[1].getName().equals("jonathan"));

    }
}
