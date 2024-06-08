package GarageAPI;
import api.mappings.garage.Client;
import api.mappings.garage.Vehicle;
import org.testng.annotations.Test;
import retrofit2.Response;
import java.util.List;
import static api.retrofit.garage.Clients.getAllClients;
import static api.validators.ResponseValidator.assertOk;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetClientsPositiveTests {

    @Test(description = "Get all clients with success")
    public void getAllClientsTest() {

        Response<List<Client>> response = getAllClients();
        assertOk(response);

        assertThat("Body should not be null", response.body(), notNullValue());
        List<Client> clients = response.body();

        // Client 1
        Client client1 = clients.get(0);

        // ID
        int id = 1;
        assertThat(String.format("id should be %d", id), client1.getId(), is(id));

        // First name
        String name = "Afonso";
        assertThat(String.format("First name should be %s", name), client1.getFirstName(), is(name));

        // Phone Number
        assertThat("Phone number must be an Integer", client1.getPhoneNumber(), isA(Integer.class));
        assertThat("Phone number must be positive", client1.getPhoneNumber(), is(greaterThan(0)));

        // Vehicles
        List<Vehicle> vehicles = client1.getVehicles();
        assertThat("Body should not be null", vehicles.size(), is(2));

        // 1st vehicle
        Vehicle vehicle1_Client1 = vehicles.get(0);

        id = 1;
        assertThat(String.format("Vehicle id should be %d", id), vehicle1_Client1.getId(), is(id));

        // 2nd vehicle
        Vehicle vehicle2_Client1 = vehicles.get(1);

        id = 2;
        assertThat(String.format("Vehicle id should be %d", id), vehicle2_Client1.getId(), is(id));

        // Client 2
        Client client2 = clients.get(1);

        // First name
        name = "Lopes";
        assertThat(String.format("Last name should be %s", name), client2.getLastName(), is(name));

        // Vehicles
        vehicles = client2.getVehicles();
        assertThat("Body should not be null", vehicles.size(), is(1));

        // Vehicle
        Vehicle vehicle1_Client2 = vehicles.get(0);

        id = 3;
        assertThat(String.format("Vehicle id should be %d", id), vehicle1_Client2.getId(), is(id));
    }
}
