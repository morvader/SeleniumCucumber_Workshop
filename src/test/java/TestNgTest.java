import org.testng.annotations.*;

import static org.testng.Assert.*;


public class TestNgTest {

    @BeforeClass
    public static void beforeAll() {
        System.out.println("Al principio de la ejecución");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Antes de cada test");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("Después de cada test");
    }

    @AfterClass
    public static void afterAll() {
        System.out.println("Al final del todo");
    }

    @Test
    public void sumarDosNumeros_SumaTest() {
        int a = 3;
        int b = 5;
        int expectedResult = 8;

        assertEquals(expectedResult, a + b, "la suma no es correcta");
    }

    @Test
    public void comprobarInicioFraseTest() {
        String fraseEntrada = "Estoy atomatizando pruebas";
        String inicio = "Estoy";

        assertTrue(fraseEntrada.startsWith(inicio));
    }

    @Test
    public void testException() {

        try {
            int result = 10 / 0;
            fail("No se ha producido una exception");
        } catch (ArithmeticException exception) {
            System.out.println("Exception Controlada");
            assertTrue(true);
        }
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testExceptionJunit4() {
        int a = 10 / 0;
    }
}
