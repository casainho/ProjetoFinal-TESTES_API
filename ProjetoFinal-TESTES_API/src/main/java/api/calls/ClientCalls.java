package api.calls;

import api.mappings.garage.Client;
import api.mappings.garage.ClientWithVehicles;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ClientCalls {
    String CLIENT = "client";
    String CLIENT_ID = CLIENT + "/{id}";
    String ID = "id";

    @GET(CLIENT)
    Call<List<ClientWithVehicles>> getClients();

    @POST(CLIENT)
    Call<Integer> createClient(@Body Client client);

    @DELETE(CLIENT_ID)
    Call<ResponseBody> deleteClient(@Path(ID) Integer id);
}
