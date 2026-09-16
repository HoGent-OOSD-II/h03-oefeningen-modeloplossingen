package domein;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import persistentie.ContainerMapper;

public class ContainerRepository {
	private ContainerMapper mapper;
	private List<Container> containers;

	public ContainerRepository() {
		mapper = new ContainerMapper();
		containers = mapper.getContainers();
	}

	public Collection<Container> getContainers() {
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpSerienummer() {
		containers.sort(Comparator.comparing(Container::getSerienummer).reversed());
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpMassa() {
		containers.sort(new Comparator<Container>() {
            @Override
            public int compare(Container container1, Container container2) {
                return Integer.compare(container1.getMassa(), container2.getMassa());
            }
        });
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpEigenaar() {
		containers.sort((container1, container2) ->
                container1.getEigenaar().compareTo(container2.getEigenaar()));
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpVolumeEnEigenaar() {
		containers.sort(Comparator.comparing(Container::getVolume).thenComparing(Container::getEigenaar));
		return containers;
	}

	public void voegContainerToe(Container c) {
		if (containers.contains(c))
			throw new IllegalArgumentException(
					String.format("Container met serienummer %d bestaat reeds", c.getSerienummer()));
		mapper.voegContainerToe(c);
		containers = mapper.getContainers();
	}

}
