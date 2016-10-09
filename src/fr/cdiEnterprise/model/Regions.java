package fr.cdiEnterprise.model;

import java.util.ArrayList;

public class Regions extends ArrayList<Region> {

	private static final long serialVersionUID = 1L;

	public Region getRegion(String name) {

		Region regionFound = null;

		for (Region region : this) {
			if (region.getRegionName().equals(name)) {
				regionFound = region;
			}
		}
		return regionFound;
	}

}