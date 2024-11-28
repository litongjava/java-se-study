/**
 * assignment 20.
 * 
 * @author Tong Li
 *
 */
public class PokemonLITPt4 {

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
	public PokemonLITPt4(String species, String name, int num, int hp) {
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
		return "Species: " + this.species + "\n"
            + "Name: " + this.name + "\n" + "Number: " + this.num 
            + "\n" + "HP: "
				+ this.hp;

	}

	/**
	 * getSpecies.
	 * 
	 * @return String
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * setSpecies.
	 * 
	 * @param species String
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * getNumber.
	 * 
	 * @return int
	 */
	public int getNumber() {
		return num;
	}

	/**
	 * setNumber.
	 * 
	 * @param newNum int
	 */
	public void setNumber(int newNum) {
		this.num = newNum;
	}

	/**
	 * get name.
	 * 
	 * @return string
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name.
	 * 
	 * @param name string
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get hp.
	 * 
	 * @return int
	 */
	public int getHP() {
		return this.hp;
	}

	/**
	 * set hp.
	 * 
	 * @param newHp int
	 */
	public void setHP(int newHp) {
		this.hp = newHp;
	}

}
