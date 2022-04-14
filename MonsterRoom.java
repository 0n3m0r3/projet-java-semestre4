package pyland;

public class MonsterRoom extends NormalRoom implements IMonsterRoom {
    
    // ATTRIBUTS
    
    private int monstersNb;
    
    // CONSTRUCTEURS
    
    public MonsterRoom(int n) {
        super();
        if (n <= 0) {
            throw new AssertionError();
        }
        monstersNb = n;
    }
    
    // REQUETES
    
    public int monstersNb() {
        return monstersNb;
    }
    
    // COMMANDES
    
    public void setVisitor(IPlayer v) {
        super.setVisitor(v);
        int x = monstersNb;
        int y = v.getHitPoints();
        if (x == 0) {
            return;
        }
        if (x <= y) {
            monstersNb = 0;
            v.strengthen(x / 2);
            
        } else {
            monstersNb += y / 2;
            v.kill();
        }
    }
    
    protected String computeFengShuiEffect() {
        if (monstersNb == 0) {
            return "Il n'y a plus aucun monstre dans cette salle.";
        }
        if (monstersNb <= getVisitor().getHitPoints()) {
            return "Vous combattez victorieusement !";
        } else {
            return "Vous succombez dans un râle affreux...";
        }
    }
}