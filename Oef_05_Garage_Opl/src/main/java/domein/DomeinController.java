package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dto.AutoDTO;

public class DomeinController {
	private final Garage garage;

	public DomeinController() {
		garage = new Garage();
	}

	public Collection<AutoDTO> geefAutosOpNummerplaat() {
		garage.sorteerOpNummerplaat();
		return zetAutosOmNaatAutoDTOs(garage.getAutos());
	}

	public Collection<AutoDTO> geefAutosOpMerk() {
		garage.sorteerOpMerk();
		return zetAutosOmNaatAutoDTOs(garage.getAutos());
	}

	public Collection<AutoDTO> geefAutosOpMerkEnModel() {
		garage.sorteerOpMerkEnModel();
		return zetAutosOmNaatAutoDTOs(garage.getAutos());
	}

	public Collection<AutoDTO> geefAutosOpAantalOnderhoudsbeurtenAflopend() {
		garage.sorteerOpAantalOnderhoudsbeurtenAflopend();
		return zetAutosOmNaatAutoDTOs(garage.getAutos());
	}
	
	private Collection<AutoDTO> zetAutosOmNaatAutoDTOs(List<Auto> autos) {
		Collection<AutoDTO> autoDTOs = new ArrayList<>();
		for (Auto auto : autos) {
			autoDTOs.add(new AutoDTO(auto));
		}
		return autoDTOs;
	}

}
