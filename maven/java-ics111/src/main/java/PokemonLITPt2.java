/**
 * assignment 19.
 * 
 * @author Tong Li
 *
 */
public class PokemonLITPt2 {

	/**
	 * species.
	 */
	private String species;
	/**
	 * name.
	 */
	private String name;
	/**
	 * Pokemon Pokedex number.
	 */
	private int num;
	/**
	 * hit power.
	 */
	private int hp;

	/**
	 * constructor.
	 * 
	 * @param species species
	 * @param name    name
	 * @param num     num
	 * @param hp      hp
	 */
	public PokemonLITPt2(String species, String name, int num, int hp) {
		this.species = species;
		this.name = name;
		this.num = num;
		this.hp = hp;
	}

	/**
	 * toString.
	 * 
	 * @return string
	 */
	public String toString() {
//		Species: Wartortle
//		Name: Edgar
//		Number: 4
//		HP: 87
		return "Species: " + this.species + "\n" + "Name: " + this.name 
            + "\n" + "Number: " + this.num 
            + "\n" + "HP: " + this.hp;

	}

}
