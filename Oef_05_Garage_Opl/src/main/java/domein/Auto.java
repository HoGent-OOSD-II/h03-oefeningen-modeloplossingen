package domein;

import java.util.Objects;

public class Auto implements Comparable<Auto> {

	private String nummerplaat;
	private String merk;
	private String model;
	private int aantalOnderhoudsbeurten;

	public Auto(String nummerplaat, String merk, String model) {
		this(nummerplaat, merk, model, 0);
	}

	public Auto(String nummerplaat, String merk, String model, int aantalOnderhoudsbeurten) {
		setNummerplaat(nummerplaat);
		setMerk(merk);
		setModel(model);
		setAantalOnderhoudsbeurten(aantalOnderhoudsbeurten);
	}

	public String getMerk() {
		return merk;
	}

	private void setMerk(String merk) {
		this.merk = merk;
	}

	public String getModel() {
		return model;
	}

	private void setModel(String model) {
		this.model = model;
	}

	public String getNummerplaat() {
		return nummerplaat;
	}

	private void setNummerplaat(String nummerplaat) {
		this.nummerplaat = nummerplaat;
	}

	public int getAantalOnderhoudsbeurten() {
		return aantalOnderhoudsbeurten;
	}

	public void setAantalOnderhoudsbeurten(int aantalOnderhoudsbeurten) {
		this.aantalOnderhoudsbeurten = aantalOnderhoudsbeurten;
	}

	public void voegOnderhoudToe() {
		this.aantalOnderhoudsbeurten++;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nummerplaat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		return Objects.equals(nummerplaat, other.nummerplaat);
	}

	@Override
	public int compareTo(Auto other) {
		return getNummerplaat().compareTo(other.getNummerplaat());
	}
	
	
}
