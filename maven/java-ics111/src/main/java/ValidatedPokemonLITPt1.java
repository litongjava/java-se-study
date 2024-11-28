/**
 * assignment 21.
 * 
 * @author Tong Li
 *
 */
public class ValidatedPokemonLITPt1 {

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
    * @throws PokemonLITException species can not be empty.
	 */
	public ValidatedPokemonLITPt1(String species, String name, int num, int hp)
			throws PokemonLITException {
		this.setSpecies(species);
		this.setName(name);
		this.species = species;
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
		return "Species: " + this.species + "\n" + "Name: " + this.name + "\n" + "Number: "
				+ this.num + "\n" + "HP: " + this.hp;

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
	 * @throws PokemonLITException species can not be empty.
	 */
	public void setSpecies(String species) throws PokemonLITException {
		if (species.trim().length() == 0) {
			throw new PokemonLITException("The species should not be empty or contain only spaces");
		}

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
	 * @param newName newName
	 */
	public void setName(String newName) {
		if (newName.trim().length() > 0) {
			this.name = newName;
		} else {
			this.name = this.species;
		}

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
