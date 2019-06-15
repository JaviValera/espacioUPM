package Test;

import UsuarioRegistrado.UsuarioRegistrado;
import org.junit.*;

import static org.junit.Assert.assertEquals;
public class UsuarioRegistradoTest {
	UsuarioRegistrado usuario;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		usuario = new UsuarioRegistrado("rodrigo");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUsuarioRegistrado() {
		String Alias = "rodrigo";
		assertEquals(Alias, usuario.getAlias());
	}
	@Test
	public void testLogin() {
		String nombre = usuario.login(); // importante loguearse con usuario "rodrigo" y contraseña "patata"
		assertEquals(nombre, "rodrigo");
	}
	@Test
	public void testSetAlias() {
		String nuevoResul = "rodri99";
		usuario.setAlias(nuevoResul);
		assertEquals("rodri99", usuario.getAlias());
	}

	@Test
	public void testGetAlias() {
		String resulEsperado = "rodrigo";
		String resul = usuario.getAlias();
		assertEquals(resulEsperado, resul);
	}

	@Test
	public void testGetemail() {
		String resulEsperado = "rodrigo@upm.es";
		String resul = usuario.getemail();
		assertEquals(resulEsperado, resul);
	}

	@Test
	public void testSetemail() {
		String nuevoResul = "rodri99@upm.es";
		usuario.setemail(nuevoResul);
		assertEquals("rodri99@upm.es", usuario.getemail());
	}

	@Test
	public void testSetPassword() {
		String nuevoResul = "potato";
		usuario.SetPassword(nuevoResul);
		assertEquals("potato", usuario.GetPassword());
	}

	@Test
	public void testGetPassword() {
		String resulEsperado = "patata";
		String resul = usuario.GetPassword();
		assertEquals(resulEsperado, resul);
	}
}
