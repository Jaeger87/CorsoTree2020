import java.util.*;

public class Facebook {

    private Map<UUID, User> users;
    private Map<UUID, List<Post>> author_post;

    public Facebook() {
        users = new HashMap<>();
        author_post = new HashMap<>();
    }

    public void signup(String name, String surname){
        User u = new User(name, surname);
        users.put(u.getId(), u);
    }

    public void addFriendship(UUID u1, UUID u2) throws Exception {

        if (!users.containsKey(u1))
            throw new Exception("utente 1 non trovato");

        if (!users.containsKey(u2))
            throw new Exception("utente 2 non trovato");

        users.get(u1).addFriend(u2);
        users.get(u2).addFriend(u1);
    }

    public void removeFriendship(UUID u1, UUID u2) throws Exception {

        if (!users.containsKey(u1))
            throw new Exception("utente 1 non trovato");

        if (!users.containsKey(u2))
            throw new Exception("utente 2 non trovato");

        users.get(u1).removeFriend(u2);
        users.get(u2).removeFriend(u1);
    }


    public void addPost(UUID author, String text) throws Exception {

        if (!users.containsKey(author))
            throw new Exception("utente non trovato");

        List<Post> userPosts = author_post
                .getOrDefault(author, new ArrayList<>());

        userPosts.add(new Post(author, text));
        author_post.put(author, userPosts);
    }


    public List<Post> getUserPosts(UUID user) throws Exception {

        if (!users.containsKey(user))
            throw new Exception("utente non trovato");

        return author_post.get(user);
    }

    public List<Post> getUserCommentedPosts(UUID user) throws Exception {

        if (!users.containsKey(user))
            throw new Exception("utente non trovato");

        List<Post> commentedPosts = new ArrayList<>();

        for (List<Post> posts : author_post.values())
            for (Post p : posts)
                if (p.getComments().containsKey(user))
                    commentedPosts.add(p);

        return commentedPosts;
    }

    public List<User> getLast3Users(){

        List<User> usersList = new ArrayList<>(users.values());

        //usersList.sort(Comparator.comparing(User::getSignup).reversed());

        usersList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getSignup().compareTo(o1.getSignup());
            }
        });

        List<User> result = new ArrayList<>();

//        int idx = 0;
//        while (result.size() < 3){
//            result.add(usersList.get(idx++));
//        }



        Iterator<User> iterator = usersList.iterator();
        while (result.size() < 3){
            result.add(iterator.next());
        }




//        while (result.size() < 3){
//            result.add(usersList.get(result.size()));
//        }


//        return users.values()
//                         .stream()
//                         .sorted(Comparator.comparing(User::getSignup))
//                         .limit(3)
//                         .collect(Collectors.toList());


        return result;
    }



}
