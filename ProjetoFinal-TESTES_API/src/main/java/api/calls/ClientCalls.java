package api.calls;

import api.mappings.garage.Client;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ClientCalls {
    String CLIENT = "client";
    String CLIENT_ID = CLIENT + "/{id}";
    String ID = "id";

    @GET(CLIENT)
    Call<List<Client>> getClients();

    @POST(CLIENT)
    Call<Client> createClient(@Body Client client);

    @GET(CLIENT_ID)
    Call<Client> getClient(@Path(ID) Integer id);
}
