package ua.elitasoftware.properyanim.fragment;

/**
 * Created by mobimaks on 17.12.2014.
 */
public enum FragmentType {
    CROSSFADE("Crossfade"), CARD_FLIP("Card flip");

    private String title;

    FragmentType(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
