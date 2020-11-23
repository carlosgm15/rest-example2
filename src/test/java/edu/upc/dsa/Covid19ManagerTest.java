package edu.upc.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Covid19ManagerTest {
    private Covid19Manager gm =null;

    @Before
    public void setUp() throws Exception {
        this.gm = Covid19ManagerImpl.getInstance();
       Covid19ManagerImpl.getInstance().addUsuario("32","juan","garcia","1234-12-18","A");
       Covid19ManagerImpl.getInstance().addUsuario("32323","Alba","lopez","12/12/1998","C");
       Covid19ManagerImpl.getInstance().addMuestra("1","Hospital","32","1234-12-18","San feliu");

    }

    @After
    public void tearDown() throws Exception {
        gm= null;
    }

    @Test
    public void crearUsuario(){
        Covid19ManagerImpl.getInstance().addUsuario("32","juan","garcia","1234-12-18","A");
        assertEquals("32",Covid19ManagerImpl.getInstance().getIdUsuario());

    }
    @Test
    public void procesarMuestra(){
        Covid19ManagerImpl.getInstance().addUsuario("32","juan","garcia","1234-12-18","A");
        assertEquals("32",Covid19ManagerImpl.getInstance().getIdUsuario());

    }

}