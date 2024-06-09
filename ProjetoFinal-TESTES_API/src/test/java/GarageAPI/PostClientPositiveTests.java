package GarageAPI;
import api.mappings.garage.Client;
import api.retrofit.garage.Clients;
import api.retrofit.garage.apiDatabase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import static api.validators.ResponseValidator.assertCreated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;
import java.time.LocalDate;

public class PostClientPositiveTests {

    Client client = null;
    int clientId = 1;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        client = Client.builder()
            .id(null)
            .firstName("Maria")
            .lastName("Alice")
            .address("Casainho de Cima")
            .postalCode("3750-000")
            .city("Águeda")
            .phoneNumber(921234567)
            .nif(509840027)
            // assuming client must have at least 18 years
//            .birthDate(LocalDate.now().minusYears(18))
            .birthDate(LocalDate.now())
            .clientDate(LocalDate.now())
            .build();
    }

    @Test(description = "Post client with success", enabled = true)
    public void createClient() {
        Clients clients = new Clients();
        Response response = clients.createClient(this.client);

        assertThat("Body should not be null", response.body(), notNullValue());

        Integer id = (Integer) response.body();
        this.clientId = id;
    }

    @AfterClass
    public void cleanUp() {
        Integer result = new DeleteClientPositiveTests().deleteClient(this.clientId);
        assertThat("Result must be 1 for success client delete",result, is(1));
    }
}
