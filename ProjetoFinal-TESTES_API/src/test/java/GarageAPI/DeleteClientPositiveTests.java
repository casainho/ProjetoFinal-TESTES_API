package GarageAPI;
import api.retrofit.garage.Clients;
import api.retrofit.garage.apiDatabase;
import okhttp3.ResponseBody;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DeleteClientPositiveTests {

    public int deleteClient(int id) {
        Clients clients = new Clients();
        Response<ResponseBody> response = clients.deleteClient(id);
        return  response.code() == 204 ? 1: 0;
    }

    @BeforeClass
    static public void setUp() throws IOException, InterruptedException {

    }

    @Test(description = "Post client with success", enabled = true)
    public void deleteClient_test() {
        assertThat("Result must be 1 for success client delete", deleteClient(0), is(1));
    }

    @AfterClass
    static public void cleanup() {

    }
}
