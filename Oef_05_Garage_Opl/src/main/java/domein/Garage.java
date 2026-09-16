package domein;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import persistentie.AutoMapper;

public class Garage {

	private final List<Auto> autos;

	public Garage() {
		autos = new AutoMapper().geefLijstVanAutos();
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void sorteerOpNummerplaat() {
		// Natuurlijke ordering
		autos.sort(null);
	}

	public void sorteerOpMerk() {
		// Met anonieme innerklasse
		autos.sort(new Comparator<Auto>() {
            @Override
            public int compare(Auto auto1, Auto auto2) {
                return auto1.getMerk().compareTo(auto2.getMerk());
            }
        });
	}

	public void sorteerOpMerkEnModel() {
		// Met method reference
		autos.sort(Comparator.comparing(Auto::getMerk).thenComparing(Auto::getModel));
	}

	public void sorteerOpAantalOnderhoudsbeurtenAflopend() {
    	// Met lambda
		autos.sort((auto1, auto2) ->
                Integer.compare(auto2.getAantalOnderhoudsbeurten(), auto1.getAantalOnderhoudsbeurten()));
	}

}
