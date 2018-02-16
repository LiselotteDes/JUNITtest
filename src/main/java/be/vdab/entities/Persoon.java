package be.vdab.entities;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Persoon {
	private static final Pattern REG_EXP = Pattern.compile("\\S");
	private final Set<String> voornamen;
	public Persoon(Set<String> voornamen) {
		if(voornamen.isEmpty()) {
			throw new IllegalArgumentException("Lege set voornamen");
		}
		if(voornamen.contains(null)) {
			throw new NullPointerException("Een null-voornaam");
		}
		if (voornamen.contains("")) {
			throw new IllegalArgumentException("Lege voornaam");
		}
		
		for (Iterator<String> iterator = voornamen.iterator(); iterator.hasNext();) {
			if ( ! REG_EXP.matcher(iterator.next()).find()) {
				throw new IllegalArgumentException("Voornaam zonder niet-blanco teken");
			}
		}
		this.voornamen = new LinkedHashSet<String>(voornamen);
	}
	
	public Set<String> getVoornamen() {
		return voornamen;
	}
	@Override
	public String toString() {
		Iterator<String> it = voornamen.iterator();
		StringBuilder builder = new StringBuilder(it.next().trim());
		while (it.hasNext()) {
			builder.append(" ");
			builder.append(it.next().trim());
		}
		return builder.toString();
	}
}
