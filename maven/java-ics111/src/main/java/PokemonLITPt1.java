/**
 * assignment 19.
 * 
 * @author Tong Li
 *
 */
public class PokemonLITPt1 {

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
	 * @param species species
	 * @param name name
	 * @param num num
	 * @param hp hp
	 */
	public PokemonLITPt1(String species, String name, int num, int hp) {
		this.species = species;
		this.name = name;
		this.num = num;
		this.hp = hp;
	}

	/**
	 * toString.
	 * @return string
	 */
	public String toString() {
		// Pikachu, Pika, 123, 89
		return this.species + ", " + this.name + ", " + this.num + ", " + this.hp;

	}

}
