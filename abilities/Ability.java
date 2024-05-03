package abilities;


public abstract class Ability {
        public int damage;
        public double rate;
        public Ability(){
                this.damage = 0;
                this.rate = 0;
        }
        public Ability(int damage, double time){
                this.damage = damage;
                this.rate = time;
        }

        public void animate(String name){

        }
}
