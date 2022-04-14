package pyland;

/**
 * @inv <pre>
 *     description() != null && !description().equals("") </pre>
 */
public class Key {
    
    // ATTRIBUTS
    
    private String description;
    
    // CONSTRUCTEURS
    
    /**
     * Une cl� de description d.
     * @pre <pre>
     *     d != null && d.length() > 0 </pre>
     * @post <pre>
     *     description().equals(d) </pre>
     */
    public Key(String d) {
        description = d;
    }
    
    // REQUETES
    
    /**
     * La description de cette cl�.
     */
    public String description() {
        return description;
    }
}
