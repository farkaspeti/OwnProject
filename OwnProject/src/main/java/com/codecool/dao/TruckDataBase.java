package com.codecool.dao;

import com.codecool.entity.Vehicles;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * @author Dávid
 */
@Slf4j
public class TruckDataBase {

    /**
     * Osztalyelem peldanyositasa.
     */
    private static final TruckDataBase DB_PELDANY = new TruckDataBase();
    /**
     * Az adatbazis neve.
     */
    @PersistenceContext(unitName = "TruckDB")
    /**
     * EntityManager letrehozasa.
     */
    private EntityManager em;

    /**
     * Privát konstruktor.
     */
    private TruckDataBase() {
    }

    /**
     * Aktiális DB szingleton példány lekérése.
     *
     * @return singleton példány referencia
     */
    public static TruckDataBase getDataBase() {
        return DB_PELDANY;
    }

    /**
     * Adatbáziskapcsolat létrehozása JPA-val.
     *
     * @throws Exception JPA hiba esetén
     */
    public void connectDB() throws Exception {
        //persistence.xml-ben fontos, hogy megegyezzen a persistence-unit name ezzel, jelen esetben 'database'
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("FlokeszDB");
        em = emFactory.createEntityManager();
        log.trace("Adatbázis kapcsolat OK.");
    }

    /**
     * Adatbáziskapcsolat lezárása JPA-val.
     */
    public void disconnectDB() {
        if (connected()) {
            em.close();
            log.trace("Disconnect OK.");
        }
        em = null;
    }

    /**
     * EntityManager él és csatlakoztatva van az adatbázishoz?
     *
     * @return true -> igen
     */
    public boolean connected() {

        return em != null && em.isOpen();
    }

    /**
     * @param entity menteni kíván entitás
     *
     * @return mentett entitás (nem lenne feltétlenül szükséges, lehetne akár
     * void is, viszont hibaellenőrzéshez tök jó szerintem)
     *
     * @throws IllegalStateException ha nincs adatbázis-kapcsolat
     * @throws IllegalArgumentException ha a menteni kívánt film címe
     * érvénytelen ({@code null})
     * @throws Exception JPA hiba esetén
     */
    public Vehicles save(Vehicles entity) throws IllegalStateException, IllegalArgumentException, Exception {

        if (!connected()) {
            throw new IllegalStateException("Nincs adatbázis-kapcsolat!");
        }

        if (entity == null) {
            throw new IllegalArgumentException("A mentendő entitás null!");
        }

        try {
            em.getTransaction().begin();

            if (entity.getId() == null) {
                em.persist(entity);  //új entitás --> persist (insert)
            } else {
                em.merge(entity);    //módosítás --> merge (update)
            }

            em.getTransaction().commit();

            return entity;
        } catch (PersistenceException e) {

            log.error("JPA lekérdezési hiba!");
            throw new Exception("JPA hiba!", e);
        }
    }

    /**
     * Entitás törlése az adatbázisból.
     *
     * @param entity törlendő entitás
     *
     * @throws IllegalStateException ha nincs adatbázis-kapcsolat
     * @throws IllegalArgumentException ha a törlendő entitás null vagy nincs
     * {@code ID}-ja
     * @throws Exception JPA hiba esetén
     */
    public void delete(Vehicles entity) throws IllegalStateException, IllegalArgumentException, Exception {
        if (!connected()) {
            throw new IllegalStateException("Nincs adatbázis-kapcsolat!");
        }

        if (entity == null || entity.getId() == 0) {
            throw new IllegalArgumentException("A törlendő entitás null vagy nincs ID-je!");
        }

        try {
            //a törlés előtt kikeresem az entitást, hogy biztosan Managed legyen
            Vehicles delEntity = em.find(Vehicles.class, entity.getId());

            if (delEntity.getId() == null) {
                throw new IllegalArgumentException("A törlendő score nem található az adatbázisban!");
            }

            em.getTransaction().begin();
            em.remove(delEntity);
            em.getTransaction().commit();

        } catch (PersistenceException e) {
            log.error("JPA lekérdezési hiba!");
            throw new Exception("JPA hiba", e);
        }
    }

//---------------------------------------------------------
//---------------------NamedQueries------------------------
//---------------------------------------------------------

}
