package be.vdab.entities;
import static org.junit.Assert.assertEquals;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;
public class PersoonTest {

	@Test(expected = NullPointerException.class)
	public void nullWaardeIsVerkeerd() {
		new Persoon(null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void deSetMagNietLeegZijn() {
		Set<String> voornamen = new LinkedHashSet<String>();
		new Persoon(voornamen);
	}
	@Test(expected = NullPointerException.class)
	public void deSetMagNietNullBevatten() {
		Set<String> voornamen = new LinkedHashSet<String>();
		voornamen.add(null);
		new Persoon(voornamen);
	}
	@Test(expected = IllegalArgumentException.class) 
	public void deSetMagGeenLegeStringBevatten() {
		Set<String> voornamen = new LinkedHashSet<String>();
		voornamen.add("");
		new Persoon(voornamen);
	}
	@Test(expected = IllegalArgumentException.class)
	public void eenVoornaamMoetMinstens1NietBlancoTekenBevatten() {
		Set<String> voornamen = new LinkedHashSet<String>();
		voornamen.add("\t");
		new Persoon(voornamen);
	}
	@Test(expected = IllegalArgumentException.class)
	public void eenVoornaamInDeSetMetMeerdereSpaties() {
		Set<String> voornamen = new LinkedHashSet<String>();
		voornamen.add("Marie");
		voornamen.add("   ");
		new Persoon(voornamen);
	}
	/*
	 * Onderstaande test is in principe overbodig.
	 * Je probeert iets dat zogezegd niet mag (2 dezelfde voornamen toevoegen),
	 * maar er wordt geen Exception opgeworpen.
	 * Doordat je met een Set werkt in de te testen class kan dit sowieso niet.
	 * Vanwege het Set contract. Dus deze test is niet nodig.
	 */
//	@Test
//	public void eenPersoonKanGeenTweeDezelfdeVoornamenBevatten() {
//		Set<String> voornamen = new LinkedHashSet<String>();
//		voornamen.add("Ann");
//		voornamen.add("Ann");
//		assertEquals("Ann", new Persoon(voornamen).toString());
//	}
	@Test
	public void toStringVanEenPersoonMetEnkeleVoornaamIsDieVoornaam() {
		Set<String> voornaam = new LinkedHashSet<String>();
		voornaam.add("Marie");
		assertEquals("Marie", new Persoon(voornaam).toString());
	}
	@Test
	public void toStringGeeftVoornamenGescheidenDoorSpatie() {
		Set<String> voornamen = new LinkedHashSet<String>();
		voornamen.add("Marie");
		voornamen.add("Eline");
		voornamen.add("Ann");
		assertEquals("Marie Eline Ann", new Persoon(voornamen).toString());
	}
	@Test
	public void toStringVanVoornaamMetSpatieErvoor() {
		Set<String> voornamen = new LinkedHashSet<String>();
		voornamen.add(" Marie");
		voornamen.add(" Ann");
		assertEquals("Marie Ann", new Persoon(voornamen).toString());
	}
	@Test
	public void toStringVanVoornaamMetSpatieErachter() {
		Set<String> voornamen = new LinkedHashSet<String>();
		voornamen.add("Marie ");
		voornamen.add("Ann");
		assertEquals("Marie Ann", new Persoon(voornamen).toString());
	}
	
}
