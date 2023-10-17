package items;

public abstract class Fighter {
    Wand wand;
    int health;

    Fighter(Wand wand, int health){
        this.wand = wand;
        this.health = health;
    }

    public int getDamage(){
        if(wand != null)
            return wand.getDamage();
        return 0;
    }
    public int getHealth() {
        return health;
    }
    public void takeDamage(int damage){
        if(damage > 0){
            if(damage > health){
                health = 0;
            } else {
                health -= damage;
            }
        } else {
            throw new IllegalArgumentException("argument number: " + damage + " was negative");
        }
    }

    public void attack(Fighter enemy){
        int damage = (int) ((Math.random() * wand.getDamage()) + 1);
        enemy.takeDamage(damage);
    }

}
