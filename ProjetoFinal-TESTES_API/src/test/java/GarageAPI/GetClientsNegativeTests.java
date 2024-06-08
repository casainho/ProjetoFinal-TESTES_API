package GarageAPI;
import api.mappings.garage.Client;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import java.util.List;
import static api.retrofit.garage.Clients.getAllClients;
import static api.validators.ResponseValidator.assertOk;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertNotEquals;

public class GetClientsNegativeTests {

    static private Client client1;
    static private Client client2;

    @BeforeClass
    static public void setUp() {
        Response<List<Client>> response = getAllClients();
        assertOk(response);

        assertThat("Body should not be null", response.body(), notNullValue());
        List<Client> clients = response.body();

        // Client 1
        client1 = clients.get(0);
        client2 = clients.get(1);
    }

    @Test(description = "Get all clients, check for client 1 wrong ID")
    public void getAllClients_Client1NegativeID_Test() {

        // ID
        int id = 0;
        assertNotEquals(client1.getId(), id, String.format("First client id should not be %d", id));
    }

    @Test(description = "Get all clients, check for client 2 wrong ID")
    public void getAllClients_Client2NegativeID_Test() {

        int id = 0;
        assertNotEquals(client1.getId(), id, String.format("Second client id should not be %d", id));
    }

    @Test(description = "Get all clients, check for client 2, vehicle not active")
    public void getAllClients_Client2VehicleNotActive_Test() {

        boolean active = true;
        assertNotEquals(client2.getVehicles().get(0).isActive(), active, "Second client, vehicle should not be active");
    }

    @AfterClass
    static public void cleanup() {
        // nothing to implement
    }
}
