package GarageAPI;

import api.mappings.garage.Client;
import api.retrofit.garage.Clients;
import api.retrofit.garage.apiDatabase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;

import static api.validators.ResponseValidator.assertCreated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.greaterThan;

public class PostClientNegativeTests {
    Client client_invalidID = null;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        Client client = Client.builder()
            .firstName("Maria")
            .lastName("Alice")
            .address("Casainho de Cima")
            .postalCode("3750-000")
            .city("Águeda")
            .phoneNumber(921234567)
            .nif(509840027)
            // assuming client must have at least 18 years
            .birthDate(LocalDate.now().minusYears(18))
            .clientDate(LocalDate.now())
            .build();

        this.client_invalidID = client;
        this.client_invalidID.setId(100);
    }

    @Test(description = "Post client without success", enabled = true)
    public void createClient() {
        Clients clients = new Clients();
        Response response = clients.createClient(this.client_invalidID);
        int code = response.code();

        assertThat("Returned code must be 400: Bad Request error", code, is(400));
    }

    @AfterClass
    public void cleanUp() {

    }
}
