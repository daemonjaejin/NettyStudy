package study.funzin.dto;

/**
 * Created by jin on 17. 1. 15.
 */
public class WildcardGeneric<W> {

    W wildcard;

    public W getWildcard() {
        return wildcard;
    }

    public void setWildcard(W wildcard) {
        this.wildcard = wildcard;
    }
}
