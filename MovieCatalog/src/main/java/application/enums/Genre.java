package application.enums;

public enum Genre {
    ACTION,ADVENTURE,ANIMATION,BIOGRAPHY,COMEDY,CRIME,DOCUMENTARY,DRAMA,FAMILY,FANTASY,GAME_SHOW,HISTORY,HORROR,MUSICAL,MYSTERY,NEWS,REALITY_TV,ROMANCE,SCI_FI,SPORT,SUPERHERO,TALK_SHOW,THRILLER,WAR,WESTERN;


    @Override
    public String toString() {
        String lower = super.name().substring(1).toLowerCase()
                .replaceAll("Sci_fi","Sci-Fi")
                .replaceAll("_show","-Show")
                .replaceAll("_tv","-TV");
        return super.name().charAt(0) + lower;
    }
}
