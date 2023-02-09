/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package inweb.spring.servidor_https_spring;

import innui.modelos.errores.oks;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emilio
 */
public class Servidor_https_springTest {
    
    public Servidor_https_springTest() {
    }

    /**
     * Test of main method, of class Servidor_https_spring.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Servidor_https_spring.main(args);
    }

    /**
     * Test of run method, of class Servidor_https_spring.
     */
    @Ignore
    public void testRun() throws Exception {
        System.out.println("run");
        oks ok = null;
        Object[] extra_array = null;
        Servidor_https_spring instance = new Servidor_https_spring();
        boolean expResult = false;
        boolean result = instance.run(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciar method, of class Servidor_https_spring.
     */
    @Ignore
    public void testIniciar() throws Exception {
        System.out.println("iniciar");
        oks ok = null;
        Object[] extra_array = null;
        Servidor_https_spring instance = new Servidor_https_spring();
        boolean expResult = false;
        boolean result = instance.iniciar(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of terminar method, of class Servidor_https_spring.
     */
    @Ignore
    public void testTerminar() throws Exception {
        System.out.println("terminar");
        oks ok = null;
        Object[] extra_array = null;
        Servidor_https_spring instance = new Servidor_https_spring();
        boolean expResult = false;
        boolean result = instance.terminar(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
