package util;

import game.objects.CollectibleCard;

import java.util.ArrayList;
import java.util.List;

public class GameObjectsInitializor {
    public static List<CollectibleCard> initCollectibleCards() {
        List<CollectibleCard> cards = new ArrayList<>();

        cards.add(new CollectibleCard(1, "The OG", "The very first card in the game. Congratulations for finding #1!"));
        cards.add(new CollectibleCard(2, "The Other", "Not as cool as The OG but still pretty nice"));

        return cards;
    }
}
