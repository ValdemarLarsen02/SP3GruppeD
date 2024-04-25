package src;

enum Category {
    UNDEFINED,
    TALK_SHOW,
    DOCUMENTARY,
    ANIMATION,
    ACTION,
    KIDS,
    CRIME,
    COMEDY,
    DRAMA,
    THRILLER,
    HORROR,
    ADVENTURE,
    ROMANCE,
    FAMILY,
    WAR,
    WESTERN,
    MUSICAL,
    BIOGRAPHY,
    SCI_FI,
    HISTORY,
    MUSIC,
    FILM_NOIR,
    MYSTERY,
    FANTASY,
    SPORT;
    public static Category findCategory(String s){
        switch(s.toUpperCase().replace(" ","")){
            case "KIDS":
                return KIDS;
            case "TALK-SHOW":
                return TALK_SHOW;
            case "DOCUMENTARY":
                return DOCUMENTARY;
            case "ANIMATION":
                return ANIMATION;
            case "ACTION":
                return ACTION;
            case "FANTASY":
                return FANTASY;
            case "CRIME":
                return CRIME;
            case "THRILLER":
                return THRILLER;
            case "COMEDY":
                return COMEDY;
            case "HORROR":
                return HORROR;
            case "DRAMA":
                return DRAMA;
            case "ADVENTURE":
                return ADVENTURE;
            case "ROMANCE":
                return ROMANCE;
            case "FAMILY":
                return FAMILY;
            case "WAR":
                return WAR;
            case "WESTERN":
                return WESTERN;
            case "MUSICAL":
                return MUSICAL;
            case "BIOGRAPHY":
                return BIOGRAPHY;
            case "SCI-FI":
                return SCI_FI;
            case "HISTORY":
                return HISTORY;
            case "MUSIC":
                return MUSIC;
            case "FILM-NOIR":
                return FILM_NOIR;
            case "MYSTERY":
                return MYSTERY;
            case "SPORT":
                return SPORT;

        }
        return UNDEFINED;
    }


}

